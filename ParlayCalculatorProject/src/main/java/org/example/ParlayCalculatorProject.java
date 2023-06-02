package org.example;

import java.util.Scanner;

public class ParlayCalculatorProject {
    public static double convertToDecimal(double odd) {
        if (odd > 1) {
            return odd;
        } else if (odd >= -100) {
            return 100 / (-odd) + 1;
        } else {
            return -100 / odd + 1;
        }
    }

    public static double calculatePotentialPayout(double[] odds, double betAmount) {
        double totalOdds = 1.0;
        for (double odd : odds) {
            totalOdds *= convertToDecimal(odd);
        }
        double potentialPayout = totalOdds * betAmount;
        return potentialPayout;
    }

    public static double calculatePotentialProfit(double[] odds, double betAmount) {
        double potentialPayout = calculatePotentialPayout(odds, betAmount);
        double potentialProfit = potentialPayout - betAmount;
        return potentialProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Parlay Pal!");
        System.out.println("Your #1 trusted parlay calculator");

        System.out.print("Enter the number of legs in your parlay: ");
        int numItems = scanner.nextInt();
        double[] odds = new double[numItems];

        for (int i = 0; i < numItems; i++) {
            System.out.printf("Enter the odds for leg %d: ", i + 1);
            odds[i] = scanner.nextDouble();
        }

        System.out.print("Enter the amount of money you are betting: $");
        double betAmount = scanner.nextDouble();

        double potentialPayout = calculatePotentialPayout(odds, betAmount);
        double potentialProfit = calculatePotentialProfit(odds, betAmount);

        System.out.printf("Your payout for this parlay is $%.2f%n", potentialPayout);
        System.out.printf("Your profit for this parlay is $%.2f%n", potentialProfit);
    }
}