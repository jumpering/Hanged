package controllers;

import models.Game;
import utils.YesNoDialog;

public class RestartController extends Controller{
    public RestartController(Game game) {
        super(game);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void AskForRestartGame(String title){
        YesNoDialog yesNoDialog = new YesNoDialog();
        if (!yesNoDialog.read(title)){
            nextGameState();
        } else{
            this.game.restart();
        }

    }
}
