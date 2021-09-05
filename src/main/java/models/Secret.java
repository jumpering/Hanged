package models;

public class Secret {

    private String word;

    public Secret(Word word){
        this.word = word.getWord();
    }

    public int getLength(){
        return word.length();
    }

    public boolean isEqualWord(String userWord){
        return userWord.equals(this.word);
    }

    public boolean isEqualCharInAnyPosition(char userChar){
        return this.word.contains(Character.toString(userChar));
    }

    public boolean isEqualCharInConcretePosition(int position, char userChar){
        if (position < this.word.length()){
            return this.word.charAt(position) == userChar;
        }
       return false;
    }

    public String getWord(){
        return this.word;
    }
}
