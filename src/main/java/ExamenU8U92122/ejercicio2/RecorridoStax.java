package ExamenU8U92122.ejercicio2;

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


public class RecorridoStax {
    public static String archivo = "pilotos.xml";
    public static void main(String[] args) {


        List<Piloto> pilotos = new ArrayList<>();


        pilotos = recorridoStax(pilotos);

        //número de pilotos de una escudería
        numPilotos(pilotos);

        //piloto con más campeonatos.
        theBest(pilotos);
}


    private static List<Piloto> recorridoStax(List<Piloto> pilotos) {
        Piloto pilotoActual = null;
        String tagActual = "";


        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader xmlReader = xmlInputFactory.createXMLEventReader(new FileInputStream(archivo));

            while (xmlReader.hasNext()){
                XMLEvent nextEvento = xmlReader.nextEvent();

                if (nextEvento.isStartElement()){
                    StartElement startElement = nextEvento.asStartElement();
                    String etiquetaApertura = startElement.getName().getLocalPart();

                    switch (etiquetaApertura) {
                        case "piloto" -> {
                            pilotoActual = new Piloto();
                            tagActual = "piloto";
                        }

                        case "nombre" -> tagActual = "nombre";
                        case "edad" -> tagActual = "edad";
                        case "escuderia" -> tagActual = "escuderia";
                        case "campeonatos" -> tagActual = "campeonatos";
                        case "pais" -> tagActual = "pais";
                        default -> tagActual = "";
                    }
                } else if (nextEvento.isEndElement()){

                    EndElement endElement = nextEvento.asEndElement();
                    String elementoCierre = endElement.getName().getLocalPart();

                    if (elementoCierre.equals("piloto")) {
                        pilotos.add(pilotoActual);
                    }

                    tagActual = "";


                } else if (nextEvento.isCharacters()) {
                    String texto = nextEvento.asCharacters().getData();

                    if ( !(texto.equals("\n") || texto.equals("\t") || texto.equals("")) ){


                        switch (tagActual) {
                            case "nombre" -> pilotoActual.setNombre(texto);
                            case "edad" -> pilotoActual.setEdad(Integer.valueOf(texto));
                            case "escuderia" -> pilotoActual.setEscuderia(texto);
                            case "campeonatos" -> pilotoActual.setCampeonatos(Integer.valueOf(texto));
                            case "pais" -> pilotoActual.setPais(texto);
                            default -> {
                            }
                        }
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("========= OBJETO COLECCIÓN PILOTOS =============");
        System.out.println(pilotos);
        return pilotos;
    }


    private static void numPilotos(List<Piloto> pilotos) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el nombre de la escudería: ");
        String escuderia = sc.nextLine();
        // contador
        Integer numPilots = 0;
        Iterator<Piloto> it = pilotos.iterator();
        while (it.hasNext()) {
            Piloto next =  it.next();

            if(next.getEscuderia()!=null && next.getEscuderia().equals(escuderia)){
                numPilots++;
            }
        }
        System.out.println("La escuderia " + escuderia + " tiene " + numPilots + " pilotos.");
    }


    private static void theBest(List<Piloto> pilotos) {

        Piloto pilotoBest = null;
        Integer numeroCampeonatos = 0;

        Iterator<Piloto> iterator = pilotos.iterator();
        while (iterator.hasNext()) {
            Piloto next =  iterator.next();
            if (next.getCampeonatos() !=null && next.getCampeonatos()>numeroCampeonatos){
                pilotoBest = next;
            }
        }
        System.out.println("El piloto con más campeonatos es: " + pilotoBest );
    }
}
