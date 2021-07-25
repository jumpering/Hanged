package views;

import types.MessageView;
import controllers.ProposeController;
import utils.Console;

public class ProposeView {

    public void interact(ProposeController proposeController){
        header(proposeController);
        String userCharOrWord = "";
        do{
            userCharOrWord = Console.getInstance().readString(MessageView.PROPOSE.getMessage());
        }while(!proposeController.isValidCharOrWord(userCharOrWord));
        proposeController.manageCharOrWordPresentOnSecretword(userCharOrWord);
        printResult(proposeController);
        if (proposeController.isPlayerEnd()){
            Console.getInstance().writeln(MessageView.PLAYER_LOSE.getMessage() + proposeController.getCurrentPlayerName() + "!");
            proposeController.removeCurrentPlayer();
        }
        proposeController.nextPlayer();
    }

    private void header(ProposeController proposeController){
        Console.getInstance().writeln(MessageView.TURN_NAME.getMessage() + proposeController.getCurrentPlayerName());
        Console.getInstance().writeln(proposeController.getHangedPartStateFromCurrentPlayer().getHangedPart());
        Console.getInstance().writeln(MessageView.SECRET_TITLE.getMessage() + proposeController.getStripes());
    }
    private void printResult(ProposeController proposeController){
        Console.getInstance().writeln(proposeController.getHangedPartStateFromCurrentPlayer().getHangedPart());
        Console.getInstance().writeln(MessageView.SECRET_TITLE.getMessage() + proposeController.getStripes());
    }
}
