package controllers;

import models.Turn;

public abstract class Controller {

    protected Turn turn;

    public Controller(Turn turn){
        this.turn = turn;
    }

    public abstract void accept (ControllerVisitor controllerVisitor);
}
