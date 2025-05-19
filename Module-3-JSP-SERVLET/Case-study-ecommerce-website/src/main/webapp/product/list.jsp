<%--
  Created by IntelliJ IDEA.
  User: lebui
  Date: 4/23/2025
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%--Khai bao thu vien JSTL--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq"
            crossorigin="anonymous"></script>

    <style>
        html, body, div, span, applet, object, iframe,
        h1, h2, h3, h4, h5, h6, p, blockquote, pre,
        a, abbr, acronym, address, big, cite, code,
        del, dfn, em, img, ins, kbd, q, s, samp,
        small, strike, strong, sub, sup, tt, var,
        b, u, i, center,
        dl, dt, dd, ol, ul, li,
        fieldset, form, label, legend,
        table, caption, tbody, tfoot, thead, tr, th, td,
        article, aside, canvas, details, embed,
        figure, figcaption, footer, header, hgroup,
        menu, nav, output, ruby, section, summary,
        time, mark, audio, video {
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            font: inherit;
            vertical-align: baseline;
        }

        /* HTML5 display-role reset for older browsers */
        article, aside, details, figcaption, figure,
        footer, header, hgroup, menu, nav, section {
            display: block;
        }

        body {
            line-height: 1;
            background-color: #f5f5f7;
        }

        ol, ul {
            list-style: none;
        }

        blockquote, q {
            quotes: none;
        }

        blockquote:before, blockquote:after,
        q:before, q:after {
            content: '';
            content: none;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        * {
            margin: 0;
            padding: 0;
        }

        .container {
            width: 1460px;
        }

        #header {
            height: 100px;
            background-color: cornflowerblue;
        }

        .header-row {
            height: 100px;
            background: cornflowerblue;
        }

        .header-col {
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /*#logo {*/
        /*    background-color: lightblue;*/
        /*}*/

        #menu {
            background-color: crimson;
        }

        .navbar {
            height: fit-content;
        }

        #cart {

            margin: 0 20px;
        }

        .bi-cart3 {
            width: 20px;
        }

        #hero-image {
            margin: 40px 0;
        }

        #sidebar {
            background-color: coral;
        }

        #footer {
            height: 200px;
            background-color: dodgerblue;
        }

    </style>
</head>
<body>
<div class="container text-center">
    <div class="row header-row" id="header">
        <div class="col-2 h-100 header-col">
            <h1 id="logo">LOGO</h1>
        </div>
        <div class="col-10 h-100 header-col">

            <nav class="navbar navbar-expand-lg" style="background-color: #e3f2fd;" data-bs-theme="light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">iPad</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                   aria-expanded="false">
                                    iPhone
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="#">iPhone 16</a></li>
                                    <li><a class="dropdown-item" href="#">iPhone 15</a></li>
                                    <%--                                    <li><hr class="dropdown-divider"></li>--%>
                                    <%--                                    <li><a class="dropdown-item" href="#">Something else here</a></li>--%>
                                </ul>
                            </li>
                            <%--                            <li class="nav-item">--%>
                            <%--                                <a class="nav-link disabled" aria-disabled="true">Disabled</a>--%>
                            <%--                            </li>--%>
                        </ul>
                        <form class="d-flex" role="search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                        <h1 id="cart"><a href="/carts" class="text-decoration-none text-dark position-relative">
                            <i class="bi bi-cart3 fs-2"></i>
                            <c:if test="${not empty sessionScope.cart}">
                                <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                                    <c:out value="${sessionScope.cart.size()}"/>
                                </span>
                            </c:if>
                        </a></h1>
                    </div>
                </div>
            </nav>
        </div>
        <%--        <div class="col-3 h-100 header-col"> CART--%>


        <%--        </div>--%>
    </div>

    <div class="row" id="banner">
        <div class="col" id="hero-image">
            <div id="carouselExampleDark" class="carousel carousel-dark slide">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active"
                            aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="10000">
                        <img src="https://shopdunk.com/images/uploaded/banner/Banner%202025/Thang_4/banner%20iP16sr_Danh%20m%E1%BB%A5c.png"
                             class="d-block w-100" alt="...">
                        <%--                    <div class="carousel-caption d-none d-md-block">--%>
                        <%--                        <h5>First slide label</h5>--%>
                        <%--                        <p>Some representative placeholder content for the first slide.</p>--%>
                        <%--                    </div>--%>
                    </div>
                    <div class="carousel-item" data-bs-interval="2000">
                        <img src="https://shopdunk.com/images/uploaded/banner/Banner%202025/Thang_4/danh%20m%E1%BB%A5c-ip_Danh%20m%E1%BB%A5c.png"
                             class="d-block w-100" alt="...">
                        <%--                    <div class="carousel-caption d-none d-md-block">--%>
                        <%--                        <h5>Second slide label</h5>--%>
                        <%--                        <p>Some representative placeholder content for the second slide.</p>--%>
                        <%--                    </div>--%>
                    </div>
                    <div class="carousel-item">
                        <img src="https://shopdunk.com/images/uploaded/banner/Banner%202025/Thang_4/danh%20m%E1%BB%A5c-ip_Danh%20m%E1%BB%A5c%20copy.png"
                             class="d-block w-100" alt="...">
                        <%--                    <div class="carousel-caption d-none d-md-block">--%>
                        <%--                        <h5>Third slide label</h5>--%>
                        <%--                        <p>Some representative placeholder content for the third slide.</p>--%>
                        <%--                    </div>--%>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>
    <div class="row">

        <div class="col-8" id="content">
            <%--    Dung vong lap lap ra du lieu listProducts tu ProductServlet--%>
            <div class="row">
                <c:forEach var="p" items="${listProducts}">
                    <div class="col-12 col-sm-6 col-md-4 mb-4">
                        <div class="card text-center">
                            <!-- Ảnh sản phẩm -->
                                <%--                            <img src="<c:out value='${p.getImageUrl()}'/>" class="card-img-top" alt="Product Image">--%>

                            <div class="card-body">
                                <!-- Tên sản phẩm -->
                                <h5 class="card-title"><c:out value="${p.getName()}"/></h5>

                                <!-- Giá sản phẩm -->
                                <p class="card-text"><fmt:formatNumber value="${p.getPrice()}" type="number"/> VND</p>

                                <!-- Nút mua hàng -->
                                <a href="carts?action=add&id=${p.getId()}" class="btn btn-primary" id="addtocart">Add to
                                    Cart<br>

                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <%--                <c:forEach var="p" items="${listProducts}">--%>
            <%--                    <div class="product">--%>
            <%--                        <p><c:out value="${p.getName()}"/></p>--%>
            <%--                        <p><c:out value="${p.getPrice()}"/></p>--%>
            <%--                    </div>--%>
            <%--                </c:forEach>--%>

        </div>
        <div class="col-4" id="sidebar">

            <h1>Sidebar</h1>

        </div>
    </div>
    <div class="row" id="footer">
        <div class="col"><h1>Footer</h1></div>
    </div>
</div>


</body>
</html>
