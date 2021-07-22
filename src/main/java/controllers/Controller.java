package controllers;

public abstract class Controller {

    public abstract void accept (ControllerVisitor controllerVisitor);
}
