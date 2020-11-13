package model;

public class Coordinate {

  private final int x;
  private final int y;
  private State state;

  public Coordinate(int x, int y, State state) {
    this.x = x;
    this.y = y;
    this.state = state;
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
