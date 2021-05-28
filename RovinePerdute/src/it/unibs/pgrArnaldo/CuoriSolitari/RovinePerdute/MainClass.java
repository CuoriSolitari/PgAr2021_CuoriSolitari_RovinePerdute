package it.unibs.pgrArnaldo.CuoriSolitari.RovinePerdute;

import it.unibs.fp.mylib.InputDati;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

public class MainClass {

    public static void main(String[] args) {

        ArrayList<City> array_city;
        ArrayList<Vertex> vertex_Tonatiuh = new ArrayList<>();
        ArrayList<Vertex> vertex_Metztli = new ArrayList<>();
        Stack<Integer> stack;

        File file = new File("RovinePerdute/src/test_file/PgAr_Map_5.xml");
        array_city = Xml.readCity(file);

        for (City c : array_city){
            System.out.println(c);
        }

        Operations.dijkstra(array_city, vertex_Tonatiuh, vertex_Metztli);
        for (Vertex v: vertex_Metztli){
            System.out.println(v);
        }

        stack = Operations.getRoute(vertex_Metztli);
        for(int i=0; i<stack.size(); i++){
            System.out.println(stack.get(i));
        }

    }
}
