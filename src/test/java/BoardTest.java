import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import view.View;


import java.util.ArrayList;


import static org.junit.Assert.*;

public class BoardTest {

  Board board;
  int[] shipSizes;
  ArrayList<Coordinate> insideCoordinates;
  ArrayList<Coordinate> outBoundsCoordinates;
  Ship testShip;

  //PROBAR BEFORE
  @BeforeEach
  public void setUp(){
    board = new Board();
    shipSizes = new int[]{1,2,3,4};

    insideCoordinates = new ArrayList<>();
    insideCoordinates.add(new Coordinate(1,1));
    insideCoordinates.add(new Coordinate(2,4));
    insideCoordinates.add(new Coordinate(5,3));
    insideCoordinates.add(new Coordinate(7,7));
    insideCoordinates.add(new Coordinate(1,10));
    insideCoordinates.add(new Coordinate(10,6));
    insideCoordinates.add(new Coordinate(9,9));

    outBoundsCoordinates = new ArrayList<>();
    outBoundsCoordinates.add(new Coordinate(-5,5));
    outBoundsCoordinates.add(new Coordinate(5,-5));
    outBoundsCoordinates.add(new Coordinate(-5,-5));
    outBoundsCoordinates.add(new Coordinate(25,15));

  }

  /*Se comprueba que al crearse un tablero todos los estados de las coordenadas de las
  * casillas sean del tipo EMPTY (están vacías)*/
  @Test
  void testBoardCreation(){

    for (int i = 0; i < this.board.getSizeCol(); i++) {
      for (int j = 0; j < this.board.getSizeRow(); j++) {
        assertEquals(board.getState(i, j), State.EMPTY);
      }
    }

  }

  /*Comprueba que se añaden correctamente barcos de distintos tamaños
   *en vertical en el tablero en distintas posiciones del mismo. Partición equivalente
   * con números positivos */
  @Test
  void testAddShipsCorrectly(){

    //Insertamos barcos de distintos tamaños en horizontal
    testShip = new Ship(insideCoordinates.get(0), shipSizes[0], Direction.HORIZONTAL);
    assertTrue(this.board.addShip(testShip));
    testShip = new Ship(insideCoordinates.get(1), shipSizes[1], Direction.HORIZONTAL);
    assertTrue(this.board.addShip(testShip));
    testShip = new Ship(insideCoordinates.get(2), shipSizes[2], Direction.HORIZONTAL);
    assertTrue(this.board.addShip(testShip));
    testShip = new Ship(insideCoordinates.get(3), shipSizes[3], Direction.HORIZONTAL);
    assertTrue(this.board.addShip(testShip));

    this.board = new Board(); //Limpiamos el tablero

    //Insertamos barcos de distintos tamaños en horizontal
    testShip = new Ship(insideCoordinates.get(0), shipSizes[0], Direction.VERTICAL);
    assertTrue(this.board.addShip(testShip));
    testShip = new Ship(insideCoordinates.get(1), shipSizes[1], Direction.VERTICAL);
    assertTrue(this.board.addShip(testShip));
    testShip = new Ship(insideCoordinates.get(2), shipSizes[2], Direction.VERTICAL);
    assertTrue(this.board.addShip(testShip));
    testShip = new Ship(insideCoordinates.get(3), shipSizes[3], Direction.VERTICAL);
    assertTrue(this.board.addShip(testShip));

  }

  /*Comprueba que NO se añaden correctamente barcos de distintos tamaños
   *en vertical en el tablero en distintas posiciones del mismo */
  @Test
  void testAddShipsNotCorrectly(){

    //Particiones equivalentes con números negativos. Fila negativa
    testShip = new Ship(outBoundsCoordinates.get(0), shipSizes[0], Direction.HORIZONTAL);
    assertFalse(this.board.addShip(testShip));
    //Particiones equivalentes con números negativos. Columna negativa
    testShip = new Ship(outBoundsCoordinates.get(1), shipSizes[0], Direction.HORIZONTAL);
    assertFalse(this.board.addShip(testShip));
    //Particiones equivalentes con números negativos. Ambas negativas
    testShip = new Ship(outBoundsCoordinates.get(2), shipSizes[0], Direction.HORIZONTAL);
    assertFalse(this.board.addShip(testShip));
    //Particiones equivalentes con números negativos. Ambas positivas fuera de rango
    testShip = new Ship(outBoundsCoordinates.get(3), shipSizes[0], Direction.HORIZONTAL);
    assertFalse(this.board.addShip(testShip));

    //Valores límite y frontera. Última columna
    testShip = new Ship(insideCoordinates.get(4), shipSizes[3], Direction.HORIZONTAL);
    assertFalse(this.board.addShip(testShip));
    //Valores límite y frontera. Última fila
    testShip = new Ship(insideCoordinates.get(5), shipSizes[3], Direction.VERTICAL);
    assertFalse(this.board.addShip(testShip));
    //Valores límite y frontera. Penúltima fila y columna
    testShip = new Ship(insideCoordinates.get(6), shipSizes[2], Direction.VERTICAL);
    assertFalse(this.board.addShip(testShip));

    //Valor límite. Intenta añadir un barco donde ya hay uno
    testShip = new Ship(insideCoordinates.get(0), shipSizes[0], Direction.VERTICAL);
    this.board.addShip(testShip);
    testShip = new Ship(insideCoordinates.get(0), shipSizes[0], Direction.VERTICAL);
    assertFalse(this.board.addShip(testShip));

  }

  //Prueba a borrar un barco existente en el tablero
  @Test
  void testRemoveExistingShipFromBoard(){

    testShip = new Ship(insideCoordinates.get(0), shipSizes[0], Direction.HORIZONTAL);
    this.board.addShip(testShip);
    assertEquals(1, board.getShips().size());
    /*Comprueba que se borra el barco dentro del tablero*/
    this.board.removeShip(testShip);
    assertEquals(0, board.getShips().size());

  }


  //Prueba a borrar un barco no existente en el tablero
  @Test
  void testRemoveNotExistingShipFromBoard(){

    testShip = new Ship(insideCoordinates.get(0), shipSizes[0], Direction.HORIZONTAL);
    this.board.addShip(testShip);
    assertEquals(1, board.getShips().size());
    testShip = new Ship(insideCoordinates.get(1), shipSizes[1], Direction.VERTICAL);
    this.board.removeShip(testShip);
    assertEquals(1, board.getShips().size());

  }

  //Comprueba lso mensajes que devuelve el método que golpea dentro del tablero rival
  @Test
  void testHitInsideBoard(){

    testShip = new Ship(insideCoordinates.get(0), shipSizes[0], Direction.VERTICAL);
    this.board.addShip(testShip);

    //Mensaje al golpear una coordenada vacía
    assertEquals(Message.WATER, this.board.hit(insideCoordinates.get(1)));

    //Golpeamos y hundimos un barco de tamaño 1
    assertEquals(Message.HITANDROWNED, this.board.hit(insideCoordinates.get(0)));

    //Volvemos a golpear el mismo barco
    assertEquals(Message.ALREADYHIT, this.board.hit(insideCoordinates.get(0)));

    testShip = new Ship(insideCoordinates.get(3), shipSizes[2], Direction.VERTICAL);
    this.board.addShip(testShip);
    assertEquals(Message.HIT, this.board.hit(7,7));

  }

  //Comprueba el mensaje que devuelve el método que golpea fuera del tablero rival
  @Test
  void testHitOutsideBoard(){

    assertEquals(Message.OUTBOUNDS, board.hit(outBoundsCoordinates.get(0)));
    assertEquals(Message.OUTBOUNDS, board.hit(outBoundsCoordinates.get(1)));
    assertEquals(Message.OUTBOUNDS, board.hit(outBoundsCoordinates.get(2)));
    assertEquals(Message.OUTBOUNDS, board.hit(outBoundsCoordinates.get(3)));

  }

  @Test
  void testNoShipsOnCreation(){

    assertEquals(0, board.getNumShips());

  }

  @Test
  void testRandomBoardShipSetting(){

    assertTrue(this.board.setBoardRandom());

  }

  @Test
  void testHitEnemyInsideBoard(){

    testShip = new Ship(insideCoordinates.get(0), shipSizes[0], Direction.VERTICAL);
    this.board.addShip(testShip);

    assertEquals(Message.HIT, this.board.hitEnemy(1,1));

  }

  @Test
  void testHitEnemyOutsideBoard(){

    assertEquals(Message.OUTBOUNDS, this.board.hitEnemy(-25,50));

  }

}
