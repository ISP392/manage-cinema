<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Staff Home</title>
    <!-- Link to FontAwesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #faf3e0; /* Màu nền nhạt */
            margin: 0;
            padding: 0;
            color: #333;
        }
        .background-container {
            position: fixed;
            top: 10;
            left: 10;
            width: 100%;
            height: 100%;
            overflow: hidden;
            z-index: -1;
        }
        .background-blur {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: url('<c:url value="/assets/images/Movie-background.jpg"/>') no-repeat center center fixed;
            background-size: cover;
            filter: blur(10px); /* Làm mờ ảnh nền */
        }
        .container {
            margin: 20px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9); /* Màu nền trắng mờ */
            max-width: 1200px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center; /* Canh giữa nội dung */
        }
        .content {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }
        .card {
            background-color: #f7c6c7; /* Màu nền nhạt cho thẻ */
            border: 1px solid #ddd;
            border-radius: 8px;
            width: 30%;
            margin: 15px;
            padding: 20px;
            text-align: center;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
        }
        .card h3 {
            margin: 0 0 15px 0;
            font-size: 1.5em;
            color: #c0392b; /* Màu chữ cho tiêu đề thẻ */
        }
        .card a {
            text-decoration: none;
            color: #c0392b;
            display: inline-block;
            margin-top: 10px;
            padding: 10px 20px;
            border: 1px solid #c0392b;
            border-radius: 4px;
            transition: background-color 0.3s, color 0.3s;
            font-size: 1em;
        }
        .card a:hover {
            background-color: #c0392b;
            color: white;
        }
        .card i {
            font-size: 3em; /* Kích thước icon */
            margin-bottom: 10px;
            color: #c0392b; /* Màu của icon */
        }
    </style>
</head>
<body>
    <div class="background-container">
        <div class="background-blur"></div>
    </div>
    <%@include file="header.jsp" %>
    <div class="container">
        <div class="content">
            <div class="card">
                <i class="fas fa-ticket-alt"></i> <!-- Icon bán vé -->
                <h3>Sell Tickets</h3>
                <a href="sell_ticket.jsp">Go to Sell Tickets</a>
            </div>
            <div class="card">
                <i class="fas fa-chart-line"></i> <!-- Icon báo cáo -->
                <h3>Daily Report</h3>
                <a href="report.jsp">View Daily Report</a>
            </div>
            <div class="card">
                <i class="fas fa-headset"></i> <!-- Icon hỗ trợ khách hàng -->
                <h3>Support Customers</h3>
                <a href="support.jsp">Support Customers</a>
            </div>
        </div>
    </div>
</body>
</html>
