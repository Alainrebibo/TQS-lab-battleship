import controller.Controller;
import model.*;

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
    public void startGameTest(){

        assertFalse(controller.getModel().getGameFinish());
        boolean player1 = this.controller.getModel().getPlayer1().getWon();
        boolean player2 = this.controller.getModel().getPlayer2().getWon();
        assertFalse(player1);
        assertFalse(player2);

    }
    @Test
    public void endGameTest(){

        this.controller.getModel().getPlayer1().won();

        boolean player1 = this.controller.getModel().getPlayer1().getWon();
        boolean player2 = this.controller.getModel().getPlayer2().getWon();

        assertTrue(player1);
        assertFalse(player2);
    }

    @Test
    public void getBoardTest(){
        Board board = controller.getModel().getPlayer1().getBoard();
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

        Coordinate[][] matrixBoard = this.controller.getModel().getPlayer1().getBoardEnemy().getMatrix();
        Coordinate[][] matrixAux = gameAux.getPlayer1().getBoardEnemy().getMatrix();

        for (int i = 0; i < matrixBoard.length; i++) {
            for (int j = 0; j < matrixAux.length; j++) {
                assertEquals(matrixBoard[i][j].getState(), matrixAux[i][j].getState());
            }
        }
    }



}
