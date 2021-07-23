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

    public String getCurrentUser(){
        return null;
    }
}
