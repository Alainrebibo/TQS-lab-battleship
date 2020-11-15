package view;

import model.Board;
import model.Coordinate;
import model.State;

public class View {

  public void printBoard(Board board){

    Coordinate[][] matrix = board.getMatrix();
    State state;

    System.out.print("     ");
    for(int i=1;i<=board.getSizeRow();i++) {
      System.out.print(i+"  ");
    }
    System.out.println();
    for (int i = 0; i < board.getSizeRow(); i++){
      if(i == board.getSizeRow()-1) {
        System.out.print(i + 1 + " ");
      }else{
        System.out.print(i+1+"  ");
      }
      for (int j = 0; j < board.getSizeCol(); j++) {
        System.out.print("  ");
        state = matrix[i][j].getState();
        if(state == State.HIT){
          System.out.print('X');
        }else if (state == State.EMPTY){
          System.out.print('~');
        } else{
          System.out.print('O');
        }
      }
      System.out.println();
    }
  }

  public void printBoardPos(Board board){

    Coordinate[][] matrix = board.getMatrix();
    State state;

    System.out.print("     ");
    for(int i=1;i<=board.getSizeRow();i++) {
      System.out.print(i+"  ");
    }
    System.out.println();
    for (int i = 0; i < board.getSizeRow(); i++){

      if(i == board.getSizeRow()-1) {
        System.out.print(i + 1 + " ");
      }else{
        System.out.print(i+1+"  ");
      }

      for (int j = 0; j < board.getSizeCol(); j++) {
        System.out.print("  ");
        state = matrix[i][j].getState();
        Coordinate xy = matrix[i][j];
        System.out.printf("(%d,%d) ",xy.getX(), xy.getY());
      }
      System.out.println();
    }
  }



  public void showMenu(){





  }

  /*public static void main(String[] args) {

    Board board = new Board();

    Coordinate hit = new Coordinate(5,5);
    Coordinate ship = new Coordinate(10, 10);

    board.getCord(hit).setState(State.HIT);
    board.getCord(ship).setState(State.SHIP);
    printBoard(board);

  }*/

  public void showVerticalHorizonal() {

    System.out.println("¿Cómo deseas posicionar el barco?");
    System.out.println("1 - Horizontal");
    System.out.println("2 - Vertical");
  }

  public void showInputShip(int size) {
    System.out.println("Introduce un barco de tamaño : " + size);
  }

  public void showInputFila() {
    System.out.print("Introduce la FILA donde quieres posicionar el barco: ");
  }
  public void showInputCol() {
    System.out.print("Introduce la COLUMNA donde quieres posicionar el barco: ");
  }

  public void shipRestantes(int numShips) {
    System.out.println("Has introducido " + numShips + " barcos de momento");
  }

  public void showErrorCoord() {
    System.out.println("Introduce filas y columnas válidas. Gracias.");
  }

  public void turnoJugador() {
    System.out.println("Te toca disparar");

  }

  public void showDialog(String txt) {
    System.out.println(txt);
  }

  public void startGame() {

    System.out.println("-------------------------------------------- ");
    System.out.println("-------------¡Empieza el Juego! ------------- ");
    System.out.println("-------------------------------------------- ");

  }

  public void gameLogo() {


    System.out.println(" _           _   _   _           _     _       \n" +
        "| |         | | | | | |         | |   (_)      \n" +
        "| |__   __ _| |_| |_| | ___  ___| |__  _ _ __  \n" +
        "| '_ \\ / _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\ \n" +
        "| |_) | (_| | |_| |_| |  __/\\__ \\ | | | | |_) |\n" +
        "|_.__/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/ \n" +
        "                                        | |    \n" +
        "                                        |_|");

    System.out.println("                __/___            \n" +
        "          _____/______|           \n" +
        "  _______/_____\\_______\\_____     \n" +
        "  \\              < < <       |    \n" +
        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

  }
}
