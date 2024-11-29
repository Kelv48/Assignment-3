import assign3.java.ColorPallet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColorPalletTest {

    @Test
    void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new ColorPallet(3));
        assertThrows(IllegalArgumentException.class, () -> new ColorPallet(1));
        assertThrows(IllegalArgumentException.class, () -> new ColorPallet(0));
    }
}
