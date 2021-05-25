package it.unibs.pgrArnaldo.CuoriSolitari.RovinePerdute;

import java.util.ArrayList;

public class Città {

    private Coordinata coord;
    private String nome;
    private int id;
    private ArrayList<Integer> link;

    public Città(Coordinata coord, String nome, int id, ArrayList<Integer> link) {
        this.coord = coord;
        this.nome = nome;
        this.id = id;
        this.link = link;
    }

    public Coordinata getCoordinata() {
        return coord;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getLink() {
        return link;
    }
}
