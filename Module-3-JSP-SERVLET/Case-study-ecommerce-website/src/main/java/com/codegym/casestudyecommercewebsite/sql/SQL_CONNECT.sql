CREATE DATABASE db_mvc;
USE db_mvc;

CREATE TABLE Product(
id int primary key auto_increment,
name varchar(250),
price decimal(10,2)
);
INSERT INTO Product(id ,name, price) values(1,'Iphone X', 10000000);
INSERT INTO Product(id ,name, price) values(2,'SS', 15000000);
INSERT INTO Product(id ,name, price) values(3,'Xiaomi', 19000000);
INSERT INTO Product(id ,name, price) values(4,'Honor', 20000000);
INSERT INTO Product(name, price) values('Nokia', 25000000);
INSERT INTO Product(name, price) values('Lumia', 24000000);
INSERT INTO Product(name, price) values('Oppo', 22000000);
INSERT INTO Product(name, price) values('Iphone 16', 21000000);
INSERT INTO Product(name, price) values('Iphone 18', 9000000);
INSERT INTO Product(name, price) values('Vertu', 12000000);

SELECT * FROM Product;


CREATE TABLE `db_mvc`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Order_date` DATETIME NULL,
  `total_price` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `db_mvc`.`order_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NULL,
  `order_id` INT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_orders_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `db_mvc`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders`
    FOREIGN KEY (`order_id`)
    REFERENCES `db_mvc`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- findAll products
delimiter //
create procedure sp_get_products()
begin
select * from product;
end //
delimiter ;

call sp_get_products();

-- add product
delimiter $$
create procedure sp_insert_product(
in _name varchar(250),
in _price decimal(10,2)
)
begin
insert into product(name, price) values(_name, _price);
end $$
delimiter ;

-- find by id
delimiter //
create procedure sp_find_product_by_id(
in _id int
)
begin
select * from product where id = _id;
end //
delimiter ;

-- update product
delimiter //
create procedure sp_update_product(
in _id int,
in _name varchar(250),
in _price decimal(10,2)
)
begin
update product
set name = _name, price = _price 
where id = _id;
end //
delimiter ;

-- insert order
delimiter //
CREATE PROCEDURE sp_insert_orders (
IN _order_date DATETIME,
IN _total_price DECIMAL(10,2),
OUT _order_id INT
)
BEGIN
INSERT INTO orders(order_date, total_price) VALUES (_order_date, _total_price);
SET _order_id = (SELECT id FROM orders order by id DESC LIMIT 1);
END//
delimiter ;
-- INSERT ORDER_DETAIL
delimiter //
CREATE PROCEDURE sp_insert_order_detail(
IN _order_id INT,
IN _product_id INT,
IN _quantity INT
)
BEGIN
INSERT INTO order_detail(order_id, product_id, quantity) VALUES (_order_id, _product_id, _quantity);
END //
delimiter ;

