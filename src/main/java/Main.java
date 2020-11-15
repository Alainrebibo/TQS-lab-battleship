import controller.Controller;
import model.Game;
import view.View;

public class Main {

  public static void main(String[] args) {

    Game game = new Game();
    View view = new View();

    Controller controller = new Controller(game, view);

    //insertShipDefault(controller);
    controller.printTitle();
    controller.printBoardP1();
    /*
    * 1 - Jugador elige donde quieres poner los barcos
    * 2 - Introduce unas cordenadas iniciales (X,Y)
    * 3 - Bucle hasta que haya introducido los 10 barcos*/

    controller.inputShip();
    controller.play();





  }


}
