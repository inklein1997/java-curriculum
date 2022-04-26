package com.company;

public class App {

    public static void main(String[] args) {

        int int1 = 1;
        int int2 = 3;

        long long1 = 4;
        long long2 = -3;

        float float1 = 1.5f;
        float float2 = 2.1f;

        double double1 = 0.7d;
        double double2 = 4.4d;

        System.out.println( SimpleAdder.add(int1, int2) );
        System.out.println( SimpleAdder.add(long1, long2) );
        System.out.println( SimpleAdder.add(float1, float2) );
        System.out.println( SimpleAdder.add(double1, double2) );

        System.out.println( UnsimpleAdder.addInts(int1, int2) );
        System.out.println( UnsimpleAdder.addLongs(long1, long2) );
        System.out.println( UnsimpleAdder.addFloats(float1, float2) );
        System.out.println( UnsimpleAdder.addDoubles(double1, double2) );

    }
    
}
