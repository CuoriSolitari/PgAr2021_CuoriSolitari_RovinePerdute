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


    /**
     * Crea un arraylist di città dopo aver ricevuto in input un XML
     *
     * @param file
     * @return array_city
     */
    public static ArrayList<City> readCity(File file){

        ArrayList<City> array_city = new ArrayList<>();
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(String.valueOf(file), new FileInputStream(file));
            int id = 0;
            String name = null;
            Double x, y, h;
            Position pos = null;


            while (xmlr.hasNext()){

                ArrayList<Integer> link_id = new ArrayList<>();

                switch (xmlr.getEventType()){

                    case XMLStreamConstants.START_DOCUMENT:
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        if ((xmlr.getLocalName()) == "city") {
                            //Legge l'id e lo trasforma da stringa in intero
                            String _id = xmlr.getAttributeValue(0);
                            id = Integer.parseInt(_id);

                            //Legge il nome
                            name = xmlr.getAttributeValue(1);

                            //Legge le coordinate e poi le trasforma da stringhe a interi e infine crea una posizione
                            String _x = xmlr.getAttributeValue(2);
                            String _y = xmlr.getAttributeValue(3);
                            String _h = xmlr.getAttributeValue(4);

                            x = Double.parseDouble(_x);
                            y = Double.parseDouble(_y);
                            h = Double.parseDouble(_h);
                            pos = new Position(x, y, h);
                        }

                        if ((xmlr.getLocalName()) == "link") {
                            String _link = xmlr.getAttributeValue(0);
                            link_id.add(Integer.parseInt(_link));
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if ((xmlr.getLocalName()) == "city"){
                            City city = new City(pos, name, id, link_id);
                            array_city.add(city);
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
