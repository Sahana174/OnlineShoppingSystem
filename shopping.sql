-- Simple schema for OnlineShoppingSystem
CREATE DATABASE IF NOT EXISTS online_shopping;
USE online_shopping;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(20) DEFAULT 'user'
);

CREATE TABLE IF NOT EXISTS products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  description TEXT,
  price DECIMAL(10,2),
  qty INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS orders (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  total DECIMAL(10,2),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS order_items (
  id INT AUTO_INCREMENT PRIMARY KEY,
  order_id INT,
  product_id INT,
  qty INT,
  price DECIMAL(10,2),
  FOREIGN KEY (order_id) REFERENCES orders(id),
  FOREIGN KEY (product_id) REFERENCES products(id)
);

-- sample data
INSERT IGNORE INTO users (username, password, role) VALUES
('admin', 'admin123', 'admin'),
('user1', 'password', 'user');

INSERT IGNORE INTO products (name, description, price, qty) VALUES
('Red T-Shirt', 'Comfortable cotton t-shirt', 199.00, 10),
('Blue Jeans', 'Stylish denim jeans', 999.00, 5),
('Sneakers', 'Running sneakers', 1499.00, 8);
