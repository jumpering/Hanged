package controllers;

import models.Game;
import types.MessageView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProposeController extends Controller{

    public ProposeController(Game game){
        super(game);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public String getCurrentNameUser(){
        return this.game.getCurrentNameUser();
    }

    public String getStripes() {
        //todo ahora solo devuelve los blancos
        String stripes = "";
        for (int i = 0; i < this.game.getSecretWordLength(); i++){
            stripes += MessageView.SECRET_STRIPES.getMessage();
        }
        return stripes;
    }

    public boolean isValidCharOrWord(String userCharOrWord) {
        String regex = "^[a-zA-ZñÑáéíóúÁÉÍÓÚÀÈÌÒÙàèìòù]{1,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userCharOrWord);
        //return matcher.matches() && userCharOrWord.matches("^\\S+$");//todo frases, no funciona
        return matcher.matches();
    }
}
