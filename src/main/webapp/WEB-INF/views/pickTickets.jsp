<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
                <title>JSP Page</title>
            </head>
            <style>
                .seats-container {
                    width: 100%;
                    text-align: center;
                }

                .seat-row {
                    display: flex;
                    justify-content: center;
                    align-items: center;
                }

                .group {
                    display: flex;
                }

                .seat-gap {
                    width: 50px;
                    /* Chiều rộng của khoảng trống, chỉ hiển thị khi totalColumns > 18 */
                }

                .seat {
                    padding: 5px;
                    margin: 2px;
                    display: inline-block;
                }
            </style>

            <body>
                <%@include file="header.jsp" %>
                    <div class="main-container-seat-booking">
                        <div class="container">
                            <div class="booking-progress">
                                <div class="page-title">
                                    <h3>BOOKING ONLINE</h3>
                                </div>
                                <div class="top-content">
                                    <div class="products-list">
                                        <c:set var="count" value="${SWS.size()}" />

                                        <p>
                                            ${screeningTimes.theaterID.cinemaID.name} | Phòng Cinema
                                            ${screeningTimes.getTheaterID().getTheaterNumber()} | Số ghế
                                            (${(screeningTimes.theaterID.rows * screeningTimes.theaterID.cols -
                                            damagedSeats.size()) - count}/ ${screeningTimes.theaterID.rows *
                                            screeningTimes.theaterID.cols})
                                        </p>
                                        <p>
                                            <fmt:formatDate value="${screeningTimes.getStartTime()}"
                                                pattern="yyyy:MM:dd HH:mm" />
                                            ~
                                            <fmt:formatDate value="${screeningTimes.getEndTime()}"
                                                pattern="yyyy-MM-dd HH:mm" />
                                        </p>
                                    </div>
                                </div>
                                <div class="main-content">
                                    <div class="progress-content" style="position: relative">
                                        <div class="ticketbox">
                                            <div class="screen"></div>
                                            <div class="row">
                                                <form style="width: 97%" id="seatForm" action="pickFood" method="post"
                                                    onsubmit="return validateForm()">
                                                    <div class="seats-container">
                                                        <c:forEach var="row"
                                                            items="${'ABCDEFGHIJKLMN'.substring(0, screeningTimes.theaterID.rows).split('')}">
                                                            <div class="seat-row">
                                                                <c:choose>
                                                                    <c:when
                                                                        test="${screeningTimes.theaterID.cols > 18}">
                                                                        <!-- Hiển thị với khoảng trống -->
                                                                        <div class="group">
                                                                            <c:forEach var="col" begin="1"
                                                                                end="${(screeningTimes.theaterID.cols div 2) - 1}">
                                                                                <!-- Phần ghế bên trái -->
                                                                                <c:set var="seatCode"
                                                                                    value="${row}${String.format('%02d', col)}" />
                                                                                <c:set var="seatFound" value="false" />
                                                                                <c:set var="rowIndex"
                                                                                    value="${row.toUpperCase().charAt(0) - 'A'.charAt(0) + 1}" />
                                                                                <c:forEach var="s" items="${SWS}">
                                                                                    <c:if
                                                                                        test="${s.getSeatID().getSeatNumber().equals(seatCode)}">
                                                                                        <label
                                                                                            class="seat seat-occupied"
                                                                                            loc="${seatCode}"
                                                                                            price="75000">${seatCode}</label>
                                                                                        <c:set var="seatFound"
                                                                                            value="true" />
                                                                                    </c:if>
                                                                                </c:forEach>
                                                                                <c:if test="${!seatFound}">
                                                                                    <label
                                                                                        class="seat ${rowIndex ge vipSeat[2] && rowIndex le vipSeat[3] && col ge vipSeat[0] && col le vipSeat[1] ? 'seat-vip' : 'seat-standard'} ${damagedSeats.contains(seatCode) ? 'seat-damaged disable' : ''}"
                                                                                        onclick="toggleSeat(this)"
                                                                                        loc="${seatCode}"
                                                                                        price="75000">${seatCode}</label>
                                                                                </c:if>
                                                                            </c:forEach>
                                                                        </div>
                                                                        <div class="seat-gap"></div>
                                                                        <div class="group">
                                                                            <c:forEach var="col"
                                                                                begin="${(screeningTimes.theaterID.cols div 2) + 1}"
                                                                                end="${screeningTimes.theaterID.cols}">
                                                                                <!-- Phần ghế bên phải -->
                                                                                <c:set var="seatCode"
                                                                                    value="${row}${String.format('%02d', col)}" />
                                                                                <c:set var="seatFound" value="false" />
                                                                                <c:set var="rowIndex"
                                                                                    value="${row.toUpperCase().charAt(0) - 'A'.charAt(0) + 1}" />
                                                                                <c:forEach var="s" items="${SWS}">
                                                                                    <c:if
                                                                                        test="${s.getSeatID().getSeatNumber().equals(seatCode)}">
                                                                                        <label
                                                                                            class="seat seat-occupied"
                                                                                            loc="${seatCode}"
                                                                                            price="75000">${seatCode}</label>
                                                                                        <c:set var="seatFound"
                                                                                            value="true" />
                                                                                    </c:if>
                                                                                </c:forEach>
                                                                                <c:if test="${!seatFound}">
                                                                                    <label
                                                                                        class="seat ${rowIndex ge vipSeat[2] && rowIndex le vipSeat[3] && col ge vipSeat[0] && col le vipSeat[1] ? 'seat-vip' : 'seat-standard'} ${damagedSeats.contains(seatCode) ? 'seat-damaged disable' : ''}"
                                                                                        onclick="toggleSeat(this)"
                                                                                        loc="${seatCode}"
                                                                                        price="75000">${seatCode}</label>
                                                                                </c:if>
                                                                            </c:forEach>
                                                                        </div>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <!-- Hiển thị mà không có khoảng trống -->
                                                                        <div class="group">
                                                                            <c:forEach var="col" begin="1"
                                                                                end="${screeningTimes.theaterID.cols}">
                                                                                <c:set var="seatCode"
                                                                                    value="${row}${String.format('%02d', col)}" />
                                                                                <c:set var="seatFound" value="false" />
                                                                                <c:set var="rowIndex"
                                                                                    value="${row.toUpperCase().charAt(0) - 'A'.charAt(0) + 1}" />
                                                                                <c:forEach var="s" items="${SWS}">
                                                                                    <c:if
                                                                                        test="${s.getSeatID().getSeatNumber().equals(seatCode)}">
                                                                                        <label
                                                                                            class="seat seat-occupied"
                                                                                            loc="${seatCode}"
                                                                                            price="75000">${seatCode}</label>
                                                                                        <c:set var="seatFound"
                                                                                            value="true" />
                                                                                    </c:if>
                                                                                </c:forEach>
                                                                                <c:if test="${!seatFound}">
                                                                                    <label
                                                                                        class="seat ${rowIndex ge vipSeat[2] && rowIndex le vipSeat[3] && col ge vipSeat[0] && col le vipSeat[1] ? 'seat-vip' : 'seat-standard'} ${damagedSeats.contains(seatCode) ? 'seat-damaged disable' : ''}"
                                                                                        onclick="toggleSeat(this)"
                                                                                        loc="${seatCode}"
                                                                                        price="75000">${seatCode}</label>
                                                                                </c:if>
                                                                            </c:forEach>
                                                                        </div>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                    <br />
                                                    <div class="ticketbox-notice">
                                                        <div class="iconlist">
                                                            <div class="icon checked">Checked</div>
                                                        </div>
                                                        <div class="iconlist">
                                                            <div class="icon occupied">Đã chọn</div>
                                                        </div>
                                                        <div class="iconlist">
                                                            <div class="icon vip">VIP</div>
                                                        </div>
                                                        <div class="iconlist">
                                                            <div class="icon standard">Thường</div>
                                                        </div>
                                                    </div>

                                                    <div class="bottom-content">
                                                        <div class="minicart-wrapper">
                                                            <ul>
                                                                <li class="item-first">
                                                                    <div class="product-detail" style="width: 30vh">
                                                                        <img src="${screeningTimes.getMovieID().getPosterImage()}"
                                                                            width="74px" height="108px" alt="alt" />
                                                                        <p>
                                                                            ${screeningTimes.getMovieID().getTitle().toUpperCase()}
                                                                        </p>
                                                                    </div>
                                                                </li>
                                                                <li class="item" style="
                                                        width: 210px;
                                                        word-break: break-word;
                                                        margin-right: 0;
                                                        width: 300px;
                                                        ">
                                                                    <p>
                                                                        Rạp
                                                                        ${screeningTimes.getTheaterID().getCinemaID().getName()}
                                                                    </p>
                                                                    <p>
                                                                        Suất chiếu
                                                                        <fmt:formatDate
                                                                            value="${screeningTimes.getStartTime()}"
                                                                            pattern="HH:mm" />,
                                                                        <fmt:formatDate
                                                                            value="${screeningTimes.startTime}"
                                                                            pattern="yyyy-MM-dd" />
                                                                    </p>
                                                                    <p>
                                                                        Phòng Cinema
                                                                        ${screeningTimes.getTheaterID().getTheaterNumber()}
                                                                    </p>
                                                                    <p id="seatType">Ghế:</p>
                                                                    <p id="selectedSeats"></p>
                                                                </li>
                                                                <li class="item">
                                                                    <p>Tổng tiền: <span id="totalPrice">0</span></p>
                                                                </li>
                                                            </ul>
                                                            <!--<input type="hidden" name=""-->
                                                            <!-- Hidden inputs to store data to be sent to the servlet -->
                                                            <input type="hidden" name="movieID"
                                                                value="${screeningTimes.getMovieID().getMovieID()}" />
                                                            <input type="hidden" name="cinemaName"
                                                                value="${screeningTimes.getTheaterID().getCinemaID().getName()}" />
                                                            <input type="hidden" name="screeningStartTime"
                                                                value="<fmt:formatDate value='${screeningTimes.getStartTime()}' pattern='yyyy-MM-dd HH:mm' />" />
                                                            <input type="hidden" name="screeningEndTime"
                                                                value="<fmt:formatDate value='${screeningTimes.getEndTime()}' pattern='yyyy-MM-dd HH:mm' />" />
                                                            <input type="hidden" name="theaterNumber"
                                                                value="${screeningTimes.getTheaterID().getTheaterNumber()}" />
                                                            <input type="hidden" name="selectedSeats"
                                                                id="hiddenSelectedSeats" />
                                                            <input type="hidden" name="totalPrice"
                                                                id="hiddenTotalPrice" />
                                                            <input type="hidden" name="screeningID"
                                                                value="${screeningTimes.getScreeningID()}" />
                                                            <input type="hidden" name="isVip" id="isVip" value="0" />

                                                            <input style="font-weight: bold; font-size: 20px"
                                                                type="submit" value="ĐẶT VÉ" />
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <script>
                                    function toggleSeat(seat) {
                                        var selectedSeats = document.querySelectorAll(".seat-selected");
                                        var seatType = seat.classList.contains("seat-vip") ? "seat-vip" : "seat-standard";

                                        if (selectedSeats.length > 0) {
                                            var firstSeatType = selectedSeats[0].classList.contains("seat-vip") ? "seat-vip" : "seat-standard";
                                            if (seatType !== firstSeatType) {
                                                alert("You can only select seats of the same type.");
                                                return;
                                            }
                                        }

                                        // Check if the user is trying to select more than 8 seats
                                        if (selectedSeats.length >= 8 && !seat.classList.contains("seat-selected")) {
                                            alert("You can only select up to 8 seats.");
                                            return;
                                        }

                                        seat.classList.toggle("seat-selected");

                                        // Get all selected seats
                                        selectedSeats = document.querySelectorAll(".seat-selected");

                                        // Create an array to store the seat codes
                                        var seatCodes = [];
                                        var total = 0;
                                        var isVip = seat.classList.contains("seat-vip");

                                        // Loop through the selected seats and add their codes to the array
                                        selectedSeats.forEach(function (seat) {
                                            seatCodes.push(seat.getAttribute("loc"));
                                            // Check if the seat is VIP
                                            if (seat.classList.contains("seat-vip")) {
                                                total += 85000; // Price for VIP seat
                                            } else {
                                                total += 75000; // Price for standard seat
                                            }
                                        });

                                        // Join the seat codes with a comma and set the value of the hidden input field
                                        document.getElementById("hiddenSelectedSeats").value =
                                            seatCodes.join(", ");

                                        var seatTypeText = isVip ? "Ghế: VIP" : "Ghế: Thường";
                                        document.getElementById("seatType").textContent = seatTypeText;
                                        document.getElementById("isVip").value = isVip ? "1" : "0";

                                        document.getElementById("selectedSeats").textContent =
                                            seatCodes.join(", ");

                                        // Calculate the total price
                                        var totalPrice = document.getElementById("totalPrice");
                                        var hiddenTotalPrice =
                                            document.getElementById("hiddenTotalPrice");
                                        totalPrice.innerHTML = formatMoney(total);
                                        hiddenTotalPrice.value = total; // Set the value of the hidden input field

                                        // Function to format money
                                        function formatMoney(amount) {
                                            return amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
                                        }
                                    }

                                    function validateForm() {
                                        var hiddenSelectedSeats = document.getElementById(
                                            "hiddenSelectedSeats"
                                        );
                                        if (hiddenSelectedSeats.value === "") {
                                            alert("Please choose your seats first.");
                                            return false;
                                        } else {
                                            return confirm("Do you agree to book this seat?");
                                        }
                                    }
                                </script>
                            </div>
                        </div>
                    </div>
                    <%@include file="footer.jsp" %>
            </body>

            </html>