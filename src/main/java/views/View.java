package views;

import controllers.Controller;
import controllers.ControllerVisitor;

public abstract class View implements ControllerVisitor {

    public void acceptController(Controller controller){
        controller.accept(this);
    }
}
