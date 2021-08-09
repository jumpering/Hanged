package models;

public class SecretB {

    private String secret;
    private Word word;

    public SecretB(){
        this.word = new Word();
        this.secret = word.getWord();
    }

    public String getSecret(){
        return this.secret;
    }

    public int getLength(){
        return secret.length();
    }

    public boolean equalWord(String userWord){
        return userWord.equals(this.secret);
    }

    public boolean containsChar(char userChar){
        return this.secret.contains(Character.toString(userChar));
    }

    public boolean containsCharInPosition(int position, char userChar){
        return this.secret.charAt(position) == userChar;
    }
}
