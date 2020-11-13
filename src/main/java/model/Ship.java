package model;


public class Ship {

    private Coordinate coordinate;
    private int size;
    private Direction direction;

    public Ship(Coordinate coordinate, int size, Direction direction) {

        this.coordinate = coordinate;
        this.size = size;
        this.direction = direction;
    }

    public int getSize() {
        return this.size;
    }
}
