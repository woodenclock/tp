package seedu.wildwatch.exception;

import seedu.wildwatch.operation.error.IncorrectInputErrorType;

public class IncorrectInputException extends Exception {
    private IncorrectInputErrorType errorType;

    private String customMessage;

    public IncorrectInputException(IncorrectInputErrorType error) {
        super();
        errorType = error;
        customMessage = "";
    }

    public IncorrectInputException(String error) {
        super();
        errorType = IncorrectInputErrorType.CUSTOM;
        this.customMessage = error;
    }

    public IncorrectInputErrorType getError() {
        return errorType;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
