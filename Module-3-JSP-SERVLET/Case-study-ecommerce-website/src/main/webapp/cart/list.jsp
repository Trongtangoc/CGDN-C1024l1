<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: lebui
  Date: 4/23/2025
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="content">
    <h1>Carts</h1>
    <table>
        <tr>
            <th>Product Name</th>
            <th>Product Price</th>
            <th>Product Quantity</th>
        </tr>
        <c:set var="totalPrice" value="${0}"/>
        <c:forEach var="item" items="${sessionScope.cart}">
            <tr>
                <td><p><c:out value="${item.getProduct().getName().toString()}"/></p></td>
                <td><p><c:out value="${item.getProduct().getPrice().toString()}"/></p></td>
                <td><input type="text" id="quantity" name="quantity" value="${item.getQuantity().toString()}"></td>

                <td><p><c:out value="${item.getQuantity() * item.getProduct().getPrice()}"/></p></td>
            </tr>
            <c:set var="totalPrice" value="${totalPrice + (item.getQuantity() * item.getProduct().getPrice())}"/>
        </c:forEach>
    </table>
    <p id="total">Total Price: <c:out value="${totalPrice}"/></p>
    <a href="/carts?action=checkout">Checkout</a>
</div>
</body>
</html>
