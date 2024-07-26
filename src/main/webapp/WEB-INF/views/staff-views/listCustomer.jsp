<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Check Customer</title>
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
            .customer-info {
                display: none;
                margin-top: 20px;
                width: 100%;
                text-align: left;
            }
            .customer-info.visible {
                display: block;
            }
            .customer-info h2 {
                font-size: 1.5em;
                margin-bottom: 10px;
            }
            .customer-info p {
                font-size: 1.2em;
                margin-bottom: 5px;
            }
        </style>
    </head>
    <body>
    <div class="background-container">
        <div class="background-blur"></div>
    </div>
    <div class="container">
        <div class="content">
            <form id="chooseCustomerForm" action="chooseCustomer" method="post">
                <div class="form-group">
                    <label for="email">Nhập mail khách hàng:</label>
                    <input type="text" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <button type="button" onclick="submitAsGuest()">Khách vãn lai</button>
                    <button type="submit">Kiểm tra</button>
                    <input type="hidden" id="action" name="action">
                </div>
            </form>
            <div id="customerInfo" class="customer-info ${not empty user ? 'visible' : ''}">
                <h2>Thông tin khách hàng</h2>
                <c:if test="${not empty user}">
                    <p><strong>ID:</strong> ${user.userID}</p>
                    <p><strong>Tên:</strong> ${user.displayName}</p>
                    <p><strong>Email:</strong> ${user.email}</p>
                </c:if>
                <c:if test="${empty user}">
                    <p>Không tìm thấy thông tin khách hàng.</p>
                </c:if>
                <c:if test="${not empty user}">
                    <div class="form-group">
                        <form action="createOrder" method="post">
                            <input type="hidden" name="userID" value="${user.userID}">
                            <button type="submit">Chọn khách hàng này</button>
                        </form>
                    </div>
                </c:if>
            </div>
            <c:if test="${not empty error}">
                <p style="color:red">${error}</p>
            </c:if>
        </div>
    </div>
    <script>
    function submitAsGuest() {
        var form = document.createElement("form");
        form.method = "post";
        form.action = "createOrder";

        var userIDInput = document.createElement("input");
        userIDInput.type = "hidden";
        userIDInput.name = "userID";
        userIDInput.value = "null";

        form.appendChild(userIDInput);
        document.body.appendChild(form);
        form.submit();
    }
</script>
</body>
</html>