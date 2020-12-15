package controller;

import model.Game;
import model.Message;
import model.MockBoard;
import model.MockInputs;
import view.View;

public class Partidas {
    private Game game = new Game();
    private View view = new View();
    private Controller controller = new Controller(game, view);
    public void play(int partida){
        controller.printTitle();
        controller.printBoardP1();
        MockBoard mockBoard1 = new MockBoard();
        MockBoard mockBoard2 = new MockBoard();
        MockBoard mockBoard3 = new MockBoard();
        MockBoard mockBoard4 = new MockBoard();
        MockInputs mockInputs = new MockInputs();
        mockInputs.crearPila(partida);
        controller.getModel().getPlayer1().setBoard(mockBoard1.setBoardPlayer(partida));
        controller.getModel().getPlayer1().setBoardEnemy(mockBoard2.setBoardMachine(partida));
        controller.getModel().getPlayer2().setBoard(mockBoard3.setBoardMachine(partida));
        controller.getModel().getPlayer2().setBoardEnemy(mockBoard4.setBoardPlayer(partida));
        controller.getView().startGame();
        controller.getModel().setTurn(0);
        Message result;
        do {
            System.out.print(game.getTurn());
            int fila=mockInputs.leerPila();
            int col=mockInputs.leerPila();
            result = controller.hitValid(fila, col);
            controller.resultHit(result, col, fila);
            game.changeTurn();
            controller.printBoardP1();
            controller.printBoardP2();
        }while(!game.getGameFinish());
    }

    public Game getGame(){
        return game;
    }
}
