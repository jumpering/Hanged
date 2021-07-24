package controllers;

import models.Game;
import types.MessageView;
import utils.Console;

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

    public void interact(){
        Console console = new Console();
        String userPropose;
        userPropose = console.readString(MessageView.PROPOSE.getMessage());

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
        String regex = "[a-zA-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userCharOrWord);
        System.out.println(matcher.find());
        System.out.println(matcher.matches());
        return matcher.matches();
    }
}
