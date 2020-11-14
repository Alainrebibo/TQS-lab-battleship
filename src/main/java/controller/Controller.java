package controller;

import model.*;
import view.ProvisionalView;
import view.View;

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
}
