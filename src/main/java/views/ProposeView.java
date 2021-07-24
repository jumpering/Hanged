package views;

import types.HangedParts;
import types.MessageView;
import controllers.ProposeController;
import utils.Console;

public class ProposeView {

    public void interact(ProposeController proposeController){
        Console console;
        console = new Console();
        console.writeln(MessageView.TURN_NAME.getMessage() + proposeController.getCurrentNameUser());
        console.writeln(HangedParts.BOARD_PAPER.getHangedPart());
        console.writeln(MessageView.SECRET_TITLE.getMessage() + proposeController.getStripes());
        String userCharOrWord = "";
        do{
            userCharOrWord = console.readString(MessageView.PROPOSE.getMessage());
        }while(!proposeController.isValidCharOrWord(userCharOrWord));
        System.out.println(userCharOrWord);

        //proposeController.getCharOrWord();
        //proposeController.interact();
    }
}
