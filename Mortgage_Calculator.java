/* Hello in this Program 
I made a Mortgage Calcualtor with the use of 
Conditional statements in Java*/

//Importing the required packages
import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage_Calculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal=0,numberOfPayments;
        float annualInterest,monthlyInterest=0;
        Scanner sc = new Scanner(System.in);

        //Block of code to ask user to enter Principal
        // Using a Infinite Loop to validate if the data entered by user is correct
        while (true) {
                System.out.print("Principal: ");
                principal = sc.nextInt();
                if(principal >=1000 && principal <= 1000000)
                    break; //If conditiion is satisfied it breaks out of loop
                System.out.println("Enter a value between 1000 and 1000000");
        }
        
        //Block of code to ask user to enter Annual Interest
        // Using a Infinite Loop to validate if the data entered by user is correct
        while (true) {
                System.out.print("Annual Interest Rate: ");
                annualInterest = sc.nextFloat();
                if(annualInterest >=1 && annualInterest <= 30){
                    monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                    break; //If conditiion is satisfied it breaks out of loop
                }
                System.out.println("Enter a value between 1 and 30");
        }
        
        //Block of code to ask user to enter Period in Years
        // Using a Infinite Loop to validate if the data entered by user is correct
        while (true){
                System.out.print("Period (Years): ");
                byte years = sc.nextByte();
                if(years >=1 && years<=30){
                     numberOfPayments = years * MONTHS_IN_YEAR;
                     break; //If conditiion is satisfied it breaks out of loop
                }
                System.out.println("Enter a value between 1 and 30");
        }
        
        //Calculation of Mortgage
        double mortgage = principal *
                (monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))
                /(Math.pow(1+monthlyInterest,numberOfPayments)-1);

        //Using Formatted String to print currency symbol along with the calculated value
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: "+mortgageFormatted);
    }
}
