package models;

import java.util.Objects;

public class SecretWord {

    private String secret;

    public SecretWord(){
        //getFromFile TODO
    }

    public int getLength(){
        return secret.length();
    }

    public char[] containedCharacters (char proposedCharacter){
        return new char[0];
    }
}
