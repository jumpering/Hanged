package models;

public class Turn {

    private Player[] players;
    private int currentTurn;


    public void setNumberOfPlayers(int numberOfPlayers){
        this.players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++){
            this.players[i] = new Player();
        }
    }

    public int getNumberOfPlayers(){
        return this.players.length;
    }

    public Player[] getAllPlayers(){
        return this.players;
    }

    public Player getPlayer(int numberOfPlayer){
        return this.players[numberOfPlayer];
    }

    public void setNameForPlayer(int playerNumber, String playerName){
        this.players[playerNumber].setName(playerName);
    }
}
