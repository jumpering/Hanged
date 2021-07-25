package types;

public enum MessageView {
    TITLE("Hanged"),
    ASK_FOR_NUMBER_OF_PLAYER("Insert number of players / secret words (one at least): "),
    NUMBER_OF_PLAYER("Player number "),
    TURN_NAME("Turn of player "),
    ASK_FOR_NAME_OF_PLAYER("insert name: "),
    SECRET_TITLE("Secret: "),
    PROPOSE("Insert proposed char or word (only characters): "),
    FAIL_PROPOSED("Character or word not found"),
    FINE_PROPOSED("Character or word found"),
    ERROR_PROPOSE("Only characters permited"),
    PLAYER_LOSE("Your lose player ");

    private String message;

    private MessageView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
