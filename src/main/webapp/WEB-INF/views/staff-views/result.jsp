<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
            header {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                background-color: rgba(255, 255, 255, 0.9);
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                z-index: 10;
            }
            .header-content {
                max-width: 1200px;
                margin: 0 auto;
                padding: 20px;
            }
            .container {
                position: relative;
                top: 100px; /* Adjust this value based on your header height */
                margin: 0 auto;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                padding: 20px;
                background-color: rgba(255, 255, 255, 0.9);
                max-width: 800px;
                width: 100%;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                border-radius: 20px;
            }
            .content {
                width: 100%;
                text-align: center;
            }
            .ticket-info {
                width: 100%;
                display: flex;
                justify-content: space-between;
                margin-top: 20px;
            }
            .ticket-info-section {
                width: 48%; /* Adjust width as necessary */
            }
            .ticket-card {
                margin-bottom: 20px;
                padding: 15px;
                border: 2px dashed #d1a054;
                border-radius: 10px;
                background-color: #ffebcd;
                position: relative;
                display: flex;
                flex-direction: column;
                align-items: flex-start;
            }
            .ticket-card::before,
            .ticket-card::after {
                content: "";
                position: absolute;
                width: 20px;
                height: 20px;
                background-color: #ffebcd;
                border: 2px solid #d1a054;
                border-radius: 50%;
            }
            .ticket-card::before {
                top: -11px;
                left: -11px;
            }
            .ticket-card::after {
                bottom: -11px;
                right: -11px;
            }
            .ticket-card p {
                margin: 5px 0;
                font-weight: bold;
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
            .used {
                color: red;
            }
            .not-used {
                color: green;
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
                            <div class="ticket-info-section">                                                   
                                <p><strong>Mã hoá đơn:</strong> ${order.orderID}</p>
                                <p><strong>Tổng giá:</strong> <fmt:formatNumber value="${order.allPrice}" type="currency" currencySymbol="VNĐ" groupingUsed="true"/></p>
                                <p><strong>Số lượng vé:</strong> ${order.quantity}</p>

                                <c:forEach var="ticketInfos" items="${ticketInfos}">
                                    <div class="ticket-card">
                                        <p><strong>Mã vé:</strong> ${ticketInfos.ticketID}</p>
                                        <p><strong>Tên phim:</strong> ${ticketInfos.title}</p>
                                        <p><strong>Suất chiếu:</strong> <fmt:formatDate value="${ticketInfos.startTime}" pattern="HH:mm dd/MM/yyyy"/> - <fmt:formatDate value="${ticketInfos.endTime}" pattern="HH:mm dd/MM/yyyy"/></p>
                                        <p><strong>Rạp:</strong> ${ticketInfos.nameCinema}</p>
                                        <p><strong>Phòng:</strong> ${ticketInfos.theaterNumber}</p>
                                        <p><strong>Số ghế:</strong> ${ticketInfos.seatNumber}</p>
                                        <p><strong>Giá vé:</strong> <fmt:formatNumber value="${ticketInfos.priceTicket}" type="currency" currencySymbol="VNĐ" groupingUsed="true"/></p>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="ticket-info-section">
                                <p><strong>Tình trạng:</strong>
                                    <c:choose>
                                        <c:when test="${order.ticketInfo.isChecked}">
                                            <span class="used">Đã sử dụng</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="not-used">Chưa sử dụng</span>
                                        </c:otherwise>
                                    </c:choose>
                                </p>
                                <p><strong>Khách hàng:</strong> ${order.userID.displayName}</p> 
                                <p><strong>Mã khách hàng:</strong> ${order.userID.userID}</p>                           
                                <c:forEach var="foodItems" items="${foodItems}">
                                    <div class="ticket-card">
                                        <p><strong>Combo bỏng nước:</strong> ${foodItems.foodName}</p>
                                        <p><strong>Số lượng:</strong> ${foodItems.quantity}</p>
                                        <p><strong>Giá:</strong> <fmt:formatNumber value="${foodItems.price}" type="currency" currencySymbol="VNĐ" groupingUsed="true"/></p>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p>Mã đặt vé không hợp lệ, vui lòng thử lại.</p>
                    </c:otherwise>
                </c:choose>
                <a class="back-btn" href="checkTicket">Quay lại</a>
                <a class="back-btn" href="homeStaff">In ra</a>
            </div>
        </div>
    </body>
</html>
