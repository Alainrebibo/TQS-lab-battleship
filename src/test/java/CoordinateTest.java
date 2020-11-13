import model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

  @Test
  void getX() {

    Coordinate coordinate = new Coordinate(1,2);
    int x = coordinate.getX();

    assertEquals(x, 1);
  }

  @Test
  void getY() {

    Coordinate coordinate = new Coordinate(1,2);
    int y = coordinate.getY();

    assertEquals(y, 2);
  }
}