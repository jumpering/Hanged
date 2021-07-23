package models;

public class Turn {

    private Player[] players;

    public void setNumberOfPlayers(int numberOfPlayers){
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
}
