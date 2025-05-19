<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <th></th>
        </tr>
        <c:set var="totalPrice" value="${0}"/>
        <c:forEach var="item" items="${sessionScope.cart}">
            <tr>
                <td><p><c:out value="${item.getProduct().getName().toString()}"/></p></td>
                <td><fmt:formatNumber value="${item.getProduct().getPrice().toString()}" type="number"/> VND </td>
<%--                <td><p><c:out value="${item.getProduct().getPrice().toString()}"/>day la price</p></td>--%>
                <td>
                    <input type="text" id="quantity2" name="quantity" value="${item.getQuantity().toString()}"></td>

                <td><p><fmt:formatNumber value="${item.getQuantity() * item.getProduct().getPrice()}" type="number" /> VND
<%--                    <c:out value="${item.getQuantity() * item.getProduct().getPrice()}"/>day la price2--%>
                </p></td>
            </tr>
            <c:set var="totalPrice" value="${totalPrice + (item.getQuantity() * item.getProduct().getPrice())}"/>
        </c:forEach>
    </table>
    <p id="total">Total Price:
        <fmt:formatNumber value="${totalPrice}" type="number" /> VND
<%--        <c:out value="${totalPrice}"/>day la price3--%>
    </p>
<c:if test="${empty sessionScope.cart}">
    <p>your cart is empty</p>
    <a href="/products"> back to products</a>
</c:if>
    <c:if test="${not empty sessionScope.cart}">

        <a href="/carts?action=checkout">Checkout</a>
    </c:if>


</div>
</body>
</html>
