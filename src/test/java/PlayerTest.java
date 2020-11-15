import model.Player;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


class PlayerTest {

  @Test
  void testPlayerName(){

    String name = "Manolo";
    Player player = new Player(name);
    assertEquals(player.getName(), name);

  }

  @Test
  void testPlayerHasWon(){

    Player player = new Player();
    //player.setWon(true);
    assertFalse(player.hasWon());

  }

  @Test
  void testPlayerStartsWithoutWinning(){

    Player player = new Player();
    assertEquals(player.hasWon(), false);

  }

  @Test
  void testPlayerHasLose(){

    Player player = new Player();
    assertEquals(player.hasWon(), false);

  }

}
