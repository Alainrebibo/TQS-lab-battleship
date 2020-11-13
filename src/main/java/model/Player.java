package model;

public class Player {

  String name;
  Boolean won , turn;
  Board board;

  public Player(){
    this.name = "Player";
    this.won = false;
    this.turn = false;
    this.board = new Board();
  }

  public Player(String name){
    this.name = name;
    this.won = false;
    this.turn = false;
    this.board = new Board();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean hasWon() {
    return won;
  }

  public void setWon(Boolean won) {
    this.won = won;
  }

  public Boolean getTurn() {
    return turn;
  }

  public void setTurn(Boolean turn) {
    this.turn = turn;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }
}
