package com.codegym.demo.service;

import com.codegym.demo.DBconnect.DBConnection;
import com.codegym.demo.model.PaymentType;
import com.codegym.demo.model.RentRoom;
import com.codegym.demo.service.GeneralDAO;

import java.sql.*;
import java.util.*;

public class PaymentTypeDAO implements GeneralDAO<PaymentType> {

    @Override
    public List<PaymentType> getAll() {
        List<PaymentType> list = new ArrayList<>();
        String sql = "SELECT * FROM payment_type";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PaymentType pt = new PaymentType();
                pt.setId(rs.getInt("id"));
                pt.setTypeName(rs.getString("type_name"));
                list.add(pt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<PaymentType> search(String keyword) {
        return getAll(); // PaymentType không cần tìm kiếm
    }

    @Override
    public void add(PaymentType entity) {

    }

    @Override
    public void insert(RentRoom room) {

    }

    @Override
    public void insert(PaymentType entity) {
        // Không yêu cầu thêm PaymentType mới trong bài này
    }

    @Override
    public void deleteById(int id) {
        // Không yêu cầu xóa PaymentType
    }
}
