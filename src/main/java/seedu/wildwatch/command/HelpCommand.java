package seedu.wildwatch.command;

public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    /**
     * Requires UPDATE
     */
    private static final String helpCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "1.  Get help - show the list of commands available for this app\n" +
                    "     Format: help\n" +
                    "     Examples: \n" +
                    "       help\n";
    private static final String addCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "2.  To add a new wildlife\n" +
                    "     Format: add D/DATE S/SPECIES N/NAME R/REMARKS\n" +
                    "       DATE should be in the format DD-MM-YY\n" +
                    "     Examples: \n" +
                    "       add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper\n";

    private static final String listCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "3.  To list all wildlife,\n" +
                    "     Format: list\n" +
                    "     Examples: \n" +
                    "       list\n";

    private static final String deleteCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "4.  To delete a wildlife\n" +
                    "     Format: delete INDEX\n" +
                    "       The index refers to the index number shown in the displayed observation list.\n" +
                    "       Note:\n" +
                    "           - The index must be a positive integer:\n" +
                    "           - Deleted items may not be recoverable:\n" +
                    "     Examples: \n" +
                    "       delete 1\n" +
                    "_________________________________________________________________\n";


    private static final String editCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "5.  To edit a wildlife\n" +
                    "     Format: edit I/INDEX D/DATE S/SPECIES N/NAME R/REMARKS\n" +
                    "       The index refers to the index number shown in the displayed observation list.\n" +
                    "       Note:\n" +
                    "           - The index must be a positive integer:\n" +
                    "           - DATE, SPECIES, NAME, REMARKS arguments are optional.\n" +
                    "     Examples: \n" +
                    "       edit I/1 D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper\n" +
                    "_________________________________________________________________\n";

    private static final String summaryCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "6.  To show a summary\n" +
                    "     Format: summary SPECIES\n" +
                    "       Note:\n" +
                    "           - SPECIES argument is optional\n" +
                    "     Examples: \n" +
                    "       summary \n" +
                    "       summary Annam Leaf Turtle\n" +
                    "_________________________________________________________________\n";

    private static final String byeCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "8.  To exit the program\n" +
                    "     Format: bye\n" +
                    "     Examples: \n" +
                    "       bye \n" +
                    "_________________________________________________________________\n";

    private static final String exportCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "7.  To export wildlife data\n" +
                    "     Format: export FILENAME\n" +
                    "       Note:\n" +
                    "           - FILENAME argument is optional\n" +
                    "           - FILENAME argument if specified should end with a .csv extension\n" +
                    "     Examples: \n" +
                    "       summary \n" +
                    "       summary Annam Leaf Turtle\n" +
                    "_________________________________________________________________\n";
    private static final String helpPage =
            "\n" +
                    "---------------------------HELP PAGE-----------------------------\n" +
                    helpCommandMessage +
                    addCommandMessage +
                    listCommandMessage +
                    deleteCommandMessage +
                    editCommandMessage +
                    summaryCommandMessage +
                    exportCommandMessage +
                    byeCommandMessage +
                    "\n" +
                    "-------------------------HELP PAGE END---------------------------\n";

    private static final String helpPageShort =
            "\n" +
                    "---------------------------HELP PAGE (short)-----------------------------\n" +
                    "add: add D/DATE S/SPECIES N/NAME R/REMARKS\n" +
                    "list: list\n" +
                    "delete: delete INDEX\n" +
                    "edit: edit I/INDEX D/DATE S/SPECIES N/NAME R/REMARKS\n" +
                    "summary: summary SPECIES\n" +
                    "export: export FILENAME\n" +
                    "bye: exits the program\n" +
                    "\n" +
                    "-------------------------HELP PAGE (short) END---------------------------\n";


    private static final String needHelpPage =
            "Please type \"help\" if you need help.";

    private String input;

    public HelpCommand(String input) {
        this.input = input;
    }

    public static void printNeedHelpMessage() {
        System.out.println(needHelpPage);
    }

    /**
     * Print specific help message based on the command specified
     *
     * @return String helpPage
     */
    public static String getHelpPage() {
        return helpPage;
    }

    /**
     * Print specific help message based on the command specified
     *
     * @param command command
     */
    public void printMessageForCommand(String command) {
        switch (command) {
            case "add":
                System.out.println(addCommandMessage);
                break;
            case "list":
                System.out.println(listCommandMessage);
                break;
            case "delete":
                System.out.println(deleteCommandMessage);
                break;
            case "edit":
                System.out.println(editCommandMessage);
                break;
            case "summary":
                System.out.println(summaryCommandMessage);
                break;
            case "export":
                System.out.println(exportCommandMessage);
                break;
            case "bye":
                System.out.println(byeCommandMessage);
                break;
            case "full":
                System.out.println(helpPage);
                break;
            default:
                break;
        }
    }

    /**
     * Prints out help page
     */
    public void execute() {
        if (input.isEmpty()) {
            System.out.println("No worries, I'm here to help!");
            System.out.println(helpPage);
            return;
        }

        String argument = input.replace("help", "").trim();
        if (argument.isEmpty()) {
            // print short version
            System.out.println("No worries, I'm here to help!");
            System.out.println(helpPageShort);
        } else {
            // e.g `help add`
            System.out.println("No worries, I'm here to help!");
            printMessageForCommand(argument);
        }

    }


}
