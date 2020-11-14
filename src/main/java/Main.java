import controller.Controller;
import model.Direction;
import model.Game;
import view.ProvisionalView;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Game game = new Game();
    ProvisionalView view = new ProvisionalView();

    Controller controller = new Controller(game, view);

    //insertShipDefault(controller);

    controller.printBoardP1();
    /*
    * 1 - Jugador elige donde quieres poner los barcos
    * 2 - Introduce unas cordenadas iniciales (X,Y)
    * 3 - Bucle hasta que haya introducido los 10 barcos*/

    controller.inputShip();
    controller.startGame();



  }

  private static void insertShipDefault(Controller controller) {
    //SIZE 1
    System.out.println("Introducida " + controller.insertShip(1, 1, 1,Direction.HORIZONTAL));
    System.out.println("Introducida " + controller.insertShip(1, 10, 1,Direction.HORIZONTAL));
    System.out.println("Introducida " + controller.insertShip(10, 1, 1,Direction.HORIZONTAL));
    System.out.println("Introducida " + controller.insertShip(10, 10, 1,Direction.HORIZONTAL));

    //SIZE 2
    System.out.println("Introducida " + controller.insertShip(5, 1, 2,Direction.VERTICAL));
    System.out.println("Introducida " + controller.insertShip(5, 3, 2,Direction.VERTICAL));
    System.out.println("Introducida " + controller.insertShip(5, 5, 2,Direction.VERTICAL));

    // SIZE 3
    System.out.println("Introducida " + controller.insertShip(10, 5, 3,Direction.HORIZONTAL));
    System.out.println("Introducida " + controller.insertShip(8, 5, 3,Direction.HORIZONTAL));

    // SIZE 4
    System.out.println("Introducida " + controller.insertShip(2, 5, 4,Direction.HORIZONTAL));
  }
}
