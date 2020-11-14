package model;


public class Ship {

    private Coordinate coordinate;
    private int size;
    private Direction direction;

    public Ship(Coordinate iniCoord, int size, Direction direction) {

        this.coordinate = iniCoord;
        this.size = size;
        this.direction = direction;
    }



    public int getSize() {
        return this.size;
    }

    public Coordinate getIniCoord() {
        return null;
    }

    public Direction getDirection(){
        return null;
    }
}
