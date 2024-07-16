<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả kiểm tra vé</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #faf3e0; 
            margin: 0;
            padding: 0;
            color: #333;
            height: 100vh;
            position: relative;
        }
        .background-container {
            position: fixed;
            top: 0;
            left: 0;
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
            filter: blur(10px); 
        }
        .container {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9); 
            max-width: 645px;
            width: 50%;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 20px;
        }
        .content {
            width: 100%;
            text-align: center;
        }
        .ticket-info {
            text-align: left;
            margin-top: 20px;
        }
        .ticket-info p {
            margin: 5px 0;
        }
        .back-btn {
            padding: 10px 20px;
            border-radius: 5px;
            border: none;
            background-color: #e74c3c;
            color: white;
            cursor: pointer;
            text-decoration: none;
        }
        .back-btn:hover {
            background-color: #c0392b;
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
            <h1>Kết quả kiểm tra vé</h1>
            <c:choose>
                <c:when test="${not empty order}">
                    <div class="ticket-info">
                        <p><strong>Mã đặt vé:</strong> ${order.orderID}</p>
                        <p><strong>Tên phim:</strong> ${order.movieID.title}</p>
                        <p><strong>Số lượng vé:</strong> ${order.quantity}</p>
                        <p><strong>Tổng giá:</strong> ${order.allPrice}</p>
                        <c:forEach var="ticket" items="${tickets}">
                            <p><strong>Mã vé:</strong> ${ticket.ticketID}</p>
                            <p><strong>Suất chiếu:</strong> ${ticket.movieID.showTime}</p>
                            <p><strong>Rạp:</strong> ${ticket.cinemaID.cinemaName}</p>
                            <p><strong>Số ghế:</strong> ${ticket.seatID.seatNumber}</p>
                            <p><strong>Giá vé:</strong> ${ticket.price}</p>
                        </c:forEach>
                    </div>
                </c:when>
                <c:otherwise>
                    <p>Mã đặt vé không hợp lệ, vui lòng thử lại.</p>
                </c:otherwise>
            </c:choose>
            <a class="back-btn" href="checkTicket">Quay lại</a>
        </div>
    </div>
</body>
</html>
