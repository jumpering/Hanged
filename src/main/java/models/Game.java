package models;

public class Game {

    private Turn turn;
    private State state;
    private SecretWord[] secretWords;

    public Game(){
        this.turn = new Turn();
        this.state = new State();
    }

    public void setNameForPlayer(String playerName){
        this.turn.setNameForPlayer(playerName);
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

    public String getCurrentPlayerName(){
        return this.turn.getCurrentPlayerName();
    }

    public Player getCurrentPlayer(){
        return this.turn.getCurrentPlayer();
    }

    public int getSecretWordLength(){
        return this.secretWords[this.turn.getCurrentNumberOfPlayer()].getLength();
    }

    public boolean isCharOrWordPresentOnSecret(String userCharOrWord) {
        if (userCharOrWord.length() == 1 && this.secretWords[this.turn.getCurrentNumberOfPlayer()].containsChar(userCharOrWord.charAt(0))){
            return true;
        }
        return userCharOrWord.length() > 1 && this.secretWords[this.turn.getCurrentNumberOfPlayer()].containsWord(userCharOrWord);
    }

    public boolean containsCharInPosition(int position, char userChar){
        return this.secretWords[this.turn.getCurrentNumberOfPlayer()].containsCharInPosition(position, userChar);
    }

    public void nextPlayer(){
        this.turn.nextPlayer();
    }

    public void setNumberOfSecretWords(int numberOfPlayers) {
        this.secretWords = new SecretWord[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++){
            this.secretWords[i] = new SecretWord();
        }
    }

    public void removeCurrentPlayer() {
        this.turn.removeCurrentPlayer();
    }
}
