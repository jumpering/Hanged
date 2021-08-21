package models;

import java.util.List;
import java.util.ArrayList;

public class Turn {

    private List<Player> players;
    private int currentNumberOfPlayer;

    public Turn(){
        this.currentNumberOfPlayer = 0;
        this.players = new ArrayList<>();
    }

    public int getNumberOfPlayers(){
        return this.players.size();
    }

    public void addPlayer(String playerName){
        this.players.add(new Player(playerName));
    }

    public String getCurrentPlayerName(){
        return this.players.get(this.currentNumberOfPlayer).getName();
    }

    public Player getCurrentPlayer(){
        return this.players.get(this.currentNumberOfPlayer);
    }

    public void nextPlayer(){
        if (this.currentNumberOfPlayer < this.players.size() - 1){
            this.currentNumberOfPlayer++;
        } else {
            this.currentNumberOfPlayer = 0;
        }
    }

    public int getCurrentNumberOfPlayer(){
        return this.currentNumberOfPlayer;
    }

    public void removeCurrentPlayer() {
        this.players.remove(this.currentNumberOfPlayer);
    }

    public Player getLastPlayer(){
        return this.players.get(this.players.size() -1);
    }
}
