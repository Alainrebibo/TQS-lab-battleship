package model;


public class Ship {

    private Coordinate[] coord;
    private int size;
    private Direction direction;

    //Crea los barcos en función de una coordenada iicial que es la "cabeza"
    public Ship(Coordinate iniCoord, int size, Direction direction) {

        this.coord = new Coordinate[size];
        this.size = size;
        this.direction = direction;

        if(this.direction == Direction.HORIZONTAL)
        {
            for (int i = 0; i < this.size; i++) {
                //Crea tantas partes del barco como tamaño tiene partiendo del punto inicia en el eje de las X
                coord[i] = new Coordinate(iniCoord.getX()+1+i, iniCoord.getY()+1, State.SHIP);
            }
        }else if(this.direction == Direction.VERTICAL)
        {
            for (int i = 0; i < this.size; i++) {
                //Crea tantas partes del barco como tamaño tiene partiendo del punto inicia en el eje de las Y
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

    //Comprueba si el barco está vivo comprobando que almenos una de sus coordenadas tenga estado barco
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
