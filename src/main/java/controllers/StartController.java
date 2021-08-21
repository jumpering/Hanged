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

    public void addPlayer(String playerName){
        this.game.addPlayer(playerName);
    }
}
