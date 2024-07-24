function toggleCouponSection() {
    var couponSection = document.getElementById('coupon-section');
    if (couponSection.style.display === 'none' || couponSection.style.display === '') {
        couponSection.style.display = 'block';
    } else {
        couponSection.style.display = 'none';
    }
}
function checkCode(inputElement) {
    var currentValue = inputElement.value.toUpperCase();
    var hiddenCodes = document.querySelectorAll('#allVouchers input[name="code"]');
    var messageElement = document.getElementById('codeMessage');
    var discountAmountElement = document.getElementById('discountAmount');
    var totalMoneyElement = document.getElementById('totalMoney');
    var totalMoneyServlet = document.getElementById('totalMoneyServlet');
    var totalAmountElement = document.getElementById('totalAmount');
    var voucherIDSelectedElement = document.getElementById('voucherIDSelected');
    var totalAmount = parseFloat(totalAmountElement.getAttribute('data-raw-value')) || 0;
    var matchFound = false;
    var discountAmount = 0;
    var selectedVoucherID = document.querySelectorAll('#allVouchers input[name="voucherID"]');
    if (currentValue === "") {
        messageElement.style.display = 'none';
        discountAmountElement.textContent = '0,00 đ';
        totalMoneyElement.textContent = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(totalAmount);
        voucherIDSelectedElement.value = '';
        return;
    }

    hiddenCodes.forEach(function (hiddenCode) {
        if (currentValue === hiddenCode.value.toUpperCase()) {
            matchFound = true;
            selectedVoucherID = hiddenCode.previousElementSibling.value;
        }
    });

    if (matchFound) {
        messageElement.textContent = 'Code matches. Apply discount.';
        var hiddenPrices = document.querySelectorAll('#allVouchers input[name="price"]');
        hiddenPrices.forEach(function (hiddenPrice) {
            if (currentValue === hiddenPrice.previousElementSibling.value.toUpperCase()) {
                discountAmount = parseFloat(hiddenPrice.value);
                var formattedDiscount = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(discountAmount);
                discountAmountElement.textContent = formattedDiscount;
            }
        });
        var totalPayment = totalAmount - discountAmount;
        var total = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(totalPayment);
        totalMoneyElement.textContent = total;
        totalMoneyServlet.value = totalPayment;

        voucherIDSelectedElement.value = selectedVoucherID; // Set giá trị của voucherIDSelected

        messageElement.classList.remove('error');
        messageElement.classList.add('success');
        messageElement.style.display = 'block';
    } else {
        messageElement.textContent = 'Code does not match or input is empty.';
        discountAmountElement.textContent = '0,00 đ';
        totalMoneyElement.textContent = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(totalAmount);
        voucherIDSelectedElement.value = ''; // Xóa giá trị của voucherIDSelected nếu không khớp
        totalMoneyServlet.value = totalAmount;
        messageElement.classList.remove('success');
        messageElement.classList.add('error');
        messageElement.style.display = 'block';
    }
}

//set value <td> with id = point to input with id = pointInput when load the page
function setPoint() {
    var point = document.getElementById('point').textContent.trim();
    var pointInput = document.getElementById('pointInput');
    pointInput.value = point.replace(' P', ''); // Loại bỏ ký tự ' P' nếu có
}





        function startCountdown(duration) {
            var timer = duration, minutes, seconds;
            var countdownInterval = setInterval(function () {
                minutes = parseInt(timer / 60, 10);
                seconds = parseInt(timer % 60, 10);
        
                minutes = minutes < 10 ? "0" + minutes : minutes;
                seconds = seconds < 10 ? "0" + seconds : seconds;
        
                document.getElementById('minutes').textContent = minutes;
                document.getElementById('seconds').textContent = seconds;
        
                sessionStorage.setItem('timeLeft', timer); // Lưu trữ thời gian còn lại
        
                if (--timer < 0) {
                    clearInterval(countdownInterval);
                    sessionStorage.removeItem('timeLeft');
                    localStorage.removeItem('startTime');
                    alert('Hết thời gian thanh toán! Bạn sẽ được chuyển về trang chủ.');
        
                    // Gửi yêu cầu POST để xóa session orderDetail bằng XHR
                    var xhr = new XMLHttpRequest();
                    xhr.open("POST", "/manage-cinema/clearOrderDetailSession", true);
                    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        
                    xhr.onload = function () {
                        if (xhr.status === 200) {
                            window.location.href = 'home'; // Chuyển hướng về trang chủ
                        } else {
                            console.error('Failed to clear orderDetail session', xhr.status, xhr.statusText);
                            console.error('Response text:', xhr.responseText);
                        }
                    };
        
                    xhr.onerror = function () {
                        console.error('Error:', xhr.statusText);
                    };
        
                    xhr.send();
                }
            }, 1000);
        }
        function confirmBack() {
            if (confirm("Bạn có chắc chắn muốn quay lại? Thời gian thanh toán của bạn sẽ bị hủy.")) {
                localStorage.removeItem('startTime');
                sessionStorage.removeItem('timeLeft');
                // Gửi yêu cầu POST để xóa session orderDetail bằng XHR
                var xhr = new XMLHttpRequest();
                xhr.open("POST", "/manage-cinema/clearOrderDetailSession", true);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

                xhr.onload = function () {
                    if (xhr.status === 200) {
                        window.location.href = 'home';
                    } else {
                        console.error('Failed to clear orderDetail session', xhr.status, xhr.statusText);
                        console.error('Response text:', xhr.responseText);
                    }
                };

                xhr.onerror = function () {
                    console.error('Error:', xhr.statusText);
                };

                xhr.send();
            }
        }

        
        window.onload = function () {
            var initialTime = 5 * 60; // 5 minutes
            var startTime = localStorage.getItem('startTime');
            var timeLeft = sessionStorage.getItem('timeLeft');
        
            // Kiểm tra nếu trang đã được tải lại
            if (timeLeft) {
                timeLeft = parseInt(timeLeft, 10);
            } else {
                localStorage.setItem('startTime', new Date().getTime());
                timeLeft = initialTime;
            }
        
            // Update the HTML with the remaining time before starting the countdown
            var minutes = parseInt(timeLeft / 60, 10);
            var seconds = parseInt(timeLeft % 60, 10);
        
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;
        
            document.getElementById('minutes').textContent = minutes;
            document.getElementById('seconds').textContent = seconds;
        
            startCountdown(timeLeft);
        };
        
        window.onbeforeunload = function (event) {
            var message = "Thời gian thanh toán của bạn sẽ bị hủy. Bạn có chắc chắn muốn rời khỏi trang này?";
            sessionStorage.removeItem('timeLeft'); // Reset time left when the user leaves the page
            localStorage.removeItem('startTime'); // Reset start time when the user leaves the page
            event.returnValue = message; // Standard way to show confirmation dialog
            return message; // For some older browsers
        };
        
        