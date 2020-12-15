package controller;

import model.*;
import view.View;

import java.util.Scanner;

public class Controller {

  private final Game model;
  private final View view;

  public Controller(Game model, View view) {
    this.model = model;
    this.view = view;
  }

  public View getView() { return view; }

  public Game getModel(){return this.model; }

  //Obtiene el tablero del jugador 1
  public Board getBoardP1(){
    return model.getPlayer1().getBoard();
  }

  //Obtiene el tablero de la máquina
  public Board getBoardP2(){
    return model.getPlayer2().getBoard();
  }

  //Golpea en el tablero de la máquina y devuelve un mensaje en base a al estado de la coordenada
  public Message hitValid(int fila, int col) {
    return this.getBoardP2().hit(col, fila);
  }

  //Obtiene el input del jugador y comprueba que sea un entero
  public int scannerInt() {
    Scanner sc = new Scanner(System.in);
    int input;

    try{
      input = Integer.parseInt(sc.nextLine());
    }catch (NumberFormatException ex) {
      System.out.println("¡Eso no era un entero!");
      input = -1;
      return input;
    }
    return input;
  }

  //Muestra el ganador y termina la ejecución del juego
  public void showWinner() {
    if(model.getPlayer2().getWon()){
      this.view.machineWins();
      System.exit(0);
    }else{
      this.view.playerWins();
      System.exit(0);
    }
  }

  //Muestra el mensaje del tiro que ha hecho el jugador sobre el tablero
  public void resultHit(Message result, int fila, int col) {
    switch (result) {
      case HIT :
        this.view.hitMessage();
        this.model.getPlayer1().getBoardEnemy().hitEnemy(fila, col);
        break;

      case WATER:
        this.view.missMessage();
        break;

      case HITANDROWNED :
        this.view.drownedMessage();
        this.model.getPlayer1().getBoardEnemy().hitEnemy(fila, col);
        break;

      case ALREADYHIT :
        this.view.alreadyHitMessage();
        break;
    }
  }

  //Muestra por consola el tablero del jugador
  public void printBoardP1() {
    this.view.printBoard(this.model.getPlayer1().getBoard());
  }

  public void printBoardP2() {
    this.view.printBoard(this.model.getPlayer2().getBoard());
  }

  //Muestra por consola el título del juego
  public void printTitle(){
    this.view.gameLogo();
  }

  //Comprueba que la posición del barco sea horizontal o vertical
  public Direction getDirection(int size) {
    int dir;
    boolean valorCorrecto = false;
    Direction scDirection = null; // default value
    while(!valorCorrecto){

      dir = getDirCorrect(size);

      switch (dir){
        case  1:
          scDirection = Direction.HORIZONTAL;
          valorCorrecto = true;
          break;
        case 2:
          scDirection = Direction.VERTICAL;
          valorCorrecto = true;
          break;
      }
    }
    return scDirection;
  }

  //Asegura que el tamaño del barco sea correcto
  public int getDirCorrect(int size) {
    int dir = -1;
    if(size >0 && size < 5){
      view.showVerticalHorizonal();
      dir = scannerInt();
    }
    return dir;
  }
}
