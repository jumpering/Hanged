package models;

import controllers.Controller;
import controllers.ProposeController;
import controllers.RestartController;
import controllers.StartController;

import java.util.Map;
import java.util.HashMap;

public class Logic {

    private Game game;
    private Map<StateValue, Controller> controllers;

    public Logic(){
        this.game = new Game();
        this.controllers = new HashMap<StateValue, Controller>();
        this.controllers.put(StateValue.START, new StartController(this.game));
        this.controllers.put(StateValue.PROPOSE, new ProposeController(this.game));
        this.controllers.put(StateValue.RESUME, new RestartController(this.game));
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        assert this.game.getStateValue() != null;
        return this.controllers.get(this.game.getStateValue());
    }


}
