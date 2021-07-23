import controllers.Controller;
import models.Logic;
import views.View;

public abstract class Hanged {

    private Logic logic;
    private View view;

    protected Hanged(){
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null){
                this.view.acceptController(controller);
            }
        } while (controller != null);
    }
}
