package assign3.java;
import java.util.Scanner;

public class ColorPalletApp {
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a color (in binary or hex, e.g., #FF5733 (6-digits) or 101011110010 (24-bits) ): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty. Please enter a valid color.");
        }
        if (input.matches("[01]{24}")) { // Binary input (24 bits)
            return binaryToHex(input);
        }
        if (input.matches("#[0-9A-Fa-f]{6}")) { // Hexadecimal input
            return input;
        }
        throw new IllegalArgumentException("Invalid color input. Please enter a valid 24-bit binary or 6-digit hex color.");
    }

    public static String binaryToHex(String binary) {
        if (binary.length() != 24) {
            throw new IllegalArgumentException("Binary input must be exactly 24 bits.");
        }
        int decimal = Integer.parseInt(binary, 2);
        return String.format("#%06X", decimal);
    }
}