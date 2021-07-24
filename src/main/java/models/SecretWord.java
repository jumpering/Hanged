package models;

import java.util.Objects;

public class SecretWord {

    private String secret;

    public SecretWord(){
        //getFromFile todo getFilefromFile
        this.secret = "hola";
    }

    public int getLength(){
        return secret.length();
    }

    public char[] containCharacter (char proposedCharacter){
        return new char[0];
    }
}
