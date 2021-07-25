package views;

import types.MessageView;
import controllers.StartController;
import utils.Console;

public class StartView {

    private int numberOfPlayers;

    public void interact(StartController startController) {
        Console.getInstance().writeln(MessageView.TITLE.getMessage());
        startController.setNumberOfSecretWords(getValidNumberOfSecretWords());
        setNameForPlayers(startController);
        startController.nextGameState();
    }

    private int getValidNumberOfSecretWords() {
        int numberOfPlayers = 0;
        do {
            numberOfPlayers = Console.getInstance().readInt(MessageView.ASK_FOR_NUMBER_OF_PLAYER.getMessage());
        } while (numberOfPlayers <= 0);
        this.numberOfPlayers = numberOfPlayers;
        return numberOfPlayers;
    }

    private void setNameForPlayers(StartController startController) {
        for (int i = 0; i < this.numberOfPlayers; i++) {
            Console.getInstance().write(MessageView.NUMBER_OF_PLAYER.getMessage() + "" + (i + 1) + " ");
            startController.setNameForPlayer(Console.getInstance().readString(MessageView.ASK_FOR_NAME_OF_PLAYER.getMessage()));
        }
    }
}
