package org.example;

public class SportsBet {
    private String sport;
    private double amountWagered;
    private double profitLoss;

    public SportsBet(String sport, double amountWagered) {
        this.sport = sport;
        this.amountWagered = amountWagered;
        this.profitLoss = 0.0; // Initialize profit/loss as 0
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public double getAmountWagered() {
        return amountWagered;
    }

    public void setAmountWagered(double amountWagered) {
        this.amountWagered = amountWagered;
    }

    public double getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(double profitLoss) {
        this.profitLoss = profitLoss;
    }
}