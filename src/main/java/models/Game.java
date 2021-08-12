package models;

public class Game {

    private Turn turn;
    private State state;
    private Secret[] secrets;

    public Game(){
        restart();
    }

    public void setNameForPlayer(String playerName){
        this.turn.addPlayer(playerName);
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
        return this.secrets[this.turn.getCurrentNumberOfPlayer()].getLength();
    }

    public boolean isCharOrWordPresentOnSecret(String userCharOrWord) {
        if (userCharOrWord.length() == 1 && this.secrets[this.turn.getCurrentNumberOfPlayer()].isEqualCharInAnyPosition(userCharOrWord.charAt(0))){
            return true;
        }
        return userCharOrWord.length() > 1 && this.secrets[this.turn.getCurrentNumberOfPlayer()].isEqualWord(userCharOrWord);
    }

    public boolean containsCharInPosition(int position, char userChar){
        return this.secrets[this.turn.getCurrentNumberOfPlayer()].isEqualCharInConcretePosition(position, userChar);
    }

    public void nextPlayer(){
        this.turn.nextPlayer();
    }

    public void setNumberOfSecretWords(int numberOfPlayers) {
        this.secrets = new Secret[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++){
            this.secrets[i] = new Secret(new Word());
        }
    }

    public void removeCurrentPlayer() {
        if (this.turn.getNumberOfPlayers() > 0){
            this.turn.removeCurrentPlayer();
        }

    }

    public void restart(){
        this.turn = new Turn();
        this.state = new State();
    }
}
