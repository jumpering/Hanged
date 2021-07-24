package controllers;

import models.Game;
import types.MessageView;
import utils.Console;

public class ProposeController extends Controller{

    public ProposeController(Game game){
        super(game);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void interact(){
        Console console = new Console();
        String userPropose;
        userPropose = console.readString(MessageView.PROPOSE.getMessage());

    }

    public String getCurrentNameUser(){
        return this.game.getCurrentNameUser();
    }


    public String getStripes() {
        String stripes = "";
        for (int i = 0; i < this.game.getSecretWordLength(); i++){
            stripes += MessageView.SECRET_STRIPES.getMessage();
        }
        return stripes;
    }
}
