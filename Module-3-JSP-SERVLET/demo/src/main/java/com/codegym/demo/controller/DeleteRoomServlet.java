package com.codegym.demo.controller;

import com.codegym.demo.service.RoomDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("roomId");
        if (ids != null) {
            RoomDAO dao = new RoomDAO();
            for (String id : ids) {
                dao.deleteById(Integer.parseInt(id));
            }
        }
        resp.sendRedirect("rooms");
    }
}
