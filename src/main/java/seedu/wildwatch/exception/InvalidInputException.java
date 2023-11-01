package seedu.wildwatch.exception;

import seedu.wildwatch.operation.error.InvalidInputErrorType;

public class InvalidInputException extends Exception {
    private InvalidInputErrorType errorType;
    private String customMessage;

    public InvalidInputException(InvalidInputErrorType error) {
        super();
        this.errorType = error;
        this.customMessage = "";
    }

    public InvalidInputException(String error) {
        super();
        this.errorType = InvalidInputErrorType.CUSTOM;
        this.customMessage = error;
    }

    public InvalidInputErrorType getError() {
        return errorType;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
