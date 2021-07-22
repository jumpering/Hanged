package controllers;

public interface ControllerVisitor {

    public void visit(StartController startController);

    public void visit(ProposedController proposedController);
}
