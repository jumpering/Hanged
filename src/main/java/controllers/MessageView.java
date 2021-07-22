package controllers;

public enum MessageView {
    TITLE("Hanged"),
    PROPOSE("Insert proposed char or word (only characters):"),
    ERROR_PROPOSE("Only characters permited");

    private String message;

    private MessageView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
