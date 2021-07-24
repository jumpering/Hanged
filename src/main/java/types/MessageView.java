package types;

public enum MessageView {
    TITLE("Hanged"),
    ASK_FOR_NUMBER_OF_PLAYER("Insert number of players: "),
    NUMBER_OF_PLAYER("Player number "),
    TURN_NAME("Turn of player "),
    ASK_FOR_NAME_OF_PLAYER("insert name: "),
    SECRET_TITLE("Secret: "),
    SECRET_STRIPES("__ "),
    PROPOSE("Insert proposed char or word (only characters): "),
    ERROR_PROPOSE("Only characters permited");

    private String message;

    private MessageView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
