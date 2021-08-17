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
                return "casa";
            case 1:
                return "calabaza";
            case 2:
                return "ñu";
        }
        return "";
    }

    public String getWord(){
        return this.word;
    }
}