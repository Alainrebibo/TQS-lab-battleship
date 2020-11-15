import controller.Controller;
import model.Game;

import model.Ship;
import model.State;
import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Test;
import view.View;

import static org.junit.Assert.*;

public class ControllerTest {

    private MockInputShips mkInput;
    private View view;
    private Controller controller;
    private Game game;

    @BeforeEach
    public void setUp() throws Exception{

        game = new Game();
        view = new View();
        controller = new Controller(game, view);

        mkInput = new MockInputShips(new Game());
        view = new View();

    }
    
    @Test
    public void scannerInputShipCorrect(){

        for(Ship ship : mkInput.getShips()){
            assertTrue(controller.insertShipP1(
                    ship.getIniCoord().getX(),
                    ship.getIniCoord().getY(),
                    ship.getSize(),
                    ship.getDirection()));
        }

        for(Ship ship : mkInput.getShips()){

            for (int i = 0; i < ship.getCoord().length; i++) {
                int mkX = ship.getCoord()[i].getX();
                int mkY = ship.getCoord()[i].getY();

                int boardX = controller.getModel().getPlayer1().getBoard().getCord(ship.getCoord()[i]).getX();
                int boardY = controller.getModel().getPlayer1().getBoard().getCord(ship.getCoord()[i]).getY();

               assertEquals(mkX,boardX);
               assertEquals(mkY,boardY);

            }
        }
    }
    //TODO TEST imnput ship incorrecto

}
