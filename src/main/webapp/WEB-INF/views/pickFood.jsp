<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Pick Food</title>
                <style>
                    body {
                        font-family: 'Helvetica Neue', Arial, sans-serif;
                        background-color: #f8f8f8;
                        margin: 0;
                        padding: 0;
                    }

                    .container1 {
                        display: flex;
                        justify-content: space-between;
                        width: 90%;
                        margin: 0 auto;
                        padding: 20px;
                    }

                    .title {
                        text-align: center;
                        margin-bottom: 20px;
                        margin-top: 20px;
                        font-size: 24px;
                        color: #333;
                    }

                    .section {
                        border-radius: 6px;
                        padding: 20px;
                        margin: 10px;
                        flex: 1;
                        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                    }

                    .selected-movie {
                        min-height: 300px;
                        background-color: #fff;
                        flex: 1;
                        height: fit-content;
                        padding: 20px;
                    }

                    .food-selection {
                        flex: 2;
                    }

                    .order-summary {
                        background-color: #fff;
                        flex: 1;
                        height: fit-content;
                        min-height: 300px;
                        padding: 20px;
                    }

                    .section h2 {
                        font-size: 20px;
                        margin-bottom: 15px;
                        color: #dc3545;
                        border-bottom: 2px solid #dc3545;
                        padding-bottom: 5px;
                    }

                    .section p {
                        font-size: 16px;
                        margin: 5px 0;
                        color: #555;
                    }

                    .selected-movie p {
                        font-weight: bold;
                    }

                    .food-items {
                        display: grid;
                        grid-template-columns: repeat(2, 1fr);
                        gap: 20px;
                    }

                    .food-item {
                        border: 1px solid #ddd;
                        border-radius: 8px;
                        background-color: #fff;
                        padding: 15px;
                        display: flex;
                        align-items: center;
                        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                    }

                    .food-item img {
                        width: 100px;
                        height: 100px;
                        margin-right: 20px;
                    }

                    .food-item-details {
                        flex-grow: 1;
                    }

                    .food-item h2 {
                        font-size: 18px;
                        margin: 0 0 10px 0;
                        color: #333;
                    }

                    .food-item p {
                        font-size: 14px;
                        color: #666;
                        margin: 5px 0;
                    }

                    .food-item .price {
                        font-size: 16px;
                        font-weight: bold;
                        color: #dc3545;
                    }

                    .order-controls {
                        display: flex;
                        align-items: baseline;
                        align-content: stretch;
                        flex-wrap: wrap;
                        flex-direction: row-reverse;
                        justify-content: flex-start;
                    }

                    .quantity {
                        display: flex;
                        align-items: center;
                        margin-right: 10px;
                    }

                    .quantity button {
                        background-color: #ddd;
                        border: none;
                        padding: 5px;
                        cursor: pointer;
                    }

                    .quantity input {
                        width: 40px;
                        text-align: center;
                        border: 1px solid #ddd;
                        margin: 0 5px;
                    }

                    .bill-summary h2,
                    .previous-orders h2 {
                        text-align: center;
                        margin-bottom: 20px;
                        color: #333;
                    }

                    .bill-summary table,
                    .previous-orders table {
                        width: 100%;
                        border-collapse: collapse;
                    }

                    .bill-summary th,
                    .bill-summary td,
                    .previous-orders th,
                    .previous-orders td {
                        border: 1px solid #ddd;
                        padding: 10px;
                        text-align: center;
                        color: #555;
                    }

                    .bill-summary th {
                        background-color: #f4f4f4;
                        font-weight: bold;
                        color: #333;
                    }

                    .bill-summary .total-row {
                        background-color: #f9f9f9;
                        font-weight: bold;
                    }

                    .bill-summary .total {
                        text-align: right;
                        font-weight: bold;
                        font-size: 18px;
                        color: #dc3545;
                    }

                    .navigation {
                        text-align: center;
                        margin: 20px 0;
                    }

                    .navigation button {
                        background-color: #343a40;
                        color: white;
                        border: none;
                        padding: 10px 20px;
                        cursor: pointer;
                        margin: 0 10px;
                        border-radius: 4px;
                    }

                    .navigation button:hover {
                        background-color: #0056b3;
                    }
                </style>
            </head>

            <body>
                <%@include file="header.jsp" %>
                    <h1 class="title">COMBO ƯU ĐÃI</h1>
                    <div class="container1">
                        <div class="section selected-movie fixed-section">
                            <h2>Thông tin phim đã chọn</h2>
                            <p>Phim: ${movie.title}</p>
                            <p>Rạp: ${cinemaName}</p>
                            <p>Suất chiếu: ${screeningStartTime} - ${screeningEndTime}</p>
                            <p>Phòng: ${theaterNumber}</p>
                            <p>Ghế đã chọn: ${selectedSeats}</p>
                            <fmt:setLocale value="de_DE" />
                            <p>Tổng tiền vé: <span id="ticketPrice">
                                    <fmt:formatNumber value="${totalPrice}" pattern="#,##0" /> VNĐ
                                </span></p>
                        </div>
                        <div class="section food-selection">
                            <div class="food-items">
                                <c:forEach var="item" items="${foodItems}">
                                    <div class="food-item">
                                        <img src="./assets/images/food/${item.imgFoodItems}" alt="${item.foodName}">
                                        <div class="food-item-details">
                                            <h2>${item.foodName}</h2>
                                            <p>${item.description}</p>
                                            <p class="price">
                                                <fmt:formatNumber value="${item.price}" pattern="#,##0" /> VNĐ
                                            </p>
                                            <div class="order-controls">
                                                <div class="quantity">
                                                    <button
                                                        onclick="updateQuantity(this, -1, ${item.price}, '${item.foodName}')">-</button>
                                                    <input type="text" value="0" readonly>
                                                    <button
                                                        onclick="updateQuantity(this, 1, ${item.price}, '${item.foodName}')">+</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <form action="order">
                            <div style="width: 380px;" class="section order-summary fixed-section">
                                <h2>Thông tin order</h2>
                                <table>
                                    <thead>
                                        <tr>
                                            <th style="padding:10px">Đồ đã chọn</th>
                                            <th style="padding:10px">Số lượng</th>
                                            <th style="padding:10px">Giá tiền</th>
                                        </tr>
                                    </thead>
                                    <tbody id="billItems">
                                        <!-- Bill items will be inserted here dynamically -->
                                    </tbody>
                                    <tfoot>
                                        <tr class="total-row">
                                            <td style="padding:10px; font-size: 20px; font-weight: bold" colspan="2"
                                                class="total">Tổng cộng:</td>
                                            <td style="padding:10px; font-size: 20px; font-weight: bold" class="total"
                                                id="totalPrice">0 VNĐ</td>
                                        </tr>
                                    </tfoot>
                                </table>
                                <input type="hidden" id="orderDetails" name="orderDetails" value="">
                                <div class="navigation">
                                    <a href="#" onclick="window.history.back(); return false;">Go Back</a>
                                    <button type="submit" onclick="goNext()">Next</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <%@include file="footer.jsp" %>
                        <script>
                            function goNext() {
                                createOrderDetailsString();
                            }
                            function createOrderDetailsString() {
                                const billItems = document.getElementById('billItems').children;
                                let orderDetailsArray = [];

                                for (let i = 0; i < billItems.length; i++) {
                                    const row = billItems[i];
                                    const foodName = row.querySelector('td:nth-child(1)').textContent;
                                    const quantity = row.querySelector('.item-quantity').textContent;
                                    orderDetailsArray.push(foodName, quantity);
                                }

                                const orderDetailsString = orderDetailsArray.join(', ');
                                document.getElementById('orderDetails').value = orderDetailsString;
                            }
                            const ticketPrice = parseInt(document.getElementById('ticketPrice').textContent.replace(/[^0-9]/g, ''));

                            function updateQuantity(button, amount, price, foodName) {
                                var input = button.parentElement.querySelector('input');
                                var currentValue = parseInt(input.value);
                                var newValue = currentValue + amount;
                                if (newValue >= 0) {
                                    input.value = newValue;
                                    updateBill(foodName, price, newValue);
                                }
                            }

                            function updateBill(foodName, price, quantity) {
                                var billItems = document.getElementById('billItems');
                                var existingRow = billItems.querySelector('[data-item="' + foodName + '"]');
                                if (existingRow) {
                                    if (quantity > 0) {
                                        existingRow.querySelector('.item-quantity').textContent = quantity;
                                        existingRow.querySelector('.item-price').textContent = (price * quantity).toLocaleString('en-US') + ' VNĐ';
                                    } else {
                                        existingRow.remove();
                                    }
                                } else if (quantity > 0) {
                                    var newRow = document.createElement('tr');
                                    newRow.setAttribute('data-item', foodName);
                                    newRow.innerHTML = '<td style="padding:10px">' + foodName + '</td><td class="item-quantity" style="padding:10px; display:flex; justify-content:center">' + quantity + '</td ><td style="padding:10px" class="item-price">' + (price * quantity).toLocaleString('en-US') + ' VNĐ</td>';
                                    billItems.appendChild(newRow);
                                }
                                updateTotal();
                            }

                            function updateTotal() {
                                var billItems = document.getElementById('billItems').children;
                                var totalPrice = ticketPrice;
                                for (var i = 0; i < billItems.length; i++) {
                                    var row = billItems[i];
                                    var pricePerItem = parseInt(row.querySelector('.item-price').textContent.replace(/[^0-9]/g, ''));
                                    totalPrice += pricePerItem;
                                }
                                document.getElementById('totalPrice').textContent = totalPrice.toLocaleString('en-US') + ' VNĐ';
                            }

                        </script>
            </body>

            </html>