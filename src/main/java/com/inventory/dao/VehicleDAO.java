package com.inventory.dao;

import com.inventory.model.Vehicle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/automobile_inventory";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "Manav@05";

    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO Vehicle (make, model, year, price, available_quantity) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getMake());
            stmt.setString(2, vehicle.getModel());
            stmt.setInt(3, vehicle.getYear());
            stmt.setDouble(4, vehicle.getPrice());
            stmt.setInt(5, vehicle.getAvailableQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vehicle getVehicle(int vehicleId) {
        String sql = "SELECT * FROM Vehicle WHERE vehicle_id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vehicleId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Vehicle(
                        rs.getInt("vehicle_id"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getDouble("price"),
                        rs.getInt("available_quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE Vehicle SET make = ?, model = ?, year = ?, price = ?, available_quantity = ? WHERE vehicle_id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getMake());
            stmt.setString(2, vehicle.getModel());
            stmt.setInt(3, vehicle.getYear());
            stmt.setDouble(4, vehicle.getPrice());
            stmt.setInt(5, vehicle.getAvailableQuantity());
            stmt.setInt(6, vehicle.getVehicleId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVehicle(int vehicleId) {
        String sql = "DELETE FROM Vehicle WHERE vehicle_id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vehicleId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                vehicles.add(new Vehicle(
                        rs.getInt("vehicle_id"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getDouble("price"),
                        rs.getInt("available_quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
