package models;

public class Secret {

    private Word word;
    private String secret;

    public Secret(){
        this.word = new Word();
        this.secret = word.getWord();
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
}
