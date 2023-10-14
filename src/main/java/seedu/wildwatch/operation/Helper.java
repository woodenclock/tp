package seedu.wildwatch.operation;

public class Helper {
    /**
     * Requires UPDATE
     */
    private static final String helpCommandMessage =
            "\n\n" +
                    "    ____________________________________________________________\n" +
                    "1.  Get help - show the list of commands available for this app\n" +
                    "     Format: help\n" +
                    "     Examples: \n" +
                    "       help\n" +
                    "    ____________________________________________________________\n";
    private static final String addCommandMessage =
            "\n\n" +
                    "    ____________________________________________________________\n" +
                    "2.  To add a new wildlife\n" +
                    "     Format: add D/DATE S/SPECIES N/NAME R/REMARKS\n" +
                    "       DATE should be in the format DD-MM-YY\n" +
                    "     Examples: \n" +
                    "       add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper\n" +
                    "       add D/10-11-20 S/Bali Myna N/Myna_1 R/ S/Malayan Water Monitor N/Monitor_1 R/Aggressive\n" +
                    "    ____________________________________________________________\n";

    private static final String listCommandMessage =
            "\n\n" +
                    "    ____________________________________________________________\n" +
                    "3.  To list all wildlife,\n" +
                    "     Format: list\n" +
                    "     Examples: \n" +
                    "       list\n" +
                    "    ____________________________________________________________\n";

    private static final String deleteCommandMessage =
            "\n\n" +
                    "    ____________________________________________________________\n" +
                    "4.  To delete a wildlife\n" +
                    "     Format: delete INDEX\n" +
                    "       The index refers to the index number shown in the displayed observation list.\n" +
                    "       Note:\n" +
                    "           - The index must be a positive integer:\n" +
                    "           - Deleted items may not be recoverable:\n" +
                    "     Examples: \n" +
                    "       delete 1\n" +
                    "       delete 6\n" +
                    "    ____________________________________________________________\n";

    private static final String helpPage =
                    "\n\n" +
                    "---------------------------HELP PAGE----------------------------\n"+
                    helpCommandMessage +
                    "\n\n" +
                    addCommandMessage +
                    "\n\n" +
                    listCommandMessage +
                    "\n\n" +
                    deleteCommandMessage +
                    //"\n\n" +

                    "\n" +
                    "-------------------------HELP PAGE END--------------------------\n";

    /**
     * Prints out help page
     */
    public static void printHelpMessage() {
        System.out.println(helpPage);
    }
}
