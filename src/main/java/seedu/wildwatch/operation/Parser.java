package seedu.wildwatch.operation;

public class Parser {
    public static void manualEntryHandler() {

        while (true) {
            String inputBuffer = Ui.inputRetriever(); //Retrieves input of user

            if (inputBuffer.contains("bye")) {  //Program exit
                break;
            } else if (inputBuffer.equals("help")) {
                Ui.printHorizontalLines();

                Ui.printHorizontalLines();
            } else {
                Ui.printHorizontalLines();
                Ui.printHorizontalLines();
            }
        }
        ShutDown.shutDown();
    }
}
