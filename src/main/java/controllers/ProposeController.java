package controllers;

import models.Game;
import types.HangedParts;
import types.MessageView;
import utils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProposeController extends Controller {

    public ProposeController(Game game) {
        super(game);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public String getCurrentPlayerName() {
        return this.game.getCurrentPlayerName();
    }

    public String getStripes() {
        char[] stripes = new char[this.game.getSecretWordLength()];
        for (int i = 0; i < stripes.length; i++){
            stripes[i] = '_';
            for (int j = 0; j < this.game.getCurrentPlayer().getMatchedChars().length; j++){
                if (this.game.containsCharInPosition(i,this.game.getCurrentPlayer().getMatchedChars()[j])){
                    stripes[i] = this.game.getCurrentPlayer().getMatchedChars()[j];
                }
            }
        }
        return new String(stripes);
    }

    public boolean isValidCharOrWord(String userCharOrWord) {
        String regex = "^[a-zA-ZñÑáéíóúÁÉÍÓÚÀÈÌÒÙàèìòù]{1,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userCharOrWord);
        return matcher.matches();
    }

    public void manageCharOrWordPresentOnSecretword(String userCharOrWord) { //todo
        if (userCharOrWord.length() > 1 && this.game.isCharOrWordPresentOnSecret(userCharOrWord)) {
            //player X gana y termina juego

        } else {
            //player pierde directamente (lo colgamos) y sigue juego SI HAY MÁS DE UN PLAYER!

        }
        if (userCharOrWord.length() == 1 && this.game.isCharOrWordPresentOnSecret(userCharOrWord)) {
            this.game.getCurrentPlayer().addMatchedChars(userCharOrWord.charAt(0));
            Console.getInstance().writeln(MessageView.FINE_PROPOSED.getMessage());
        } else {
            Console.getInstance().writeln(MessageView.FAIL_PROPOSED.getMessage());
            this.game.getCurrentPlayer().increaseHangedPartState();
//            if (this.game.getCurrentPlayer().getHangedPartState() == HangedParts.ROPE){
//                //player pierde y sigue el juego si todavia quedan jugadores
//                this.game.removeCurrentPlayer();
//            }
        }
    }

    public boolean isPlayerEnd(){
        return this.game.getCurrentPlayer().getHangedPartState() == HangedParts.ROPE;
    }

    public void removeCurrentPlayer(){
        this.game.removeCurrentPlayer();
    }

//    public boolean isCharOrWordPresentOnSecretword(String userCharOrWord) {
//        if (userCharOrWord.length() > 1 && this.game.isCharOrWordPresentOnSecret(userCharOrWord)) {
//            return true;
//        }
//        return userCharOrWord.length() == 1 && this.game.isCharOrWordPresentOnSecret(userCharOrWord);
//    }



    public HangedParts getHangedPartStateFromCurrentPlayer(){
        return this.game.getCurrentPlayer().getHangedPartState();
    }

    public void nextPlayer(){
        this.game.nextPlayer();
    }
}
