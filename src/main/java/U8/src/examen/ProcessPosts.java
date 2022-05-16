package U8.src.examen;

import com.google.gson.Gson;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProcessPosts {

    private Document doc;
    private List<Post> postList = new ArrayList<>();
    private static final String FICHEROJSON = "posts.json";

    public ProcessPosts() {}

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public void parseDOM (String filename){
        // Cargar fichero XML en memoria
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            doc = db.parse(new File(filename));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void addPost(Post post) {
        NodeList nodeList = doc.getElementsByTagName("post");
        Node root = doc.getDocumentElement();

        Text saltoLinea = doc.createTextNode("\n");

        Element postElement = doc.createElement("post");

        Element title = doc.createElement("title");
        title.setTextContent(post.getTitle());

        Element link = doc.createElement("link");
        link.setTextContent(post.getLink());

        Element description = doc.createElement("description");
        description.setTextContent(post.getDescription());

        Element pubDate = doc.createElement("pubDate");
        pubDate.setTextContent(post.getPubdate());

        Element guid = doc.createElement("guid");

        //Construyo toda la estructura general de la etiqueta
        postElement.appendChild(saltoLinea);
        postElement.appendChild(title);
        postElement.appendChild(link);
        postElement.appendChild(description);
        postElement.appendChild(pubDate);
        postElement.appendChild(guid);

        //Añadimos ese nuevo nodo al root
        root.appendChild(postElement);
    }

    public void getPosts(){
        NodeList nodeList = doc.getElementsByTagName("post");
        Post post = null;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList != null && nodeList.item(i).getNodeType() == 1) {
                // Si es de tipo 1 (Elemento), imprime el nombre del nodo
                // System.out.print(nodeList.item(i).getNodeName() + " ");
                post = new Post();

                if (nodeList.item(i).getChildNodes().getLength() > 0) {
                    // Recorrer nodos hijos, si los hay
                    NodeList nlsub = nodeList.item(i).getChildNodes();
                    for (int j = 0; j < nlsub.getLength(); j++) {
                        if (nlsub.item(j).getNodeType() == 1) {
                            String elemento = nlsub.item(j).getNodeName();
                            switch (elemento) {
                                case "title":
                                    post.setTitle(nlsub.item(j).getTextContent());
                                    break;
                                case "link":
                                    post.setLink(nlsub.item(j).getTextContent());
                                    break;
                                case "description":
                                    post.setDescription(nlsub.item(j).getTextContent());
                                    break;
                                case "pubDate":
                                    post.setPubdate(nlsub.item(j).getTextContent());
                                    break;
                                case "guid":
                                    post.setGuid(nlsub.item(j).getTextContent());
                            }

                        }
                    }
                    postList.add(post);
                }
            }
        }
    }

    public String convertToJSON () {
        Gson gson = new Gson();
        String cadenaJSON = gson.toJson(postList);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter( new FileWriter(FICHEROJSON));
            bw.write(cadenaJSON);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cadenaJSON;
    }

    public Integer nomPostsStax(String filename){
        Integer numPosts = 0;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlReader = xmlInputFactory.createXMLEventReader(new FileInputStream(filename));
            while (xmlReader.hasNext()) {

                XMLEvent xmlEvent = xmlReader.nextEvent();

                if (xmlEvent.isStartElement()) {

                    StartElement startTag = xmlEvent.asStartElement();
                    if(startTag.getName().getLocalPart().equals("post")){
                        numPosts++;
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return numPosts;
    }
}

