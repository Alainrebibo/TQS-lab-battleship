package model;

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
    return  true;
  }

  public State getState(int i, int j) {

    return  this.board[i][j].getState();
  }
}
