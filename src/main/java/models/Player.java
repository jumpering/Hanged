package models;

public class Player {

    private String name;
    private int hangedPartState;

    public Player(){
        this.hangedPartState = 0;
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
}
