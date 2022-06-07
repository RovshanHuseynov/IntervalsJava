package model;

public enum ErrorMessagesEnum {
    MIN_VALUE_ERROR("could not find minimum value"),
    MAX_VALUE_ERROR("could not find maximum value");

    private String message;

    ErrorMessagesEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
