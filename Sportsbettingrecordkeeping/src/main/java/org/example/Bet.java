package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bet {
    private String sport;
    private double wagerAmount;
    private double profit;
    private double loss;

    public Bet(String sport, double wagerAmount, double profit, double loss) {
        this.sport = sport;
        this.wagerAmount = wagerAmount;
        this.profit = profit;
        this.loss = loss;
    }

    // Getters and setters

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public double getWagerAmount() {
        return wagerAmount;
    }

    public void setWagerAmount(double wagerAmount) {
        this.wagerAmount = wagerAmount;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getLoss() {
        return loss;
    }

    public void setLoss(double loss) {
        this.loss = loss;
    }
}
