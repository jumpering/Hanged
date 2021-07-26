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
        if (userCharOrWord.length() > 1){
            if(this.game.isCharOrWordPresentOnSecret(userCharOrWord)){
                for (int i = 0; i < userCharOrWord.length(); i++){
                    this.game.getCurrentPlayer().addMatchedChars(userCharOrWord.charAt(i));
                }
                Console.getInstance().writeln(MessageView.PLAYER_WIN.getMessage() + this.getCurrentPlayerName()  + "!");
                nextGameState();
            }else{
                this.game.getCurrentPlayer().setHangedPartState(HangedParts.ROPE);
            }
        }
        if (userCharOrWord.length() == 1){
            if(this.game.isCharOrWordPresentOnSecret(userCharOrWord)){
                this.game.getCurrentPlayer().addMatchedChars(userCharOrWord.charAt(0));
                Console.getInstance().writeln(MessageView.FINE_PROPOSED.getMessage());
            }else{
                Console.getInstance().writeln(MessageView.FAIL_PROPOSED.getMessage());
                this.game.getCurrentPlayer().increaseHangedPartState();
            }
        }


    }

    public boolean isWordEqualSecret(String userCharOrWord){
        return userCharOrWord.length() > 1 && this.game.isCharOrWordPresentOnSecret(userCharOrWord);
    }

    public boolean isCharEqualSecret(String userCharOrWord){
        return userCharOrWord.length() == 1 && this.game.isCharOrWordPresentOnSecret(userCharOrWord);
    }

    public boolean isPlayerEnd(){
        return this.game.getCurrentPlayer().getHangedPartState() == HangedParts.ROPE;
    }

    public void removeCurrentPlayer(){
        this.game.removeCurrentPlayer();
    }

    public HangedParts getHangedPartStateFromCurrentPlayer(){
        return this.game.getCurrentPlayer().getHangedPartState();
    }

    public void nextPlayer(){
        this.game.nextPlayer();
    }
}
