//@@woodenclock
package seedu.wildwatch.operation;

public class BootUp {
    public static final String WELCOME_MESSAGE_1 =
            "Hello there! Welcome to WildWatch!\n";

    public static final String WELCOME_MESSAGE_2 =
            "What would you like to do?\n";

    public static final String LOGO =
            "____    __    ____  __   __       _______\n" +
            "\\   \\  /  \\  /   / |  | |  |     |       \\\n" +
            " \\   \\/    \\/   /  |  | |  |     |  .--.  |\n" +
            "  \\            /   |  | |  |     |  |  |  |\n" +
            "   \\    /\\    /    |  | |  `----.|  '--'  |\n" +
            "    \\__/  \\__/     |__| |_______||_______/\n" +
            "____    __    ____  ___   .___________.  ______  __    __\n" +
            "\\   \\  /  \\  /   / /   \\  |           | /      ||  |  |  |\n" +
            " \\   \\/    \\/   / /  ^  \\ `---|  |----`|  ,----'|  |__|  |\n" +
            "  \\            / /  /_\\  \\    |  |     |  |     |   __   |\n" +
            "   \\    /\\    / /  _____  \\   |  |     |  `----.|  |  |  |\n" +
            "    \\__/  \\__/ /__/     \\__\\  |__|      \\______||__|  |__|\n";

    public static void bootUpOne() {
        Ui.printHorizontalLines();
        System.out.print(BootUp.LOGO);
        Ui.printHorizontalLines();
        System.out.print(BootUp.WELCOME_MESSAGE_1);
    }

    public static void bootUpTwo() {
        System.out.print(BootUp.WELCOME_MESSAGE_2);
        Ui.printHorizontalLines();
    }
}
