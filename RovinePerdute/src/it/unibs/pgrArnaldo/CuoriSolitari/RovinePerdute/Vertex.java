package it.unibs.pgrArnaldo.CuoriSolitari.RovinePerdute;

public class Vertex {

    private City city;
    private int from;
    private int distance;

    public Vertex(City city, int from, int distance) {
        this.city = city;
        this.from = from;
        this.distance = distance;
    }

    public City getCity() {
        return city;
    }

    public int getFrom() {
        return from;
    }

    public int getDistance() {
        return distance;
    }
}
