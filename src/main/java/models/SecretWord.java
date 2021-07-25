package models;

public class SecretWord {

    private String secret;

    public SecretWord(){
        //getFromFile todo getFilefromFile
        this.secret = "hola";
    }

    public int getLength(){
        return secret.length();
    }

    public boolean containsWord(String userWord){
        return userWord.equals(this.secret);
    }

    public boolean containsChar(String userChar){
        return this.secret.contains(userChar);
    }
}
