package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {
    private Scanner scan = new Scanner(System.in);

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int inputtedInt = Integer.parseInt(scan.nextLine());
        return inputtedInt;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long inputtedLong = Long.parseLong(scan.nextLine());
        return inputtedLong;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double inputtedDouble = Double.parseDouble(scan.nextLine());
        return inputtedDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float inputtedFloat = Float.parseFloat(scan.nextLine());
        return inputtedFloat;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String inputtedString = scan.nextLine();
        return inputtedString;
    }
}
