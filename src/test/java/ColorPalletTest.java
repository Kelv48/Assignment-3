import assign3.java.ColorPallet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColorPalletTest {

    @Test
    void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new ColorPallet(3));
        assertThrows(IllegalArgumentException.class, () -> new ColorPallet(1));
        assertThrows(IllegalArgumentException.class, () -> new ColorPallet(0));
    }

    @Test
    void testValidConstructor() {
        ColorPallet pallet = new ColorPallet(4);
        assertEquals(4, pallet.getSize());
        assertEquals(0, pallet.getColors().length);
    }

    @Test
     void testAddValidColor() {
        ColorPallet palette = new ColorPallet(4);
        palette.addColour(0xFF5733);
        palette.addColour(0x000000);
        assertArrayEquals(new int[] {0xFF5733, 0x000000, -1, -1}, palette.getArray());
    }

    @Test
     void testAddTooManyColours() {
        ColorPallet pallet = new ColorPallet(2);
        pallet.addColour(0xFF0000);
        pallet.addColour(0x00FF00);
        assertThrows(IllegalArgumentException.class, () -> {
            pallet.addColour(0x0000FF);
        });
    }

    @Test
     void testEmptyPalette() {
        ColorPallet palette = new ColorPallet(4);
        assertArrayEquals(new int[] {-1, -1, -1, -1}, palette.getArray()); // Ensure it's empty
    }

    @Test
    void testAddInvalidColour() {
        ColorPallet pallet = new ColorPallet(4);
        assertThrows(IllegalArgumentException.class, () -> pallet.addColour(0x1000000));
        assertThrows(IllegalArgumentException.class, () -> pallet.addColour(-1));
    }

    @Test
     void testRejectDuplicateColor() {
        ColorPallet palette = new ColorPallet(4);
        palette.addColour(0xFF5733);
        assertThrows(IllegalArgumentException.class, () -> palette.addColour(0xFF5733));
        assertArrayEquals(new int[] {0xFF5733, -1, -1, -1}, palette.getArray());
    }

    @Test
    void getColour() {
        ColorPallet pallet = new ColorPallet(4);

        pallet.addColour(0xFF0000);
        pallet.addColour(0x00FF00);
        pallet.addColour(0x0000FF);

        assertAll("Colour does exist in table",
                () -> assertEquals(0xFF0000, pallet.getColour(0xFF0000)),
                () -> assertEquals(0x00FF00, pallet.getColour(0x00FF00)),
                () -> assertEquals(0x0000FF, pallet.getColour(0x0000FF))
        );

        assertAll("Colour does not exist in table",
                () -> assertThrows(IllegalArgumentException.class, () -> pallet.getColour(0x123456)),
                () -> assertThrows(IllegalArgumentException.class, () -> pallet.getColour(0xAAAAAA))
        );

    }
}