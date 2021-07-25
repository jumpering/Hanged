package models;

import java.util.Random;

public class SecretWord {

    private String secret;

    public SecretWord(){
        getFromFileRandom();
    }

    public int getLength(){
        return secret.length();
    }

    public boolean containsWord(String userWord){
        return userWord.equals(this.secret);
    }

    public boolean containsChar(char userChar){
        return this.secret.contains(Character.toString(userChar));
    }

    public boolean containsCharInPosition(int position, char userChar){
        return this.secret.charAt(position) == userChar;
    }

    public void getFromFileRandom(){
        //getFromFile todo getFilefromFile
        Random random = new Random();
        switch(random.nextInt(3)) {
            case 0:
                this.secret = "caracola";
                break;
            case 1:
                this.secret = "hola";
                break;
            case 2:
                this.secret = "onomatopeya";
                break;
        }
    }
}
