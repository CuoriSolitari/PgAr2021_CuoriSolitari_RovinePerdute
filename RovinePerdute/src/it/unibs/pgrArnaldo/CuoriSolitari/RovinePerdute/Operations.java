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
            dist_high = -dist_high;

        return dist_high;
    }

    /**
     * Utilizza l'algoritmo di dijkstra per trovare la minima distanza dal punto di partenza
     * @param array_city
     * @param vertex_dist
     * @param vertex_high_dist
     */
    public static void dijkstra(ArrayList<City> array_city, ArrayList<Vertex> vertex_dist, ArrayList<Vertex> vertex_high_dist){

        //Inizializza i due arraylist con le città
        for(City city: array_city){
            Vertex vertex = new Vertex(city, 0, Double.MAX_VALUE);
            vertex_dist.add(vertex);
            vertex_high_dist.add(vertex);
        }
        vertex_dist.get(0).setDistance(0);
        vertex_high_dist.get(0).setDistance(0);

        for(City city: array_city){

            for(Integer link: city.getLink()){

                double distance = getDist(city.getPosition(), vertex_dist.get(link).getCity().getPosition());

                if (vertex_dist.get(link).getDistance() >= (distance + vertex_dist.get(city.getId()).getDistance()) ){

                    int id = city.getId();
                    if (vertex_dist.get(link).getDistance() == (distance + vertex_dist.get(city.getId()).getDistance())) {

                        Stack stack1 = getRoute(vertex_dist);
                        int og_from = vertex_dist.get(link).getFrom();
                        vertex_dist.get(link).setFrom(city.getId());
                        Stack stack2 = getRoute(vertex_dist);

                        if ( stack1.size() < stack2.size())
                            id = og_from;
                    }

                    vertex_dist.get(link).setFrom(id);
                    vertex_dist.get(link).setDistance(distance + vertex_dist.get(id).getDistance());
                }

                double high_distance = getHighDist(city.getPosition(), vertex_high_dist.get(link).getCity().getPosition());

                if (vertex_high_dist.get(link).getDistance() > (high_distance + vertex_high_dist.get(city.getId()).getDistance())) {

                    int id = city.getId();
                    if (vertex_high_dist.get(link).getDistance() == (high_distance + vertex_high_dist.get(city.getId()).getDistance())) {

                        Stack stack1 = getRoute(vertex_high_dist);
                        int og_from = vertex_high_dist.get(link).getFrom();
                        vertex_high_dist.get(link).setFrom(city.getId());
                        Stack stack2 = getRoute(vertex_high_dist);

                        if ( stack1.size() < stack2.size())
                            id = og_from;
                    }

                    vertex_high_dist.get(link).setFrom(id);
                    vertex_high_dist.get(link).setDistance(high_distance + vertex_high_dist.get(id).getDistance());
                }

            }

        }

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
