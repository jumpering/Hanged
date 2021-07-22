package controllers;

public class StartController extends Controller{

    private Logic logic;

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void interact(){
        System.out.println("hola desde startcontroller");

    }
}
