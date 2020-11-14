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

      }else{//Turno jugador 2

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

  public boolean insertShip(int fila, int col, int size, Direction dir) {

    Board boardP1 = this.model.getPlayer1().getBoard();
    return boardP1.addShip(fila, col, size, dir);
  }


  public boolean finished() {

    return this.getBoardP1().finished();
  }


  public void inputShip() {

    Scanner scanner = new Scanner(System.in);
    int[] sizeShip = {1};
    int i = 0;
    int dir;
    boolean insertado = false;
    while(i<=10){

      insertado = false;
      int fila = 0 ,col = 0;
      while (!insertado){

        //view.showInputShip(sizeShip[0]);
        view.showInputFila();

        fila = scanner.nextInt();
        scanner.nextLine();
        view.showInputCol();
        col = scanner.nextInt();
        scanner.nextLine();


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

          view.showErrorCoord();
        }

      }//end while insert


    };


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

  private  Board getBoardP2(){
    return model.getPlayer2().getBoard();
  }

  private Message hit(){
    //return model.getPlayer1().getBoard().hit(new Coordinate(x,y));

    return  Message.WATER;
  }
}
