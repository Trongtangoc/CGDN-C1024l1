package com.codegym.casestudyecommercewebsite.service;

import com.codegym.casestudyecommercewebsite.model.Product;

import java.util.Collections;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


public class ProductDAO implements GeneralDAO<Product> {
    private static final String SELECT_ALL_PRODUCTS = "select * from product";
    private static final String SELECT_PRODUCT_BY_ID = "select * from product where id = ?";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product (Name, Price) VALUES (?,?)";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE product SET Name = ?, Price = ? WHERE id = ?";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                products.add(new Product(id, name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;

    }

    @Override
    public List<Product> findAllWithStoreProcedure() {
        List<Product> products = new ArrayList<>();
        String query = "{CALL sp_get_products()}";
        try (Connection connection = DBConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                products.add(new Product(id, name, price));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void save(Product entity) throws SQLException {

    }

    @Override
    public void saveWithStoreProcedure(Product entity) throws SQLException {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean update(Product entity) throws SQLException {
        return false;
    }

    @Override
    public Product findByIdWithStoreProcedure(int id) {
        return null;
    }

    @Override
    public boolean updateWithStoreProcedure(Product entity) throws SQLException {
        return false;
    }
}
