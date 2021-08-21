package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Word {

    private String word;
    private List<String> wordArrayList;

    public Word(){
        this.wordArrayList = new ArrayList<>();
        this.word = getFromFileRandom();
    }

//    public String getFromFileRandom() { //fake
//        Random random = new Random();
//        switch(random.nextInt(3)) {
//            case 0:
//                return "casa";
//            case 1:
//                return "calabaza";
//            case 2:
//                return "ñu";
//        }
//        return "";
//    }

    public String getFromFileRandom(){
        Random random = new Random();
        try {
            File file = new File ("words.txt");
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while((line = bf.readLine()) != null){
                this.wordArrayList.add(line);
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
        for (int i = 0; i < this.wordArrayList.size(); i++) {
            this.wordArrayList.get(i).toString().toLowerCase()
                    .replace("á","a")
                    .replace("é", "e")
                    .replace("í", "i")
                    .replace("ó", "o")
                    .replace("ú", "u")
                    .replace("\n", "");
        }
        return this.wordArrayList.get(random.nextInt(this.wordArrayList.size()));
    }

    public String getWord(){
        return this.word;
    }
}