public abstract class Hanged {

    private Logic logic;
    private View view;

    public void Hanged(){
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null){
                this.view.interact(controller);
            }
        } while (controller != null);
    }
}
