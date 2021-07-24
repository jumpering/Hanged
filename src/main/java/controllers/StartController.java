package controllers;

import models.Game;

public class StartController extends Controller{

    public StartController(Game game){
        super(game);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void setNumberOfPlayers(int numberOfPlayers){
        assert numberOfPlayers > 0;
        this.game.setNumberOfPlayers(numberOfPlayers);
    }

    public int getNumberOfPlayers(){
        return this.game.getNumberOfPlayers();
    }

    public void setNameForPlayer(int numberOfPlayer, String nameOfPlayer){
        this.game.setNameForPlayer(numberOfPlayer,nameOfPlayer);
    }

    public void nextGameState(){
        this.game.nextGameState();
    }


}
