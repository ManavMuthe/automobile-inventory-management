package com.inventory.model;

import java.util.Date;

public class SalesTransaction {
    private int transactionId;
    private int vehicleId;
    private int customerId;
    private Date transactionDate;
    private double amount;

    public SalesTransaction(int transactionId, int vehicleId, int customerId, Date transactionDate, double amount) {
        this.transactionId = transactionId;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    // Getters and setters

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SalesTransaction{" +
                "transactionId=" + transactionId +
                ", vehicleId=" + vehicleId +
                ", customerId=" + customerId +
                ", transactionDate=" + transactionDate +
                ", amount=" + amount +
                '}';
    }
}
