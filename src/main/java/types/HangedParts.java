package types;

public enum HangedParts {

    BOARD_PAPER("+-----------------+\n" +
                "|                 |\n" +
                "|                 |\n" +
                "|                 |\n" +
                "|                 |\n" +
                "|                 |\n" +
                "|                 |\n" +
                "|                 |\n" +
                "+-----------------+"),
    BASE("+-----------+\\n|               |\\n ++++++++++++\\n|                |\\n+--------------+"),
    POOL("+-----------+\\n|               |\\n\\n *********** \\n ++++++++++++\\n|                |\\n+--------------+");

    private String hangedPart;

    private HangedParts(String hangedPart) {
        this.hangedPart = hangedPart;
    }

   public String getHangedPart(){
        return this.hangedPart;
   }
}
