package models;

import types.HangedParts;

import java.util.HashSet;
import java.util.Set;

public class Player {

    private String name;
    private HangedParts hangedPartState;
    private Set<Character> matchedChars;

    public Player(String name){
        this.name = name;
        this.hangedPartState = HangedParts.BOARD_PAPER;
        this.matchedChars = new HashSet<>();
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
        this.matchedChars.add(character);
    }

    public Character[] getMatchedChars(){
        Character[] chars = new Character[this.matchedChars.size()];
        this.matchedChars.toArray(chars);
        return chars;
    }
}
