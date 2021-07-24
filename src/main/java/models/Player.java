package models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Player {

    private String name;
    private int hangedPartState;
    private Set<Character> matchedChars;

    public Player(){
        this.hangedPartState = 0;
        this.matchedChars = new HashSet<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHangedPartState(){
        return this.hangedPartState;
    }

    public void increaseHangedPartState(){
        this.hangedPartState++;
    }

    public String getName(){
        return this.name;
    }

    public void addMatchedChars(Character character){
        this.matchedChars.add(character);
    }
}
