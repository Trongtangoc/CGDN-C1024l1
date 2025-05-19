package com.codegym.casestudyecommercewebsite.service;

import com.codegym.casestudyecommercewebsite.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO implements GeneralDAO<Product> {
    //    Lay cac san pham trong DB
    private static final String SELECT_ALL_PRODUCTS = "select * from product";

    private static final String SELECT_PRODUCT_BY_ID = "select * from product where id = ?";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product (Name, Price) VALUES (?,?)";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE product SET Name = ?, Price = ? WHERE id = ?";

//    Override lai interface GeneralDAO voi method findAll()
//    method findAll. tao ArrayList<> se luu cac sp sau khi ket noi DB va lay duoc list sp trong DB.
//    sau do su dung Class DBConnection goi den ham getConnection() tra ve 1 doi tuong connection
//    sau do su dung ham PreparedStatement sau do truyen vao cau lenh SELECT_ALL_PRODUCTS tra ve 1 doi tuong preparedStatement
//    tiep tuc su dung ham executeQuery() de thuc hien chay cau lenh SELECT_ALL_PRODUCTS (nhu trong SQL)
//    chay xong tra ve doi tuong resultSet co cac danh sach san pham trong DB
//    xong dung while de doc va hien thi ra cac sp. sau khi lay ve roi thi add vao ArrayList<> products.add(new Product(id, name, price));

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
        }
//        neu gap loi thi gui ve Exception
        catch (SQLException e) {
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
    public void save(Product product)
            throws SQLException {
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)){
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            DBConnection.printSQLException(e);
        }

    }

    @Override
    public void saveWithStoreProcedure(Product product)
            throws SQLException {
        String query = "{CALL sp_insert_product(?,?)}";
        try (Connection connection = DBConnection.getConnection();
        CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setString(1,product.getName());
            callableStatement.setDouble(2,product.getPrice());
            callableStatement.executeUpdate();
        }
        catch (SQLException e) {
            DBConnection.printSQLException(e);
        }

    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = Double.parseDouble(resultSet.getString("price"));
                product = new Product(id, name, price);
            }

        } catch (SQLException exception) {
            DBConnection.printSQLException(exception);
        }
        return product;
    }

    @Override
    public boolean update(Product product)
            throws SQLException {
        boolean rowUpdated = false;
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)){
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return rowUpdated;
    }

    @Override
    public Product findByIdWithStoreProcedure(int id) {
        String query = "{CALL sp_find_product_by_id(?)}";
        Product product = null;
        try (Connection connection = DBConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                double price = Double.parseDouble(resultSet.getString("price"));
                product = new Product(id, name, price);
            }
        }catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return product;
    }

    @Override
    public boolean updateWithStoreProcedure(Product entity) throws SQLException {
        return false;
    }
}
