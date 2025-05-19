<%@ page import="java.util.*, com.codegym.casestudyecommercewebsite.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ hàng</title>
    <style>
        body { font-family: Arial; background: #f5f5f5; margin: 0; padding: 0; }
        .container { width: 60%; margin: 30px auto; background: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); }
        .product { display: flex; align-items: center; justify-content: space-between; border-bottom: 1px solid #eee; padding: 10px 0; }
        .product img { width: 80px; }
        .product-info { flex: 1; padding-left: 20px; }
        .product-actions { text-align: right; }
        .section { margin-top: 30px; }
        .section label { display: block; margin: 8px 0 4px; }
        .input { width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 5px; }
        .radio-group { display: flex; gap: 20px; margin-bottom: 10px; }
        .total { font-size: 20px; font-weight: bold; margin-top: 20px; text-align: right; }
        .qty-btn { padding: 5px 10px; border: 1px solid #ccc; background: #f0f0f0; cursor: pointer; }
        .discount { margin-top: 20px; }
    </style>
</head>
<body>
<div class="container">
    <h2>Giỏ hàng của bạn</h2>

    <%
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
    %>
    <p>Không có sản phẩm nào trong giỏ.</p>
    <% } else {
        double total = 0;
        for (Item item : cart.getItems()) {
            Product p = item.getProduct();
            double itemTotal = p.getPrice() * item.getQuantity();
            total += itemTotal;
    %>
    <div class="product">
<%--        <img src="<%= p.getImage() %>" alt="ảnh sản phẩm">--%>
        <div class="product-info">
            <strong><%= p.getName() %></strong><br>


        </div>
        <div class="product-actions">
            <div>
                <button class="qty-btn">-</button>
                <%= item.getQuantity() %>
                <button class="qty-btn">+</button>
            </div>
            <div><strong><%= itemTotal %>₫</strong></div>
        </div>
    </div>
    <% } %>

    <div class="total">Tạm tính: <%= total %>₫</div>

    <div class="section">
        <h3>Thông tin khách hàng</h3>
        <div class="radio-group">
            <label><input type="radio" name="gender" checked> Anh</label>
            <label><input type="radio" name="gender"> Chị</label>
        </div>
        <label>Họ và Tên</label>
        <input class="input" type="text" name="fullname" />
        <label>Số điện thoại</label>
        <input class="input" type="text" name="phone" />
    </div>

    <div class="section">
        <h3>Hình thức nhận hàng</h3>
        <div class="radio-group">
            <label><input type="radio" name="shipping" checked> Giao tận nơi</label>
            <label><input type="radio" name="shipping"> Nhận tại cửa hàng</label>
        </div>
        <label>Tỉnh / Thành phố</label>
        <input class="input" type="text" name="city" />
        <label>Địa chỉ cụ thể</label>
        <input class="input" type="text" name="address" />
        <label>Ghi chú (nếu có)</label>
        <input class="input" type="text" name="note" />
        <label><input type="checkbox" name="invoice"> Xuất hoá đơn công ty</label>
    </div>

    <div class="discount">
        <label><strong>Sử dụng mã giảm giá</strong></label>
        <input class="input" type="text" name="coupon" placeholder="Nhập mã giảm giá" />
    </div>
    <% } %>

</div>
</body>
</html>