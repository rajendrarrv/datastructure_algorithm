package utils;

public class MathUtils {
    public static double roundOff(double v, int i) {
        double base  = Math.pow(10,2);
        return Math.round(v*base)/base;
    }

    public static double percentage(int input, int percentage) {
        double dd  = (double)percentage/100;
        return input * dd;
    }
}
