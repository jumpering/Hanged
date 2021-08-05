package models;

public class Secret {

    private String secret;
    //private Word word;

    public Secret(Word word){
        //.word = new Word();
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
