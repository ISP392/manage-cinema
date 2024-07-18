<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Report Shift</title>
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
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            font-size: 1.2em;
            margin-right: 10px;
        }
        .form-group select, .form-group input, .form-group button {
            padding: 10px;
            font-size: 1em;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .form-group button {
            background-color: #e74c3c;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .form-group button:hover {
            background-color: #c0392b;
        }
        input[type="text"] {
            -moz-appearance: textfield;
        }
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
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
            <h2>Báo cáo ca làm việc</h2>
            <form action="SaveReportServlet" method="post">
                <div class="form-group">
                    <label for="date">Ngày:</label>
                    <input type="date" id="date" name="date" value="<%= java.time.LocalDate.now() %>" readonly>
                </div>
                <div class="form-group">
                    <label for="shift">Ca làm việc:</label>
                    <select id="shift" name="shift" required>
                        <option value="8:00-12:00">8:00-12:00</option>
                        <option value="12:00-16:00">12:00-16:00</option>
                        <option value="16:00-20:00">16:00-20:00</option>
                        <option value="20:00-0:00">20:00-0:00</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="startCash">Tiền mặt đầu ca:</label>
                    <input type="text" id="startCash" name="startCash" required pattern="\d*" title="Please enter a valid number">
                </div>
                <div class="form-group">
                    <label for="endCash">Tiền mặt cuối ca:</label>
                    <input type="text" id="endCash" name="endCash" required pattern="\d*" title="Please enter a valid number">
                </div>
                <div class="form-group">
                    <label for="transferPayments">Thanh toán chuyển khoản:</label>
                    <input type="text" id="transferPayments" name="transferPayments" required pattern="\d*" title="Please enter a valid number">
                </div>
                <div class="form-group">
                    <label for="revenue">Doanh thu:</label>
                    <input type="text" id="revenue" name="revenue" required pattern="\d*" title="Please enter a valid number">
                </div>
                <div class="form-group">
                    <button type="submit">Nộp báo cáo</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
