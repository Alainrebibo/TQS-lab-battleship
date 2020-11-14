package model;

public class Player {

  String name;
  Boolean won , turn;
  Board board;
  Board boardEnemy;

  public Player(){
    this.name = "Player";
    this.won = false;
    this.turn = false;
    this.board = new Board();
    this.boardEnemy = new Board();

  }

  public Player(String name){
    this.name = name;
    this.won = false;
    this.turn = false;
    this.board = new Board();
    this.boardEnemy = new Board();
  }

  public String getName() {
    return name;
  }

  public Boolean hasWon() {
    return won;
  }

  public void won() {
    this.won = true;
  }

  public boolean getWon() {return this.won;}
  public Boolean getTurn() {
    return turn;
  }

  public void setTurn(Boolean turn) {
    this.turn = turn;
  }

  public Board getBoard() {
    return board;
  }

  public Board getBoardEnemy() {
    return this.boardEnemy;
  }
}
