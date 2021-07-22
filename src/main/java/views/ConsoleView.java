package views;

import controllers.MessageView;
import controllers.ProposedController;
import controllers.StartController;

public class ConsoleView extends View{

    private StartView startView;
    private ProposedCharView proposedCharView;


    public ConsoleView(){
        this.startView = new StartView();
        this.proposedCharView = new ProposedCharView();
    }

    @Override
    public void visit(StartController startController) {
        this.startView.show();

    }

    @Override
    public void visit(ProposedController proposedController) {

    }
}
