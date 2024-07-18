<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Check Ticket</title>
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
        .form-group {
            margin-bottom: 15px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .form-group label {
            font-size: 1.5em;
            margin-bottom: 10px;
        }
        .form-group input, .form-group button {
            padding: 10px;
            font-size: 1.2em;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: 100%;
            max-width: 400px;
        }
        .form-group button {
            background-color: #e74c3c;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-top: 10px;
        }
        .form-group button:hover {
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
            <form action="checkTicket" method="post">
                <div class="form-group">
                    <label for="orderID">Nhập ID hoá đơn:</label>
                    <input type="text" id="orderID" name="orderID" required>
                </div>
                <div class="form-group">
                    <button type="submit">Kiểm tra</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
