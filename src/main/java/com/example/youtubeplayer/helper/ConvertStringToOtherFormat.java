package com.example.youtubeplayer.helper;

public class ConvertStringToOtherFormat {

    public static String getPercentFromString(String s) {
        float f = Float.parseFloat(s);
        float f1 = f * 100;
        int x = (int) f1;
        return x + "%";
    }

    public static Integer getIntFromString(String s) {
        return Integer.parseInt(s.replace(".00", ""));
    }

    public static double getDoubleFromString(String s) {
        return Double.parseDouble(s);
    }


}
