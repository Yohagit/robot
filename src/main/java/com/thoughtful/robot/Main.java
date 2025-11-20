package com.thoughtful.robot;

public class Main {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java -jar robot-1.0.0.jar <width> <height> <length> <mass>");
            System.exit(1);
        }
        try {
            int width = Integer.parseInt(args[0]);
            int height = Integer.parseInt(args[1]);
            int length = Integer.parseInt(args[2]);
            double mass = Double.parseDouble(args[3]);

            String result = PackageSorter.sort(width, height, length, mass);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(2);
        }
    }
}
