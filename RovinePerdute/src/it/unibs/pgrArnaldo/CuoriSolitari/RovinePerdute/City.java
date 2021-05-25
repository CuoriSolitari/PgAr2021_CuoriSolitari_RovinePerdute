package it.unibs.pgrArnaldo.CuoriSolitari.RovinePerdute;

import java.util.ArrayList;

public class City {

    private Position coord;
    private String name;
    private int id;
    private ArrayList<Integer> link;

    public City(Position coord, String name, int id, ArrayList<Integer> link) {
        this.coord = coord;
        this.name = name;
        this.id = id;
        this.link = link;
    }

    public Position getCoord() {
        return coord;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getLink() {
        return link;
    }
}
