package com.codegym.demo.controller;

import com.codegym.demo.model.RentRoom;
import com.codegym.demo.model.PaymentType;
import com.codegym.demo.service.RoomDAO;
import com.codegym.demo.service.PaymentTypeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "RoomServlet", urlPatterns = "/rooms")
public class RoomListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomDAO roomDAO;
    private PaymentTypeDAO paymentTypeDAO;

    @Override
    public void init() {
        roomDAO = new RoomDAO();
        paymentTypeDAO = new PaymentTypeDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                case "create":
                    insertRoom(request, response);
                    break;
                case "edit":
                    updateRoom(request, response);
                    break;
                case "delete":
                    deleteRoom(request, response);
                    break;
                default:
                    listRooms(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteRoom(request, response);
                    break;
                default:
                    listRooms(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listRooms(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String keyword = request.getParameter("keyword");
        List<RentRoom> rooms;
        if (keyword != null && !keyword.isEmpty()) {
            rooms = roomDAO.search(keyword);
        } else {
            rooms = roomDAO.getAll();
        }

        List<PaymentType> paymentTypes = paymentTypeDAO.getAll();
        request.setAttribute("listRoom", rooms);
        request.setAttribute("paymentTypes", paymentTypes);
        request.setAttribute("keyword", keyword);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<PaymentType> paymentTypes = paymentTypeDAO.getAll();
        request.setAttribute("paymentTypes", paymentTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/room-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        RentRoom existingRoom = roomDAO.findById(id);
        List<PaymentType> paymentTypes = paymentTypeDAO.getAll();
//        request.setAttribute("room", existingRoom);
        request.setAttribute("paymentTypes", paymentTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/room-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertRoom(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String tenntt_name = request.getParameter("tenntt_name");
        String phoneNumber = request.getParameter("phoneNumber");
        String startDate = request.getParameter("startDate");
        int paymentTypeId = Integer.parseInt(request.getParameter("paymentTypeId"));
        String note = request.getParameter("note");

        RentRoom newRoom = new RentRoom();
        newRoom.setTenntt_name(tenntt_name);
        newRoom.setPhoneNumber(phoneNumber);
        newRoom.setStartDate(startDate);
        newRoom.setPaymentTypeId(paymentTypeId);
        newRoom.setNote(note);

        roomDAO.insert(newRoom);
        response.sendRedirect("rooms");
    }

    private void updateRoom(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenntt_name = request.getParameter("tenntt_name");
        String phoneNumber = request.getParameter("phoneNumber");
        String startDate = request.getParameter("startDate");
        int paymentTypeId = Integer.parseInt(request.getParameter("paymentTypeId"));
        String note = request.getParameter("note");

        RentRoom room = new RentRoom(id, tenntt_name, phoneNumber, startDate, paymentTypeId, null, note);
        roomDAO.update(room);
        response.sendRedirect("rooms");
    }

    private void deleteRoom(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        roomDAO.deleteById(id);
        response.sendRedirect("rooms");
    }
}
