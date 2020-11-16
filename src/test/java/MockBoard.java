import model.Board;

public class MockBoard {

  Board board;

  public MockBoard() {
    this.board = new Board();

  }

  public Board getRandomBoard(){
    this.board.setBoardRandom();
    return this.board;
  }
}
