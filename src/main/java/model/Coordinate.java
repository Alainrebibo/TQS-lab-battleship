package model;

public class Coordinate {

  private final int x;
  private final int y;
  private State state;

  public Coordinate(int x, int y, State state) {
    this.x = x-1;
    this.y = y-1;
    this.state = state;
  }

  public Coordinate(int x, int y) {
    this.x = x-1;
    this.y = y-1;
  }

  public int getX() {
    return this.x+1;
  }

  public int getY() {
    return this.y+1;
  }

  public State getState() { return this.state; }

  public void setState(State state) {
    this.state = state;
  }
}
