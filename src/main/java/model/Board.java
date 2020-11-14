package model;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class Board {

  public final int MAX_SIZE = 10;
  Coordinate[][] board;
  ArrayList<Ship> ships;

  public Board() {
    board = new Coordinate[MAX_SIZE][MAX_SIZE];

    for (int i = 0; i < getSizeRow(); i++) {
      for (int j = 0; j < getSizeCol(); j++) {
        
        board[i][j] = new Coordinate(i,j,State.EMPTY);
      }
    }

    this.ships = new ArrayList<>();
        //new Ship[10];//cada jugador dispone de 10 Ships

  }


  public int getSizeCol() {
    return  MAX_SIZE;
  }

  public int getSizeRow() {

    return MAX_SIZE;
  }

  public Coordinate getCord(int x, int y){
    return null;
  }

  public boolean addShip(Ship ship) {
    /* TODO
    para poder add un Ship primero ha de verificar que pueda entrar.
    * Para que pueda entrar tiene que ver si se pondra en vertical o horizonal y que todas las casillas esten EMPTY
    *
    *   En el caso que se encuentres todas en EMPTY tendra que pasarlas de EMPTY a SHIP las coordenadas del tablero.
    *  Estas cordenadas tambien se han de guardar en el propio objeto SHIP para saber donde se encuentra la Ship
    *
    *   TODO crear un nuevo estado, busy, este determina que en las casillas adjacentes que no se pueden poner barcos.*/

      /*1 - Recorrer la matriz con las posoiciones de ship,
      * 2 - Si todos los estados del la matriz son EMPTY
      *       - Cambiar estado de EMPTY a SHIP
      *       - Casillas adjayentes poner un estado que no se pueden ocupar (reglas del juego)
      *       - Defolver True, porque se ha podido insertar
      * 3 - Alguno != Empty o cualquier otro caso (Ej. Fuera de rango)
      *       - Devolver False
      *       - Pedir que se introduzca otra posicion inicial
      * */


    boolean shipAdd = false;

    if(shipCanAddToBoard(ship))
    {
      for (int i = 0; i < ship.getCoord().length; i++) {
        int x = ship.getCoord()[i].getX();
        int y = ship.getCoord()[i].getY();
        board[x][y].setState(State.SHIP);
        shipAdd = true;
      }
    }

    return  shipAdd;


  }

  private boolean shipCanAddToBoard(Ship ship) {
    boolean verification = false;

    if(checkBoundaries(ship) && checkAvailableCoordinates(ship) && checkNoShipAround(ship) )
    {
      verification = true;
    }

    return  verification;
  }

  public boolean ShipInRange(Coordinate[] coord){

    //TODO verificar que puedo add el SHIP
    return false;
  }


  public State getState(int i, int j) {

    return  this.board[i][j].getState();
  }

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

  private boolean insideBoundaries(Coordinate coordinate) {

    int x = coordinate.getX();
    int y = coordinate.getY();

    return (x >= 0 && x <= 9) && (y >= 0 && y <= 9);

  }

  private boolean checkAvailableCoordinates(Ship ship){

    boolean allEmpty = true;

    for (int i = 0; i < ship.getCoord().length; i++) {
      int x = ship.getCoord()[i].getX();
      int y = ship.getCoord()[i].getY();

      // TODO comprobar que compureba todos los coordenadas que no sean empty
      if(!isEmpty(board[x][y]))
      {
        allEmpty = false;
        return allEmpty;
      }
    }
    //TODO IS EMPTY CALLING
    return  allEmpty;


  }

  private boolean checkNoShipAround(Ship ship){


    return false;
  }

  public Message hit(Coordinate coordinate) {

    if (insideBoundaries(coordinate)){

      State state = coordinate.getState();

      switch (state){

        case EMPTY :
          return Message.WATER;

        case SHIP:

          coordinate.setState(State.HIT);

          Ship ship = findShip(coordinate);

          assert ship != null;
          if(ship.isAlive()){
            return Message.HIT;
          } else{
            removeShip(ship);
            return Message.HITANDROWNED;
          }

        case HIT:
          return Message.ALREADYHIT;

          default:
          break;

      }
    }

    return Message.OUTBOUNDS;
  }

  private void removeShip(Ship ship) {

    this.ships.remove(ship);

  }

  private Ship findShip(Coordinate coordinate) {

    for (Ship ship: this.ships) {

      for (Coordinate shipCoordinate : ship.getCoord()) {

        if(coordinate == shipCoordinate){
          shipCoordinate.setState(State.HIT);
          return ship;
        }
      }
    }

    //NO DEBERIA DARSE
    return null;

  }

  private  boolean isEmpty(Coordinate coord){
    boolean empty = false;

    if(coord.getState() == State.EMPTY)
    {
      empty = true;
    }
      return empty;
  }
}
