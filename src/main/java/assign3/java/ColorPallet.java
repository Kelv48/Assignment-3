package assign3.java;

import java.util.Arrays;

public class ColorPallet {

    private int[] colorPallet;
    private int currentIndex = 0;

    public ColorPallet(int size) {
        if (size<=1) {
            throw new IllegalArgumentException("Size must be greater than 1");
        }
        if ((size&(size-1))!=0) {
            throw new IllegalArgumentException("Size must be power of 2");
        }
        colorPallet = new int[size];
        Arrays.fill(colorPallet, -1);
    }

    public void addColour(int rgbColour) {
        if ((rgbColour & 0xFFFFFF) != rgbColour) {
            throw new IllegalArgumentException("Invalid RGB colour: must be a 24-bit value.");
        }
        if (currentIndex >= colorPallet.length) {
            throw new IllegalArgumentException("Color array is full");
        }
        colorPallet[currentIndex] = rgbColour;
        currentIndex++;
    }

    public int getSize() {
        return colorPallet.length;
    }

    public int[] getColors() {
        return java.util.Arrays.copyOf(colorPallet, currentIndex);
    }
}