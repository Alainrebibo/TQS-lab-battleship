package model;

import model.Board;
import model.Direction;

public class MockBoard {

  Board board;

  public MockBoard() {
    this.board = new Board();

  }

  public Board getRandomBoard(){
    this.board.setBoardRandom();
    return this.board;
  }
  //{1,1,1,1,2,2,2,3,3,4}
  public Board setBoardPlayer(int partida) {
    switch (partida){
      case 1:
        board.addShip(1,1,1, Direction.VERTICAL);
        board.addShip(1,2,1, Direction.VERTICAL);
        board.addShip(1,3,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(1,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(1,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(1,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;
      case 2:
        board.addShip(1,1,1, Direction.VERTICAL);
        board.addShip(2,2,1, Direction.VERTICAL);
        board.addShip(1,3,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(1,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(1,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(1,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;
      case 3:
        board.addShip(8,1,1, Direction.VERTICAL);
        board.addShip(9,2,1, Direction.VERTICAL);
        board.addShip(7,5,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(1,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(1,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(1,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;
      case 4:
        board.addShip(1,1,1, Direction.VERTICAL);
        board.addShip(1,2,1, Direction.VERTICAL);
        board.addShip(1,3,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(1,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(1,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(1,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;
      case 5:
        board.addShip(2,1,1, Direction.VERTICAL);
        board.addShip(3,2,1, Direction.VERTICAL);
        board.addShip(4,3,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(1,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(1,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(1,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;
      case 6:
        board.addShip(5,1,1, Direction.VERTICAL);
        board.addShip(6,2,1, Direction.VERTICAL);
        board.addShip(7,3,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(1,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(1,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(1,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;
    }
    return this.board;
  }

  public Board setBoardMachine(int partida) {
    switch (partida){
      case 1:
        board.addShip(1,1,1, Direction.VERTICAL);
        board.addShip(1,2,1, Direction.VERTICAL);
        board.addShip(1,3,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(1,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(1,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(1,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;

      case 2:
        board.addShip(1,1,1, Direction.VERTICAL);
        board.addShip(2,2,1, Direction.VERTICAL);
        board.addShip(1,3,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(1,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(1,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(1,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;

      case 3:
        board.addShip(8,1,1, Direction.VERTICAL);
        board.addShip(9,2,1, Direction.VERTICAL);
        board.addShip(7,5,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(1,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(1,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(1,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;

      case 4:
        board.addShip(1,1,1, Direction.VERTICAL);
        board.addShip(1,2,1, Direction.VERTICAL);
        board.addShip(3,3,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(7,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(9,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(10,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;

      case 5:
        board.addShip(1,1,1, Direction.VERTICAL);
        board.addShip(1,2,1, Direction.VERTICAL);
        board.addShip(1,3,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(1,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(1,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(1,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;

      case 6:
        board.addShip(1,1,1, Direction.VERTICAL);
        board.addShip(1,2,1, Direction.VERTICAL);
        board.addShip(1,3,1, Direction.VERTICAL);
        board.addShip(1,4,1, Direction.VERTICAL);
        board.addShip(1,5,2, Direction.VERTICAL);
        board.addShip(1,6,2, Direction.VERTICAL);
        board.addShip(1,7,2, Direction.VERTICAL);
        board.addShip(1,8,3, Direction.VERTICAL);
        board.addShip(1,9,3, Direction.VERTICAL);
        board.addShip(1,10,4, Direction.VERTICAL);
        break;
    }
    return this.board;
  }

}
