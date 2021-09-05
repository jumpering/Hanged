package views;

import models.ReturnInputValue;
import types.MessageView;
import controllers.ProposeController;
import utils.Console;

public class ProposeView {

    private ProposeController proposeController;

    public void interact(ProposeController proposeController) { //todo No Open/Close
        this.proposeController = proposeController;
        showHeader();
        ReturnInputValue userInput = getUserInput();
        if (userInput.isString()) {
            this.proposeUserInput(userInput,MessageView.PLAYER_WIN.getMessage() + this.proposeController.getCurrentPlayerName() + "!");
        }
        if (userInput.isCharacter()) {
            this.proposeUserInput(userInput,MessageView.FINE_PROPOSED.getMessage());
        }
        if (this.proposeController.getNumberOfPlayers() == 0) {//todo logic
            this.proposeController.nextGameState();
        } else {
            proposeController.nextPlayer();
        }
    }

    private void showHeader() {
        Console.getInstance().writeln(this.proposeController.getHangedPartStateFromCurrentPlayer().getHangedPart());
        Console.getInstance().writeln(MessageView.TURN_NAME.getMessage() + this.proposeController.getCurrentPlayerName());
        Console.getInstance().writeln(MessageView.SECRET_TITLE.getMessage() + this.proposeController.getStripes());
    }

    private ReturnInputValue getUserInput() {//todo with generics is possible?¿ //todo no Open/Close
        String userStringInput;
        ReturnInputValue returnInputValue = new ReturnInputValue();
        do {
            userStringInput = Console.getInstance().readString(MessageView.PROPOSE.getMessage());
        } while (!this.proposeController.isValidCharacterOrString(userStringInput));
        if (userStringInput.length() == 1) {
            returnInputValue.setCharacter(userStringInput.charAt(0));
        }
        if (userStringInput.length() > 1) {
            returnInputValue.setString(userStringInput.toLowerCase());
        }
        return returnInputValue;
    }

    private void proposeUserInput(ReturnInputValue userInput, String messageIsEqualToSecret){
        //todo SI EXISTE CAMBA DE PLAYER I NO PUNTUA WTF
        if (this.proposeController.isEqualWithSecret(userInput)) {
            Console.getInstance().writeln(messageIsEqualToSecret);
            if (this.proposeController.isLengthEqualSecret(userInput)) {
                this.printResult();
                this.proposeController.nextGameState();//todo logic
            }
        } else {
            Console.getInstance().writeln(MessageView.FAIL_PROPOSED.getMessage());
            if (this.proposeController.isPlayerEnd()) {
                Console.getInstance().writeln(MessageView.PLAYER_LOSE.getMessage() + proposeController.getCurrentPlayerName() + "!");
                Console.getInstance().writeln(MessageView.SECRET_TITLE + this.proposeController.showCurrentPlayerSecret());
                this.proposeController.removeCurrentPlayer();//todo logic
            }
        }
    }

    private void printResult() {
        Console.getInstance().writeln(this.proposeController.getHangedPartStateFromCurrentPlayer().getHangedPart());
        Console.getInstance().writeln(MessageView.SECRET_TITLE.getMessage() + this.proposeController.getStripes());
    }
}
