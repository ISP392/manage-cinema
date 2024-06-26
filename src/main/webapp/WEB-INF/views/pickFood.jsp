<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Pick Food</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f8f8f8;
                margin: 0;
                padding: 0;
            }

            .container {
                width: 90%;
                margin: 0 auto;
                padding: 20px;
                background-color: white;
            }

            .title {
                text-align: center;
                margin-bottom: 20px;
            }

            .food-items {
                display: grid;
                grid-template-columns: repeat(2, 1fr); 
                gap: 20px;
            }

            .food-item {
                border: 1px solid #ddd;
                border-radius: 8px;
                text-align: center;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 15px;
                display: flex;
                flex-direction: column;
                justify-content: space-between;
            }

            .food-item img {
                width: 100%;
                height: 300px;
                border-bottom: 1px solid #ddd;
                padding-bottom: 15px;
                margin-bottom: 15px;
            }

            .food-item h2 {
                font-size: 18px;
                margin: 10px 0;
            }

            .food-item p {
                font-size: 14px;
                color: #666;
            }

            .food-item .price {
                font-size: 16px;
                font-weight: bold;
                margin: 10px 0;
            }

            .food-item .order-controls {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .food-item .quantity {
                display: flex;
                align-items: center;
            }

            .food-item .quantity button {
                background-color: #ddd;
                border: none;
                padding: 5px;
                cursor: pointer;
            }

            .food-item .quantity input {
                width: 40px;
                text-align: center;
                border: 1px solid #ddd;
                margin: 0 5px;
            }

            .food-item .order-button {
                background-color: #f90;
                border: none;
                color: white;
                padding: 10px;
                cursor: pointer;
                width: 100%;
                border-radius: 8px;
                margin-top: 10px;
            }

            .food-item .order-button:hover {
                background-color: #e80;
            }
            
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <h1 class="title">Bắp Nước</h1>
            <div class="food-items">
                <c:forEach var="item" items="${foodItems}">
                    <div class="food-item">
                        <img src="./assets/images/food/${item.imgFoodItems}" alt="${item.foodName}">

                        <h2>${item.foodName}</h2>
                        <p>${item.description}</p>
                        <p class="price">${item.price} VNĐ</p>
                        <div class="order-controls">
                            <div class="quantity">
                                <button>-</button>
                                <input type="text" value="0">
                                <button>+</button>
                            </div>

                        </div>
                    </div>
                    
                </c:forEach>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
