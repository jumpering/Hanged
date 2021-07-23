package models;

import java.util.Set;

public class Session {

    private Turn turn;
    private Player[] players;
    //private Set<Player> players;


    public Session(){

    }

    public void setNumberOfPlayers(int numberOfPlayers){
        this.players = new Player[numberOfPlayers];
    }
    public Player getPlayer(int numberOfPlayer){
        return this.players[numberOfPlayer];
    }

    public void setNameForPlayers(int playerNumber, String playerName){
        this.players[playerNumber].setName(playerName);
    }

    public void setPlayerName(){

    }
}
