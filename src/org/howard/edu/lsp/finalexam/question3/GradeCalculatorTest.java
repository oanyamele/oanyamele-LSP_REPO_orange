package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    GradeCalculator gc = new GradeCalculator();

    // ===== average() tests =====

    @Test
    void testAverageNormalValues() {
        assertEquals(80.0, gc.average(70, 80, 90));
    }

    @Test
    void testAverageAllSame() {
        assertEquals(85.0, gc.average(85, 85, 85));
    }

    @Test
    void testAverageBoundaryValues() {
        assertEquals(0.0, gc.average(0, 0, 0));       // lower bound
        assertEquals(100.0, gc.average(100, 100, 100)); // upper bound
    }

    @Test
    void testAverageInvalidLowScore() {
        assertThrows(IllegalArgumentException.class, () -> {
            gc.average(-1, 80, 90);
        });
    }

    @Test
    void testAverageInvalidHighScore() {
        assertThrows(IllegalArgumentException.class, () -> {
            gc.average(101, 80, 90);
        });
    }

    // ===== letterGrade() tests =====

    @Test
    void testLetterGradeA() {
        assertEquals("A", gc.letterGrade(95));
    }

    @Test
    void testLetterGradeB() {
        assertEquals("B", gc.letterGrade(85));
    }

    @Test
    void testLetterGradeC() {
        assertEquals("C", gc.letterGrade(75));
    }

    @Test
    void testLetterGradeD() {
        assertEquals("D", gc.letterGrade(65));
    }

    @Test
    void testLetterGradeF() {
        assertEquals("F", gc.letterGrade(50));
    }

    @Test
    void testLetterGradeBoundaryEdges() {
        assertEquals("A", gc.letterGrade(90));
        assertEquals("B", gc.letterGrade(80));
        assertEquals("C", gc.letterGrade(70));
        assertEquals("D", gc.letterGrade(60));
        assertEquals("F", gc.letterGrade(59.9));
    }

    // ===== isPassing() tests =====

    @Test
    void testIsPassingTrue() {
        assertTrue(gc.isPassing(75));
    }

    @Test
    void testIsPassingFalse() {
        assertFalse(gc.isPassing(50));
    }

    @Test
    void testIsPassingBoundary() {
        assertTrue(gc.isPassing(60));   // exact passing
        assertFalse(gc.isPassing(59.9)); // just below
    }
}