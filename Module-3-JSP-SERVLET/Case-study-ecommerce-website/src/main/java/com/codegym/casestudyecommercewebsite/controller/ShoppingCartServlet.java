package com.codegym.casestudyecommercewebsite.controller;

import com.codegym.casestudyecommercewebsite.model.Item;
import com.codegym.casestudyecommercewebsite.model.Product;
import com.codegym.casestudyecommercewebsite.service.OrderDAO;
import com.codegym.casestudyecommercewebsite.service.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = "/carts")
public class ShoppingCartServlet extends HttpServlet {

    private ProductDAO productDAO;
    private OrderDAO orderDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
        orderDAO = new OrderDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    showCart(request, response);
                    break;
                case "checkout":
                    checkout(request, response);
                    break;
                case "delete":
                    deleteProductCart(request, response);
                    break;
                default:
                    listProducts(request, response);
                    break;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Product product = productDAO.findById(id);
        List<Item> cart;
        if (product == null) {
            response.sendRedirect("error.jsp");
            return;
        }
//check if cart chua co
        if (session.getAttribute("cart") == null) {
//            tao moi gio hang dung ArrayList
            //        cart da khai bao o tren;
            cart = new ArrayList<Item>();
//          Product product = productDAO.findById(id);
            cart.add(new Item(product, 1));
            session.setAttribute("cart", cart);
        }
//        Neu san pham da co trong gio hang thi kiem tra va cap nhat san pham
        else {
            cart = (List<Item>) session.getAttribute("cart");
            int index = getIndex(id, session);
            if (index == -1)
//              product đã khai báo ở bên trên;
                cart.add(new Item(product, 1));

            else {
//                Neu san pham da co thi tawng so luong san pham
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        if (cart == null || cart.isEmpty()){
            request.setAttribute("message", " KHong co san pham nao trong gio hang");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart/list.jsp");
        dispatcher.forward(request, response);
    }

    private int getIndex(int id, HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            Product product = cart.get(i).getProduct();
            if (product.getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private void checkout(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
//        Luu order vao DB
        orderDAO.checkOut(cart);
        session.removeAttribute("cart");
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteProductCart(HttpServletRequest request, HttpServletResponse response) {
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
    }


}
