package views;

import controllers.RestartController;
import types.MessageView;

public class RestartView {
    public void interact(RestartController restartController){
        restartController.AskForRestartGame(MessageView.ASK_FOR_RESUME_GAME.getMessage());
    }
}
