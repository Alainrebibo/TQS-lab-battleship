import controller.Controller;
import model.Direction;
import model.Game;
import view.ProvisionalView;

public class Main {

  public static void main(String[] args) {

    Game game = new Game();
    ProvisionalView view = new ProvisionalView();

    Controller controller = new Controller(game, view);

    //controller.startGame();

    controller.printBoardP1();


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


    System.out.println();
    System.out.println();
    System.out.println();
    controller.printBoardP1();



  }
}
