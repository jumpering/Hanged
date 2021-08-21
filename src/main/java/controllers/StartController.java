package controllers;

import models.Game;

public class StartController extends Controller {

    public StartController(Game game) {
        super(game);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void setPlayerName(String playerName) {
        this.game.setPlayerName(playerName);
    }

    public void setSecretForPlayer(String playerName){
        this.game.setSecretForPlayer(playerName);
    }
}
