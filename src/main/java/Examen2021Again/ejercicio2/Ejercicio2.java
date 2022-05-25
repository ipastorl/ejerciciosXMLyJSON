package Examen2021Again.ejercicio2;

import U8U9Examen2021.Libro;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Utilizando el parserStax crear una clase llamada RecorridoStax que:
 *
 * Muestre por pantalla los datos del libro con más páginas.
 * Que muestre por pantalla el número de libros de una editorial determinada que se solicitará al usuario.
 */
public class Ejercicio2 {
    public static String archivo = "ejercicio2.xml";
    public static void main(String[] args) {

        // primeros pasos: crear una Lista libros, un objeto Libro vacío y el nombre de una etiqueta vacía (String)
        List<Libro> libros = new ArrayList<>();

        // Leer el archivo .xml e introducir los libros en una lista
        libros = recorridoStax(libros);

        // ¿Qué libro contiene más páginas?
        libroLongest(libros);

        // ¿Cuántos libros tiene una editorial?
        numLibrosEditorial(libros);
    }

    /**
     * Se utiliza un xmlReader para recorrer el documento xml e ir guardándolo en una lista
     * que devuelve de libros
     * @param libros
     * @return libros Lista
     */
    private static List<Libro> recorridoStax(List<Libro> libros) {
        Libro libroActual = null;
        String tagActual = "";


        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader xmlReader = xmlInputFactory.createXMLEventReader(new FileInputStream(archivo));

            // Recorrer el xmlReader (XMLEvent)
            while (xmlReader.hasNext()){
                XMLEvent nextEvento = xmlReader.nextEvent();

                //¿es apertura de etiqueta ( StartElement ) ?
                if (nextEvento.isStartElement()){
                    // Lo asignamos al objeto etiqueta de apertura (StartElement)
                    StartElement startElement = nextEvento.asStartElement();
                    // Sacar un String de la etiqueta para saber cómo se llama la etiqueta
                    String etiquetaApertura = startElement.getName().getLocalPart();

                    switch (etiquetaApertura) {
                        // si es un libro, creamos el objeto libro y asignamos al String tagActual, la etiqueta libro
                        case "libro" -> {
                            libroActual = new Libro();
                            tagActual = "libro";
                        }

                        // Asignamos para cada caso al String tagActual, el nombre de la etiqueta
                        case "titulo" -> tagActual = "titulo";
                        case "autor" -> tagActual = "autor";
                        case "editorial" -> tagActual = "editorial";
                        case "pais" -> tagActual = "pais";
                        case "paginas" -> tagActual = "paginas";
                        default -> tagActual = "";
                    }
                    // ¿es evento de cierre de etiqueta (EndElement)?
                } else if (nextEvento.isEndElement()){

                    // Creamos el objeto EndElement (el evento encontrado nextEvento, marcado como asEndElement)
                    EndElement endElement = nextEvento.asEndElement();
                    // Creamos un String con el cierre de la etiqueta
                    String elementoCierre = endElement.getName().getLocalPart();

                    // Si se trata del cierre de la etiqueta de apertura (libro),
                    // ya podemos añadir el libro actual a la colección (libros)
                    if (elementoCierre.equals("libro")) {
                        libros.add(libroActual);
                    }

                    // resetear la etiqueta
                    tagActual = "";


                    // si hemos encontrado texto
                } else if (nextEvento.isCharacters()) {
                    // Asignar al String texto el contenido del evento encontrado
                    String texto = nextEvento.asCharacters().getData();

                    // Descartar que no se trate de saltos de línea, ni de tabulaciones ni de cadenas vacías
                    if ( !(texto.equals("\n") || texto.equals("\t") || texto.equals("")) ){

                        // ¿Qué texto en cada etiqueta?
                        // añadimos la información al objeto libro
                        switch (tagActual) {
                            case "titulo" -> libroActual.setTitulo(texto);
                            case "autor" -> libroActual.setAutor(texto);
                            case "editorial" -> libroActual.setEditor(texto);
                            case "pais" -> libroActual.setPais(texto);
                            case "paginas" -> libroActual.setPaginas(Integer.valueOf(texto));
                            default -> {
                            }
                        }
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }

        // Ya hemos leído el xml, vamos a comprobar que es todo correcto, sacándolo por pantalla
        System.out.println("========= OBJETO COLECCIÓN LIBROS =============");
        System.out.println(libros);
        return libros;
    }

    /**
     * Se pide por teclado el nombre de una editorial y muestra por pantalla
     * el número de libros que ha encontrado en la lista libros de esa editorial
     * @param libros
     */
    private static void numLibrosEditorial(List<Libro> libros) {
        // Pedir por pantalla el nombre de la editorial
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el nombre de la editorial: ");
        String editorial = sc.nextLine();
        // contador
        Integer numLibros = 0;
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro next =  it.next();
            // si coincide con la editorial introducida por el usuario
            if(next.getEditor().equals(editorial)){
                numLibros++;
            }
        }
        System.out.println("La editorial " + editorial + " tiene " + numLibros + " libros.");
    }

    /**
     * Muestra por pantalla el libro que más páginas tiene
     * @param libros
     */
    private static void libroLongest(List<Libro> libros) {
        // Un objeto libro vacío
        Libro longestBook = null;
        // un contador
        Integer numeroPaginas = 0;

        Iterator<Libro> iterator = libros.iterator();
        while (iterator.hasNext()) {
            Libro next =  iterator.next();
            // si es más alto que el número de páginas almacenado, almacenamos el libroActual
            if (next.getPaginas()>numeroPaginas){
                longestBook = next;
            }
        }
        System.out.println("El libro con más páginas es: " + longestBook );
    }
}
