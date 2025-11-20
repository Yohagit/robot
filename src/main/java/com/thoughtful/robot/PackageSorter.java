package com.thoughtful.robot;

public final class PackageSorter {

    private static final long BULKY_VOLUME_THRESHOLD = 1_000_000L; // cm^3
    private static final int BULKY_DIMENSION_THRESHOLD = 150;      // cm
    private static final double HEAVY_MASS_THRESHOLD = 20.0;       // kg

    private PackageSorter() {}

    /**
     * Sort a package into STANDARD, SPECIAL, or REJECTED.
     *
     * @param width  cm, must be > 0
     * @param height cm, must be > 0
     * @param length cm, must be > 0
     * @param mass   kg, must be > 0
     * @return stack name
     */
    public static String sort(int width, int height, int length, double mass) {
        validateInputs(width, height, length, mass);

        long volume = 1L * width * height * length; // avoid int overflow
        boolean bulky = volume >= BULKY_VOLUME_THRESHOLD
                || width  >= BULKY_DIMENSION_THRESHOLD
                || height >= BULKY_DIMENSION_THRESHOLD
                || length >= BULKY_DIMENSION_THRESHOLD;

        boolean heavy = mass >= HEAVY_MASS_THRESHOLD;

        if (bulky && heavy) return "REJECTED";
        if (bulky || heavy) return "SPECIAL";
        return "STANDARD";
    }

    private static void validateInputs(int width, int height, int length, double mass) {
        if (width <= 0 || height <= 0 || length <= 0 || mass <= 0) {
            throw new IllegalArgumentException("All dimensions and mass must be positive.");
        }
    }
}
