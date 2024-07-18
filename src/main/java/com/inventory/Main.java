package com.inventory;

import java.util.Scanner;
import com.inventory.service.VehicleService;
import com.inventory.service.CustomerService;
import com.inventory.service.SalesTransactionService;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleService vehicleService = new VehicleService();
        CustomerService customerService = new CustomerService();
        SalesTransactionService salesTransactionService = new SalesTransactionService();

        while (true) {
            System.out.println("Automobile Inventory Management System");
            System.out.println("1. Manage Vehicles");
            System.out.println("2. Manage Customers");
            System.out.println("3. Manage Sales Transactions");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    vehicleService.manageVehicles(scanner);
                    break;
                case 2:
                    customerService.manageCustomers(scanner);
                    break;
                case 3:
                    salesTransactionService.manageSalesTransactions(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
