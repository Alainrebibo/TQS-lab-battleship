import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


class PlayerTest {

  Game game;
  @BeforeEach
  public void setUp(){

    game = new Game();
  }

  @Test
  void testPlayerName(){

    String name = "Manolo";
    Player player = new Player(name);
    assertEquals(player.getName(), name);

  }

  @Test
  void testPlayerHasWon(){

    Player player = new Player();
    assertFalse(player.hasWon());

  }

}
