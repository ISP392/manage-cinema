<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                margin-bottom: 20px;
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            .form-group h2 {
                font-size: 2em;
                margin-bottom: 20px;
                color: #e74c3c;
            }
            .form-group a {
                font-size: 1.2em;
                color: #3498db;
                text-decoration: none;
                padding: 10px 20px;
                border: 1px solid #3498db;
                border-radius: 5px;
                transition: background-color 0.3s, color 0.3s;
            }
            .form-group a:hover {
                background-color: #3498db;
                color: white;
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
                <div class="form-group">
                    <h2>Báo cáo ca làm thành công!</h2>
                    <a href="viewReport">Xem báo cáo doanh thu</a>
                </div>  
            </div>
        </div>
    </body>
</html>
