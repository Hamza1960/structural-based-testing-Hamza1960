import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;

class LeftPadUtilsTest {

    @Test
    @Tag("specification")
    void testLeftPad_NullString_ReturnsNull() {
        assertNull(LeftPadUtils.leftPad(null, 5, "-"));
    }

    @Test
    @Tag("specification")
    void testLeftPad_SizeSmallerThanString_ReturnsOriginalString() {
        assertEquals("abc", LeftPadUtils.leftPad("abc", 2, "-"));
    }

    @Test
    @Tag("specification")
    void testLeftPad_NullPadStr_UsesSpace() {
        assertEquals("  abc", LeftPadUtils.leftPad("abc", 5, null));
    }

    @Test
    @Tag("specification")
    void testLeftPad_EmptyPadStr_UsesSpace() {
        assertEquals("  abc", LeftPadUtils.leftPad("abc", 5, ""));
    }

    @Test
    @Tag("specification")
    void testLeftPad_PadsEqualsPadStrLength_Concatenates() {
        assertEquals("-abc", LeftPadUtils.leftPad("abc", 4, "-"));
    }

    @Test
    @Tag("specification")
    void testLeftPad_PadsLessThanPadStrLength_Substrings() {
        assertEquals("xyabc", LeftPadUtils.leftPad("abc", 5, "xyz"));
    }

    @Test
    @Tag("specification")
    void testLeftPad_PadsGreaterThanPadStrLength_RepeatsPadStr() {
        // pads = 7 - 3 = 4. padStr = "xy" (len 2). 4 > 2.
        // padding array size 4. 
        // i=0: padChars[0%2] = 'x'
        // i=1: padChars[1%2] = 'y'
        // i=2: padChars[2%2] = 'x'
        // i=3: padChars[3%2] = 'y'
        // Result: "xyxyabc"
        assertEquals("xyxyabc", LeftPadUtils.leftPad("abc", 7, "xy"));
    }

    @Test
    @Tag("structural")
    void testLeftPad_PadsExactlyEqualToMultiple_Coverage() {
        assertEquals("---abc", LeftPadUtils.leftPad("abc", 6, "-"));
    }
}
