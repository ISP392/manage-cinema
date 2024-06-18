<%-- 
    Document   : paymentPolicy
    Created on : Jun 18, 2024, 2:29:13 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

            .intro{
                text-align: center;
                color: red;
                font-size: 25px;
                font-weight: bold;
            }

        </style>
    </head>
    <%@include file="../header.jsp" %>
    <body>
        <div class="container">
            <div class="my-account">
                <div class="left-content">
                    <h1>${test}</h1>
                    <div class="block-cotent">
                        <ul style="padding:0">
                            <li style="background-color:${backgroundColorSecond}">
                                <a href="introduce" style="color: ${colorSecond}">
                                    GIỚI THIỆU
                                </a>
                            </li>
                            <li style="background-color:${backgroundColorSecond}">
                                <a style="color: ${colorSecond}" href="contact">
                                    LIÊN HỆ BANNY
                                </a>
                            </li>
                            <li style="background-color:${backgroundColorSecond}">
                                <a style="color: ${colorSecond}"
                                   href="generalTerms">
                                    ĐIỀU KHOẢN CHUNG
                                </a>
                            </li>
                            <li style="background-color:${backgroundColorSecond}">
                                <a style="color: ${colorSecond}"
                                   href="transactionTerms">
                                    ĐIỀU KHOẢN GIAO DỊCH
                                </a>
                            </li><li style="background-color:${backgroundColorMain}">
                                <a style="color: ${colorMain}"
                                   href="paymentPolicy">
                                    CHÍNH SÁCH THANH TOÁN
                                </a>
                            </li><li style="background-color:${backgroundColorSecond}">
                                <a style="color: ${colorSecond}"
                                   href="securityPolicy">
                                    CHÍNH SÁCH BẢO MẬT
                                </a>
                            </li><li style="background-color:${backgroundColorSecond}">
                                <a style="color: ${colorSecond}"
                                   href="forPartners">
                                    DÀNH CHO ĐỐI TÁC
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                                   <div class="dashboard" style="font-size: 15px">
                    <p class="intro">CHÍNH SÁCH THANH TOÁN</p>
                    <p> </p>
                    <p> </p>
                    <h5><p><strong>1. QUY ĐỊNH VỀ THANH TOÁN</strong></p></h5>
                    <p>Quý Khách hàng có thể lựa chọn các hình thức thanh toán sau để thanh toán cho giao dịch đặt vé trên Ứng Dụng của BANNY Việt Nam:</p>
                    <p>(i) Thẻ Thanh toán Quốc tế hoặc thẻ Thanh toán Nội địa;</p>
                    <p>(ii) Ví điện tử (Momo, Zalopay, ShopeePay, Viettelpay);</p>
                    <p>(iii) Các cổng thanh toán Payoo, VNPAY và ứng dụng QR code;</p>
                    <p>(iv) Thẻ quà Tặng BANNY Cinemas (BANNY Gift cards, BANNY E-Gift cards), Phiếu đổi vé Xem phim BANNY Cinemas (BANNY vouchers, BANNY E-vouchers);</p>
                    <p>(v) Thẻ BANNYIANS và thẻ CJ Members; và</p>
                    <p>(vi) Điểm thưởng tích lũy của Thành viên BANNY Việt Nam theo chương trình tích lũy điểm thưởng tại từng thời điểm.</p>
                    <h5><p><strong>2. CHI TIẾT CÁC HÌNH THỨC THANH TOÁN</strong></p></h5>
                    <p><strong>-  Điểm thưởng tích lũy của Thành viên BANNY Việt Nam (Membership Point)</strong>: Mỗi 01 điểm thưởng tương đương với 1.000 VND. Điểm thưởng này, bạn có thể sử dụng để (1) Thanh toán vé xem phim; (2) Mua các sản phẩm đồ ăn thức uống tại hệ thống BANNY; (3) Đổi sang hàn trăm ngàn voucher ưu đãi các sản phẩm/dịch vụ của các bên đối tác thứ 3 trên BANNY Reward/Đổi ưu đãi. Khi sử dụng điểm thưởng, bạn vui lòng xuất trình thẻ thành viên để được nhân viên hỗ trợ thanh toán. Điểm thưởng được sử dụng phải từ 20 điểm trở lên (Chưa có quy định cụ thể về mức điểm sử dụng tối thiểu đối với các sản phẩm voucher trên BANNY Reward).</p>
                    <p>Để kiểm tra điểm thưởng, bạn vui lòng truy cập vào mục Tài Khoản BANNY trên Ứng Dụng.</p>
                    <p>- <strong> Thẻ quà Tặng BANNY Cinemas (BANNY Gift cards, BANNY E-Gift cards), Phiếu đổi vé Xem phim BANNY Cinemas (BANNY vouchers, BANNY E-vouchers)</strong>: Với Thẻ Quà Tặng BANNY Cinemas hoặc Phiếu đổi vé Xem phim BANNY Cinemas vật lý, bạn có thể tìm mua tại các Cụm Rạp Chiếu Phim BANNY Cinemas toàn quốc với các mệnh giá từ 100.000đ. Với Thẻ Quà Tặng BANNY Cinemas hoặc Phiếu đổi vé Xem phim BANNY Cinemas trực tuyến (BANNY E-Gift cards, BANNY E-vouchers) bạn có thể dễ dàng mua tại Ứng Dụng có các mệnh giá: 100.000đ - 200.000đ - 300.000đ - 500.000đ - 1.000.000đ.</p>
                    <p>Mỗi loại <strong>Phiếu đổi vé Xem phim BANNY Cinemas</strong> sẽ có giá trị quy đổi và thời hạn sử dụng khác nhau. Bạn vui lòng đọc kỹ các điều khoản sử dụng ở mặt sau <strong>Phiếu đổi vé Xem phim BANNY Cinemas</strong> để biết thêm chi tiết. Khi thanh toán trực tuyến, bạn vui lòng đăng ký mã Phiếu đổi vé Xem phim BANNY Cinemas và mã PIN để thực hiện thanh toán. Xin lưu ý <strong>Phiếu đổi vé Xem phim BANNY Cinemas</strong> vật lý sau khi mất lớp tráng bạc sẽ không thể đổi vé tại quầy.</p>
                    <p>Đặc biệt, bạn có thể gửi kèm lời chúc bí mật dành cho "người thương" qua <strong>Thẻ quà Tặng BANNY Cinemas (BANNY Gift cards, BANNY E-Gift cards)</strong>.</p>
                    <p>-  <strong>Ví Điện Tử (Momo, Zalopay, ShopeePay, Viettelpay)</strong> làm phương thức thanh toán trên Ứng Dụng. Hoặc nhanh chóng hơn bằng cách mở Ví MoMo và chọn mục "Mua Vé Xem Phim", xem thông tin chi tiết: <a href="#">Tại đây</a></p>
                    <p>- <strong> Thẻ ATM (Thẻ ghi nợ/thanh toán /trả trước nội địa)</strong>: Để thanh toán bằng thẻ ngân hàng nội địa, thẻ của khách hàng phải được đăng ký sử dụng tính năng thanh toán trực tuyến, hoặc ngân hàng điện tử của Ngân hàng. Giao dịch phải được ghi nhận thành công từ thông báo cấp phép thành công do hệ thống cổng thanh toán trả về (đảm bảo số dư/hạn mức và xác thực khách hàng theo quy định sử dụng của thẻ).</p>
                    <p>-  <strong>Thẻ tín dụng, thẻ thanh toán quốc tế, thẻ trả trước quốc tế</strong>: Thẻ tín dụng/ghi nợ/trả trước VISA, MasterCard, JCB, Union Pay, Amex của các Ngân hàng trong nước và nước ngoài phát hành. Giao dịch phải được ghi nhận cấp phép thành công do đúng hệ thống cổng thanh toán trả về (đảm bảo số dư/hạn mức và xác thực khách hàng theo quy định sử dụng của thẻ).</p>
                    <h5><p><strong>3. DANH SÁCH THẺ ĐƯỢC CHẤP NHẬN THANH TOÁN TRỰC TUYẾN</strong></p></h5>
                    <p>(Cập nhật theo thông báo của nhà cung cấp dịch vụ)</p>
                    <p><strong>Thẻ quốc tế:</strong></p>
                    <p></p>
                    <p>- Visa</p>
                    <p>- MasterCard</p>
                    <p>- JCB</p>
                    <p>- American Express</p>
                    <p>- Union Pay</p>
                    <p><strong>Thẻ nội địa:</strong></p>
                    <p>- Ngân hàng Nông nghiệp và phát triển nông thôn - Agribank.</p>
                    <p>- Ngân hàng TMCP Ngoại thương Việt Nam - Vietcombank.</p>
                    <p>- Ngân hàng TMCP Tiên phong – TienphongBank.</p>
                    <p>- Ngân hàng TMCP Công thương Việt Nam - Vietinbank.</p>
                    <p>- Ngân hàng TMCP Kỹ thương Việt Nam – Techcombank.</p>
                    <h5><p><strong>4. TRƯỜNG HỢP GIAO DỊCH THANH TOÁN KHÔNG THÀNH CÔNG</strong></p></h5>
                    <p>Giao dịch thanh toán không thành công có thể do nhiều nguyên nhân. Bạn tham khảo các nguyên nhân sau:</p>
                    <p>- Chưa đăng ký chức năng thanh toán trên Internet với Ngân hàng</p>
                    <p>- Đối với thẻ Visa, MasterCard: Trong quá trình thanh toán, có thể bạn được yêu cầu nhập Mật khẩu của chương trình Verified by Visa hoặc MasterCard SecureCode... nhưng bạn đã không hoàn thành bước xác thực này.</p>
                    <p>- Thẻ không đủ hạn mức/ số dư để thanh toán. Một số Ngân hàng có quy định cả hạn mức chi tiêu theo ngày cho thẻ.</p>
                    <p>- Nhập sai thông tin thẻ.</p>
                    <p></p>
                    <p>Vui lòng liên hệ hotline 1900 6017 hoặc Ngân hàng phát hành thẻ để tìm hiểu nguyên nhân chính xác.</p>
  
                </div>

            </div>

        </div>
        <%@include file="../footer.jsp" %>
    </div>
</body>
</html>


