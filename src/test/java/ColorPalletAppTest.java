import assign3.java.ColorPallet;
import assign3.java.ColorPalletApp;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ColorPalletAppTest {


    //Broken into two tests
    @Test
    void testWhitespaceUserInputForColor() {
        // Simulate whitespace-only user input for "color" mode
        String simulatedInput = "   \n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> ColorPalletApp.getUserInput("color"));
    }

    @Test
    void testWhitespaceUserInputForSize() {
        // Simulate whitespace-only user input for "size" mode
        String simulatedInput = "   \n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> ColorPalletApp.getUserInput("size"));
    }

    @Test
     void testBinaryToHex() {
        String binaryInput = "111111110000000011111111";
        String hexOutput = ColorPalletApp.binaryToHex(binaryInput);

        assertEquals("#FF00FF", hexOutput);
    }

    @Test
    public void testInvalidBinaryInput() {
        // Simulate invalid binary input
        String simulatedInput = "1111111100000000111111111\n"; // 25 bits
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> ColorPalletApp.getUserInput("color"));
    }

    @Test
    void testUserInputForBinary() {
        String simulatedInput = "111111110000000011111111\n"; // 24 bits
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        String userInput = ColorPalletApp.getUserInput("color");
        assertEquals("#FF00FF", userInput);
    }

    @Test
    public void testInvalidHexInput() {
        String simulatedInput = "#ZZZZZZ\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> ColorPalletApp.getUserInput("color"));
    }

    @Test
    void testUserInputForHex() {
        // Simulate valid hex input
        String simulatedInput = "#FF5733\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String userInput = ColorPalletApp.getUserInput("color");
        assertEquals("#FF5733", userInput);
    }

    @Test
    public void testSizeInputValid() {
        String simulatedInput = "8\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String sizeInput = ColorPalletApp.getUserInput("size");
        assertEquals("8", sizeInput);
    }

    @Test
    public void testSizeInputInvalid() {
        String simulatedInput = "5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> ColorPalletApp.getUserInput("size"));
    }

    @Test
    public void testPrintColorPallet() {
        ColorPallet colorPallet = new ColorPallet(4);
        colorPallet.addColour(0xFF00FF);
        colorPallet.addColour(0x00FF00);
        colorPallet.addColour(0x123ABC);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ColorPalletApp.printColorPallet(colorPallet);

        System.setOut(System.out);

        String expectedOutput = """
                Your Color Pallet:
                #FF00FF
                #00FF00
                #123ABC
                """;

        String actualOutput = outputStream.toString().trim().replace("\r\n", "\n").strip();
        String expectedNormalized = expectedOutput.trim().replace("\r\n", "\n").strip();
        assertEquals(expectedNormalized, actualOutput);
    }
}