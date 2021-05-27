package it.unibs.pgrArnaldo.CuoriSolitari.RovinePerdute;

import java.util.ArrayList;

public class Operations {

    private double dist;
    private double dist_high;
    private ArrayList<Vertex> vertex;

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
     * Caòcola la differenza di altitudine
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

    public ArrayList<Vertex> dijkstra(){

        return vertex;
    }
}
