package model;

public class Coordinate {

  private final int x;
  private final int y;
  private State state;

  public Coordinate(int fila, int col, State state) {
    this.x = (col-1);
    this.y = (fila-1);
    this.state = state;
  }

  public Coordinate(int fila, int col) {
    this.x = (col-1);
    this.y = (fila-1);
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public State getState() { return this.state; }

  public void setState(State state) {
    this.state = state;
  }
}
