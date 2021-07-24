package views;

import types.MessageView;
import controllers.StartController;
import utils.Console;

public class StartView {

    public void interact(StartController startController){
        Console console;
        console = new Console();
        console.writeln(MessageView.TITLE.getMessage());
        startController.setNumberOfPlayers(console.readInt(MessageView.ASK_FOR_NUMBER_OF_PLAYER.getMessage()));
        for (int i = 0; i < startController.getNumberOfPlayers(); i++){
            console.write(MessageView.NUMBER_OF_PLAYER.getMessage() + "" + (i+1) + " ");
            startController.setNameForPlayer(i,console.readString(MessageView.ASK_FOR_NAME_OF_PLAYER.getMessage()));
        }
        startController.nextGameState();
    }
}
