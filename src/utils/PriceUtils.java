package utils;

import java.math.BigDecimal;

public class PriceUtils {
    // float的加法
    public static float add(float a, float b){
        BigDecimal bigA =new BigDecimal(Float.toString(a));
        BigDecimal bigB =new BigDecimal(Float.toString(b));
        return bigA.add(bigB).floatValue();
    }
    // double的加法
    public static double add(double a, double b){
        BigDecimal bigA =new BigDecimal(Double.toString(a));
        BigDecimal bigB =new BigDecimal(Double.toString(b));
        return bigA.add(bigB).floatValue();

    }
    // float的减法
    public static float subtract(float a, float b){
        BigDecimal bigA =new BigDecimal(Float.toString(a));
        BigDecimal bigB =new BigDecimal(Float.toString(b));
        return bigA.subtract(bigB).floatValue();
    }
    // double的减法
    public static double subtract(double a, double b) {
        BigDecimal bigA = new BigDecimal(Double.toString(a));
        BigDecimal bigB = new BigDecimal(Double.toString(b));
        return bigA.subtract(bigB).floatValue();
    }
}
