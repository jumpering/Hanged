package models;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Turn turn;
    private State state;
    private Map<Player, Secret> secrets;


    public Game() {
        restart();
    }

    public void setPlayerName(String playerName) {
        this.turn.addPlayer(playerName);
    }

    public void nextGameState() {
        this.state.next();
    }

    public StateValue getStateValue() {
        return this.state.getStateValue();
    }

    public String getCurrentPlayerName() {
        return this.turn.getCurrentPlayerName();
    }

    public Player getCurrentPlayer() {
        return this.turn.getCurrentPlayer();
    }

    public int getSecretWordLength(Player player) {
        return this.secrets.get(player).getLength();
    }


    public boolean isUserInputPresentOnSecret(String userWord) {
        return this.secrets.get(this.getCurrentPlayer()).isEqualWord(userWord);
    }


    public boolean isUserInputPresentOnSecret(char userChar) {
        return this.secrets.get(this.getCurrentPlayer()).isEqualCharInAnyPosition(userChar);
    }

    public boolean containsCharInPosition(int position, char userChar) {
        return this.secrets.get(this.getCurrentPlayer()).isEqualCharInConcretePosition(position, userChar);
    }

    public void nextPlayer() {
        this.turn.nextPlayer();
    }

    public void removeCurrentPlayer(Player player) {
        this.turn.removeCurrentPlayer();
        this.secrets.remove(player);
    }

    public void restart() {
        this.turn = new Turn();
        this.state = new State();
        this.secrets = new HashMap<Player, Secret>();
    }

    public int getNumberOfPlayers() {
        return this.turn.getNumberOfPlayers();
    }

    public void setSecretForPlayer(String playerName) {
        this.secrets.put(this.turn.getPlayerByName(playerName), new Secret(new Word()));
    }
}
