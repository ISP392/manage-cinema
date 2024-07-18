<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Information</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #faf3e0; 
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 20px;
            margin-top: 50px;
        }
        .content {
            width: 100%;
            text-align: center;
        }
        .info {
            margin-bottom: 15px;
            font-size: 1.2em;
        }
        .form-group button {
            padding: 10px;
            font-size: 1.2em;
            border: 1px solid #ddd;
            border-radius: 4px;
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
    <div class="container">
        <div class="content">
            <h2>Thông tin khách hàng</h2>
            <div class="info">
                <p>ID: ${customer.id}</p>
                <p>Tên: ${customer.name}</p>
                <p>Số điện thoại: ${customer.phone}</p>
            </div>
            <form action="nextPage" method="post">
                <input type="hidden" name="userID" value="${customer.id}">
                <button type="submit">Tiếp theo</button>
            </form>
        </div>
    </div>
</body>
</html>
