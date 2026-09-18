package com.foodmanagementsys.foodorder.util;


import java.util.Scanner;


public class InputUtil {


    private static final Scanner scanner =
            new Scanner(System.in);


    public static String getString(String message) {


        System.out.print(message);


        return scanner.nextLine();
    }


    public static int getInt(String message) {


        System.out.print(message);


        return Integer.parseInt(scanner.nextLine());
    }


    public static double getDouble(String message) {


        System.out.print(message);


        return Double.parseDouble(scanner.nextLine());
    }
}