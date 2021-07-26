package views;

import types.MessageView;
import controllers.ProposeController;
import utils.Console;

public class ProposeView {

    private ProposeController proposeController;

    public void interact(ProposeController proposeController){
        this.proposeController = proposeController;
        header();
        proposeController.manageCharOrWordPresentOnSecretword(getUserCharOrWordString());
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

    private String getUserCharOrWordString(){
        String userCharOrWord;
        do{
            userCharOrWord = Console.getInstance().readString(MessageView.PROPOSE.getMessage());
        }while(!this.proposeController.isValidCharOrWord(userCharOrWord));
        return userCharOrWord.toLowerCase();
    }

    private void printResult(){
        Console.getInstance().writeln(this.proposeController.getHangedPartStateFromCurrentPlayer().getHangedPart());
        Console.getInstance().writeln(MessageView.SECRET_TITLE.getMessage() + this.proposeController.getStripes());
    }
}
