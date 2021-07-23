package models;

public class State {
    private StateValue stateValue;

    public State() {
        this.stateValue = StateValue.START;
    }

    public void next() {
        this.stateValue = StateValue.values()[this.stateValue.ordinal()+1];
    }

    public void reset() {
        this.stateValue = StateValue.START;
    }

    public StateValue getStateValue() {
        return this.stateValue;
    }
}
