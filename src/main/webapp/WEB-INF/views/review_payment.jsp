<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Order Review</title>
                <link rel="stylesheet" href="./assets/css/review_payment.css">
            </head>

            <body>
                <div class="container">
                    <h1>Review Your Order</h1>

                    <div class="order-summary">
                        <h2>Order Summary</h2>
                        <ul style="width: 800px;">
                            <li>
                                <span class="item-name">Tên Phim</span>
                                <span class="item-price">${orderDetail.screeningID.movieID.title}</span>
                            </li>
                            <!-- check if voucher is null, the price voucher is 0 -->
                            <c:if test="${orderDetail.voucherID == null}">
                                <c:set var="voucherPrice" value="0" />
                            </c:if>
                            <li>
                                <span class="item-name">Food and Drinks</span>
                                <span class="item-price">
                                    <c:set var="totalPriceFood" value="0" />
                                    <c:forEach items="${orderDetail.foodMap}" var="food">
                                        <div>
                                            <span>${food.key.foodName}:</span>
                                        </div>
                                        <c:set var="totalPriceFood"
                                            value="${totalPriceFood + (food.value * food.key.price)}" />
                                    </c:forEach>
                                </span>
                                <span class="item-name">Giá Đồ Ăn</span>
                                <span class="item-price">
                                    <fmt:formatNumber value="${totalPriceFood}" pattern="#,##0.###" /> VNĐ
                                </span>
                            </li>
                            <li>
                                <span class="item-name">Số Ghế</span>
                                <span class="item-price">${orderDetail.selectedSeats}</span>
                                <span class="item-name">Giá Vé</span>
                                <span class="item-price">
                                    <fmt:formatNumber value="${((orderDetail.totalPrice +
                                    orderDetail.voucherID.discountAmount) - totalPriceFood)}" pattern="#,##0.###" />
                                    VNĐ
                                </span>
                            </li>
                            <li>
                                <span class="item-name">Điểm Tích Luỹ</span>
                                <span class="item-price">${orderDetail.point} Đ</span>
                            </li>
                            <c:if test="${orderDetail.voucherID != null}">
                                <li>
                                    <span class="item-name">Voucher Đã Dùng</span>
                                    <span class="item-price">${orderDetail.voucherID.voucherName}</span>
                                </li>
                                <li>
                                    <span class="item-name">Giảm Giá Của Voucher</span>
                                    <span class="item-price">
                                        <fmt:formatNumber value="${orderDetail.voucherID.discountAmount}"
                                            pattern="#,##0.###" /> VNĐ
                                    </span>
                                </li>
                            </c:if>
                            <li>
                                <span class="item-name">Tổng Số Tiền</span>
                                <span class="item-price">
                                    <fmt:formatNumber value="${orderDetail.totalPrice}" pattern="#,##0.###" /> VNĐ
                                </span>
                            </li>
                        </ul>
                    </div>
                    <div class="button-container">
                        <a href="payment_complete" class="confirm-button">Confirm Payment</a>
                        <a href="home" class="cancel-button">Cancel</a>
                    </div>
                </div>
            </body>

            </html>