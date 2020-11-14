package model;

import org.junit.jupiter.api.BeforeEach;

public class Board {

  public final int MAX_SIZE = 10;
  Coordinate[][] board;
  Ship[] ships;

  public Board() {
    board = new Coordinate[MAX_SIZE][MAX_SIZE];

    for (int i = 0; i < getSizeRow(); i++) {
      for (int j = 0; j < getSizeCol(); j++) {
        
        board[i][j] = new Coordinate(i,j,State.EMPTY);
      }
    }

    ships = new Ship[10];//cada jugador dispone de 10 Ships

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




    return  true;
  }
  public boolean ShipInRange(Coordinate[] coord){

    //TODO verificar que puedo add el SHIP
    return false;
  }

  public State getState(int i, int j) {

    return  this.board[i][j].getState();
  }
}
