package assign3.java;
import java.util.Scanner;

public class ColorPalletApp {
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a color (in hex, e.g., #FF5733): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty. Please enter a valid color.");
        }
        if (isValidColor(input)) {
            return input; // Return the input if it's a valid hex color code
        } else {
            throw new IllegalArgumentException("Invalid color input. Please enter a valid 6-digit hex color.");
        }
    }

    public static boolean isValidColor(String input) {
        return input.matches("#[0-9A-Fa-f]{6}");
    }

    public static String binaryToHex(String binary) {
        if (binary.length() != 24) {
            throw new IllegalArgumentException("Binary input must be exactly 24 bits.");
        }
        int decimal = Integer.parseInt(binary, 2);
        return String.format("#%06X", decimal);
    }
}