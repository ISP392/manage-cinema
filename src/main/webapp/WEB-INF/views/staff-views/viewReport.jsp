<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Daily Report</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #faf3e0; /* Light background color */
            margin: 0;
            padding: 0;
            color: #333;
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
            filter: blur(10px); /* Blur background image */
        }
        .container {
            margin: 20px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            max-width: 1200px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .content {
            margin: 20px 0;
        }
        .summary {
            margin: 20px 0;
            padding: 20px;
            background-color: #f7c6c7; /* Light background color */
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .summary h2 {
            margin: 0 0 15px 0;
            color: #e74c3c; /* Main red color */
        }
        .summary p {
            margin: 5px 0;
            font-size: 1.2em;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f7c6c7; /* Light background color for table headers */
            color: #333;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
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
            <div class="summary">
                <h2>Doanh thu ca làm việc</h2>
            </div>
            <table>
                    <thead>
                        <tr>
                            <th>Nhân viên</th>
                            <th>Thời gian làm</th>
                            <th>Tiền mặt đầu ca</th>
                            <th>Tiền mặt cuối ca</th>
                            <th>Thanh toán chuyển khoản</th>
                            <th>Doanh thu</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="shift" items="${shifts}">
                            <tr>
                                <td>${shift.displayName}</td>
                                <td>${shift.startTime} - ${shift.endTime}</td>
                                <td>${shift.startAmount}</td>
                                <td>${shift.endAmount}</td>
                                <td>${shift.transferPayments}</td>
                                <td>${shift.revenue}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </div>
    </div>
</body>
</html>
