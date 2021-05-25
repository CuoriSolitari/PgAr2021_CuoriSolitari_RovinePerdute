package it.unibs.pgrArnaldo.CuoriSolitari.RovinePerdute;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import java.io.File;
import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {

        ArrayList<City> arry_city = new ArrayList<>();

        File file = new File("RovinePerdute/src/test_file/PgAr_Map_5.xml");
        arry_city = Xml.readCity(file);

        for (City c : arry_city){
            System.out.println(c);
        }


    }
}
