package com.inventory.dao;

import com.inventory.model.SalesTransaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesTransactionDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/automobile_inventory";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "Manav@05";

    public void recordTransaction(SalesTransaction transaction) {
        String sql = "INSERT INTO SalesTransaction (vehicle_id, customer_id, transaction_date, amount) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getVehicleId());
            stmt.setInt(2, transaction.getCustomerId());
            stmt.setDate(3, new java.sql.Date(transaction.getTransactionDate().getTime()));
            stmt.setDouble(4, transaction.getAmount());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SalesTransaction getTransaction(int transactionId) {
        String sql = "SELECT * FROM SalesTransaction WHERE transaction_id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transactionId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new SalesTransaction(
                        rs.getInt("transaction_id"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("transaction_date"),
                        rs.getDouble("amount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SalesTransaction> getAllTransactions() {
        List<SalesTransaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM SalesTransaction";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                transactions.add(new SalesTransaction(
                        rs.getInt("transaction_id"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("transaction_date"),
                        rs.getDouble("amount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public double calculateTotalSalesRevenue() {
        String sql = "SELECT SUM(amount) AS total_revenue FROM SalesTransaction";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("total_revenue");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
