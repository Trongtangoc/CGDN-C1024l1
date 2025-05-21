package com.codegym.demo.controller;


import com.codegym.demo.service.RoomDAO;
import com.codegym.demo.model.RentRoom;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class CreateRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenantName = req.getParameter("tenantName");
        String phone = req.getParameter("phoneNumber");
        String startDate = req.getParameter("startDate");
        String note = req.getParameter("note");
        int paymentTypeId = Integer.parseInt(req.getParameter("paymentTypeId"));

        // Validate các dữ liệu
        String error = null;
        if (!tenantName.matches("^[A-Za-z\\s]{5,50}$")) {
            error = "Tên không hợp lệ";
        } else if (!phone.matches("\\d{10}")) {
            error = "SĐT phải 10 số";
        } else if (LocalDate.parse(startDate).isBefore(LocalDate.now())) {
            error = "Ngày không được trong quá khứ";
        } else if (note != null && note.length() > 200) {
            error = "Ghi chú quá 200 ký tự";
        }

        if (error != null) {
            req.setAttribute("error", error);
            req.getRequestDispatcher("RoomListServlet").forward(req, resp);
            return;
        }

//        RentRoom room = new RentRoom();
//        room.setTenntt_name(tenantName);
//        room.setPhoneNumber(phone);
//        room.setStartDate(startDate);
//        room.setPaymentTypeId(paymentTypeId);
//        room.setNote(note);
//
//        RoomDAO dao = new RoomDAO();
//        dao.insert(room);
//
//        resp.sendRedirect("RoomListServlet");
    }
}
