package views;

import controllers.ProposeController;
import controllers.RestartController;
import controllers.StartController;

public class ConsoleView extends View{

    private StartView startView;
    private ProposeView proposeView;
    private RestartView restartView;


    public ConsoleView(){
        this.startView = new StartView();
        this.proposeView = new ProposeView();
        this.restartView = new RestartView();
    }

    @Override
    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    @Override
    public void visit(ProposeController proposeController) {
        this.proposeView.interact(proposeController);
    }

    @Override
    public void visit(RestartController restartController) {
        this.restartView.interact(restartController);
    }
}
