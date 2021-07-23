package types;

public enum MessageView {
    TITLE("Hanged"),
    ASK_FOR_NUMBER_OF_PLAYER("Insert number of players: "),
    NUMBER_OF_PLAYER("Player number "),
    ASK_FOR_NAME_OF_PLAYER("insert name: "),
    SECRET_TITLE("Secret: "),
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
