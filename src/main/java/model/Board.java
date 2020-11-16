package model;

import java.util.ArrayList;
import java.util.Random;

public class Board {

  public final int MAX_SIZE = 10;
  Coordinate[][] matrix;
  ArrayList<Ship> ships;

  public Board() {
    this.matrix = new Coordinate[MAX_SIZE][MAX_SIZE];

    for (int i = 0; i < getSizeRow(); i++) {
      for (int j = 0; j < getSizeCol(); j++) {
        
        this.matrix[i][j] = new Coordinate(i,j,State.EMPTY);
      }
    }

    this.ships = new ArrayList<>();

  }

  public Coordinate[][] getMatrix() { return matrix; }

  public int getSizeCol() {
    return  MAX_SIZE;
  }

  public int getSizeRow() { return MAX_SIZE; }

  public ArrayList<Ship> getShips() {
    return ships;
  }

  public int getNumShips(){return  this.ships.size();}

  //Recibe una coordenada y devuelve la misma coordenada pero en el tablero
  public Coordinate getCord(Coordinate coordinate){
    return this.matrix[coordinate.getX()][coordinate.getY()];
  }

  //Devuelve el estado de la coordenada en el tablero
  public State getState(int i,int j) { return this.matrix[i][j].getState(); }

  //Obtiene una coordenada valida aleatoriamente
  public Coordinate getCoordinateRandom() {
    return new Coordinate(randomNumber(), randomNumber());
  }

  //Añade barcos al tablero
  public boolean addShip(Ship ship) {

    boolean shipAdd = false;

    //Comprueba si el barco se puede añadir al tablero
    if(shipCanAddToBoard(ship)) {
      for (int i = 0; i < ship.getCoord().length; i++) {
        int x = ship.getCoord()[i].getX();
        int y = ship.getCoord()[i].getY();
        this.matrix[x][y].setState(State.SHIP);

      }
      this.ships.add(ship);
      shipAdd = true;
    }

    return shipAdd;

  }

  //Añadir barco con otro constructor para clase controlador
  public boolean addShip(int fila, int col, int size, Direction dir){
    Ship ship = new Ship(new Coordinate(fila, col), size, dir);
    return addShip(ship);
  }

  /*Comprueba si se puede añadir el barco en base a si entra los límites del tablero,
  *si las coordenadas que tiene el barco estan libres y si la lista de barcos del jugador
  * no ha llegado a su máximo (10)*/
  private boolean shipCanAddToBoard(Ship ship) {
    boolean verification = false;

    if(checkShipBoundaries(ship)){
      if (checkAvailableCoordinates(ship)){
        if(this.getShips().size() <=10){
          verification = true;
        }
      }
    }

    return verification;
  }

  //Comprueba que todas las coordenadas de un barco están en los límites del tablero
  public boolean checkShipBoundaries(Ship ship){

    boolean insideBoundaries = true;

    for (Coordinate coordinate: ship.getCoord()) {

      if(!insideBoundaries(coordinate)){
        insideBoundaries = false;
        break;
      }
    }

    return insideBoundaries;
  }

  //Comprueba que la coordenada que recibe está dentro de los límites del tablero
  private boolean insideBoundaries(Coordinate coordinate) {

    int x = coordinate.getX();
    int y = coordinate.getY();

    return (x >= 0 && x <= 9) && (y >= 0 && y <= 9);

  }

  //Comprueba que las coordenadas que el barco quiere estén libres en el tablero
  private boolean checkAvailableCoordinates(Ship ship){

    boolean allEmpty = true;

    for (int i = 0; i < ship.getCoord().length; i++) {
      int x = ship.getCoord()[i].getX();
      int y = ship.getCoord()[i].getY();

      if(!isEmpty(matrix[x][y])) {
        allEmpty = false;
        return allEmpty;
      }
    }

    return  allEmpty;

  }

  //Golpea para el constructor
  public Message hit(int col, int fila){
    return  hit(new Coordinate(col, fila));
  }


  public Message hitEnemy(int fila, int col){

    if(insideBoundaries(new Coordinate(fila, col))){
      this.getCord(new Coordinate(fila, col)).setState(State.HIT);
      return Message.HIT;

    }else return Message.OUTBOUNDS;

  }

  /*Golpea en las coordenadas dadas*/
  public Message hit(Coordinate coordinate) {

    if (insideBoundaries(coordinate)){
       int x = coordinate.getX();
       int y = coordinate.getY();
      State state = this.matrix[x][y].getState();

      switch (state){
        case EMPTY :
          return Message.WATER;
        case SHIP:
          Ship ship = findShip(coordinate);

          if(ship.isAlive()){
            return Message.HIT;
          } else{
            removeShip(ship);
            return Message.HITANDROWNED;
          }
        case HIT:
          return Message.ALREADYHIT;
      }
    }

    return Message.OUTBOUNDS;
  }

  //Borra barcos de la lista de barcos del tablero
  public void removeShip(Ship ship) {

    this.ships.remove(ship);

  }

  public Ship findShip(Coordinate coordinateHit) {

    for (Ship ship: this.ships) {

      for (Coordinate shipCoordinate : ship.getCoord()) {

        if(coordinateHit.getX() == shipCoordinate.getX() && coordinateHit.getY() == shipCoordinate.getY()){
          shipCoordinate.setState(State.HIT);
          this.getCord(coordinateHit).setState(State.HIT);

          return ship;

        }
      }
    }

    //NUNCA PASA POR AQUI PORQUE SOLO SE TRABAJA CON BARCOS YA INSERTADOS EN EL BOARD
    return null;

  }

  //Comprueba si el estado de la coordenada recibida es vacía
  private  boolean isEmpty(Coordinate coord){
    boolean empty = false;

    if(coord.getState() == State.EMPTY) {
      empty = true;
    }
      return empty;
  }

  //Setea el el tablero de forma aleatória asegurándose de que los barcos no se pisen y estén dentro de los límites
  public boolean setBoardRandom(){

    int[] shipsToSet = {1,1,1,1,2,2,2,3,3,4};

    int i = 0;
    while(i < 10){
      Coordinate coordinate = getCoordinateRandom();
      Ship ship = new Ship(coordinate, shipsToSet[i], randomDirection());
      if (addShip(ship)){
        i++;
      }
    }

    return true;
  }

  //Devuelve un numero aleatorio dentro del limite del tablero
  private int randomNumber(){
    Random rand = new Random();
    return rand.nextInt(MAX_SIZE-1) + 1;
  }

  //Devuelve una direccion (vertical/horizontal) aleatoria
  private Direction randomDirection(){
    Random rand = new Random();
    return Direction.values()[rand.nextInt(Direction.values().length)];
  }

}
