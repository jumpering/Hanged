package controllers;

import models.Game;
import models.ReturnInputValue;
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

    public boolean isValidCharacterOrString(String userCharOrWord) {
        String regex = "^[a-zA-ZñÑáéíóúÁÉÍÓÚÀÈÌÒÙàèìòù]{1,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userCharOrWord);
        return matcher.matches();
    }

    public void compareCharacterOrStringWithSecret(ReturnInputValue getUserInput) {//todo return boolean, message in view, separate char and string
        if (getUserInput.isString()){
            if(this.game.isCharacterOrStringPresentOnSecret(getUserInput.getString())){
                for (int i = 0; i < getUserInput.getString().length(); i++){
                    this.game.getCurrentPlayer().addMatchedChars(getUserInput.getString().charAt(i));
                }
                Console.getInstance().writeln(MessageView.PLAYER_WIN.getMessage() + this.getCurrentPlayerName()  + "!");
                nextGameState();
            }else{
                Console.getInstance().writeln(MessageView.FAIL_PROPOSED.getMessage());
                this.game.getCurrentPlayer().setHangedPartState(HangedParts.L_LEG);
                if (this.game.getNumberOfPlayers() == 0){
                    nextGameState();
                }
            }
        }
        if (getUserInput.isCharacter()){
            if(this.game.isCharacterOrStringPresentOnSecret(getUserInput.getCharacter())){
                this.game.getCurrentPlayer().addMatchedChars(getUserInput.getCharacter());
                Console.getInstance().writeln(MessageView.FINE_PROPOSED.getMessage());
            }else{
                Console.getInstance().writeln(MessageView.FAIL_PROPOSED.getMessage());
                this.game.getCurrentPlayer().increaseHangedPartState();
               if(this.game.getCurrentPlayer().getHangedPartState() == HangedParts.L_LEG && this.game.getNumberOfPlayers() == 0){
                       nextGameState();
               }
            }
        }
    }

    public boolean isPlayerEnd(){
        return this.game.getCurrentPlayer().getHangedPartState() == HangedParts.L_LEG;
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
