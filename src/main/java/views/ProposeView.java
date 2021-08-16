package views;

import models.ReturnInputValue;
import types.MessageView;
import controllers.ProposeController;
import utils.Console;

public class ProposeView {

    private ProposeController proposeController;

    public void interact(ProposeController proposeController){
        this.proposeController = proposeController;
        header();
        proposeController.compareCharOrStringWithSecret(getUserInput());
        printResult();
        if (proposeController.isPlayerEnd()){
            Console.getInstance().writeln(MessageView.PLAYER_LOSE.getMessage() + proposeController.getCurrentPlayerName() + "!");
            proposeController.removeCurrentPlayer();
        }
        proposeController.nextPlayer();
    }

    private void header(){
        Console.getInstance().writeln(MessageView.TURN_NAME.getMessage() + this.proposeController.getCurrentPlayerName());
        Console.getInstance().writeln(this.proposeController.getHangedPartStateFromCurrentPlayer().getHangedPart());
        Console.getInstance().writeln(MessageView.SECRET_TITLE.getMessage() + this.proposeController.getStripes());
    }

    public ReturnInputValue getUserInput(){//todo with generics is possible?¿
        String userStringInput = "";
        ReturnInputValue returnInputValue = new ReturnInputValue();
        do {
            userStringInput = Console.getInstance().readString(MessageView.PROPOSE.getMessage());
        } while (!this.proposeController.isValidCharacterOrString(userStringInput));
        if(userStringInput.length() == 1){
            returnInputValue.setCharacter(userStringInput.charAt(0));
        }
        if(userStringInput.length() > 1){
            returnInputValue.setString(userStringInput.toLowerCase());
        }
        return returnInputValue;
    }



//    private String getUserCharOrWordString(){
//        String userCharOrWord;
//        do{
//            userCharOrWord = Console.getInstance().readString(MessageView.PROPOSE.getMessage());
//        }while(!this.proposeController.isValidCharacterOrString(userCharOrWord));
//        return userCharOrWord.toLowerCase();
//    }

    private void printResult(){
        Console.getInstance().writeln(this.proposeController.getHangedPartStateFromCurrentPlayer().getHangedPart());
        Console.getInstance().writeln(MessageView.SECRET_TITLE.getMessage() + this.proposeController.getStripes());
    }
}
