package controller;

import model.*;
import view.View;

import java.util.Scanner;

public class Controller {

  private Game model;
  private View view;

  public Controller(Game model, View view) {
    this.model = model;
    this.view = view;
  }

  public Game getModel(){return this.model;}

  public void startGame(){
    view.startGame();
    model.startGame();
    Scanner sc = new Scanner(System.in);
    Message result;

    do{
      int fila = 0, col;

      if( model.getTurn()%2 == 0){
        this.view.turnoJugador();

        this.view.showInputFila();
        fila = sc.nextInt();

        this.view.showInputCol();
        col = sc.nextInt();

        result = this.getBoardP2().hit(col, fila);

        resultHit(result,  col, fila);

      }else{//Turno maquina

         result = this.getBoardP1().hit(this.getBoardP2().getCoordinateRandom());

         view.showDialog("Maquina ha disparado con el siguient resultado:");
          resultHit(result, -1, -1);
      }
      model.changeTurn();


      view.printBoard(model.getPlayer1().getBoardEnemy());
      System.out.println();
      System.out.println();
      view.printBoard(this.getBoardP2());

    }while(!model.getGameFinish() );

    showWiner();
  }

  public void showWiner() {
    if(model.getPlayer2().getWon()){
      view.showDialog("player 2 WIN");
      System.exit(0);
    }else{
      view.showDialog("player 1 WIN");
      System.exit(0);
    }
  }

  private void resultHit(Message result, int fila, int col) {
    switch (result){
      case HIT :
        view.showDialog("Has acertado a un barco enemigo.");

        this.model.getPlayer1().getBoardEnemy().hitEnemy(fila, col);
        break;
      case WATER:
        view.showDialog("Has fallado, habia agua.");
        break;
      case HITANDROWNED:
        view.showDialog("Tocado y hundido.");
        this.model.getPlayer1().getBoardEnemy().hitEnemy(fila, col);
        break;
      case ALREADYHIT:
        view.showDialog("Ya habias disparado a esta casilla");
    }
  }


  public void printBoardP1() {
    this.view.printBoard(this.model.getPlayer1().getBoard());
  }

  public void printTitle(){
    this.view.gameLogo();
  }

  //Funcion de traspaso
  public boolean insertShipP1(int fila, int col, int size, Direction dir) {
    Board boardP1 = this.model.getPlayer1().getBoard();
    return boardP1.addShip(fila, col, size, dir);
  }

  public void inputShip() {
    Scanner sc = new Scanner(System.in);
    int[] sizeShip = {1,1,1,1,2,2,2,3,3,4};
    int i = 0;
    int dir;

    //boolean insertado = false;

      while (i < sizeShip.length){

        view.showInputShip(sizeShip[i]); //Mensaje tamaño barco

        view.showInputFila(); //Mensaje fila
        int fila = sc.nextInt();

        view.showInputCol(); //Mensaje columna
        int col = sc.nextInt();

        Direction direction = getDirection(sizeShip[i]); //Obtener dirección

        Board boardP1 = getBoardP1(); //Obtiene board 1
        if(boardP1.addShip(fila, col, sizeShip[i], direction)){
          view.shipRestantes(this.getBoardP1().getNumShips());
          this.printBoardP1();
          i++;


        }else{
          //insertado = false;
          //TODO introduce una posicion valida
          view.showErrorCoord();

        }

      }//end while insert


  }

  public Direction getDirection(int size) {

    int dir = 0;
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
        default:

          valorCorrecto = false;
      }
    }

    return scDirection;
  }

  public int getDirCorrect(int size) {
    int dir = -1;
    Scanner sc = new Scanner(System.in);
    if(size >0 && size < 5){
      view.showVerticalHorizonal();
      dir = sc.nextInt();
    }
    return dir;
  }

  private Board getBoardP1(){
    return model.getPlayer1().getBoard();
  }

  private  Board getBoardP2(){
    return model.getPlayer2().getBoard();
  }

  private Message hit(){
    //return model.getPlayer1().getBoard().hit(new Coordinate(x,y));

    return  Message.WATER;
  }

  public void printBoardCoord() {
    this.view.printBoardPos(this.model.getPlayer1().getBoard());
  }
}
