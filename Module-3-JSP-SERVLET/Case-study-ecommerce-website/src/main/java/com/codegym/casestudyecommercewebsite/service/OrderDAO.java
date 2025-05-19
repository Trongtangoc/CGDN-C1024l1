package com.codegym.casestudyecommercewebsite.service;

import com.codegym.casestudyecommercewebsite.model.Item;
import com.codegym.casestudyecommercewebsite.model.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderDAO {
    public void checkOut(List<Item> cart)
            throws SQLException {
        String queryOrder = "{CALL sp_insert_orders(?,?,?)}";
        String queryOderDetail = "{CALL sp_insert_order_detail(?,?)}";
        int orderId = -1;
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
//Add new Order
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String orderDate = format.format(new Date());

            double totalPrice = 0;
            for (Item item : cart) {
                Product product = item.getProduct();
                totalPrice += product.getPrice() * item.getQuantity();
            }
            Date _orderDate = format.parse(orderDate);
            CallableStatement callableStatementOrder = connection.prepareCall(queryOrder);
            callableStatementOrder.setDate(1, new java.sql.Date(_orderDate.getTime()));
            callableStatementOrder.setDouble(2, totalPrice);
            callableStatementOrder.registerOutParameter(3, Types.INTEGER);
            callableStatementOrder.executeUpdate();
            orderId = callableStatementOrder.getInt(3);

//Add new OrderDetail
            for (Item item : cart) {
                Product product = item.getProduct();
                CallableStatement callableStatementOrderDetail = connection.prepareCall(queryOderDetail);
                callableStatementOrderDetail.setInt(1, orderId);
                callableStatementOrderDetail.setInt(2, product.getId());
                callableStatementOrderDetail.setInt(3, item.getQuantity());

            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
    }
}
