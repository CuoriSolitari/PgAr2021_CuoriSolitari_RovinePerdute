package it.unibs.pgrArnaldo.CuoriSolitari.RovinePerdute;

public class Position {

    private double coord_x;
    private double coord_y;
    private double coord_h;
    private double dist;
    private double dist_high;

    public Position(double coord_x, double coord_y, double coord_h) {

        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.coord_h = coord_h;

    }

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

    public double getX() {
        return coord_x;
    }

    public double getY() {
        return coord_y;
    }

    public double getH() {
        return coord_h;
    }

}
