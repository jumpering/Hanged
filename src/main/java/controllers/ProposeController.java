package controllers;

import types.MessageView;
import utils.Console;
import models.Turn;

public class ProposeController extends Controller{

    public ProposeController(Turn turn){
        super(turn);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
    }

    public void interact(){
        Console console = new Console();
        String userPropose;
        userPropose = console.readString(MessageView.PROPOSE.getMessage());

    }
}
