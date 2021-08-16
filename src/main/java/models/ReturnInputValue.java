package models;

public class ReturnInputValue {

    private String string;
    private Character character;

    public String getString() {
        return this.string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Character getCharacter() {
        return this.character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public boolean isCharacter(){
        return this.character != null;
    }

    public boolean isString(){
        return this.string != null;
    }
}
