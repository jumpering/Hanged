package controllers;

public interface ControllerVisitor {

    public void visit(StartController startController);

    public void visit(ProposeController proposeController);

    public void visit(RestartController restartController);
}
