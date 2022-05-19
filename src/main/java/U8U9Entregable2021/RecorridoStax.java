package U8U9Entregable2021;

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
 * Muestre por pantalla los datos del libro con más páginas.
 * Que muestre por pantalla el número de libros de una editorial determinada que se solicitará al usuario.
 */
public class RecorridoStax {

    public static void main(String[] args) {
        // Extraer estos datos del XML
        List<Libro> libros = new ArrayList<>();
        Libro libroActual = null;
        String tagActual = "";

        try {
            //Obtenemos el lector de XML
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader xmlReader = xmlInputFactory.createXMLEventReader(new FileInputStream("biblioteca.xml"));

            // Recorrer la lista de eventos con el xmlReader
            while (xmlReader.hasNext()) {

                // Obtener el siguien evento
                XMLEvent xmlEvent = xmlReader.nextEvent();

                //Si es evento de apertura (apertura de una etiqueta)
                if (xmlEvent.isStartElement()) {

                    // Obtener información de la etiqueta
                    StartElement startElement = xmlEvent.asStartElement();
                    String elementoApertura = startElement.getName().getLocalPart();

                    // Rellenar el objeto libro
                    switch (elementoApertura) {
                        // si es la etiqueta libro, creamos el objeto libro
                        // y señalamos la etiqueta como etiquetaActual
                        case "libro" :
                            libroActual = new Libro();
                            tagActual = "libro";
                            break;

                        // señalamos para el resto de etiquetas la etiqueta Actual
                        case "titulo":
                            tagActual = "titulo";
                            break;
                        case "autor":
                            tagActual = "autor";
                            break;
                        case "editorial":
                            tagActual = "editorial";
                            break;
                        case "pais":
                            tagActual = "pais";
                            break;
                        case "paginas":
                            tagActual = "paginas";
                            break;
                        default:
                            tagActual ="";
                            break;
                    }

                    // Si es evento de cierre (cierre de una etiqueta)
                } else if (xmlEvent.isEndElement()){

                    // Obtenemos información de la etiqueta
                    EndElement endElement = xmlEvent.asEndElement();
                    String elementoCierre = endElement.getName().getLocalPart();

                    // Si se trata del cierre de pedido, ya podemos añadir el libro actual a la colección
                    if (elementoCierre.equals("libro")) {
                        libros.add(libroActual);
                    }

                    // resetear la etiqueta
                    tagActual = "";


                    // si hemos encontrado texto
                } else if (xmlEvent.isCharacters()) {
                    // obtenemos el texto
                    String texto = xmlEvent.asCharacters().getData();

                    // Descartar que no se trate de saltos de línea, ni de tabulaciones ni de cadenas vacías
                    if ( !(texto.equals("\n") || texto.equals("\t") || texto.equals("")) ){

                        // obtener el texto según la etiqueta actual en la que nos encontramos
                        // añadimos la información al objeto libro
                        switch (tagActual) {
                            case "titulo":
                                libroActual.setTitulo(texto);
                                break;
                            case "autor":
                                libroActual.setAutor(texto);
                                break;
                            case "editorial":
                                libroActual.setEditor(texto);
                                break;
                            case "pais":
                                libroActual.setPais(texto);
                                break;
                            case "paginas":
                                libroActual.setPaginas(Integer.valueOf(texto));
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }

        // proba proba
        System.out.println("---- libro -----");
        System.out.println(libroActual);
        System.out.println("---- libros -----");
        System.out.println(libros);

        // Averigual el número de páginas más alto
        libroActual = null;
        Integer numeroPaginas = 0;
        Iterator<Libro> iterator = libros.iterator();
        while (iterator.hasNext()) {
            Libro next =  iterator.next();
            // si es más alto que el número de páginas almacenado, almacenamos el libroActual
            if (next.getPaginas()>numeroPaginas){
                libroActual = next;
            }
        }
        System.out.println("El libro con más páginas es: " + libroActual );

        // número de libros de una editorial
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el nombre de la editorial: ");
        String editorial = sc.nextLine();
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
}



