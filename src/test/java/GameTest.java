import model.Game;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

class GameTest {

    /*Este test verifica que se crea un juego con los dos jugadores y que aun no ha acabado la partida,
    * ja que, para poder jugar el valor de terminado ha de ser false.*/
  @Test
  void createGameTest(){

    Game game = new Game();

    assertThat(game.getPlayer1(), instanceOf(Player.class));
    assertThat(game.getPlayer2(), instanceOf(Player.class));
    assertFalse(game.getGameFinish());

  }
  @Test
  void testGameFinished(){


  }

    @Test
    void testMenu(){


    }


}
