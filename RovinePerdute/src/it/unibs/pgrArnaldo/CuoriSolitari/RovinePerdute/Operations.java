package it.unibs.pgrArnaldo.CuoriSolitari.RovinePerdute;

import java.util.ArrayList;

public class Operations {

    private double dist;
    private double dist_high;

    /**
     *Calcola la distanza euclidea
     * @param p1
     * @param p2
     * @return dist
     */
    public double getDist(Position p1, Position p2){

        dist = Math.sqrt((Math.pow((p2.getX() - p1.getX()), 2)) + (Math.pow((p2.getY() - p1.getY()), 2)));
        return dist;
    }

    /**
     * Calcola la differenza di altitudine
     * @param p1
     * @param p2
     * @return dist_high
     */
    public double getHighDist(Position p1, Position p2){

        dist_high = p1.getH() - p2.getH();

        if(dist_high < 0)
            dist_high = -dist_high;

        return dist_high;
    }

    /**
     * Utilizza l'algoritmo di dijkstra per trovare la minima distanza dal punto di partenza
     * @param array_city
     * @param vertex_dist
     * @param vertex_high_dist
     */
    public void dijkstra(ArrayList<City> array_city, ArrayList<Vertex> vertex_dist, ArrayList<Vertex> vertex_high_dist){

        //Inizializza i due arraylist con le città
        Vertex vertex;
        for(City city: array_city){
            vertex = new Vertex(city, 0, Double.MAX_VALUE);
            vertex_dist.add(vertex);
            vertex_high_dist.add(vertex);
        }

        for(City city: array_city){

            for(Integer link: city.getLink()){


            }

        }

    }
}
