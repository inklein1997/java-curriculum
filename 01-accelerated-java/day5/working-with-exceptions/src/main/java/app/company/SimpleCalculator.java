package app.company;

public class SimpleCalculator {
    public int divide(int numerator,  int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cant be 0");
        }
        return numerator/denominator;
    }
}
