<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Thanh Toán</title>
                <link rel="stylesheet" href="./assets/css/order_style.css" />
                <script src="./assets/JS/order_script.js"></script>
            </head>

            <body>
                <div class="container">
                    <div class="header">
                        THANH TOÁN
                    </div>
                    <div class="section">
                        <h2>Bước 1: GIẢM GIÁ</h2>
                        <table>
                            <tr>
                                <td>
                                    <table>
                                        <tr>
                                            <th>Tên phim</th>
                                            <td>${orderDetail.screeningID.movieID.title}</td>
                                        </tr>
                                        <tr>
                                            <th>Mã Khuyến Mãi</th>
                                            <td style="display: flex; flex-direction: column;">
                                                <input class="voucher" type="text" onclick="toggleCouponSection()"
                                                    oninput="checkCode(this)" placeholder="Nhập mã khuyến mãi">
                                                <span style="margin-top:5px; color: red;" id="codeMessage"
                                                    class="message"></span>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <table>
                                        <tr>
                                            <th>Bắp Nước</th>
                                            <th>Giá</th>
                                            <th>Số lượng</th>
                                            <th>Thành Tiền</th>
                                        </tr>
                                        <c:set var="totalPriceFood" value="0" />
                                        <c:forEach items="${orderDetail.foodMap}" var="food">
                                            <tr>
                                                <td>${food.key.foodName}</td>
                                                <td>
                                                    <fmt:formatNumber value="${food.key.price}" pattern="#,##0.###" />
                                                </td>
                                                <td>${food.value}</td>
                                                <td>
                                                    <fmt:formatNumber value="${food.value * food.key.price}"
                                                        pattern="#,##0.###" />
                                                </td>
                                            </tr>
                                            <c:set var="totalPriceFood"
                                                value="${totalPriceFood + (food.value * food.key.price)}" />
                                        </c:forEach>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <div id="coupon-section" class="coupon-section">
                            <div class="coupon-list">
                                <h3>Mã Giảm Giá Có Thể Sử Dụng</h3>
                                <ul id="allVouchers">
                                    <c:forEach items="${vouchers}" var="coupon">
                                        <li>${coupon.code} - ${coupon.voucherDescription}</li>
                                        <input type="hidden" name="voucherID" value="${coupon.voucherID}" />
                                        <input type="hidden" id="hiddenCode" name="code" value="${coupon.code}" />
                                        <input type="hidden" name="price" value="${coupon.discountAmount}" />
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <form action="payment" method="post" onsubmit="setPoint()">
                        <div class="section">
                            <h2>Bước 2: HÌNH THỨC THANH TOÁN</h2>
                            <ul class="payment-method">
                                <li><label><input type="radio" checked name="payment" /> PayPal</label></li>
                                <li><label><input type="radio" name="payment" /> VNPAY</label></li>
                            </ul>
                        </div>
                        <div class="section">
                            <div class="left">
                                <table>
                                    <tr>
                                        <th>Vé</th>
                                        <td>${orderDetail.selectedSeats}</td>
                                        <td>
                                            <fmt:formatNumber value="${orderDetail.totalPrice}" pattern="#,##0.###" /> đ
                                        </td>
                                    </tr>
                                    <tr>
                                        <th></th>
                                        <td>Đồ Ăn Kèm</td>
                                        <td>
                                            <fmt:formatNumber value="${totalPriceFood}" pattern="#,##0.###" /> đ
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Tổng cộng</th>
                                        <td></td>
                                        <td id="totalAmount"
                                            data-raw-value="${orderDetail.totalPrice + totalPriceFood}">
                                            <fmt:formatNumber value="${orderDetail.totalPrice + totalPriceFood}"
                                                pattern="#,##0.###" /> đ
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Khuyến mãi</th>
                                        <td></td>
                                        <td id="discountAmount">0,00 đ</td>
                                    </tr>
                                    <tr>
                                        <th>Tổng số tiền thanh toán</th>
                                        <td colspan="2" class="highlight" id="totalMoney">
                                            <fmt:formatNumber value="${orderDetail.totalPrice + totalPriceFood}"
                                                pattern="#,##0.###" /> đ
                                        </td>
                                        <input type="hidden" name="totalMoney" id="totalMoneyServlet"
                                            value="${orderDetail.totalPrice + totalPriceFood}" />
                                    </tr>
                                    <tr>
                                        <th>Điểm BANNY</th>
                                        <td id="point">
                                            <fmt:formatNumber
                                                value="${(orderDetail.totalPrice + totalPriceFood) / 10000}"
                                                type="number" maxFractionDigits="0" /> P
                                        </td>
                                        <input type="hidden" name="point" id="pointInput" value="" />
                                        <td></td>
                                    </tr>
                                </table>
                                <input type="hidden" id="voucherIDSelected" name="voucherIDSelected" value="" />
                            </div>
                            <div class="right">
                                <div id="countdown" class="countdown">
                                    <div class="time-box">
                                        <div id="minutes">5</div>
                                        <div>Minutes</div>
                                    </div>
                                    <div class="time-box">
                                        <div id="seconds">00</div>
                                        <div>Seconds</div>
                                    </div>
                                </div>
                                <a href="#" onclick="confirmBack(); return false;" class="back-button">Go
                                    Back</a>
                                <button type="submit" class="payment-button">Thanh Toán</button>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </form>
                </div>
            </body>

            </html>