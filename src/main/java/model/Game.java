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

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public boolean getGameFinish(){
        return this.finished;
    }

    public void startGame(){
        this.turn = 0;
        this.getPlayer2().board.setBoardRandom();
    }

    public void changeTurn(){
        /*Comprueba que la cantidad de barcos sea 0 y se hayan pasado los primeros turno para
        asegurar que se ha insertado algú barco antes*/
        if(player1.getBoard().getNumShips()==0 && this.turn > 10){
            player2.won();
            this.finished = true;
        }else if(player2.getBoard().getNumShips()==0 && this.turn > 10){
            player1.won();
            this.finished = true;
        }

        this.turn++;
    }

    public int getTurn() {
        return this.turn;
    }
}
