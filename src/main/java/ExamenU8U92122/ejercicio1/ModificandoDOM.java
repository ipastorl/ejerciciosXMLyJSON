package ExamenU8U92122.ejercicio1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Partiendo del XML que se proporciona, crear una clase ModificacionDOM que haga lo siguiente:
 *
 * Añada un nuevo piloto a la lista de pilotos solicitando los datos al usuario.
 * Inserte un nuevo nodo dentro cada piloto que indique el país de origen del piloto
 * Escriba todo esto en un fichero llamado ModificandoDOM.xml
 */
public class ModificandoDOM {

    public static void main(String[] args) {
        String archivoXML = "pilotos.xml";
        String ficheroSalida = "pilotos.xml";
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(archivoXML));

            doc = addPilotoDOM(doc, addPiloto());
            doc = insertarNodo(doc);
            Node root = doc.getDocumentElement();
            arbolAFichero(ficheroSalida,root);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }

    }

    private static Document insertarNodo(Document doc) {

        // Insertar la etiqueta pais en los pilotos
        NodeList pilotos = doc.getElementsByTagName("piloto");
        for (int i = 0; i < pilotos.getLength(); i++) {
            Element pais = doc.createElement("pais");
            pais.setTextContent("Spain");
            Node pilot = pilotos.item(i);
            Element elem = (Element) pilot;
            elem.appendChild(pais);
        }
        return doc;
    }


    private static Document addPilotoDOM(Document doc, Piloto pilot) {

        Node root = doc.getDocumentElement();

        Element piloto = doc.createElement("piloto");

        Element nombre = doc.createElement("nombre");
        nombre.setTextContent(pilot.getNombre());
        Element edad = doc.createElement("edad");
        edad.setTextContent(String.valueOf(pilot.getEdad()));
        Element escuderia = doc.createElement("escuderia");
        escuderia.setTextContent(pilot.getEscuderia());
        Element campeonatos = doc.createElement("campeonatos");
        campeonatos.setTextContent(String.valueOf(pilot.getCampeonatos()));

        piloto.appendChild(nombre);
        piloto.appendChild(edad);
        piloto.appendChild(escuderia);
        piloto.appendChild(campeonatos);

        root.appendChild(piloto);

        return doc;
    }

    private static Piloto addPiloto() {
        Scanner sc = new Scanner(System.in);

        Piloto piloto = new Piloto();
        System.out.println("Introduzca el nombre del piloto");
        piloto.setNombre(sc.nextLine());
        System.out.println("Introduzca la edad del piloto");
        piloto.setEdad(sc.nextInt());
        System.out.println("Introduzca la escudería del piloto");
        piloto.setEscuderia(sc.nextLine());
        System.out.println("Introduzca el número de campeonatos del piloto");
        piloto.setCampeonatos(sc.nextInt());
        return piloto;
    }

    private static void arbolAFichero(String ficheroSalida, Node root) throws TransformerException {

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();

        transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "no" );
        transformer.setOutputProperty( OutputKeys.METHOD, "xml" );
        transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

        DOMSource domSource = new DOMSource(root);
        StreamResult streamResult = new StreamResult(new File(ficheroSalida));

        transformer.transform(domSource,streamResult);
    }
}
