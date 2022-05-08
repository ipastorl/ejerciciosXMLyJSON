package U8_T1_2021_Parseando_XML;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class RecorridoDOM {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Cargar fichero XML en memoria
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("platos.xml"));

        //Recoger etiquetas food
        NodeList nl = doc.getElementsByTagName("food");

        System.out.println(nl.getLength());
    }
    public static void mostrarXML(){

    }
    public static void cantidadDePlatos(){

    }
    public static void platoMasCaro(){

    }
}
