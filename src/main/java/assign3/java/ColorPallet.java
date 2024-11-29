package assign3.java;

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
    }

    public int getSize() {
        return colorPallet.length;
    }

    public int[] getColors() {
        return java.util.Arrays.copyOf(colorPallet, currentIndex);
    }
}
