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

  public void showVerticalHorizonal() {

    System.out.println("¿Como deseas posicionar el barco?");
    System.out.println("1 - Horizontal");
    System.out.println("2 - Vertical");
  }

  public void showInputShip(int size) {
    System.out.println("Introduce un barco de tamaño : " + size);
  }

  public void hitFila(){
    System.out.println("Escoge la FILA a la que quieres apuntar");
  }

  public void hitCol(){
    System.out.println("Escoge la COLUMNA a la que quieres apuntar");
  }

  public void machineTurnResult(){
    System.out.println("--Resultado del turno de la máquina:--");
  }

  public void showInputFila() {
    System.out.println("Introduce la FILA donde quieres posicionar el barco: ");
  }

  public void showInputCol() {
    System.out.println("Introduce la COLUMNA donde quieres posicionar el barco: ");
  }

  public void shipRestantes(int numShips) {
    System.out.println("Has introducido " + numShips + " barcos de momento");
  }

  public void showErrorCoord() {
    System.out.println("Introduce filas y columnas válidas. Gracias.");
  }

  public void turnoJugador(int turno) {
    if(turno %2 == 0){
      System.out.println("¡Te toca disparar!" );
    } else System.out.println("Dispara la máquina" );


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



  public void hitMessage(){
    System.out.println("Has acertado a un barco enemigo");
  }

  public void missMessage(){
    System.out.println("Has fallado, sólo había agua");
  }

  public void drownedMessage(){
    System.out.println("¡Tocado y hundido! Un barco menos :)");
  }

  public void alreadyHitMessage(){
    System.out.println("Ya habías disparado a esta coordenada. Pierdes el turno :(");
  }

  public void machineWins(){
    System.out.println("Ha ganado la máquina");
  }

  public void playerWins(){
    System.out.println("¡Has ganado a la máquina!");
  }

}
