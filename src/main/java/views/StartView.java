package views;

import types.MessageView;
import controllers.StartController;
import utils.Console;

public class StartView {

    private int numberOfPlayers;
    private StartController startController;

    public void interact(StartController startController) {
        this.startController = startController;
        Console.getInstance().writeln(MessageView.TITLE.getMessage());
        int numberOfPlayers = getValidNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++){
            String playerName;
            Console.getInstance().write(MessageView.NUMBER_OF_PLAYER.getMessage() + "" + (i + 1) + " ");
            playerName = Console.getInstance().readString(MessageView.ASK_FOR_NAME_OF_PLAYER.getMessage());
            this.startController.setPlayerName(playerName);
            this.startController.setSecretForPlayer(playerName);
        }
        startController.nextGameState();
    }

    private int getValidNumberOfPlayers() {
        int numberOfPlayers = 0;
        do {
            numberOfPlayers = Console.getInstance().readInt(MessageView.ASK_FOR_NUMBER_OF_PLAYER.getMessage());
        } while (numberOfPlayers <= 0);
        this.numberOfPlayers = numberOfPlayers;
        return numberOfPlayers;
    }
}
