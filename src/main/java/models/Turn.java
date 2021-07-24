package models;

public class Turn {

    private Player[] players;
    private int currentUser;

    public Turn(){
        this.currentUser = 0;
    }

    public void setNumberOfPlayers(int numberOfPlayers){
        assert numberOfPlayers > 0;
        this.players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++){
            this.players[i] = new Player();
        }
    }

    public int getNumberOfPlayers(){
        return this.players.length;
    }

    public void setNameForPlayer(int playerNumber, String playerName){
        this.players[playerNumber].setName(playerName);
    }

    public String getCurrentUser(){
        return this.players[this.currentUser].getName();
    }
}
