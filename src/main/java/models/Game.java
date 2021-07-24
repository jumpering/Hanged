package models;

public class Game {

    private Turn turn;
    private State state;
    private SecretWord secretWord;

    public Game(){
        this.turn = new Turn();
        this.state = new State();
        this.secretWord = new SecretWord();
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

    public StateValue getStateValue(){
        return this.state.getStateValue();
    }

    public String getCurrentNameUser(){
        return this.turn.getCurrentUser();
    }

    public int getSecretWordLength(){
        return this.secretWord.getLength();
    }
}
