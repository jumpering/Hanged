package controllers;

import models.Game;
import types.MessageView;
import utils.Console;

public class StartController extends Controller{

    public StartController(Game game){
        super(game);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void interact(){
        //todo assert que no hay un 0 (cero)
        Console console = new Console();
        this.game.setNumberOfPlayers(console.readInt(MessageView.ASK_FOR_NUMBER_OF_PLAYER.getMessage()));
        for (int i = 0; i < this.game.getNumberOfPlayers(); i++){
            console.write(MessageView.NUMBER_OF_PLAYER.getMessage() + "" + (i+1) + " ");
            this.game.setNameForPlayer(i,console.readString(MessageView.ASK_FOR_NAME_OF_PLAYER.getMessage()));
        }
        this.game.nextGameState();
    }
}
