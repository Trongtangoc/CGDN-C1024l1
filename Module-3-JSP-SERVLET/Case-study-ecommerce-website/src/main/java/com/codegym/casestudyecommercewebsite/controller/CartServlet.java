//package com.codegym.casestudyecommercewebsite.controller;
//
//import com.codegym.casestudyecommercewebsite.model.Product;
//import com.codegym.casestudyecommercewebsite.service.OrderDAO;
//import com.codegym.casestudyecommercewebsite.service.ProductDAO;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet("/carts")
//public class CartServlet extends HttpServlet {
//    private ProductDAO productDAO;
//    private OrderDAO orderDAO;
//
//    @Override
//    public void init() {
//        productDAO = new ProductDAO();
//        orderDAO = new OrderDAO();
//    }
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "add":
//                    addToCart(request, response);
//                    break;
//                case "checkout":
////                    checkout(request, response);
//                    break;
//                case "delete":
////                    deleteProductCart(request, response);
//                    break;
//                default:
//                    listProducts(request, response);
//                    break;
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//    }
//
//    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
//    }
//
//    private void addToCart(HttpServletRequest request, HttpServletResponse response) {
//    }
//}
