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
}
