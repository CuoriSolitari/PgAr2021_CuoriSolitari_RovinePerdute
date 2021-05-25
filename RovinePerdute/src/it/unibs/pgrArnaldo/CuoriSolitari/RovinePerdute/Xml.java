package it.unibs.pgrArnaldo.CuoriSolitari.RovinePerdute;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Xml {

    private static ArrayList<City> array_city;

    /**
     * Crea un arraylist di città dopo aver ricevuto in input un XML
     *
     * @param file
     * @return array_city
     */
    public static ArrayList<City> readCity(File file){

        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(String.valueOf(file), new FileInputStream(file));
            while (xmlr.hasNext()){

                switch (xmlr.getEventType()){

                    case XMLStreamConstants.START_DOCUMENT:
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        if ((xmlr.getLocalName()) == "codice") {
                            xmlr.next();
                            codice = xmlr.getText();
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if ((xmlr.getLocalName()) == "codice"){

                        }

                        break;
                    case XMLStreamConstants.COMMENT:
                        System.out.println("// commento " + xmlr.getText());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        break;
                }
                xmlr.next();
            }
            xmlr.close();
        }


        catch (FileNotFoundException | XMLStreamException e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        return  array_city;
    }
}
