package com.inventory.dao;

import com.inventory.model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/automobile_inventory";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "Manav@05";

    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (customer_name, email, phone_number) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhoneNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomer(int customerId) {
        String sql = "SELECT * FROM Customer WHERE customer_id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("email"),
                        rs.getString("phone_number")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCustomer(Customer customer) {
        String sql = "UPDATE Customer SET customer_name = ?, email = ?, phone_number = ? WHERE customer_id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhoneNumber());
            stmt.setInt(4, customer.getCustomerId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId) {
        String sql = "DELETE FROM Customer WHERE customer_id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("email"),
                        rs.getString("phone_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
