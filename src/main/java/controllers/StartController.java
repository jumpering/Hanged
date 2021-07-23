package controllers;

import types.MessageView;
import utils.Console;
import models.Turn;

public class StartController extends Controller{

    public StartController(Turn turn){
        super(turn);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void interact(){
        Console console = new Console();
        this.turn.setNumberOfPlayers(console.readInt(MessageView.ASK_FOR_NUMBER_OF_PLAYER.getMessage()));
        for (int i = 0; i < this.turn.getNumberOfPlayers(); i++){
            console.write(MessageView.NUMBER_OF_PLAYER.getMessage() + "" + (i+1) + " ");
            this.turn.setNameForPlayer(i,console.readString(MessageView.ASK_FOR_NAME_OF_PLAYER.getMessage()));
        }
        //next state! TODO

    }
}
