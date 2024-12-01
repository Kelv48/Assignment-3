import assign3.java.ColorPallet;
import assign3.java.ColorPalletApp;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ColorPalletAppTest {


    @Test
     void testWhitespaceUserInput() {
        // Simulate whitespace-only user input
        String simulatedInput = "   \n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThrows(IllegalArgumentException.class, ColorPalletApp::getUserInput);
    }

    @Test
     void testBinaryToHex() {
        String binaryInput = "111111110000000011111111";
        String hexOutput = ColorPalletApp.binaryToHex(binaryInput);

        assertEquals("#FF00FF", hexOutput);
    }

    @Test
    public void testInvalidBinaryInput() {
        String simulatedInput = "1111111100000000111111111\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));


        assertThrows(IllegalArgumentException.class, ColorPalletApp::getUserInput);
    }

    @Test
     void testUserInputForBinary() {
        String simulatedInput = "111111110000000011111111\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        String userInput = ColorPalletApp.getUserInput();
        assertEquals("#FF00FF", userInput);
    }

    @Test
    public void testInvalidHexInput() {
        // Simulate invalid hex input (too many characters)
        String simulatedInput = "#ZZZZZZ\n"; // Invalid hex
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        // Ensure an exception is thrown for invalid hex input
        assertThrows(IllegalArgumentException.class, ColorPalletApp::getUserInput);
    }

    @Test
     void testUserInputForHex() {
        String simulatedInput = "#FF5733\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        String userInput = ColorPalletApp.getUserInput();
        assertEquals("#FF5733", userInput);
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