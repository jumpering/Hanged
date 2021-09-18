package models;

public class Secret {

    private String secret;
    //private Word word;
    private WordBD word;

    public Secret(){
        this.word = new Word();
        this.setWord();
    }

    public void setWord(){
        this.secret = this.word.getWord();
    }

    public int getLength(){
        return secret.length();
    }

    public boolean isEqualWord(String userWord){
        return userWord.equals(this.secret);
    }

    public boolean isEqualCharInAnyPosition(char userChar){
        return this.secret.contains(Character.toString(userChar));
    }

    public boolean isEqualCharInConcretePosition(int position, char userChar){
        if (position < this.secret.length()){
            return this.secret.charAt(position) == userChar;
        }
       return false;
    }

    public String getSecret(){
        return this.secret;
    }
}
