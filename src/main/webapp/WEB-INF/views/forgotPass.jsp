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
            input::after {
    content: "";
    background-color: rgba(0, 0, 0, 0.5); /* Màu đen với độ mờ 50% */
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: -10; /* Để phần mờ nằm dưới phần nội dung */
}
           .input {
    background-image: url('assets/images/Foto.jfif');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    margin: inherit;
    padding: 206px;
    height: 75vh;
    background-color: rgba(0, 0, 0, 0.8); /* Màu đen với độ mờ 50% */
}


            .container {
                width: 100%;
                max-width: 400px;
                background-color: #fff;
                padding: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                border-radius: 10px;
                text-align: center;
            }
            h2 {
                margin-bottom: 20px;
                font-size: xx-large;
                font-weight: bold;
            }
            .form-group {
                margin-bottom: 15px;
            }
            .form-group label {
                display: block;
                margin-bottom: 5px;
            }
            .form-group input {
                width: 100%;
                padding: 10px;
                box-sizing: border-box;
                border: none;
                border-bottom: 2px solid #cccccc;
                outline: none;
            }
            .form-group input:focus {
                border-bottom: 2px solid #000;
            }
            .form-group button {
                width: 100%;
                padding: 10px;
                background-color: #007BFF;
                color: #fff;
                border: none;
                cursor: pointer;
            }
            .form-group button:hover {
                background-color: #0056b3;
            }
            .message {
                margin-top: 20px;
                color: green;
            }
            .error {
                margin-top: 20px;
                color: red;
            }
            .back-link {
                text-align: center;
                margin-top: 20px;
            }
            .back-link a {
                color: #007BFF;
                text-decoration: none;
            }
            .back-link a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <%@include file="header.jsp" %>
    <body>
        <div class = "input">
        <div class="container">
            <h2>Forgot Password</h2>
            <form action="forgotPasswordServlet" method="post">
                <div class="form-group">
                    <input type="email" id="email" name="email" placeholder="Enter your email address" required>
                </div>
                <div class="form-group">
                    <button type="submit">Send Reset Password</button>
                </div>
            </form>
            <c:if test="${not empty message}">
                <div class="message">${message}</div>
            </c:if>
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <div class="back-link">
                <p>Have already an account? <a href="signin">Back</a></p>
            </div>
        </div>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>
