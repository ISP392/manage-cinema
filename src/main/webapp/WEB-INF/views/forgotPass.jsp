<%-- 
    Document   : forgotPass
    Created on : Jun 14, 2024, 12:46:31 AM
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
            font-size: 40px;
            margin-bottom: 20px;
        }
        .con h6 {
            font-size: 15px;
            margin-bottom: 20px;
        }
        .con p {
            color: #777;
            margin-bottom: 30px;
        }
        .con input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .con button {
            width: 100%;
            padding: 10px;
            background-color: #990000;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .con a {
            display: block;
            margin-top: 20px;
            color: #990000;
            text-decoration: none;
            text-align: left;
            
        }
    </style>
</head>

<body>
    <div class="header">
        <%@include file="header.jsp" %>
    </div>
    <div class="middle">
        <div class="con">
            <img src="./assets/images/logo_forgot.png" alt="">
            <h1>Forgot your password?</h1>
            <p>Don't worry, we'll send you reset instructions.</p>
            <form action="forgot" method="post">
                <input type="email" name="email" placeholder="Enter your email" required>
                <h6 style="color: red">${error}</h6>
                <button type="submit">Reset Password</button>
            </form>
            <a href="signin">← Back to login</a>
        </div>
    </div>
    <div class="footer">
        <%@include file="footer.jsp" %>
    </div>
</body>
</html>
