package U8U9Examen2021;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Añada un nuevo libro a la biblioteca solicitando los datos al usuario.
 * Inserte un nuevo nodo dentro de editorial que indique el país de origen de la editorial.
 * Escriba todo esto en un fichero llamado ejercicio2.xml
 */
public class ModificacionDOM {
    public static void main(String[] args) {
        // crear libro nuevo pidiendo datos a usuario
        Libro libro = crearLibro();

        String ficheroEntrada = "biblioteca.xml";
        String ficheroSalida = "ejercicio2.xml";
        try {
            //Obtenemos la referencia al objeto Document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //Parseamos el documento XML para tenerlo en memoria cargado
            Document doc = db.parse(new File(ficheroEntrada));
            //Obtenemos el nodo raíz
            Node root = doc.getDocumentElement();
            //Nodo texto de salto de línea que voy a utilizar posteriormente

            anyadirLibro(libro, doc, root);


            arbolAFichero(ficheroSalida, root);

        } catch (ParserConfigurationException | SAXException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void anyadirLibro(Libro libro, Document doc, Node root) {
        Element llibre = doc.createElement("libro");
        // Añadir los atributos del libro como elementos
        Element titulo = doc.createElement("titulo");
        titulo.setTextContent(libro.getTitulo());
        Element autor = doc.createElement("autor");
        autor.setTextContent(libro.getAutor());
        Element editor = doc.createElement("editor");
        editor.setTextContent(libro.getEditor());
        // crear el elemento pais dentro de editor
        Element pais = doc.createElement("pais");
        pais.setTextContent(libro.getPais());
        editor.appendChild(pais);


        Element paginas = doc.createElement("paginas");
        paginas.setTextContent(libro.getPaginas().toString());

        llibre.appendChild(titulo);
        llibre.appendChild(autor);
        llibre.appendChild(editor);
        llibre.appendChild(paginas);

        root.appendChild(llibre);
    }

    /**
     * Vuelca todo el árbol del nodo pasado por parámetro al fichero
     * @param ficheroSalida String
     * @param root Node
     * @throws TransformerException
     */
    private static void arbolAFichero(String ficheroSalida, Node root) throws TransformerException {

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();

        transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "no" );
        transformer.setOutputProperty( OutputKeys.METHOD, "xml" );
        transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");
        // el nodo root es el "source"
        DOMSource domSource = new DOMSource(root);
        // fichero salida donde se va a guardar
        StreamResult streamResult = new StreamResult(new File(ficheroSalida));

        transformer.transform(domSource,streamResult);
    }

    /**
     * Crea un nuevo Libro, pidiendo datos al usuario
     * @return Libro
     */
    private static Libro crearLibro() {
        Libro libro = new Libro();
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte el título del libro: ");
        libro.setTitulo(sc.nextLine());
        System.out.println("Inserte el autor del libro: ");
        libro.setAutor(sc.nextLine());
        System.out.println("Inserte el editor del libro: ");
        libro.setEditor(sc.nextLine());
        System.out.println("Inserte el país de la editorial");
        libro.setPais(sc.nextLine());
        System.out.println("Inserte el número de páginas: ");
        libro.setPaginas(sc.nextInt());
        return libro;
    }
}
