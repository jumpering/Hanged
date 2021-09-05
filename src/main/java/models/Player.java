package models;

import types.HangedParts;
import java.util.HashSet;
import java.util.Set;

public class Player {

    private String name;
    private HangedParts hangedPartState;
    private Set<Character> matchedCharacters;
    private int totalMatchedCharacters;

    public Player(String name){
        this.name = name;
        this.hangedPartState = HangedParts.BOARD_PAPER;
        this.matchedCharacters = new HashSet<>();
        this.totalMatchedCharacters = 0;
    }

//    public void incrementTotalMatchedCharacters(){
//        this.totalMatchedCharacters++;
//    }

    public void setTotalMatchedCharacters(int totalMatchedCharacters){
        this.totalMatchedCharacters = totalMatchedCharacters;
    }

    public void setName(String name){
        this.name = name;
    }

    public HangedParts getHangedPartState(){
        return this.hangedPartState;
    }

    public void setHangedPartState(HangedParts hangedPartState){
        this.hangedPartState = hangedPartState;
    }

    public void increaseHangedPartState(){
        this.hangedPartState = HangedParts.values()[this.hangedPartState.ordinal()+1];
    }

    public String getName(){
        return this.name;
    }

    public void addMatchedChars(Character character){
        this.matchedCharacters.add(character);
    }

    public Character[] getMatchedCharacters(){
        Character[] chars = new Character[this.matchedCharacters.size()];
        this.matchedCharacters.toArray(chars);
        return chars;
    }

    public int getTotalMatchedCharacters() {
        return this.totalMatchedCharacters;
    }
}
