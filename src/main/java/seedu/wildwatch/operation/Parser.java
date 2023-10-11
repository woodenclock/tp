package seedu.wildwatch.operation;

public class Parser {
    public static void manualInputHandler() {

        while (true) {
            String inputBuffer = Ui.inputRetriever(); //Retrieves input of user

            if (inputBuffer.contains("bye")) {  //Program exit
                break;
            } else if (inputBuffer.equals("help")) {
                Ui.printHorizontalLines();
                Ui.helpRequestMessagePrinter();
                Ui.printHorizontalLines();
                Help.helper();
            } else {
                Ui.printHorizontalLines();
                Ui.printHorizontalLines();
            }
        }
        ShutDown.shutDown();
    }
}
