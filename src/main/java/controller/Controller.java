package controller;

import model.*;
import view.ProvisionalView;

import java.util.Scanner;

public class Controller {

  private Game model;
  private ProvisionalView view;

  public Controller(Game model, ProvisionalView view) {
    this.model = model;
    this.view = view;
  }

  public void startGame(){



  }


  public void printBoardP1() {
    this.view.printBoard(this.model.getPlayer1().getBoard());

  }

  public boolean insertShip(int fila, int col, int size, Direction dir) {

    Board boardP1 = this.model.getPlayer1().getBoard();
    return boardP1.addShip(fila, col, size, dir);
  }


  public boolean finished() {

    return this.getBoardP1().finished();
  }


  public void inputShip() {

    Scanner sc = new Scanner(System.in);
    int[] sizeShip = {1,1,1,1,3,3,2,2,2,5};
    int i = 0;
    int dir;
    do{

      boolean insertado = false;

      while (!insertado){

        view.showInputShip(sizeShip[i]);
        view.showInputShipFila();
        int fila = sc.nextInt();

        view.showInputShipCol();
        int col = sc.nextInt();


        Direction direction = getDirection(sizeShip[i]);

        Board boardP1 = getBoardP1();
        if(boardP1.addShip(fila, col, sizeShip[i], direction))
        {
          view.shipRestantes( this.getBoardP1().getNumShips());
          this.printBoardP1();
          insertado = true;
          i++;
        }else{
          insertado = false;
          //TODO introduce una posicion valida
          view.showErrorCoord();
        }
        System.out.println("VALOR I " +  i);
      }//end while insert


    }while (!this.finished());
  }

  private Direction getDirection(int size) {
    Scanner sc = new Scanner(System.in);
    int dir = 1;

    boolean valorCorrecto = false;
    Direction scDirection = Direction.HORIZONTAL; // default value
    while(!valorCorrecto){

      if(size != 1){
        view.showVerticalHorizonal();
        dir = sc.nextInt();
      }
      
      switch (dir){
        case  1:
          scDirection = Direction.HORIZONTAL;
          valorCorrecto = true;
          break;
        case 2:
          scDirection = Direction.VERTICAL;
          valorCorrecto = true;
          break;
        default:
          valorCorrecto = false;
      }
    }




    return scDirection;
  }

  private Board getBoardP1(){
    return model.getPlayer1().getBoard();
  }
}
