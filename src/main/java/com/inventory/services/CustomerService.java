package com.inventory.service;

import com.inventory.dao.CustomerDAO;
import com.inventory.model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();

    public void manageCustomers(Scanner scanner) {
        while (true) {
            System.out.println("Customer Management");
            System.out.println("1. Register New Customer");
            System.out.println("2. View Customer Details");
            System.out.println("3. Update Customer Information");
            System.out.println("4. Delete Customer Account");
            System.out.println("5. View All Customers");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    registerNewCustomer(scanner);
                    break;
                case 2:
                    viewCustomerDetails(scanner);
                    break;
                case 3:
                    updateCustomerInformation(scanner);
                    break;
                case 4:
                    deleteCustomerAccount(scanner);
                    break;
                case 5:
                    viewAllCustomers();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void registerNewCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.next();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();

        Customer customer = new Customer(0, customerName, email, phoneNumber);
        customerDAO.addCustomer(customer);
        System.out.println("Customer registered successfully.");
    }

    private void viewCustomerDetails(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerDAO.getCustomer(customerId);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void updateCustomerInformation(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerDAO.getCustomer(customerId);
        if (customer != null) {
            System.out.print("Enter new customer name: ");
            customer.setCustomerName(scanner.next());
            System.out.print("Enter new email: ");
            customer.setEmail(scanner.next());
            System.out.print("Enter new phone number: ");
            customer.setPhoneNumber(scanner.next());
            customerDAO.updateCustomer(customer);
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void deleteCustomerAccount(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        customerDAO.deleteCustomer(customerId);
        System.out.println("Customer deleted successfully.");
    }

    private void viewAllCustomers() {
        List<Customer> customers = customerDAO.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
