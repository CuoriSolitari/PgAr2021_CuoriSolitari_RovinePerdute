package it.unibs.pgrArnaldo.CuoriSolitari.RovinePerdute;

import it.unibs.fp.mylib.InputDati;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import java.io.File;
import java.util.ArrayList;

public class MainClass {

    public static final String MSG_CHOICE = "Di quale squadra fate parte?\n1- Veicolo Tonatiuh\n2- Veicolo Metztli\n3- Esci";

    public static void main(String[] args) {

        ArrayList<City> arry_city = new ArrayList<>();
        ArrayList<Vertex> vertex_Tonatiuh = new ArrayList<>();
        ArrayList<Vertex> vertex_Metztli = new ArrayList<>();

        File file = new File("RovinePerdute/src/test_file/PgAr_Map_5.xml");
        arry_city = Xml.readCity(file);

        for (City c : arry_city){
            System.out.println(c);
        }

        Operations.dijkstra(arry_city, vertex_Tonatiuh, vertex_Metztli);
        for (Vertex v: vertex_Metztli){
            System.out.println(v);
        }

    }
}
