import assign3.java.ColorPallet;
import assign3.java.ColorPalletApp;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ColorPalletAppTest {
    @Test
    public void testUserInputForValidColor() {
        // Simulate valid user input
        String simulatedInput = "#FF5733\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes())); // Mock input

        // Call the method to handle user input
        String userInput = ColorPalletApp.getUserInput();

        // Verify the input is correct
        assertEquals("#FF5733", userInput);

        // Simulate adding this color to the palette
        ColorPallet palette = new ColorPallet(4);
        palette.addColour(Integer.parseInt(userInput.substring(1), 16)); // Convert hex to RGB

        // Check if the color has been added to the palette
        assertArrayEquals(new int[] {0xFF5733, -1, -1, -1}, palette.getArray());
    }
}
