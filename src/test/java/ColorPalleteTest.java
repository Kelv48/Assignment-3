import assign3.java.ColorPallete;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColorPalleteTest {
    @Test
    void createColorPaletteWithValidSize() {
        assertAll("Invalid size", () -> assertThrows(IllegalArgumentException.class, () -> new ColorPallete(1)));
    }
}
