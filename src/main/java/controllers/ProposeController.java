package controllers;

import models.Game;
import models.ReturnInputValue;
import types.HangedParts;
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
        char[] stripes = new char[this.game.getSecretWordLength(this.game.getCurrentPlayer())];
        for (int i = 0; i < stripes.length; i++) {
            stripes[i] = '_';
            for (int j = 0; j < this.game.getCurrentPlayer().getMatchedChars().length; j++) {
                if (this.game.containsCharInPosition(i, this.game.getCurrentPlayer().getMatchedChars()[j])) {
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

    public boolean isEqualWithSecret(ReturnInputValue getUserInput) {
        if (getUserInput.isString()) {
            return isEqualWithSecret(getUserInput.getString());
        }
        if (getUserInput.isCharacter()) {
            return isEqualWithSecret(getUserInput.getCharacter());
        }
        return false;
    }

    private boolean isEqualWithSecret(String getUserInput) {
        boolean isEqual = false;
        if (this.game.isUserInputPresentOnSecret(getUserInput)) {
            for (int i = 0; i < getUserInput.length(); i++) {
                this.game.getCurrentPlayer().addMatchedChars(getUserInput.charAt(i));
            }
            isEqual = true;
        } else {
            this.game.getCurrentPlayer().setHangedPartState(HangedParts.L_LEG);
        }
        return isEqual;
    }

    private boolean isEqualWithSecret(Character getUserInput) {
        boolean isEqual = false;
        if (this.game.isUserInputPresentOnSecret(getUserInput)) {
            this.game.getCurrentPlayer().addMatchedChars(getUserInput);
            isEqual = true;
        } else {
            this.game.getCurrentPlayer().increaseHangedPartState();
        }
        return isEqual;
    }

    public boolean isLengthEqualSecret(ReturnInputValue getUserInput){
        boolean isLengthEqual = false;
        if (getUserInput.isString() && this.game.getSecretWordLength(this.game.getCurrentPlayer()) == getUserInput.getString().length()){
            isLengthEqual = true;
        }
        if (getUserInput.isCharacter() && this.game.getSecretWordLength(this.game.getCurrentPlayer()) == this.game.getCurrentPlayer().getMatchedChars().length){
            isLengthEqual = true;
        }
        return isLengthEqual;
    }

    public boolean isPlayerEnd() {
        return this.game.getCurrentPlayer().getHangedPartState() == HangedParts.L_LEG;
    }

    public void removeCurrentPlayer() {
        this.game.removeCurrentPlayer(this.game.getCurrentPlayer());
    }

    public HangedParts getHangedPartStateFromCurrentPlayer() {
        return this.game.getCurrentPlayer().getHangedPartState();
    }

    public void nextPlayer() {
        this.game.nextPlayer();
    }

    public int getNumberOfPlayers() {
        return this.game.getNumberOfPlayers();
    }

    public String showCurrentPlayerSecret(){
        return this.game.getPlayerSecret();
    }
}
