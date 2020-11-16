import model.Coordinate;
import model.Direction;
import model.State;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

  Coordinate coordinate;
  @BeforeEach
  public void setUp() throws  NullPointerException{

    coordinate = new Coordinate(0,0,State.EMPTY);

  }

  @Test
  void testStateCoordinate() {

    assertEquals(State.EMPTY, coordinate.getState());
    coordinate.setState(State.HIT);
    assertEquals(State.HIT, coordinate.getState());
    coordinate.setState(State.SHIP);
    assertEquals(State.SHIP, coordinate.getState());
  }


}