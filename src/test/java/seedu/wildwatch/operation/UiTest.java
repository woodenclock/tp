package seedu.wildwatch.operation;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {
    @Test
    public void testInputRetriever() {
        System.out.println("Testing Ui.inputRetriever()");
        String input = " test input ";
        InputStream originalSystemIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            assertEquals("test input", Ui.inputRetriever());
        } finally {
            System.setIn(originalSystemIn);
        }
    }
}
