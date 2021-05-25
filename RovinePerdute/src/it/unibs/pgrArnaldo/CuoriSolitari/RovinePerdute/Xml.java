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

                int id = 0;
                String name = null;
                int x, y, h;
                Position pos = null;
                ArrayList<Integer> link_id = new ArrayList<>();

                switch (xmlr.getEventType()){

                    case XMLStreamConstants.START_DOCUMENT:
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        if ((xmlr.getLocalName()) == "city") {
                            //Legge l'id e lo trasforma da stringa in intero
                            xmlr.next();
                            String _id = xmlr.getText();
                            id = Integer.parseInt(_id);

                            //Legge il nome
                            xmlr.next();
                            name = xmlr.getText();

                            //Legge le coordinate e poi le trasforma da stringhe a interi e infine crea una posizione
                            xmlr.next();
                            String _x = xmlr.getText();
                            xmlr.next();
                            String _y = xmlr.getText();
                            xmlr.next();
                            String _h = xmlr.getText();

                            x = Integer.parseInt(_x);
                            y = Integer.parseInt(_y);
                            h = Integer.parseInt(_h);
                            pos = new Position(x, y, h);
                        }
                        if ((xmlr.getLocalName()) == "link") {
                            xmlr.next();
                            String _link = xmlr.getText();
                            link_id.add(Integer.parseInt(_link));
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if ((xmlr.getLocalName()) == "city"){
                            City city = new City(pos, name, id, link_id);
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
