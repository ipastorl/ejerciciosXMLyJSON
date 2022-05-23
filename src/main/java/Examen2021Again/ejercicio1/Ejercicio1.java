package Examen2021Again.ejercicio1;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
            Libro libro = addLibro();
            String ficheroxml = "libros.xml";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(ficheroxml));

            addLibroDOM(doc,libro);




        }   catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    public static void addLibroDOM(Document doc, Libro libro){
        // raiz del árbol
        Node root = doc.getDocumentElement();

        // Elementos
        Element elibro = doc.createElement("libro");

        Element etitulo = doc.createElement("titulo");
        etitulo.setTextContent(libro.getTitulo());

        Element eautor = doc.createElement("autor");
    }

    public static Libro addLibro(){
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
