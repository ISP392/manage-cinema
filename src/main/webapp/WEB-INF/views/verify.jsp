<%--
  Created by IntelliJ IDEA.
  User: baoquoc
  Date: 22/05/2024
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<style>


    .container {
        text-align: center;
        background-color: white;
        padding: 30px 50px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .container h1 {
        margin-bottom: 20px;
    }

    .container p {
        margin-bottom: 20px;
        font-size: 16px;
    }

    .otp-input {
        font-size: 18px;
        padding: 10px;
        width: calc(100% - 22px);
        border: 2px solid #ddd;
        border-radius: 5px;
        margin-bottom: 20px;
        text-align: center;
    }

    .submit-button {
        font-size: 18px;
        padding: 10px 20px;
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    .submit-button:hover {
        background-color: #218838;
    }
</style>
<body>
<%@include file="header.jsp" %>
<form action="verify" method="post">
<div style="width: 750px; margin: 100px auto" class="container">
    <h1>OTP Code Verification</h1>
    <h5 style="color: red; font-weight: bold">${error}</h5>
    <p>Enter the OTP code sent to your Email: </p>
    <input type="text" name="otp-code" class="otp-input" maxlength="6" placeholder="------">
    <button class="submit-button">Verify OTP Code</button>
    <p>Didn't receive the OTP code? <a href="verify">Resend OTP Code</a></p>
</div>
</form>
<%@include file="footer.jsp" %>
</body>
</html>
