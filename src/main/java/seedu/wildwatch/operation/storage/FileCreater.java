package seedu.wildwatch.operation.storage;

import java.io.File;
import java.io.IOException;
import seedu.wildwatch.operation.Ui;

public class FileCreater {
    /**
     * Creates new file with filename specified by {@code FILE_PATH}.
     */
    public static File createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                Ui.createNewFileMessagePrinter();
                return file;
            } else {
                Ui.fileCreationFailMessagePrinter();
            }
        } catch (IOException exception) {
            Ui.errorMessagePrinter(exception);
        }
        return null;
    }
}
