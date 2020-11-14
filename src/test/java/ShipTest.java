
import model.Coordinate;
import model.Direction;
import model.Ship;
import model.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ShipTest {

  /*TODO crear un test para cada barco diferente:
  * 4 size
  * 3 size
  * 2 size
  * 1 size*/

  Coordinate coordinateZeroZeroEmpty;
  Coordinate coordinateZeroZeroShip;
  Ship ship ;

  @BeforeEach
  public void setUp(){

    this.coordinateZeroZeroEmpty = new Coordinate(0,0, State.EMPTY);
    this.coordinateZeroZeroShip = new Coordinate(0,0, State.SHIP);


    ship = new Ship(coordinateZeroZeroEmpty,1, Direction.HORIZONTAL);
  }

  @Test
  void testShipCreationSize1(){

    assertEquals(1, ship.getSize());
  }

  @Test
  void testShipCreationSize2(){

    ship = new Ship(coordinateZeroZeroEmpty,2, Direction.HORIZONTAL);
    assertEquals(2, ship.getSize());
  }

  @Test
  void testShipCreationSize3(){

    ship = new Ship(coordinateZeroZeroEmpty,3, Direction.HORIZONTAL);
    assertEquals(3, ship.getSize());
  }

  @Test
  void testShipCreationSize4(){

    ship = new Ship(coordinateZeroZeroEmpty,4, Direction.HORIZONTAL);
    assertEquals(4, ship.getSize());
  }

  /*Test size mínimo(1) máximo(4)  */
  @Test
  void testShipCoordinatesInitialization(){
    ship = new Ship(coordinateZeroZeroEmpty, 1, Direction.HORIZONTAL);
    Coordinate aux = ship.getIniCoord();
    assertEquals(coordinateZeroZeroShip, ship.getIniCoord());

    ship = new Ship(coordinateZeroZeroEmpty, 4, Direction.VERTICAL);
     aux = ship.getIniCoord();
    assertEquals(coordinateZeroZeroShip, ship.getIniCoord());
  }

/*  @Test
  void testShipSizeCorrect(){
    *//* TODO ??Estos test son los que hemos hecho arriba de size 1 a size 4*//*

  }*/

  /*Test size mínimo(1) máximo(4)  */
  @Test
  void testShipDirectionCorrect(){

    ship = new Ship(coordinateZeroZeroEmpty, 1, Direction.HORIZONTAL);
    assertEquals(Direction.HORIZONTAL, ship.getDirection());

    ship = new Ship(coordinateZeroZeroEmpty, 1, Direction.VERTICAL);
    assertEquals(Direction.VERTICAL, ship.getDirection());

    ship = new Ship(coordinateZeroZeroEmpty, 4, Direction.HORIZONTAL);
    assertEquals(Direction.HORIZONTAL, ship.getDirection());

    ship = new Ship(coordinateZeroZeroEmpty, 4, Direction.VERTICAL);
    assertEquals(Direction.VERTICAL, ship.getDirection());

  }
  /*Test size mínimo(1) máximo(4)  */
  @Test
  void testShipDirectionNotCorrect(){

    ship = new Ship(coordinateZeroZeroEmpty, 1, Direction.HORIZONTAL);
    assertNotEquals(Direction.VERTICAL, ship.getDirection());

    ship = new Ship(coordinateZeroZeroEmpty, 1, Direction.VERTICAL);
    assertNotEquals(Direction.HORIZONTAL, ship.getDirection());

    ship = new Ship(coordinateZeroZeroEmpty, 4, Direction.HORIZONTAL);
    assertNotEquals(Direction.VERTICAL, ship.getDirection());

    ship = new Ship(coordinateZeroZeroEmpty, 4, Direction.VERTICAL);
    assertNotEquals(Direction.HORIZONTAL, ship.getDirection());

    //TODO testear una direccion que no existe? no me deja enviar un valor aleatorio, entiendo que es pq es un enum
   /* ship = new Ship(coordinateZeroZeroEmpty, 4, ((Direction)"random value"));
    assertNotEquals(Direction.HORIZONTAL, ship.getDirection());*/

  }


}
