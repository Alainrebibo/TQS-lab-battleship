package model;


public class Ship {

    private Coordinate[] coord;
    private int size;
    private Direction direction;

    public Ship(Coordinate iniCoord, int size, Direction direction) {

        this.coord = new Coordinate[size];
        //this.coord[0] = iniCoord;
        this.size = size;

        this.direction = direction;

        /* Se ha de tener en cuenta que aqui estamos creando cualquier barco en cualquier Cordenada
        Quien ha de controlar si se add al board es el tablero que devolvera false si no puede add el barco*/

        //caso horizonal se ha de fixear la i, que es la X
        //caso vertical se ha de fixear la J, que es la Y

        if(this.direction == Direction.HORIZONTAL)
        {
            for (int i = 0; i < this.size; i++) {
                coord[i] = new Coordinate(iniCoord.getX()+1+i, iniCoord.getY()+1, State.SHIP);
            }
        }else if(this.direction == Direction.VERTICAL)
        {
            for (int i = 0; i < this.size; i++) {
                coord[i] = new Coordinate(iniCoord.getX()+1, iniCoord.getY()+1+i, State.SHIP);
            }
        }
    }
    public Coordinate[] getCoord(){

        return this.coord;
    }

    public int getSize() {
        return this.size;
    }

    public Coordinate getIniCoord() {
        return this.coord[0];
    }

    public Direction getDirection(){
        return this.direction;
    }

    public boolean isAlive() {

        boolean alive = false;

        for (Coordinate coordinate : this.coord) {
            if (coordinate.getState() == State.SHIP) {
                alive = true;
                break;
            }
        }

        return alive;
    }
}
