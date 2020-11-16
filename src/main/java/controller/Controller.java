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

  public Game getModel(){return this.model;}

  public Board getBoardP1(){
    return model.getPlayer1().getBoard();
  }

  public Board getBoardP2(){
    return model.getPlayer2().getBoard();
  }

  public Message hitValid(int fila, int col) {
    return this.getBoardP2().hit(col, fila);
  }

  public int scannerInt() {
    Scanner sc = new Scanner(System.in);

    int input = 0;

    if (sc.hasNextInt()){
      input = sc.nextInt();
      return input;
    }

    try{
      input = Integer.parseInt(sc.nextLine());
    }catch (NumberFormatException ex) {
      System.out.println("¡Eso no era un entero!");
    }
    return input;
  }

  public void showWinner() {
    if(model.getPlayer2().getWon()){

      this.view.machineWins();
      System.exit(0);
    }else{

      this.view.playerWins();
      System.exit(0);
    }
  }

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

  public void printBoardP1() {
    this.view.printBoard(this.model.getPlayer1().getBoard());
  }

  public void printTitle(){
    this.view.gameLogo();
  }

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

  public int getDirCorrect(int size) {
    int dir = -1;
    Scanner sc = new Scanner(System.in);
    if(size >0 && size < 5){
      view.showVerticalHorizonal();
      dir = scannerInt();
    }
    return dir;
  }
}
