package com.rajendra.utils;

/**
 * Created by Rajendra Verma on 02/10/22.
 */
public class Beautify {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    String fontColor =ANSI_BLACK;
    public  void setFrontColor(String str){
        fontColor  =str;
    }



    public void print(Object obj){
        System.out.print(fontColor+obj+fontColor);
    }

    public void println(Object obj){
        System.out.println(fontColor+obj+fontColor);
    }
}
