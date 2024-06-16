<%-- 
    Document   : successPass
    Created on : Jun 17, 2024, 1:14:40 AM
    Author     : caoha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="./assets/images/logo_home.png" />
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
    <style>
        body, html {
            height: 100%;
            margin: 0;
            display: flex;
            flex-direction: column;
        }
        .header, .footer {
            width: 100%;
        }
        .middle {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }
        .con {
            text-align: center;
            background: #ffffff;
            padding: 40px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 40px;
            max-width: 500px; /* Adjust the width to center the content */
            width: 100%;
        }
        .con img {
            width: 250px;
            margin-bottom: 20px;
        }
        .con h1 {
            font-size: 24px;
            margin-bottom: 10px;
        }
        .con p {
            color: #777;
            margin-bottom: 20px;
        }
        .con button {
            width: 100%;
            padding: 10px;
            background-color: #6c63ff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .con a {
            display: block;
            margin-top: 20px;
            color: #6c63ff;
            text-decoration: none;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="header">
        <%@include file="header.jsp" %>
    </div>
    <div class="middle">
        <div class="con">
            <img src="./assets/images/PasswordSuccess.png" alt="Checkmark Icon">
            <h1>Password reset</h1>
            <p>Your password has been successfully reset. Click below to log in magically.</p>
            <button onclick="location.href='login.jsp'">Continue</button>
            <a href="signin">← Back to log in</a>
        </div>
    </div>
    <div class="footer">
        <%@include file="footer.jsp" %>
    </div>
</body>
</html>