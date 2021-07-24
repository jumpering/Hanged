package views;

import types.MessageView;
import controllers.StartController;
import utils.Console;

public class StartView {

    public void interact(StartController startController){
        Console console;
        console = new Console();
        console.writeln(MessageView.TITLE.getMessage());
        int numberOfPlayers = 0;
        do{
            numberOfPlayers = console.readInt(MessageView.ASK_FOR_NUMBER_OF_PLAYER.getMessage());
        }while (numberOfPlayers <= 0);
        startController.setNumberOfPlayers(numberOfPlayers);
        for (int i = 0; i < startController.getNumberOfPlayers(); i++){
            console.write(MessageView.NUMBER_OF_PLAYER.getMessage() + "" + (i+1) + " ");
            startController.setNameForPlayer(i,console.readString(MessageView.ASK_FOR_NAME_OF_PLAYER.getMessage()));
        }
        startController.nextGameState();
    }
}
