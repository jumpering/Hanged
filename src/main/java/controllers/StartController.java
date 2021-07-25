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

    public void setNumberOfSecretWords(int numberOfSecretWords) {
        assert numberOfSecretWords > 0;
        this.game.setNumberOfSecretWords(numberOfSecretWords);
    }

    public void setNameForPlayer(String nameOfPlayer) {
        this.game.setNameForPlayer(nameOfPlayer);
    }

    public void nextGameState() {
        this.game.nextGameState();
    }
}
