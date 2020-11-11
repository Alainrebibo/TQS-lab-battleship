import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    player.setWon(true);
    assertEquals(player.hasWon(), true);

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
