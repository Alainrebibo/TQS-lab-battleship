import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

class GameTest {

    /*Este test verifica que se crea un juego con los dos jugadores y que aun no ha acabado la partida,
    * ja que, para poder jugar el valor de terminado ha de ser false.*/

  Game game = new Game();
  @BeforeEach
  public void setUp(){
    game = new Game();

  }

  @Test
  void createGameTest(){

     game = new Game();

    assertThat(game.getPlayer1(), instanceOf(Player.class));
    assertThat(game.getPlayer2(), instanceOf(Player.class));
    assertFalse(game.getGameFinish());

  }
  @Test
  void testGameFinished(){


  }



  @Test
  public void changeTurnTest(){
    Game game = new Game();

    int numTurns = 100;
    // ships tablero vacio
    for (int turn = 0; turn <numTurns; turn++) {
      game.changeTurn();
      assertEquals(turn+1, game.getTurn());
    }
    game = new Game();//reniciamos tablero
    //tablero con barcos aleatorios
    game.getPlayer1().getBoard().setBoardRandom();
    for (int turn = 0; turn <numTurns; turn++) {
      game.changeTurn();
      assertEquals(turn+1, game.getTurn());
    }
  }

  @Test
  public void startGameTest(){

    assertFalse(this.game.getGameFinish());
    boolean player1 = this.game.getPlayer1().getWon();
    boolean player2 = this.game.getPlayer2().getWon();

    assertFalse(player1);
    assertFalse(player2);

    this.game.startGame();
    assertEquals(0 , this.game.getTurn());

  }
}
