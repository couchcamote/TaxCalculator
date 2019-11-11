package com.alexiesracca.sandbox;

import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

import main.java.com.alexiesracca.sandbox.taxcalculator.TaxCalculator;

/**
 * @author Alexies
 */
public final class App {
    private App() {
    }

    final static double minusSSS = 581.30;
    final static double minusPhilHealth = 550.00;
    final static double minusPagIbig = 100.00;

    static double deduction = minusSSS + minusPhilHealth + minusPagIbig;

    public static void main(String[] args) {

    //monthly range
    long start = 50_000;
    long end = 500_000;
    //iterate
    long every = 2500;

    long count = ((end - start) / every)+1;

    LongStream lStream = LongStream.iterate(start, (n) -> n+every);
    System.out.printf("\nMonthly\tMonTax\tMonNet\tN/G");
    lStream.limit(count).mapToDouble( n -> Double.valueOf(n)).forEach(App::calculateMonthly);

    }

    private static void calculateMonthly(double monthlyGross){
        double taxable = monthlyGross - deduction;
        double tax = TaxCalculator.calculateMonthlyTax(taxable);
        double monthNet = taxable - tax;
        double netPercent = monthNet/monthlyGross;

        System.out.printf("\n%.2f\t%6.2f\t%6.2f\t%2.2f", monthlyGross,tax,monthNet,netPercent);
    }
}
