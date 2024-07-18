package com.inventory.model;

public class Vehicle {
    private int vehicleId;
    private String make;
    private String model;
    private int year;
    private double price;
    private int availableQuantity;

    public Vehicle(int vehicleId, String make, String model, int year, double price, int availableQuantity) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    // Getters and setters

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}
