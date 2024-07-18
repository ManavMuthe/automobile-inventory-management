package com.inventory.service;

import com.inventory.dao.VehicleDAO;
import com.inventory.model.Vehicle;

import java.util.List;
import java.util.Scanner;

public class VehicleService {
    private VehicleDAO vehicleDAO = new VehicleDAO();

    public void manageVehicles(Scanner scanner) {
        while (true) {
            System.out.println("Vehicle Management");
            System.out.println("1. Add New Vehicle");
            System.out.println("2. View Vehicle Details");
            System.out.println("3. Update Vehicle Information");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. View All Vehicles");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewVehicle(scanner);
                    break;
                case 2:
                    viewVehicleDetails(scanner);
                    break;
                case 3:
                    updateVehicleInformation(scanner);
                    break;
                case 4:
                    deleteVehicle(scanner);
                    break;
                case 5:
                    viewAllVehicles();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addNewVehicle(Scanner scanner) {
        System.out.print("Enter make: ");
        String make = scanner.next();
        System.out.print("Enter model: ");
        String model = scanner.next();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter available quantity: ");
        int availableQuantity = scanner.nextInt();

        Vehicle vehicle = new Vehicle(0, make, model, year, price, availableQuantity);
        vehicleDAO.addVehicle(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    private void viewVehicleDetails(Scanner scanner) {
        System.out.print("Enter vehicle ID: ");
        int vehicleId = scanner.nextInt();
        Vehicle vehicle = vehicleDAO.getVehicle(vehicleId);
        if (vehicle != null) {
            System.out.println(vehicle);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private void updateVehicleInformation(Scanner scanner) {
        System.out.print("Enter vehicle ID: ");
        int vehicleId = scanner.nextInt();
        Vehicle vehicle = vehicleDAO.getVehicle(vehicleId);
        if (vehicle != null) {
            System.out.print("Enter new make: ");
            vehicle.setMake(scanner.next());
            System.out.print("Enter new model: ");
            vehicle.setModel(scanner.next());
            System.out.print("Enter new year: ");
            vehicle.setYear(scanner.nextInt());
            System.out.print("Enter new price: ");
            vehicle.setPrice(scanner.nextDouble());
            System.out.print("Enter new available quantity: ");
            vehicle.setAvailableQuantity(scanner.nextInt());
            vehicleDAO.updateVehicle(vehicle);
            System.out.println("Vehicle updated successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private void deleteVehicle(Scanner scanner) {
        System.out.print("Enter vehicle ID: ");
        int vehicleId = scanner.nextInt();
        vehicleDAO.deleteVehicle(vehicleId);
        System.out.println("Vehicle deleted successfully.");
    }

    private void viewAllVehicles() {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
