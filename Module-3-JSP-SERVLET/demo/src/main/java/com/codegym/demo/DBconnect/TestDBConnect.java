package com.codegym.demo.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestDBConnect {
    public static void main(String[] args) {
        String sql = "SELECT * FROM rent_room";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("ID | Tenant Name | Phone Number | Start Date | Payment Type ID | Note");
            while (rs.next()) {
                int id = rs.getInt("id");
                String tenantName = rs.getString("tenntt_name");
                String phone = rs.getString("phone_number");
                String startDate = rs.getString("start_date");
                int paymentTypeId = rs.getInt("payment_type_id");
                String note = rs.getString("note");

                System.out.printf("%d | %s | %s | %s | %d | %s%n", id, tenantName, phone, startDate, paymentTypeId, note);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy dữ liệu:");
            e.printStackTrace();
        }
    }
}
