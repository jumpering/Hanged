package views;

import controllers.ProposeController;
import controllers.StartController;

public class ConsoleView extends View{

    private StartView startView;
    private ProposeView proposeView;


    public ConsoleView(){
        this.startView = new StartView();
        this.proposeView = new ProposeView();
    }

    @Override
    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    @Override
    public void visit(ProposeController proposeController) {
        this.proposeView.interact(proposeController);
    }
}
