package com.inventory.service;

import com.inventory.dao.SalesTransactionDAO;
import com.inventory.model.SalesTransaction;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SalesTransactionService {
    private SalesTransactionDAO salesTransactionDAO = new SalesTransactionDAO();

    public void manageSalesTransactions(Scanner scanner) {
        while (true) {
            System.out.println("Sales Transaction Management");
            System.out.println("1. Record Vehicle Sale");
            System.out.println("2. View Sales Transaction Details");
            System.out.println("3. View All Sales Transactions");
            System.out.println("4. Generate Sales Report");
            System.out.println("5. Calculate Total Sales Revenue");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    recordVehicleSale(scanner);
                    break;
                case 2:
                    viewSalesTransactionDetails(scanner);
                    break;
                case 3:
                    viewAllSalesTransactions();
                    break;
                case 4:
                    generateSalesReport();
                    break;
                case 5:
                    calculateTotalSalesRevenue();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void recordVehicleSale(Scanner scanner) {
        System.out.print("Enter vehicle ID: ");
        int vehicleId = scanner.nextInt();
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Enter transaction amount: ");
        double amount = scanner.nextDouble();
        SalesTransaction transaction = new SalesTransaction(0, vehicleId, customerId, new Date(), amount);
        salesTransactionDAO.recordTransaction(transaction);
        System.out.println("Vehicle sale recorded successfully.");
    }

    private void viewSalesTransactionDetails(Scanner scanner) {
        System.out.print("Enter transaction ID: ");
        int transactionId = scanner.nextInt();
        SalesTransaction transaction = salesTransactionDAO.getTransaction(transactionId);
        if (transaction != null) {
            System.out.println(transaction);
        } else {
            System.out.println("Transaction not found.");
        }
    }

    private void viewAllSalesTransactions() {
        List<SalesTransaction> transactions = salesTransactionDAO.getAllTransactions();
        for (SalesTransaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private void generateSalesReport() {
        List<SalesTransaction> transactions = salesTransactionDAO.getAllTransactions();
        for (SalesTransaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private void calculateTotalSalesRevenue() {
        double totalRevenue = salesTransactionDAO.calculateTotalSalesRevenue();
        System.out.println("Total Sales Revenue: " + totalRevenue);
    }
}
