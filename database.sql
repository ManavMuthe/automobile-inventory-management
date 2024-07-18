
### Database Setup

Create the MySQL database and tables using the following SQL script:

```sql
CREATE DATABASE automobile_inventory;

USE automobile_inventory;

CREATE TABLE Vehicle (
    vehicle_id INT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(50),
    model VARCHAR(50),
    year INT,
    price DOUBLE,
    available_quantity INT
);

CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    email VARCHAR(100),
    phone_number VARCHAR(15)
);

CREATE TABLE SalesTransaction (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT,
    customer_id INT,
    transaction_date DATE,
    amount DOUBLE,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);
