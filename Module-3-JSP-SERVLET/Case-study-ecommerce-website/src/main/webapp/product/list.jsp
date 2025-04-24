<%--
  Created by IntelliJ IDEA.
  User: lebui
  Date: 4/23/2025
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="header">
    <h1>Header</h1>
</div>
<div id="content">
    <h1>Content</h1>
    <c:forEach var="p" items="${listProducts}">
        <div class="product">
            <p><c:out value="${p.getName()}"/> </p>
            <p><c:out value="${p.getPrice()}"/> </p>
        </div>
    </c:forEach>
</div>
<div id="sidebar">
    <h1>Sidebar</h1>
</div>
<div id="footer">
    <h1>Footer</h1>
</div>
</body>
</html>
