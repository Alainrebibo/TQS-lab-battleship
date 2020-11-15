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

  @Test
  public void getBoardTest(){
    Board board = game.getPlayer1().getBoard();
    Game gameAux = new Game();

    Coordinate[][] matrixBoard = board.getMatrix();
    Coordinate[][] matrixAux = gameAux.getPlayer1().getBoard().getMatrix();

    for (int i = 0; i < board.getMatrix().length; i++) {
      for (int j = 0; j < board.getMatrix().length; j++) {
        assertEquals(matrixBoard[i][j].getState(), matrixAux[i][j].getState());
      }
    }
  }

  @Test
  public void getBoardEnemyTest(){

    Game gameAux = new Game();

    Coordinate[][] matrixBoard = game.getPlayer1().getBoardEnemy().getMatrix();
    Coordinate[][] matrixAux = gameAux.getPlayer1().getBoardEnemy().getMatrix();

    for (int i = 0; i < matrixBoard.length; i++) {
      for (int j = 0; j < matrixAux.length; j++) {
        assertEquals(matrixBoard[i][j].getState(), matrixAux[i][j].getState());
      }
    }
  }

}
