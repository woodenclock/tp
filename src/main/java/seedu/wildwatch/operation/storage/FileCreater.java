package seedu.wildwatch.operation.storage;

import java.io.File;
import java.io.IOException;
import seedu.wildwatch.operation.Ui;

public class FileCreater {
    /**
     * Creates new file with filename specified by {@code FILE_PATH}.
     */
    public static File createFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.createNewFile()) {
            Ui.createNewFileMessagePrinter();
            return file;
        } else {
            throw new IOException();
        }
    }
}
