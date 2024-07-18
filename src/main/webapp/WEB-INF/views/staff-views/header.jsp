<%@page contentType="text/html" pageEncoding="UTF-8" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Header</title>
    <!-- Link to FontAwesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa; /* Màu nền nhạt */
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        .nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #f5f5da; /* Màu nền nhạt */
            padding: 10px 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .logo img {
            height: 90px;
            display: block;
        }
        .nav-links {
            display: flex;
            justify-content: center;
            flex: 1;
        }
        .nav-links a {
            color: #333;
            text-decoration: none;
            padding: 10px 20px;
            transition: background-color 0.3s;
            border-radius: 4px;
            margin: 0 5px;
            font-size: 1.5em;
            display: flex;
            align-items: center;
        }
        .nav-links a:hover {
            background-color: #e74c3c;
            color: white;
        }
        .nav i {
            margin-right: 8px; /* Khoảng cách giữa icon và text */
        }
        .account-info {
            font-size: 1.6em;
            color: white;
            display: flex;
            align-items: center;
            padding: 10px 20px;
            border-radius: 4px;
            margin-right: 10px;
            background-color: #e74c3c;
            color: white;
        }
        .account-info a:hover {
            background-color: #e74c3c;
            color: white;
        }
        .account-info a {
            color: #333;
            text-decoration: none;
            padding: 10px 20px;
            transition: background-color 0.3s;
            border-radius: 4px;
            margin: 0 5px;
            font-size: 1.0em;
            display: flex;
            align-items: center;
        }
        
    </style>
</head>
<body>
    <div class="nav">
        <div class="logo">
            <img src="<c:url value='./assets/images/logo_mini.png' />" alt="Logo"> <!-- Đường dẫn tới logo -->
        </div>
        <div class="nav-links">
            <a href="homeStaff"><i class="fas fa-home"></i> Home</a>
            <a href="nowShowing"><i class="fas fa-ticket-alt"></i> Bán vé</a>
            <a href="viewReport"><i class="fas fa-chart-line"></i> Doanh thu</a>
            <a href="checkTicket"><i class="fas fa-qrcode"></i> Check vé</a>
            <a href="report"><i class="fas fa-file-alt"></i>Báo cáo</a>
            <a href="logout"><i class="fas fa-sign-out-alt"></i> Đăng xuất</a>
        </div>
        <div class="account-info">
            <c:if test="${sessionScope.account != null}">
            <a href="information"><i class="fas fa-user"></i> ${sessionScope.account.getDisplayName().toUpperCase()}</a><!-- Hiển thị tài khoản đang đăng nhập -->
        </c:if>
        </div>
    </div>
</body>
</html>
