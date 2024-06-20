<%-- 
    Document   : contact
    Created on : Jun 17, 2024, 8:59:26 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

            .img{
                float: left;
                width: 100%;
                height: 169px;
                border-radius: 3px;
                padding: 3px

            }
            .intro{
                text-align: center;
                color: red;
                font-size: 25px;
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
                            <li style="background-color:${backgroundColorMain}">
                                <a style="color: ${colorMain}" href="contact">
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
                            </li><li style="background-color:${backgroundColorSecond}">
                                <a style="color: ${colorSecond}"
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
                    <p class="intro">Liên Hệ Với Chúng Tôi</p>
                    <p><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d39755.95530212734!2d105.54036370520225!3d21.00283487454809!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135abc60e7d3f19%3A0x2be9d7d0b5abcbf4!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBGUFQgSMOgIE7hu5lp!5e0!3m2!1svi!2s!4v1718714840136!5m2!1svi!2s" width="790" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe></p>
                    <p><h5>TRỤ SỞ CHÍNH</h5> </p>
                    <hr>
                    <p>Tầng 2, Rivera Park Saigon - Số 7/28 Thành Thái, P.14, Q.10, Thành phố Hồ Chí Minh. </p>
                    <p><h5>DỊCH VỤ KHÁCH HÀNG</h5> </p>
                    <hr>
                    <p>Hotline: 1900 6017 </p>
                    <p>Giờ làm việc: 8:00 - 22:00</p>
                    <p>Tất cả các ngày bao gồm cả Lễ Tết </p>
                    <p>Email hỗ trợ: <a href="#" style="color: red">hoidap@cgv.vn</a> </p>
                    <p><h5>LIÊN HỆ QUẢNG CÁO</h5> </p>
                    <hr>                    
                    <p>Phòng kinh doanh: +84-28-3636 57 57 </p>
                    <p>Ext: 278 (Mr. Quốc Bảo)  </p>
                    <p>Hotline: 0335400414 </p>
                    <p>Email: <a href="#" style="color: red">ad.cgv@cj.net </p>
                    <p> </p>
                    <h5><p style="color: black">LIÊN HỆ MUA VÉ NHÓM, THẺ QUÀ TẶNG, TỔ CHỨC SỰ KIỆN, THUÊ RẠP,… THAM GIA CHƯƠNG TRÌNH GIÁO DỤC CÙNG ĐIỆN ẢNH </p></h5>
                    <hr>
                    <p style="color: black">Phòng Kinh Doanh: </p>
                    <p>- Miền Bắc: <a href="#" style="color: red">Liên hệ <strong>Tại đây!</strong> </a></p>
                    <p>(Phương Mai/Nguyễn Nga) </p>
                    <p>Email: <a href="#" style="color: red">sale.cinema@banny.vn </a></p>
                    <p> </p>
                    <p>- Miền Nam: </p>
                    <p>Tele: 0906 942 227 (Ms. Hà Vy) </p>
                    <p>Email: <a href="#" style="color: red">Havy.caothi@banny.vn </a></p>
                    <p> </p>
                    <h5><p>LIÊN HỆ HỢP TÁC TRUYỀN THÔNG & TÀI TRỢ </p></h5>
                    <hr>
                    <p>Phòng truyền thông: +84-28-3636-5757 </p>
                    <p>Ext: 168 (Ms. Hạ) </p>
                    <p>Email: <a href="#" style="color: red">hadaothi@banny.vn </a></p>
                    <p> </p>
                    <h5><p>LIÊN HỆ HỢP TÁC TIẾP THỊ TRUYỀN THÔNG THƯƠNG HIỆU </p></h5>
                    <hr>
                    <p>Phòng Cinema Marketing: +84-28-3636 57 57 </p>
                    <p>Ext: 302 (Ms. Nga) </p>
                    <p>Email: <a href="#" style="color: red">NgaNguyen@banny.vn </a></p>
                    <p> </p>
                    <h5><p>VỀ CÁC RẠP CGV </p></h5>
                    <hr>
                    <p>Chi tiết về các rạp CGV (địa chỉ, giá vé), vui lòng nhấn vào <a href="#" style="color: red">đây.</a> </p>
                    <p> </p>
                    <p> </p>
                    <p> </p>
                    <p> </p>
                    <p> </p>

                </div>

            </div>

        </div>
        <%@include file="../footer.jsp" %>
    </div>
</body>
</html>
