package models;

import controllers.Controller;
import controllers.ProposeController;
import controllers.StartController;

import java.util.Map;
import java.util.HashMap;

public class Logic {

    //private Session session;
    private Turn turn;

    private Map<StateValue, Controller> controllers;

    public Logic(){
        this.turn = new Turn();
        this.controllers = new HashMap<StateValue, Controller>();
        this.controllers.put(StateValue.START, new StartController(this.turn));
        this.controllers.put(StateValue.USER_PROPOSE, new ProposeController(this.turn));
        //this.controllers.put(StateValue.RESUME, new ResumeController());
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(StateValue.START);
    }


}
