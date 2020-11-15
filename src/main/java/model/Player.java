package model;

public class Player {

  String name;
  Boolean won ;
  Board board;
  Board boardEnemy;

  public Player(){
    this.name = "Player";
    this.won = false;
    this.board = new Board();
    this.boardEnemy = new Board();

  }

  public Player(String name){
    this.name = name;
    this.won = false;
    this.board = new Board();
    this.boardEnemy = new Board();
  }

  public String getName() {
    return name;
  }

  public Boolean hasWon() {
    return this.won;
  }

  public void won() {
    this.won = true;
  }

  public boolean getWon() {return this.won;}


  public Board getBoard() {
    return board;
  }

  public Board getBoardEnemy() {
    return this.boardEnemy;
  }
}
