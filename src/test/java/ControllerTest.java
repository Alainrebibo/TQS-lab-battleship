import controller.Controller;
import model.*;

import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Test;
import view.View;

import static org.junit.Assert.*;

public class ControllerTest {

    private MockInputShips mkInput;
    private Controller controller;

    @BeforeEach
    public void setUp() throws Exception{

         Game game = new Game();
         View view = new View();
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

   @Test
    public void testDirecctionCorrect(){
       int[] shipsToSet = {2,2,2,3,3,4};
       int i = 0;
       MockDirecction mkDir = new MockDirecction();

       for(Integer key : mkDir.getmDirecction().keySet()){

           this.mkInput.scanner(key);
           Direction dirController = controller.getDirection(shipsToSet[i]);
           assertTrue( dirController == Direction.HORIZONTAL || dirController == Direction.VERTICAL);

           i++;
       }
   }

    public void testDirecctionIncorrect(){
        int[] shipsToSet = {2,2,2,3,3,4};
        int i = 0;
        MockDirecction mkDir = new MockDirecction();

        for(Integer key : mkDir.getmDirecctionIncorrect().keySet()){
            //TODO como enviar un input, y cuando este en la funcion getDirCorrect enviar otro input...
            this.mkInput.scanner(key);
            int correct = controller.getDirCorrect(shipsToSet[i]);
            assertTrue( correct == -1);

            i++;
        }
    }


    @Test
    public void endGameTest(){

        this.controller.getModel().getPlayer1().won();

        boolean player1 = this.controller.getModel().getPlayer1().getWon();
        boolean player2 = this.controller.getModel().getPlayer2().getWon();

        assertTrue(player1);
        assertFalse(player2);
    }







}
