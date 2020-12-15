import controller.Controller;
import controller.Partidas;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.View;
import static org.junit.Assert.*;

public class AutomatedTests {
    Partidas partida;
    @BeforeEach
    public void setUp(){
        partida = new Partidas();
    }

    @Test
    public void partida1(){
        partida.play(1);
        assertEquals(true,partida.getGame().getPlayer1().getWon());
    }

    @Test
    public void partida2(){
        partida.play(2);
        assertEquals(true,partida.getGame().getPlayer1().getWon());
    }

    @Test
    public void partida3(){
        partida.play(3);
        assertEquals(true,partida.getGame().getPlayer1().getWon());
    }

    @Test
    public void partida4(){
        partida.play(4);
        assertEquals(false,partida.getGame().getPlayer1().getWon());
    }

    @Test
    public void partida5(){
        partida.play(5);
        assertEquals(false,partida.getGame().getPlayer1().getWon());
    }

    @Test
    public void partida6(){
        partida.play(6);
        assertEquals(false,partida.getGame().getPlayer1().getWon());
    }
}
