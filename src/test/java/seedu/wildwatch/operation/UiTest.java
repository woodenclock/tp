package seedu.wildwatch.operation;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {
    private static final int NUMBER_OF_UNDERSCORES = 60;

    @Test
    public void testInputRetriever() {
        printHorizontalLines();
        System.out.println("Testing Ui.inputRetriever");
        printHorizontalLines();
        System.out.println();

        String input = " test input ";
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            assertEquals("test input", Ui.inputRetriever());
        } finally {
            System.setIn(System.in);
        }
    }

    public static void printHorizontalLines() {
        for (int i = 0; i < NUMBER_OF_UNDERSCORES; i++) {
            System.out.print("_");
        }
        System.out.print(System.lineSeparator());
    }
}
