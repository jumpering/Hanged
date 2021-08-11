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
                return "aabb";
            case 1:
                return "ccdd";
            case 2:
                return "eeff";
        }
        return "";
    }

    public String getWord(){
        return this.word;
    }
}