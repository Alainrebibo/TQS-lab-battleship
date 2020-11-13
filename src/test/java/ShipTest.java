import model.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ShipTest {

  /*TODO crear un test para cada barco diferente:
  * 4 size
  * 3 size
  * 2 size
  * 1 size*/

  Coordinate coor00;
  Ship ship ;

  @Before
  public void setUp() throws  Exception{

    coor00 = new Coordinate(0,0, State.EMPTY);
    ship = new Ship(coor00,1, Direction.HORIZONTAL);
  }

  @Test
  void testShipCreationSize1(){

    assertEquals(1, ship.getSize());

  }

  void testShipCreationSize2(){

    ship = new Ship(coor00,2, Direction.HORIZONTAL);
    assertEquals(2, ship.getSize());

  }

  void testShipCreationSize3(){

    ship = new Ship(coor00,3, Direction.HORIZONTAL);
    assertEquals(3, ship.getSize());
  }

  void testShipCreationSize4(){

    ship = new Ship(coor00,4, Direction.HORIZONTAL);
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
