package seedu.wildwatch.operation.storage;

import java.io.File;
import seedu.wildwatch.operation.Ui;

public class ExistenceChecker {
    /**
     * Checks if file exists. Opens file if the file exists.
     *
     * @return true if file exists; false if not.
     */
    public static boolean checkFileExistence(String filePath) {
        System.out.print(System.lineSeparator());
        Ui.checkingIfFileExistsMessagePrinter();
        assert filePath != null : "File path should not be null.";
        File file = new File(filePath);

        if (!file.exists()) {
            return false;
        } else {
            return true;
        }
    }
}
