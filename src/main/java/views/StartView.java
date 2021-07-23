package views;

import types.MessageView;
import controllers.StartController;
import utils.Console;

public class StartView {

    public void interact(StartController startController){
        Console console;
        console = new Console();
        console.writeln(MessageView.TITLE.getMessage());
        startController.interact();
    }
}
