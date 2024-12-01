import assign3.java.ColorPalletApp;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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
     void testUserInputForBinary() {
        String simulatedInput = "111111110000000011111111\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        String userInput = ColorPalletApp.getUserInput();
        assertEquals("#FF00FF", userInput);
    }

    @Test
     void testUserInputForHex() {
        String simulatedInput = "#FF5733\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        String userInput = ColorPalletApp.getUserInput();
        assertEquals("#FF5733", userInput);
    }
}