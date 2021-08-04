package models;

import java.util.Random;

public class Word {

    private String word;

    public Word(){
        this.word = getFromFileRandom();
    }

    public String getFromFileRandom(){ //todo
        Random random = new Random();
        switch(random.nextInt(3)) {
            case 0:
                return "caracola";
            //break;
            case 1:
                return "hola";
            //break;
            case 2:
                return "onomatopeya";
            //break;
        }
        return "";
    }

    public String getWord(){
        return this.word;
    }
}