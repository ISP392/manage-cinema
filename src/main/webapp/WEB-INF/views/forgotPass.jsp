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
        body {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            height: 100vh;
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
            margin: 0;
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
        .container {
            text-align: center;
            background: #ffffff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px; /* Adjust the width to center the content */
            width: 100%;
        }
        .container img {
            width: 50px;
            margin-bottom: 20px;
        }
        .container h1 {
            font-size: 24px;
            margin-bottom: 10px;
        }
        .container p {
            color: #777;
            margin-bottom: 20px;
        }
        .container input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .container button {
            width: 100%;
            padding: 10px;
            background-color: #6c63ff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .container a {
            display: block;
            margin-top: 20px;
            color: #6c63ff;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="header">
        <%@include file="header.jsp" %>
    </div>
    <div class="middle">
        <div class="container">
            <img src="lock-icon.png" alt="Lock Icon"> <!-- Placeholder for the lock icon -->
            <h1>Forgot password?</h1>
            <p>No worries, we’ll send you reset instructions.</p>
            <form action="ForgotPasswordServlet" method="post">
                <input type="email" name="email" placeholder="Enter your email" required>
                <button type="submit">Reset password</button>
            </form>
            <a href="login.jsp">← Back to log in</a>
        </div>
    </div>
    <div class="footer">
        <%@include file="footer.jsp" %>
    </div>
</body>
</html>
