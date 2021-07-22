package controllers;

import java.util.Map;
import java.util.HashMap;

public class Logic {

    private Map<StateValue, Controller> controllers;

    public Logic(){
        this.controllers = new HashMap<StateValue, Controller>();
        this.controllers.put(StateValue.START, new StartController());
        this.controllers.put(StateValue.USER_PROPOSE, new ProposedController());
        this.controllers.put(StateValue.FINAL, new ProposedController());
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(StateValue.START);
    }
}
