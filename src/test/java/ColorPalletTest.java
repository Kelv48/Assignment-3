import assign3.java.ColorPallet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void testAddValidColour() {
        ColorPallet pallet = new ColorPallet(4);
        pallet.addColour(0x123456);
        pallet.addColour(0xFFFFFF);
        assertEquals(2, pallet.getColors().length);

        int[] colours = pallet.getColors();
        assertEquals(0x123456, colours[0]);
        assertEquals(0xFFFFFF, colours[1]);
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
    void testAddInvalidColour() {
        ColorPallet pallet = new ColorPallet(4);
        assertThrows(IllegalArgumentException.class, () -> pallet.addColour(0x1000000));
        assertThrows(IllegalArgumentException.class, () -> pallet.addColour(-1));
    }
}
