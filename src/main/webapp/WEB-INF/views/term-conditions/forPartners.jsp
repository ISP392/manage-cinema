<%-- 
    Document   : forPartners
    Created on : Jun 18, 2024, 4:09:36 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

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
                            </li><li style="background-color:${backgroundColorMain}">
                                <a style="color: ${colorMain}"
                                   href="forPartners">
                                    DÀNH CHO ĐỐI TÁC
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="dashboard" style="font-size: 15px">
                    <p></p>
                    <p></p>

                    <p><strong>Kính gửi Quý Đối Tác,</strong></p>
                    <p></p>
                    <p>Đầu tiên, chúng tôi đánh giá cao vai trò của Quý Đối Tác trong việc cung cấp các sản phẩm và dịch vụ chất lượng cao với giá cả phải chăng. Vai trò của Quý Đối Tác rất quan trọng đối với sự thành công của chúng tôi trong việc hoàn thành các mục tiêu kinh doanh.</p>
                    <p>Để giữ vững vị thế là doanh nghiệp hàng đầu trong ngành điện ảnh Việt Nam, CJ BANNY không chỉ chú trọng đến dịch vụ đẳng cấp mà còn cam kết tuân thủ mọi luật lệ và quy định hiện hành của Việt Nam cũng như Giá trị cốt lõi của chúng tôi. Để đạt được điều đó, chúng tôi kỳ vọng rằng Quý Đối Tác sẵn sàng duy trì các Giá trị cốt lõi của chúng tôi về đạo đức và tính chính trực. CJ BANNY đã xây dựng Bộ Quy tắc Ứng xử dành cho Nhà Cung Cấp để trình bày rõ những kỳ vọng của chúng tôi về sự liêm chính trong kinh doanh, quyền lợi người lao động, sức khỏe và an toàn, và quản lý môi trường. Chúng tôi mong muốn Quý Đối Tác đáp ứng các tiêu chuẩn và thúc đẩy các nguyên tắc được nêu trong Bộ quy tắc này, nhằm thúc đẩy cam kết của CJ BANNY Việt Nam đối với tất cả các khía cạnh về tính bền vững</p>
                    <p>Nếu Quý Đối Tác có bất kỳ thắc mắc nào về các vấn đề đạo đức hoặc phát hiện hành vi vi phạm Quy tắc Ứng xử, vui lòng liên hệ ngay với chúng tôi thông qua bất kỳ phương thức nào sau đây</p>
                    <p>- Email: ksnb@cgv.vn</p>
                    <p>- Gửi thư đến : Phòng kiểm soát nội bộ – Công ty TNHH BANNY Việt Nam</p>
                    <p>Lầu 02, Tòa nhà Rivera Park Saigon, Số 7/28 Thành Thái, Quận 10, Thành phố Hồ Chí Minh, Việt Nam</p>
                    <p>Chúng tôi trân trọng chuyên môn, sản phẩm và dịch vụ mà Quý Đối Tác đã cung cấp đến BANNY. Cảm ơn Quý Đối Tác vì những nỗ lực trong việc đáp ứng các yêu cầu kinh doanh của chúng tôi với sự chính trực không khoan nhượng</p>
                    <p></p>
                    <p>Xin vui lòng tham khảo Bộ Quy tắc Ứng xử dành cho Nhà Cung Cấp dưới đây (file đính kèm):</p>
                    <p></p>
                    <p><strong><a href="#" style="color: red">- BANNY-Letter to Suppliers (E-V)</a></strong></p>
                    <p><strong><a href="#" style="color: red">- BANNY-Supplier Code of conduct-EN version</a></strong></p>
                    <p><strong><a href="#" style="color: red">- BANNY-Supplier Code of conduct-VN version</a></strong></p>


                </div>

            </div>

        </div>
        <%@include file="../footer.jsp" %>
    </div>
</body>
</html>



