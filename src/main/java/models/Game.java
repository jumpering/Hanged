package models;

public class Game {

    private Turn turn;
    private State state;


    public Game(){
        this.turn = new Turn();
        this.state = new State();
    }

    public void setNumberOfPlayers(int numberOfPlayers){
        this.turn.setNumberOfPlayers(numberOfPlayers);
    }

    public void setNameForPlayer(int playerNumber, String playerName){
        this.turn.setNameForPlayer(playerNumber,playerName);
    }

    public int getNumberOfPlayers(){
        return this.turn.getNumberOfPlayers();
    }

    public void nextGameState(){
        this.state.next();
    }

    public String printActualState(){
        return this.state.getStateValue().toString();
    }

    public void resetGame(){
        this.resetGame();
    }

    public StateValue getStateValue(){
        return this.state.getStateValue();
    }

}
