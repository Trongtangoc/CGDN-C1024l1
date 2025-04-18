CREATE DATABASE demo_db_ss5;
USE demo_db_ss5;
CREATE TABLE Products (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    productCode VARCHAR(50) NOT NULL,
    productName VARCHAR(255) NOT NULL,
    productPrice DECIMAL(10,2) NOT NULL,
    productAmount INT NOT NULL,
    productDescription TEXT,
    productStatus ENUM('active', 'inactive') NOT NULL
);

INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus) VALUES
('P001', 'Laptop Dell', 1500.00, 10, 'Laptop Dell chính hãng', 'active'),
('P002', 'MacBook Pro', 2000.00, 5, 'MacBook Pro 2023', 'active'),
('P003', 'iPhone 14', 999.99, 20, 'iPhone 14 chính hãng', 'inactive');

CREATE UNIQUE INDEX idx_productCode ON Products(productCode);
CREATE INDEX idx_productName_price ON Products(productName, productPrice);

EXPLAIN SELECT * FROM Products WHERE productCode = 'P001';
CREATE VIEW ProductView AS
SELECT productCode, productName, productPrice, productStatus FROM Products;

CREATE OR REPLACE VIEW ProductView AS
SELECT productCode, productName, productPrice, productStatus, productAmount FROM Products;

DROP VIEW ProductView;

DELIMITER //
CREATE PROCEDURE GetAllProducts()
BEGIN
    SELECT * FROM Products;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE AddProduct(
    IN p_code VARCHAR(50), 
    IN p_name VARCHAR(255), 
    IN p_price DECIMAL(10,2), 
    IN p_amount INT, 
    IN p_desc TEXT, 
    IN p_status ENUM('active', 'inactive')
)
BEGIN
    INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
    VALUES (p_code, p_name, p_price, p_amount, p_desc, p_status);
END //
DELIMITER ;
CALL AddProduct(
    'P005',                   
    'Sony Xperia 1 V',        
    1300.00,                  
    10,                       
    'Sony flagship 2024',     
    'active'                  
);
select * from products;

DELIMITER //
CREATE PROCEDURE UpdateProduct(
    IN p_id INT, 
    IN p_name VARCHAR(255), 
    IN p_price DECIMAL(10,2), 
    IN p_amount INT, 
    IN p_desc TEXT, 
    IN p_status ENUM('active', 'inactive')
)
BEGIN
    UPDATE Products 
    SET productName = p_name, 
        productPrice = p_price, 
        productAmount = p_amount, 
        productDescription = p_desc, 
        productStatus = p_status
    WHERE Id = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE DeleteProduct(IN p_id INT)
BEGIN
    DELETE FROM Products WHERE Id = p_id;
END //
DELIMITER ;




