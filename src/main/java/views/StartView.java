package views;

import types.MessageView;
import controllers.StartController;
import utils.Console;

public class StartView {

    public void interact(StartController startController) {
        Console.getInstance().writeln(MessageView.TITLE.getMessage());
        startController.setNumberOfPlayers(getValidNumberOfPlayers());
        setNameForPlayers(startController);
        startController.nextGameState();
    }

    private int getValidNumberOfPlayers() {
        int numberOfPlayers = 0;
        do {
            numberOfPlayers = Console.getInstance().readInt(MessageView.ASK_FOR_NUMBER_OF_PLAYER.getMessage());
        } while (numberOfPlayers <= 0);
        return numberOfPlayers;
    }

    private void setNameForPlayers(StartController startController) {
        for (int i = 0; i < startController.getNumberOfPlayers(); i++) {
            Console.getInstance().write(MessageView.NUMBER_OF_PLAYER.getMessage() + "" + (i + 1) + " ");
            startController.setNameForPlayer(i, Console.getInstance().readString(MessageView.ASK_FOR_NAME_OF_PLAYER.getMessage()));
        }
    }
}
