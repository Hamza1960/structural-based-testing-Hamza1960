import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class NumberUtilsTest {

    // ========== PARTITION 1: NULL INPUTS ==========

    @Test
    void testBothInputsNull_ReturnsNull() {
        // Arrange
        List<Integer> left = null;
        List<Integer> right = null;

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertNull(result);
    }

    @Test
    void testLeftNullRightValid_ReturnsNull() {
        // Arrange
        List<Integer> left = null;
        List<Integer> right = Arrays.asList(5);

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertNull(result);
    }

    @Test
    void testLeftValidRightNull_ReturnsNull() {
        // Arrange
        List<Integer> left = Arrays.asList(5);
        List<Integer> right = null;

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertNull(result);
    }

    // ========== PARTITION 2: EMPTY LISTS ==========

    @Test
    void testBothEmpty_ReturnsZero() {
        // Arrange
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(0), result);
    }

    @Test
    void testLeftEmptyRightSingleDigit_ReturnsSingleDigit() {
        // Arrange
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>(Arrays.asList(5));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(5), result);
    }

    @Test
    void testLeftSingleDigitRightEmpty_ReturnsSingleDigit() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(5));
        List<Integer> right = new LinkedList<>();

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(5), result);
    }

    @Test
    void testLeftEmptyRightMultipleDigits_ReturnsRightNumber() {
        // Arrange
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>(Arrays.asList(1, 2, 3));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    // ========== PARTITION 3: SINGLE DIGITS (NO CARRY) ==========

    @Test
    void testSingleDigitNoCarry_2Plus3_Returns5() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(2));
        List<Integer> right = new LinkedList<>(Arrays.asList(3));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(5), result);
    }

    @Test
    void testSingleDigitZeroPlusZero_ReturnsZero() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(0));
        List<Integer> right = new LinkedList<>(Arrays.asList(0));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(0), result);
    }

    @Test
    void testSingleDigitZeroPlusNine_ReturnsNine() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(0));
        List<Integer> right = new LinkedList<>(Arrays.asList(9));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(9), result);
    }

    @Test
    void testSingleDigitOnePlusNine_Returns10() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(1));
        List<Integer> right = new LinkedList<>(Arrays.asList(9));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(1, 0), result);
    }

    // ========== PARTITION 4: SINGLE DIGITS (WITH CARRY) ==========

    @Test
    void testSingleDigitWithCarry_5Plus5_Returns10() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(5));
        List<Integer> right = new LinkedList<>(Arrays.asList(5));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(1, 0), result);
    }

    @Test
    void testSingleDigitWithCarry_6Plus9_Returns15() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(6));
        List<Integer> right = new LinkedList<>(Arrays.asList(9));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(1, 5), result);
    }

    @Test
    void testSingleDigitWithCarry_9Plus9_Returns18() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(9));
        List<Integer> right = new LinkedList<>(Arrays.asList(9));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(1, 8), result);
    }

    // ========== PARTITION 5: MULTIPLE DIGITS (NO CARRY) ==========

    @Test
    void testMultipleDigitsNoCarry_23Plus42_Returns65() {
        // Arrange: [2,3] = 23, [4,2] = 42
        List<Integer> left = new LinkedList<>(Arrays.asList(2, 3));
        List<Integer> right = new LinkedList<>(Arrays.asList(4, 2));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 23 + 42 = 65 = [6,5]
        assertEquals(Arrays.asList(6, 5), result);
    }

    @Test
    void testMultipleDigitsNoCarry_100Plus23_Returns123() {
        // Arrange: [1,0,0] = 100, [2,3] = 23
        List<Integer> left = new LinkedList<>(Arrays.asList(1, 0, 0));
        List<Integer> right = new LinkedList<>(Arrays.asList(2, 3));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 100 + 23 = 123 = [1,2,3]
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void testMultipleDigitsNoCarry_123Plus234_Returns357() {
        // Arrange: [1,2,3] = 123, [2,3,4] = 234
        List<Integer> left = new LinkedList<>(Arrays.asList(1, 2, 3));
        List<Integer> right = new LinkedList<>(Arrays.asList(2, 3, 4));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 123 + 234 = 357 = [3,5,7]
        assertEquals(Arrays.asList(3, 5, 7), result);
    }

    // ========== PARTITION 6: MULTIPLE DIGITS (WITH CARRY) ==========

    @Test
    void testMultipleDigitsWithCarry_99Plus1_Returns100() {
        // Arrange: [9,9] = 99, [1] = 1
        List<Integer> left = new LinkedList<>(Arrays.asList(9, 9));
        List<Integer> right = new LinkedList<>(Arrays.asList(1));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 99 + 1 = 100 = [1,0,0]
        assertEquals(Arrays.asList(1, 0, 0), result);
    }

    @Test
    void testMultipleDigitsWithCarry_999Plus1_Returns1000() {
        // Arrange: [9,9,9] = 999, [1] = 1
        List<Integer> left = new LinkedList<>(Arrays.asList(9, 9, 9));
        List<Integer> right = new LinkedList<>(Arrays.asList(1));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 999 + 1 = 1000 = [1,0,0,0]
        assertEquals(Arrays.asList(1, 0, 0, 0), result);
    }

    @Test
    void testMultipleDigitsWithCarry_95Plus67_Returns162() {
        // Arrange: [9,5] = 95, [6,7] = 67
        List<Integer> left = new LinkedList<>(Arrays.asList(9, 5));
        List<Integer> right = new LinkedList<>(Arrays.asList(6, 7));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 95 + 67 = 162 = [1,6,2]
        assertEquals(Arrays.asList(1, 6, 2), result);
    }

    @Test
    void testMultipleDigitsWithMultipleCarries_555Plus555_Returns1110() {
        // Arrange: [5,5,5] = 555, [5,5,5] = 555
        List<Integer> left = new LinkedList<>(Arrays.asList(5, 5, 5));
        List<Integer> right = new LinkedList<>(Arrays.asList(5, 5, 5));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 555 + 555 = 1110 = [1,1,1,0]
        assertEquals(Arrays.asList(1, 1, 1, 0), result);
    }

    // ========== PARTITION 7: LEADING ZEROS REMOVAL ==========

    @Test
    void testLeadingZerosRemoved_0Plus0_Returns0() {
        // Arrange: [0] = 0, [0] = 0
        List<Integer> left = new LinkedList<>(Arrays.asList(0));
        List<Integer> right = new LinkedList<>(Arrays.asList(0));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 0 + 0 = 0, not [0,0]
        assertEquals(Arrays.asList(0), result);
    }

    @Test
    void testLeadingZerosRemoved_05Plus5_Returns10() {
        // Arrange: [0,5] = 05, [5] = 5
        List<Integer> left = new LinkedList<>(Arrays.asList(0, 5));
        List<Integer> right = new LinkedList<>(Arrays.asList(5));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 05 + 5 = 10 = [1,0]
        assertEquals(Arrays.asList(1, 0), result);
    }

    @Test
    void testLeadingZerosRemoved_001Plus2_Returns3() {
        // Arrange: [0,0,1] = 001, [2] = 2
        List<Integer> left = new LinkedList<>(Arrays.asList(0, 0, 1));
        List<Integer> right = new LinkedList<>(Arrays.asList(2));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 001 + 2 = 3 = [3], not [0,0,3]
        assertEquals(Arrays.asList(3), result);
    }

    // ========== PARTITION 8: INVALID DIGITS - NEGATIVE NUMBERS ==========

    @Test
    void testInvalidDigit_LeftNegative_ThrowsException() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(-1, 5));
        List<Integer> right = new LinkedList<>(Arrays.asList(1));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right));
    }

    @Test
    void testInvalidDigit_RightNegative_ThrowsException() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(1));
        List<Integer> right = new LinkedList<>(Arrays.asList(-5));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right));
    }

    // ========== PARTITION 9: INVALID DIGITS - GREATER THAN 9 ==========

    @Test
    void testInvalidDigit_LeftGreaterThan9_ThrowsException() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(1, 10));
        List<Integer> right = new LinkedList<>(Arrays.asList(1));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right));
    }

    @Test
    void testInvalidDigit_RightGreaterThan9_ThrowsException() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(1));
        List<Integer> right = new LinkedList<>(Arrays.asList(15));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right));
    }

    @Test
    void testInvalidDigit_BothGreaterThan9_ThrowsException() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(10));
        List<Integer> right = new LinkedList<>(Arrays.asList(20));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.add(left, right));
    }

    // ========== BOUNDARY CASES: DIGIT BOUNDARIES ==========

    @Test
    void testBoundary_MinDigit0Plus0_Returns0() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(0));
        List<Integer> right = new LinkedList<>(Arrays.asList(0));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(0), result);
    }

    @Test
    void testBoundary_MaxDigit9Plus0_Returns9() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(9));
        List<Integer> right = new LinkedList<>(Arrays.asList(0));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(9), result);
    }

    @Test
    void testBoundary_MaxDigit9Plus9_Returns18() {
        // Arrange
        List<Integer> left = new LinkedList<>(Arrays.asList(9));
        List<Integer> right = new LinkedList<>(Arrays.asList(9));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert
        assertEquals(Arrays.asList(1, 8), result);
    }

    // ========== EDGE CASE: VERY LARGE NUMBERS ==========

    @Test
    void testLargeNumbers_123456Plus654321_Returns777777() {
        // Arrange: [1,2,3,4,5,6] = 123456, [6,5,4,3,2,1] = 654321
        List<Integer> left = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> right = new LinkedList<>(Arrays.asList(6, 5, 4, 3, 2, 1));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 123456 + 654321 = 777777 = [7,7,7,7,7,7]
        assertEquals(Arrays.asList(7, 7, 7, 7, 7, 7), result);
    }

    @Test
    void testDifferentLengths_1Plus9999_Returns10000() {
        // Arrange: [1] = 1, [9,9,9,9] = 9999
        List<Integer> left = new LinkedList<>(Arrays.asList(1));
        List<Integer> right = new LinkedList<>(Arrays.asList(9, 9, 9, 9));

        // Act
        List<Integer> result = NumberUtils.add(left, right);

        // Assert: 1 + 9999 = 10000 = [1,0,0,0,0]
        assertEquals(Arrays.asList(1, 0, 0, 0, 0), result);
    }
}
