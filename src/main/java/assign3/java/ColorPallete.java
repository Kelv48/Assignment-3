package assign3.java;

public class ColorPallete {

    private int[] colorPalette;

    public ColorPallete(int size) {
        if (size<=1) {
            throw new IllegalArgumentException("Size must be greater than 1");
        }
        if ((size&(size-1))!=0) {
            throw new IllegalArgumentException("Size must be power of 2");
        }
        colorPalette = new int[size];
    }
}
