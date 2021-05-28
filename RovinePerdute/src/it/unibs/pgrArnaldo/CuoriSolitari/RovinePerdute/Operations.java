package it.unibs.pgrArnaldo.CuoriSolitari.RovinePerdute;

import java.util.ArrayList;
import java.util.Stack;

public class Operations {

    private static double dist;
    private static double dist_high;

    /**
     *Calcola la distanza euclidea
     * @param p1
     * @param p2
     * @return dist
     */
    public static double getDist(Position p1, Position p2){

        dist = Math.sqrt((Math.pow((p2.getX() - p1.getX()), 2)) + (Math.pow((p2.getY() - p1.getY()), 2)));
        return dist;
    }

    /**
     * Calcola la differenza di altitudine
     * @param p1
     * @param p2
     * @return dist_high
     */
    public static double getHighDist(Position p1, Position p2){

        dist_high = p1.getH() - p2.getH();

        if(dist_high < 0)
            dist_high = -1 * dist_high;

        return dist_high;
    }

    /**
     * Tramite l'algoritmo di Dijkstra trova la minima distanza dell'array di nodi
     * In questo caso della distanza del veicolo
     * @param array_city
     * @return vertex_dist
     */
    public static ArrayList<Vertex> dijkstra(ArrayList<City> array_city) {

        //Inizializza i due arraylist con le città
        ArrayList<Vertex> vertex_dist = new ArrayList<>();
        for(City city: array_city){
            Vertex vertex = new Vertex(city, 0, Double.MAX_VALUE);
            vertex_dist.add(vertex);
        }
        vertex_dist.get(0).setDistance(0);

        for(City city: array_city) {

            for(Integer link: city.getLink()) {

                double distance = getDist(city.getPosition(), vertex_dist.get(link).getCity().getPosition()) + vertex_dist.get(city.getId()).getDistance();
                if ( distance < vertex_dist.get(link).getDistance()) {
                    vertex_dist.get(link).setDistance(distance);
                    vertex_dist.get(link).setFrom(city.getId());
                }
            }
        }
        return vertex_dist;
    }

    /**
     * Tramite l'algoritmo di Dijkstra trova la minima distanza dell'array di nodi
     * In questo caso della distanza del veicolo
     * @param array_city
     * @return vertex_high_dist
     */
    public static ArrayList<Vertex> dijkstraHigh(ArrayList<City> array_city) {

        //Inizializza i due arraylist con le città
        ArrayList<Vertex> vertex_high_dist = new ArrayList<>();
        for(City city: array_city){
            Vertex vertex = new Vertex(city, 0, Double.MAX_VALUE);
            vertex_high_dist.add(vertex);
        }
        vertex_high_dist.get(0).setDistance(0);

        for(City city: array_city) {

            for(Integer link: city.getLink()) {

                double distance = getHighDist(city.getPosition(), vertex_high_dist.get(link).getCity().getPosition()) + vertex_high_dist.get(city.getId()).getDistance();
                if ( distance < vertex_high_dist.get(link).getDistance()) {
                    vertex_high_dist.get(link).setDistance(distance);
                    vertex_high_dist.get(link).setFrom(city.getId());
                }
            }
        }
        return vertex_high_dist;
    }

    /**
     * Crea una stack con gli id del percorso più veloce per raggingere l'ultimo elemento dell'array di nodi
     * @param array_vertex
     * @return stack_id
     */
    public static Stack<Integer> getRoute(ArrayList<Vertex> array_vertex){

        Stack<Integer> stack_id = new Stack<>();

        int id = array_vertex.size()-1;
        do {
            stack_id.add(0, id);
            id = array_vertex.get(id).getFrom();
        } while ( id > 0 );
        stack_id.add(0, id);


        return stack_id;
    }
}
