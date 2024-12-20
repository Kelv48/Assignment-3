package assign3.java;
import java.util.Scanner;

public class ColorPalletApp {


    public static String getUserInput(String mode) {
        Scanner scanner = new Scanner(System.in);

        if (mode.equals("size")) {
            System.out.print("Enter the size of the color pallet (must be a power of 2 and greater than 1): ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty. Please enter a valid size.");
            }
            try {
                int size = Integer.parseInt(input);
                if (size <= 1 || (size & (size - 1)) != 0) { // Not a power of 2
                    throw new IllegalArgumentException("Size must be greater than 1 and a power of 2.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input. Size must be a number.");
            }
            return input;
        }

        if (mode.equals("color")) {
            System.out.println("\nEnter colors in binary (24-bits) or hexadecimal (6-digits), or type 'exit' to quit.");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty. Please enter a valid color.");
            }

            if (input.equalsIgnoreCase("exit")) {
                return "exit";
            }

            if (input.matches("[01]{24}")) {
                return binaryToHex(input);
            }
            if (input.matches("#[0-9A-Fa-f]{6}")) {
                return input;
            }
            throw new IllegalArgumentException("Invalid color input. Please enter a valid 24-bit binary or 6-digit hex color.");
        }

        throw new IllegalArgumentException("Invalid mode. Must be 'size' or 'color'.");
    }

    public static String binaryToHex(String binary) {
        if (binary.length() != 24) {
            throw new IllegalArgumentException("Binary input must be exactly 24 bits.");
        }
        int decimal = Integer.parseInt(binary, 2);
        return String.format("#%06X", decimal);
    }

    public static void printColorPallet(ColorPallet colorPallet) {
        int[] colors = colorPallet.getArray();
        System.out.println("Your Color Pallet:");
        for (int color : colors) {
            if (color != -1) {
                System.out.printf("#%06X%n", color);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Color Pallet App!");

        int size;
        while (true) {
            try {
                String sizeInput = getUserInput("size");
                size = Integer.parseInt(sizeInput.trim());
                if (size <= 1 || (size & (size - 1)) != 0) {
                    throw new IllegalArgumentException("Size must be greater than 1 and a power of 2.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        ColorPallet colorPallet = new ColorPallet(size);

        while (true) {
            String userInput = getUserInput("color").trim();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the app. Here is your color pallet:");
                printColorPallet(colorPallet);
                break;
            }

            try {
                colorPallet.addColour(Integer.parseInt(userInput.substring(1), 16));
                System.out.println("Color added successfully: " + userInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}