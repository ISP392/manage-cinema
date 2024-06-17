<%-- 
    Document   : newPass
    Created on : Jun 17, 2024, 12:55:55 AM
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
        .con input[type="email"], .con input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
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
            <img src="./assets/images/password.png" alt="Lock Icon">
            <h1>Set new password</h1>
            <p style="color: red" id="error"></p>
            <form id="resetPasswordForm" action="new_password" method="post">
                <input id="password" type="password" name="password" placeholder="Password" required>
                <input id="confirm_password" type="password" name="confirm_password" placeholder="Confirm password" required>
                <button type="submit">Reset password</button>
            </form>
            <a href="signin">← Back to log in</a>
        </div>
    </div>
    <div class="footer">
        <%@include file="footer.jsp" %>
    </div>
</body>
<script>
    document.getElementById('resetPasswordForm').addEventListener('submit', function(event) {
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('confirm_password').value;
        var errorElement = document.getElementById('error');

        if (password !== confirmPassword) {
            errorElement.textContent = 'Passwords do not match.';
            event.preventDefault(); // Prevent form submission
        } else {
            errorElement.textContent = ''; // Clear the error message when passwords match
        }
    });
</script>
</html>
