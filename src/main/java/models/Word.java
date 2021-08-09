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
                return "aaaaa";
            //break;
            case 1:
                return "bbbbb";
            //break;
            case 2:
                return "cccccc";
            //break;
        }
        return "";
    }

    public String getWord(){
        return this.word;
    }
}