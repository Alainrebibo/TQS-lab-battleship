import controller.Controller;
import model.Board;
import model.Direction;
import model.Game;
import model.Message;
import view.View;

public class Main {

  public static void main(String[] args) {

    Game game = new Game();
    View view = new View();

    Controller controller = new Controller(game, view);

    startPlaying(controller);
  }

  private static void startPlaying(Controller controller) {
    controller.printTitle();
    controller.printBoardP1();

    int[] sizeShip = {1,1,1,1,2,2,2,3,3,4};
    int i = 0;

    while (i < sizeShip.length){

      controller.getView().showInputShip(sizeShip[i]); //Mensaje tamaño barco

      controller.getView().showInputFila(); //Mensaje fila
      int fila = controller.scannerInt();

      controller.getView().showInputCol(); //Mensaje columna
      int col = controller.scannerInt();

      Direction direction = controller.getDirection(sizeShip[i]); //Obtener dirección

      Board boardP1 = controller.getBoardP1(); //Obtiene board 1
      if(boardP1.addShip(fila, col, sizeShip[i], direction)){
        controller.getView().shipRestantes(controller.getBoardP1().getNumShips());
        controller.printBoardP1();
        i++;

      }else{
        controller.getView().showErrorCoord();
      }

    }

    controller.getView().startGame();
    controller.getModel().startGame();

    Message result;

    do{
      int fila, col, turn;
      turn = controller.getModel().getTurn();
      if(turn % 2 == 0){

        controller.getView().turnoJugador(controller.getModel().getTurn());
        controller.getView().hitFila();
        fila = controller.scannerInt();
        controller.getView().hitCol();
        col = controller.scannerInt();

        result = controller.hitValid(fila, col);

        controller.resultHit(result,  col, fila);

      }else{//Turno maquina

        result = controller.hitValid(controller.getBoardP2().getCoordinateRandom().getX(), controller.getBoardP2().getCoordinateRandom().getY());

        controller.getView().machineTurnResult();
        controller.resultHit(result, -1, -1);
      }
      controller.getModel().changeTurn();

      controller.getView().printBoard(controller.getModel().getPlayer1().getBoardEnemy());
      controller.getView().printBoard(controller.getBoardP2());

    }while(!controller.getModel().getGameFinish());

    controller.showWinner();
  }

}


