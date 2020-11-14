package model;

public class Game {

    private Player player1, player2;
    private boolean finished;
    private int turn;

    public Game() {
        this.player1 = new Player();
        this.player2 = new Player();
        this.finished = false;
    }

    public Player getPlayer1() {
        /* aqui implementaremos tal y tal y lo haremos*/
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public boolean getGameFinish(){
        return finished;
    }

    public void startGame(){
        this.turn = 0;
    }

    public void changeTurn(){
        this.turn++;
    }

}
