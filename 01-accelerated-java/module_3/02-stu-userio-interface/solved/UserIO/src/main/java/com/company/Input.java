package com.company;

import com.company.interfaces.UserIO;
import java.util.Scanner;

public class Input implements UserIO {

    private Scanner scan;

    public Input () {
        this.scan = new Scanner(System.in);
    }

    public int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(scan.nextLine());
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        return Long.parseLong(scan.nextLine());
    }

    public double readDouble(String prompt) {
        System.out.println(prompt);
        return Double.parseDouble(scan.nextLine());
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        return Float.parseFloat(scan.nextLine());
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        return scan.nextLine();
    }

}
