package model;

public class Board {

  public final int MAX_SIZE = 10;
  Coordinate[][] matrix;
  Ship[] ships;
  public Board() {
  }


  public int getSizeCol() {
    return  -1;
  }

  public int getSizeRow() {

    return -1;
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
    return  false;
  }
}
