package com.thoughtful.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageSorterTest {

    @Test
    void standard_whenNotBulkyOrHeavy() {
        assertEquals("STANDARD", PackageSorter.sort(10, 10, 10, 1.0));
    }

    @Test
    void special_whenHeavyOnly() {
        assertEquals("SPECIAL", PackageSorter.sort(10, 10, 10, 20.0));
    }

    @Test
    void special_whenBulkyByVolumeOnly() {
        assertEquals("SPECIAL", PackageSorter.sort(100, 100, 100, 10.0)); // 1,000,000 cm^3
    }

    @Test
    void special_whenBulkyByDimensionOnly() {
        assertEquals("SPECIAL", PackageSorter.sort(150, 10, 10, 10.0));
    }

    @Test
    void rejected_whenBulkyAndHeavy() {
        assertEquals("REJECTED", PackageSorter.sort(200, 200, 200, 25.0));
    }

    @Test
    void invalid_whenNonPositive() {
        assertThrows(IllegalArgumentException.class, () -> PackageSorter.sort(0, 10, 10, 1.0));
        assertThrows(IllegalArgumentException.class, () -> PackageSorter.sort(10, -1, 10, 1.0));
        assertThrows(IllegalArgumentException.class, () -> PackageSorter.sort(10, 10, 10, 0.0));
    }
}
