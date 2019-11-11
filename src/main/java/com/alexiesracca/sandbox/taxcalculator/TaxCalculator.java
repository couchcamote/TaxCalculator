package main.java.com.alexiesracca.sandbox.taxcalculator;

public class TaxCalculator {

    public static double calculateMonthlyTax(double monthlyTaxable){

        if(monthlyTaxable <= 20_833 ){
            return 0;
        }
        if(monthlyTaxable > 20_833 && monthlyTaxable <= 33_333){
            return (monthlyTaxable - 20_833) * .20;
        }
        if(monthlyTaxable > 33_333 &&  monthlyTaxable <= 66_667){
            return 2_500 + (monthlyTaxable - 33_333 ) * 0.25;
        }
        if(monthlyTaxable > 66_667 &&  monthlyTaxable <= 166_667){
            return 10_833.33+ (monthlyTaxable - 66_667 ) * 0.30;
        }
        if(monthlyTaxable > 166_667 &&  monthlyTaxable <= 666_667.33){
            return 40_833.33+ (monthlyTaxable - 166_667 ) * 0.32;
        }
        return 200_833.33 + (monthlyTaxable - 666_667) * 0.35;
    }


}
