package controllers;

import views.View;

public class ProposedController extends Controller{

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
    }

    public void interact(){
        System.out.println("hola desde proposedCharController");
    }
}
