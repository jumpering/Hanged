package models;

public class Turn {

    private Player[] players;
    private int currentNumberOfPlayer;

    public Turn(){
        this.currentNumberOfPlayer = 0;
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

    public String getCurrentPlayerName(){
        return this.players[this.currentNumberOfPlayer].getName();
    }

    public Player getCurrentPlayer(){
        return this.players[this.currentNumberOfPlayer];
    }
}
