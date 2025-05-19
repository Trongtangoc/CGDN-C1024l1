package com.codegym.casestudyecommercewebsite.controller;

import com.codegym.casestudyecommercewebsite.model.Product;
import com.codegym.casestudyecommercewebsite.service.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //    goi den cac method
    private ProductDAO productDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
        System.out.println("ProductServlet init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(request, response);
                    break;
                case "edit":
                    updateProduct(request, response);
                    break;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    //    Trong nay nhan ve action (trong form co action no se roi vao cac switch case va thuc hien cac method tuong ung)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;

            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

//    truyen vao listProduct(HttpServletRequest request, HttpServletResponse response) 2 tham so
//    khai bao List<Product> de goi den method findAllWithStoreProcedure() trong class productDAO
    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
            List<Product> listProducts = productDAO.findAll();

//  request.setAttribute ten: listProducts va du lieu listProducts
            request.setAttribute("listProducts", listProducts);
//  sau do hien thi du lieu ra theo URL
            RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");

        dispatcher.forward(request, response);
        }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }


    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
    }
}

