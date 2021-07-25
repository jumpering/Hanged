package views;

import types.HangedParts;
import types.MessageView;
import controllers.ProposeController;
import utils.Console;

public class ProposeView {

    public void interact(ProposeController proposeController){
        Console.getInstance().writeln(MessageView.TURN_NAME.getMessage() + proposeController.getCurrentNameUser());
        Console.getInstance().writeln(HangedParts.BOARD_PAPER.getHangedPart());
        Console.getInstance().writeln(MessageView.SECRET_TITLE.getMessage() + proposeController.getStripes());
        String userCharOrWord = "";
        do{
            userCharOrWord = Console.getInstance().readString(MessageView.PROPOSE.getMessage());
        }while(!proposeController.isValidCharOrWord(userCharOrWord));
        proposeController.manageCharOrWord(userCharOrWord);

    }
}
