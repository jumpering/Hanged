package controllers;

public enum HangedParts {

    BOARD_PAPER("+-----------+\\n|               |\\n|                |\\n+--------------+"),
    SECRET("__ "),
    BASE("---------\\n||||||||||\\n"),
    POOL("         \\n-----------\\n");

    private String hangedPart;

    private HangedParts(String hangedPart) {
        this.hangedPart = hangedPart;
    }

   public String getHangedPart(){
        return this.hangedPart;
   }
}
