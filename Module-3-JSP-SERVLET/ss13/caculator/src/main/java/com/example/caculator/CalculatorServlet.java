package com.example.caculator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        int num1 = Integer.parseInt(request.getParameter("txtNum1"));
        int num2 = Integer.parseInt(request.getParameter("txtNum2"));
        String operator = request.getParameter("txtOperator");

        int result = 0;
        try {
            Calculator calculator = new Calculator();
            result = calculator.calculator(num1, num2, operator);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
