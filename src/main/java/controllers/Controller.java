package controllers;

import models.Game;

public abstract class Controller {

    protected Game game;

    public Controller(Game game){
        this.game = game;
    }

    public abstract void accept (ControllerVisitor controllerVisitor);

    public void nextGameState() {
        this.game.nextGameState();
    }

}
