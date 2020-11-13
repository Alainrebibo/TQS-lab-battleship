import model.Coordinate;
import model.Direction;
import model.State;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {


  Coordinate coordinate;
  @Before
  public void setUp() throws  Exception{

    coordinate = new Coordinate(0,0,State.EMPTY);

  }

  @Test
  void testEmptyStateCoordinate() {

    assertEquals(State.EMPTY, coordinate.getState());

  }

  @Test
  void testShipStateCoordinate() {

    coordinate.setState(State.SHIP);
    assertEquals(State.SHIP, coordinate.getState());

  }

  @Test
  void testHitStateCoordinate() {

    coordinate.setState(State.HIT);
    assertEquals(State.HIT, coordinate.getState());

  }

  //Test empty coordinate to positioned ship
  @Test
  void testEmptyToShipStateCoordinate() {


  }

  //Test ship gets hit status
  @Test
  void testShipToHitStateCoordinate() {


  }

  @Test
  void testNoShipToEmptyStateCoordinate() {


  }

  //Test ship gets hit status
  @Test
  void testNoHitToShipStateCoordinate() {


  }

}