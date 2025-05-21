package com.codegym.demo.service;

import com.codegym.demo.DBconnect.DBConnection;
import com.codegym.demo.model.PaymentType;
import com.codegym.demo.model.RentRoom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO implements GeneralDAO<RentRoom> {
    // Dùng procedure đã tạo sẵn trong DB
    private static final String CALL_GET_RENT_ROOMS = "{CALL get_rent_rooms()}";

    @Override
    public List<RentRoom> getAll() {
        List<RentRoom> rentRooms = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(CALL_GET_RENT_ROOMS);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String tennttName = rs.getString("tenntt_name");
                String phone = rs.getString("phone_number");
                String startDate = rs.getString("start_date");
                int paymentTypeId = rs.getInt("payment_type_id");
                String paymentTypeName = rs.getString("type_name");
                String note = rs.getString("note");

                System.out.printf("%d | %s | %s | %s | %d | %s | %s%n",
                        id, tennttName, phone, startDate, paymentTypeId, paymentTypeName, note);

                RentRoom rentRoom = new RentRoom(id, tennttName, phone, startDate, paymentTypeId, paymentTypeName, note);
                rentRooms.add(rentRoom);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy dữ liệu:");
            e.printStackTrace();
        }
        return rentRooms;
    }

    @Override
    public List<RentRoom> search(String keyword) {
        List<RentRoom> list = new ArrayList<>();
        String sql = "SELECT r.*, p.type_name FROM rent_room r JOIN payment_type p ON r.payment_type_id = p.id " +
                "WHERE CAST(r.id AS CHAR) LIKE ? OR r.tenntt_name LIKE ? OR r.phone_number LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String kw = "%" + keyword + "%";
            ps.setString(1, kw);
            ps.setString(2, kw);
            ps.setString(3, kw);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RentRoom room = new RentRoom();
                room.setId(rs.getInt("id"));
                room.setTenntt_name(rs.getString("tenntt_name"));
                room.setPhoneNumber(rs.getString("phone_number"));
                room.setStartDate(rs.getString("start_date"));
                room.setPaymentTypeId(rs.getInt("payment_type_id"));
                room.setPaymentTypeName(rs.getString("type_name"));
                room.setNote(rs.getString("note"));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(RentRoom entity) {
    }

    @Override
    public void insert(RentRoom room) {
        String sql = "INSERT INTO rent_room (tenntt_name, phone_number, start_date, payment_type_id, note) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, room.getTenntt_name());
            ps.setString(2, room.getPhoneNumber());
            ps.setString(3, room.getStartDate());
            ps.setInt(4, room.getPaymentTypeId());
            ps.setString(5, room.getNote());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(PaymentType entity) {
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM rent_room WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RentRoom findById(int id) {
        String sql = "SELECT r.*, p.type_name FROM rent_room r JOIN payment_type p ON r.payment_type_id = p.id WHERE r.id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new RentRoom(
                        rs.getInt("id"),
                        rs.getString("tenntt_name"),
                        rs.getString("phone_number"),
                        rs.getString("start_date"),
                        rs.getInt("payment_type_id"),
                        rs.getString("type_name"),
                        rs.getString("note"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(RentRoom room) {
        String sql = "UPDATE rent_room SET tenntt_name = ?, phone_number = ?, start_date = ?, payment_type_id = ?, note = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, room.getTenntt_name());
            ps.setString(2, room.getPhoneNumber());
            ps.setString(3, room.getStartDate());
            ps.setInt(4, room.getPaymentTypeId());
            ps.setString(5, room.getNote());
            ps.setInt(6, room.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
