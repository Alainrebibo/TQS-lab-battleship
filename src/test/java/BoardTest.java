import model.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class BoardTest {

  Board board;
  int size1;
  int size2;
  int size3;
  int size4;

  @BeforeEach
  public void setUp() throws  Exception{

    board = new Board();
    size1 = 1;
    size2 = 2;
    size3 = 3;
    size4 = 4;

  }

  /*Se determina que se ha creado correcamente un tablero vacio, si todoas
  * las coordenadas tienen el estdo vacio (EMPTY).*/
  @Test
  void testBoardCreation(){

    for (int i = 0; i < board.getSizeCol(); i++) {
      for (int j = 0; j < board.getSizeRow(); j++) {
        assertEquals(board.getState(i, j), State.EMPTY);
      }
    }

  }

  /*Se puede verificar si se ha insertado correcamente barco, si el methodo
  * ha devuelto True*/
  @Test
  void testAddShipCorrect(){
    /*Se ha de tener en cuenta, que no pueden add barcos adjacentes, estos
    * han de tener minimo un cuado de separacion.*/
    Coordinate coord00 = new Coordinate(0,0, State.SHIP);
    Ship ship1 = new Ship(coord00, size1,Direction.HORIZONTAL );
    boolean result = board.addShip(ship1);
    assertTrue(result);

    Coordinate coord20 = new Coordinate(0,2, State.SHIP);
    Ship ship2 = new Ship(coord20, size2,Direction.HORIZONTAL );
    board.addShip(ship2);
    assertTrue(result);

    Coordinate coord40 = new Coordinate(0,4, State.SHIP);
    Ship ship3 = new Ship(coord40, size3,Direction.HORIZONTAL );
    board.addShip(ship3);
    assertTrue(result);

    Coordinate coord60 = new Coordinate(0,6, State.SHIP);
    Ship ship4 = new Ship(coord60, size4,Direction.HORIZONTAL );
    board.addShip(ship4);
    assertTrue(result);

  }


  @Test
  void testaddShipOutofRange(){

    Coordinate coordOut = new Coordinate(15,15, State.SHIP);
    Ship ship1 = new Ship(coordOut, size1, Direction.HORIZONTAL);
    boolean result = board.addShip(ship1);
    assertFalse(!result);
  }

  @Test
  void testRemoveShipCorrect(){

    /*TODO remover para? si la eliminamos perdemos la información de donde
    *  esta la nave y no podemos mostrarla en la interfaz que ya han undido
    * la nave*/


  }

  @Test
  void testRemoveNotExistingShip(){




  }

  @Test
  void testHitShipOutsideBoard(){

    Coordinate coordinate = new Coordinate(-1, 25);
    //board.hit(coordinate);

    assertFalse(board.hit(coordinate));


  }

  @Test
  void testHitEmptyCoordinate(){




  }

  @Test
  void testHitShipCoordinate(){


  }

  @Test
  void testCheckBoundaries(){

  }

  @Test
  void testCheckAvailableCoordinates(){

  }

  @Test
  void testCheckNoShipAround(){

  }




}
