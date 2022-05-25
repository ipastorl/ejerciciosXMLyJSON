package Examen2021Again.ejercicio1;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
public class Ejercicio1 {

    public static void main(String[] args) {

        try{
            Libro libro = createLibro();
            String ficheroxml = "libros.xml";
            String ficheroSalida = "ejercicio2.xml";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(ficheroxml));

            doc = addLibroDOM(doc,libro);
            guardarFichero(ficheroSalida,doc);

        }   catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }

    }

    /**
     * Guardar en un fichero .xml de salida
     * @param ficheroSalida
     * @param document
     * @throws TransformerException
     */
    private static void guardarFichero(String ficheroSalida, Document document) throws TransformerException {
        Node root = document.getDocumentElement();
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
     * Crea un objeto Node root y va añadiendo con appendChild, primero al elemento libro y finalmente al root
     * @param doc
     * @param libro
     * @return Document
     */
    public static Document addLibroDOM(Document doc, Libro libro){
        // raiz del árbol
        Node root = doc.getDocumentElement();

        // Elementos
        Element elibro = doc.createElement("libro");

        Element etitulo = doc.createElement("titulo");
        etitulo.setTextContent(libro.getTitulo());

        Element eautor = doc.createElement("autor");
        eautor.setTextContent(libro.getAutor());

        Element eedit = doc.createElement("editorial");
        eedit.setTextContent(libro.getEditorial());

        Element epag = doc.createElement("paginas");
        epag.setTextContent(libro.getPaginas());

        elibro.appendChild(etitulo);
        elibro.appendChild(eautor);
        elibro.appendChild(eedit);
        elibro.appendChild(epag);

        root.appendChild(elibro);
        return doc;

    }

    /**
     * Crea un objeto Libro preguntando los parámetros por teclado
     * @return Libro
     */
    public static Libro createLibro(){
        Libro libro = new Libro();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el título del libro: ");
        libro.setTitulo(sc.nextLine());
        System.out.println("Introduce el autor del libro: ");
        libro.setAutor(sc.nextLine());
        System.out.println("Introduce el nombre de la editorial");
        libro.setEditorial(sc.nextLine());
        System.out.println("Introduce el número de páginas");
        libro.setPaginas(sc.nextLine());

        return libro;
    }

}
