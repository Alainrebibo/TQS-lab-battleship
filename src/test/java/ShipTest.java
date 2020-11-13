
import model.Coordinate;
import model.Direction;
import model.Ship;
import model.State;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ShipTest {

  /*TODO crear un test para cada barco diferente:
  * 4 size
  * 3 size
  * 2 size
  * 1 size*/

  Coordinate coordinateZeroZeroEmpty;
  Ship ship ;

  @Before
  public void setUp(){

    this.coordinateZeroZeroEmpty = new Coordinate(0,0, State.EMPTY);

  }

  @Test
  void testShipCreationSize1(){

    ship = new Ship(coordinateZeroZeroEmpty,1, Direction.HORIZONTAL);
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


  @Test
  void testShipCoordinatesInitialization(){

  }

  @Test
  void testShipSizeCorrect(){

  }

  @Test
  void testShipDirectionCorrect(){

  }

  @Test
  void testShipDirectionNotCorrect(){

  }


}
