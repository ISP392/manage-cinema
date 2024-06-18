<%-- 
    Document   : generalTerms
    Created on : Jun 18, 2024, 11:46:54 AM
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
                                    LIÊN HỆ CGV
                                </a>
                            </li>
                            <li style="background-color:${backgroundColorMain}">
                                <a style="color: ${colorMain}"
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
                    <p class="intro">ĐIỀU KHOẢN CHUNG</p>
                    <p> </p>
                    <p>Chào mừng bạn đến với <strong>website banny.vn</strong> và <strong>ứng dụng di động Banny Cinemas (“Ứng Dụng”)</strong>, 
                        được thiết lập và sở hữu bởi CÔNG TY TNHH CJ CGV VIỆT NAM (“<strong>Banny Việt Nam</strong>”, “<strong>chúng tôi</strong>”). </p>
                    <p> </p>
                    <p>Trước khi sử dụng Ứng Dụng hoặc tạo tài khoản để trải nghiệm các sản phẩm, dịch vụ do Banny Việt Nam cung cấp (“<strong>Tài Khoản</strong>”), 
                        vui lòng tham khảo và chắc chắn rằng bạn đã hiểu rõ <strong>Điều Khoản Chung</strong> để hiểu rõ quyền lợi và nghĩa vụ của mình trong tương quan với Banny Việt Nam. </p>
                    <p> </p>
                    <p>Sản phẩm và dịch vụ do BANNY Việt Nam cung cấp đến bạn bao gồm: (i) Ứng Dụng; (ii) Dịch vụ chiếu phim; (iii) Dịch vụ quảng cáo; (iv) Dịch vụ ăn uống thông qua các quầy hàng thực phẩm tại Cụm Rạp Chiếu Phim BANNY Cinemas Việt Nam; 
                        (v) Bán Phiếu Đổi Vé Xem Phim và Thẻ Quà Tặng; (vi) Các sản phẩm và dịch vụ khác tại từng thời điểm; (vi) các dịch vụ được cung cấp bởi Ứng Dụng và bởi phần mềm dành cho khách hàng của BANNY Việt Nam có sẵn trên Ứng Dụng, và tất cả các thông tin, đường dẫn, tính năng, dữ liệu, văn bản, hình ảnh, biểu đồ, âm nhạc, âm thanh, video (bao gồm cả các đoạn
                        video được đăng tải trực tiếp theo thời gian thực (livestream), tin nhắn, các tags được gắn, nội dung, chương trình, phần mềm, ứng dụng (bao gồm bất kỳ ứng dụng dịch vụ di động nào) hoặc các tài liệu khác có sẵn trên Ứng Dụng (“<strong>Nội Dung</strong>”). Bất kỳ tính năng mới nào được bổ sung hoặc mở rộng đối với sản phẩm và dịch vụ đều thuộc phạm vi điều chỉnh của Điều Khoản Chung này.<strong> ĐIỀU KHOẢN CHUNG NÀY ĐIỀU CHỈNH VIỆC BẠN SỬ DỤNG ỨNG DỤNG, SẢN PHẨM VÀ DỊCH VỤ CUNG CẤP BỞI BANNY VIỆT NAM.</strong> </p>
                    <p> </p>
                    <p>BANNY Việt Nam bảo lưu quyền thay đổi, chỉnh sửa, tạm ngưng hoặc chấm dứt tất cả hoặc bất kỳ phần nào của Ứng Dụng hoặc bất kỳ sản phẩm, dịch vụ nào được BANNY Việt Nam cung cấp vào bất cứ thời điểm nào. Phiên bản thử nghiệm hoặc tính năng thử nghiệm trên Ứng Dụng hoặc các sản phẩm, dịch vụ do BANNY Việt Nam cung cấp có thể không hoàn toàn giống với phiên bản cuối cùng. </p>
                    <p> </p>
                    <p>BANNY Việt Nam bảo lưu quyền từ chối yêu cầu mở Tài Khoản hoặc các truy cập của bạn tới Ứng Dụng theo quy định pháp luật và quy định của BANNY Việt Nam. </p>
                    <p> </p>
                    <p>BANNY Việt Nam yêu cầu trước khi trở thành Người Sử Dụng của Ứng Dụng, bạn cần đọc và chấp nhận mọi điều khoản và điều kiện được quy định trong, và dẫn chiếu đến Điều Khoản Chung được dẫn chiếu theo đây. </p>
                    <p> </p>
                    <p><strong>BẰNG VIỆC SỬ DỤNG ỨNG DỤNG, TẠO TÀI KHOẢN TẠI ỨNG DỤNG HAY THAM GIA GIAO DỊCH VỚI BANNY VIỆT NAM</strong>., BẠN ĐÃ CHẤP NHẬN VÀ ĐỒNG Ý VỚI NHỮNG ĐIỀU KHOẢN DỊCH VỤ NÀY VÀ CHÍNH SÁCH BỔ SUNG ĐƯỢC DẪN CHIẾU THEO ĐÂY. NẾU BẠN KHÔNG ĐỒNG Ý VỚI NHỮNG ĐIỀU KHOẢN CHUNG NÀY, VUI LÒNG KHÔNG SỬ DỤNG HOẶC TRUY CẬP VÀO ỨNG DỤNG HOẶC CHẤM DỨT GIAO DỊCH. </p>
                    <p> </p>
                    <p><strong>1. ĐIỀU KHOẢN CHUNG</strong> </p>
                    <p> </p>
                    <p>Khi đề cập đến Điều Khoản Chung là đề cập đến Điều Khoản Chung như quy định tại đây và </p>
                    <p> </p>
                    <p>(i) Điều Khoản Giao Dịch (truy cập tại <a href="#">Đây</a>);</p>
                    <p> </p>
                    <p>(ii) Chính Sách Thanh Toán (truy cập tại <a href="#">Đây</a>); </p>
                    <p> </p>
                    <p>(iii) Chính Sách Bảo Mật Thông Tin (truy cập tại <a href="#">Đây</a>); và </p>
                    <p> </p>
                    <p>Khi dẫn chiếu đến Điều Khoản Chung là dẫn chiếu đến toàn bộ nội dung hoặc bất kỳ phần nào của nội dung như được quy định ngay bên trên (tùy thuộc vào ngữ cảnh yêu cầu); và bất kỳ sửa đổi, bổ sung nào của nó tại từng thời điểm. </p>
                    <p> </p>
                    <p><strong>2. TUYÊN BỐ MIỄN TRỪ TRÁCH NHIỆM TỪ NGƯỜI SỬ DỤNG</strong> </p>
                    <p> </p>
                    <p>Khi truy cập vào Ứng Dụng, Người Sử Dụng đồng ý chấp nhận mọi rủi ro. BANNY Việt Nam và các bên đối tác khác không chịu trách nhiệm về bất kỳ tổn thất nào do những hậu quả trực tiếp, tình cờ hay gián tiếp; những thất thoát, chi phí (bao gồm chi phí pháp lý, chi phí tư vấn hoặc các khoản chi tiêu khác) có thể phát sinh trực tiếp hoặc gián tiếp do việc truy cập Ứng Dụng hoặc khi tải dữ liệu về thiết bị cá nhân; những tổn hại gặp phải do virus; hành động phá hoại trực tiếp hay gián tiếp của hệ thống máy tính khác; đường dây điện thoại; phần cứng, phần mềm, lỗi chương trình; các phần mềm gián điệp; các phần mềm thu thập thông tin không hợp pháp; các hành vi tấn công mạng có chủ đích nhằm vào BANNY Việt Nam hay bất kỳ chủ thể nào được thực hiện thông
                        qua Ứng Dụng hoặc mạng máy tính; hoặc bất kì các lỗi nào khác; đường truyền dẫn của máy tính hoặc nối kết mạng bị chậm; và các vấn đề có tính chất tương tự. </p>
                    <p> </p>
                    <p><strong>3. NỘI DUNG TRÊN ỨNG DỤNG</strong> </p>
                    <p> </p>
                    <p>Tất cả những thông tin ở đây được cung cấp cho bạn một cách trung thực như bản thân sự việc. BANNY Việt Nam và các bên liên quan không bảo đảm, hay có bất kỳ tuyên bố nào liên quan đến tính chính xác, tin cậy của việc sử dụng hay kết quả của việc sử dụng nội dung trên Ứng Dụng này. Nội Dung trên Ứng Dụng được cung cấp vì lợi ích của cộng đồng và có tính phi thương mại. Các cá nhân và tổ chức không được phép sử dụng nội dung trên Ứng Dụng này với mục đích thương mại mà không có sự đồng thuận của BANNY Việt Nam bằng văn bản. Mặc dù BANNY Việt Nam luôn cố gắng cập nhật thường xuyên các Nội Dung tại Ứng Dụng, BANNY Việt Nam không bảo đảm rằng các thông tin đó là mới nhất, chính xác hay đầy đủ. Tất cả các Nội Dung trên Ứng Dụng có thể được thay đổi bất kỳ lúc nào. </p>
                    <p> </p>
                    <p><strong>4. QUYỀN SỞ HỮU TRÍ TUỆ</strong> </p>
                    <p> </p>
                    <p><strong>Đối với Ứng Dụng</strong> : BANNY Việt Nam là chủ sở hữu và là bên có quyền sở hữu trí tuệ phát sinh từ và/hoặc liên quan đến Ứng Dụng;</p>
                    <p><strong>Đối với Nội Dung đăng tải trên Ứng Dụng</strong> : BANNY Việt Nam và là bên có quyền sở hữu trí tuệ phát sinh từ và/hoặc liên quan đến Nội Dung đăng tải tại Ứng Dụng, hoặc được cấp quyền sử dụng hợp pháp đối với Nội Dung đăng tải tại Ứng Dụng.</p>
                    <p> </p>
                    <p>Việc chỉnh sửa trang, nội dung, và sắp xếp thuộc về thẩm quyền tuyệt đối và duy nhất của BANNY Việt Nam. Sự chỉnh sửa, thay đổi, phân phối hoặc tái sử dụng những Nội Dung trong Ứng Dụng này vì bất kì mục đích nào khác được xem như vi phạm quyền lợi hợp pháp của BANNY Việt Nam. </p>
                    <p> </p>
                    <p><strong>5. SỬ DỤNG THÔNG TIN</strong> </p>
                    <p> </p>
                    <p>5.1. BANNY Việt Nam sẽ không sử dụng thông tin cá nhân của Người Sử Dụng trên Ứng Dụng nếu không được phép. Nếu Người Sử Dụng đồng ý cung cấp thông tin cá nhân, thông tin này sẽ được bảo vệ và xử lý theo quy định pháp luật, Chính Sách Bảo Mật Thông Tin. Thông tin của Người Sử Dụng sẽ được sử dụng phù hợp với mục đích Xử Lý Dữ Liệu Cá Nhân như quy định tại Chính Sách Bảo Mật Thông Tin. Thông tin cá nhân của Người Sử Dụng sẽ không được gửi cho bất kỳ bên thứ ba nào, ngoại trừ BANNY Việt Nam, Công ty mẹ, Công ty liên quan, Công ty liên kết, các Công ty con của BANNY Việt Nam và những mở rộng cần thiết để Người Sử Dụng có thể tham gia vào Ứng Dụng (những nhà cung cấp dịch vụ, đối tác, các công ty quảng cáo, các bên thứ ba bất kỳ mà việc sử dụng thông tin là cần thiết để duy trì tính ổn định và liên tục của Ứng Dụng và bất kỳ sản phẩm, dịch vụ nào được BANNY Việt Nam cung cấp) và yêu cầu cung cấp bởi luật pháp (“Bên Nhận Được Cấp Quyền”). </p>
                    <p> </p>
                    <p>5.2. Nếu BANNY Việt Nam chia sẻ thông tin cá nhân của Người Sử Dụng cho Bên Nhận Được Cấp Quyền, thì BANNY Việt Nam cũng yêu cầu họ bảo vệ thông tin cá nhân của Người Sử Dụng ở mức độ tối thiểu như cách BANNY Việt Nam thực hiện. Khoản này không áp dụng trong trường hợp BANNY Việt Nam cung cấp thông tin cá nhân của Người Sử Dụng cho Cơ quan Nhà nước có thẩm quyền theo yêu cầu của những cơ quan này. </p>
                    <p> </p>
                    <p>5.3. BANNY Việt Nam <strong>CAM KẾT KHÔNG THAM GIA VÀO</strong> các giao dịch bán, chuyển nhượng, chuyển giao, trao đổi để nhận lại lợi ích khác, hoặc thực hiện các hành vi nhằm chuyển quyền sở hữu thông tin cá nhân của Người Sử Dụng trong mọi trường hợp. </p>
                    <p> </p>
                    <p><strong>6. TẢI DỮ LIỆU</strong> </p>
                    <p> </p>
                    <p>Nếu Người Sử Dụng tải về thiết bị cá nhân những Nội Dung từ Ứng Dụng, thì Nội Dung tải về vẫn thuộc quyền sở hữu hoặc quyền sử dụng hợp pháp của BANNY Việt Nam và BANNY Việt Nam cấp cho Người Sử Dụng quyền sử dụng không độc quyền và có thể hủy ngang tại bất kỳ thời điểm nào. Dù cho có bất kỳ nội dung nào hay điều khoản nào từ Điều Khoản Chung quy định trái ngược lại, <strong>KHÔNG CÓ BẤT KỲ ĐIỀU KHOẢN NÀO THỂ HIỆN RẰNG</strong> BANNY Việt Nam đồng ý chuyển giao quyền sở hữu (bao gồm Quyền Sở Hữu Trí Tuệ) của Nội Dung do Người Sử Dụng tải về. Người Sử Dụng không được phép bán, chuyển nhượng, phân phối, phân phối lại, bẻ khóa, mã hóa, phát triển, mở rộng, dịch ngược mã, giải mã, hoặc thực hiện bất kỳ hành vi nào khác đối với Nội Dung được tải về mà không có sự đồng ý của BANNY Việt Nam. </p>
                    <p> </p>
                    <p>Mọi hành động vi phạm Điều này là xâm phạm quyền sở hữu và quyền sở hữu trí tuệ của BANNY Việt Nam và Người Sử Dụng đồng ý rằng hành vi vi phạm các quy định này không thể được bồi thường một cách thỏa đáng và toàn bộ bằng vật chất và vì vậy, BANNY Việt Nam và bất kỳ bên có liên quan nào được quyền, ngoài bất kỳ quyền hoặc biện pháp khắc phục khác có sẵn theo Điều Khoản Chung hoặc theo pháp luật, khắc phục một cách hợp lý bao gồm một lệnh cấm hành vi vi phạm hoặc đe dọa vi phạm và/hoặc việc thực hiện cụ thể bất kỳ quy định nào của Điều Khoản Chung này.</p>
                    <p> </p>
                    <p><strong>7. THAY ĐỔI NỘI DUNG</strong> </p>
                    <p> </p>
                    <p>BANNY Việt Nam giữ quyền thay đổi, chỉnh sửa và loại bỏ những thông tin hợp pháp vào bất kỳ thời điểm nào vì bất kỳ lý do nào. Các thay đổi có hiệu lực ngay khi được đăng trên Ứng Dụng mà không cần thông báo trước. Và khi Người Sử Dụng tiếp tục sử dụng Ứng Dụng sau khi các thay đổi này được đăng tải, có nghĩa là Người Sử Dụng chấp nhận với những thay đổi đó. Người Sử Dụng vui lòng kiểm tra thường xuyên để cập nhật những thay đổi của BANNY Việt Nam. </p>
                    <p> </p>
                    <p><strong>8. LIÊN KẾT VỚI CÁC TRANG KHÁC</strong> </p>
                    <p> </p>
                    <p>Mặc dù Ứng Dụng này có thể được liên kết với những trang khác, BANNY Việt Nam không trực tiếp hoặc gián tiếp tán thành, tổ chức, tài trợ, đứng sau hoặc sáp nhập với những trang đó, trừ khi điều này được tuyên bố một cách minh thị và rõ ràng. Khi truy cập vào trang web liên kết, Người Sử Dụng chấp nhận rằng BANNY Việt Nam không thể kiểm soát tất cả những trang liên kết với Ứng Dụng và cũng không chịu trách nhiệm cho nội dung của những trang liên kết. </p>
                    <p> </p>
                    <p><strong>9. ĐƯA THÔNG TIN LÊN ỨNG DỤNG</strong> </p>
                    <p> </p>
                    <p>Người Sử Dụng không được cấp quyền để đưa bất kỳ thông tin, hoặc chuyển tải lên Ứng Dụng bất kỳ thông tin nào; bao gồm nhưng không giới hạn tất cả những hình ảnh, từ ngữ khiêu dâm, thô tục, xúc phạm, phỉ báng, bôi nhọ, đe dọa, những thông tin không hợp pháp hoặc những thông tin có thể đưa đến việc vi phạm pháp luật, trách nhiệm pháp lý. </p>
                    <p> </p>
                    <p>BANNY Việt Nam và tất cả các bên có liên quan đến việc xây dựng và quản lý Ứng Dụng không chịu trách nhiệm hoặc có nghĩa vụ pháp lý đối với những phát sinh từ nội dung do Người Sử Dụng tải lên Ứng Dụng. </p>
                    <p> </p>
                    <p><strong>10. LUẬT ÁP DỤNG</strong> </p>
                    <p> </p>
                    <p>Điều Khoản Chung sẽ được điều chỉnh bởi và diễn giải theo luật pháp của Việt Nam. </p>
                    <p> </p>
                    <p>Bất kỳ tranh chấp, khiếu nại hoặc sự bất đồng dưới bất cứ hình thức nào phát sinh từ hoặc liên quan đến các Điều Khoản Chung này, chống lại hoặc liên quan đến BANNY Việt Nam hoặc bất kỳ Bên Được Bồi Thường nào thuộc đối tượng của Điều Khoản Chung sẽ được giải quyết bằng Tòa án có thẩm quyền tại Thành phố Hồ Chí Minh. </p>
                    <p> </p>
                    <p><strong>11. TÍNH RIÊNG LẺ</strong> </p>
                    <p> </p>
                    <p>Nếu bất kì điều khoản nào trong Điều Khoản Chung này không hợp pháp, bị bãi bỏ, hoặc vì bất kỳ lý do nào không thể thực thi theo pháp luật, thì điều khoản đó sẽ được tách ra khỏi các điều khoản và điều kiện này và sẽ không ảnh hưởng tới hiệu lực cũng như tính thi hành của bất kỳ điều khoản còn lại nào cũng như không ảnh hưởng tới hiệu lực cũng như tính thi hành của điều khoản sẽ được xem xét theo luật. </p>
                    <p> </p>
                    <p><strong>12. BỒI THƯỜNG</strong> </p>
                    <p> </p>
                    <p>Người Sử Dụng đồng ý bồi thường, bảo vệ và không gây hại cho BANNY Việt Nam, các thành viên, cổ đông, công ty con, công ty liên kết, giám đốc, viên chức, đại lý, đồng sở hữu thương hiệu hoặc đối tác, và nhân viên của BANNY Việt Nam (gọi chung là “<strong>Bên Được Bồi Thường</strong>”) liên quan đến khiếu nại, hành động, thủ tục tố tụng, và các vụ kiện cũng như nghĩa vụ, tổn thất, thanh toán, khoản phạt, tiền phạt, chi phí và phí tổn có liên quan (bao gồm chi phí giải quyết tranh chấp) do Bên Được Bồi Thường gánh chịu, phát sinh từ (a) giao dịch được thực hiện trên Ứng Dụng, hoặc tranh chấp liên quan đến giao dịch đó (trừ trường hợp BANNY Việt Nam hoặc các công ty liên kết của BANNY Việt Nam là Người Bán đối với giao dịch liên quan đến khiếu nại), (b) các chính sách, quy định và bảo đảm của BANNY Việt Nam, (c) việc tổ chức, hoạt động, quản trị và/hoặc điều hành các được thực hiện bởi hoặc đại diện cho BANNY Việt Nam, (d) vi phạm hoặc không tuân thủ bất kỳ điều khoản nào trong các Điều Khoản Chung này hoặc bất kỳ chính sách hoặc hướng dẫn nào được tham chiếu theo đây, (e) việc Người Sử Dụng sử dụng hoặc sử dụng không đúng sản phẩm, dịch vụ, hoặc (f) vi phạm của Người Sử Dụng đối với bất kỳ luật hoặc bất kỳ các quyền của bên thứ ba nào, hoặc (g) bất kỳ Nội Dung nào được đăng tải bởi Người Sử Dụng. </p>
                    <p> </p>
                    <p><strong>13. LOẠI TRỪ TRÁCH NHIỆM VÀ GIỚI HẠN TRÁCH NHIỆM</strong> </p>
                    <p> </p>
                    <p>13.1. DỊCH VỤ ĐƯỢC CUNG CẤP NHƯ ‘SẴN CÓ’ VÀ KHÔNG CÓ BẤT KỲ SỰ ĐẢM BẢO, KHIẾU NẠI HOẶC KHẲNG ĐỊNH NÀO TỪ BANNY VIỆT NAM VỀ BẤT KỲ NỘI DUNG NÀO ĐƯỢC THỂ HIỆN, NGỤ Ý HOẶC BẮT BUỘC ĐỐI VỚI DỊCH VỤ, BAO GỒM VIỆC ĐẢM BẢO VỀ CHẤT LƯỢNG, VIỆC THỰC HIỆN, KHÔNG VI PHẠM, VIỆC MUA BÁN, HAY SỰ PHÙ HỢP CHO MỘT MỤC ĐÍCH CỤ THỂ, CŨNG NHƯ KHÔNG CÓ BẤT KỲ SỰ ĐẢM BẢO NÀO ĐƯỢC TẠO RA TRONG QUÁ TRÌNH GIAO DỊCH, THỰC HIỆN, MUA BÁN HOẶC SỬ DỤNG SẢN PHẨM SAU KHI MUA. </p>
                    <p> </p>
                    <p>13.2. NGƯỜI SỬ DỤNG THỪA NHẬN RẰNG MỌI RỦI RO PHÁT SINH NGOÀI VIỆC SỬ DỤNG HOẶC VẬN HÀNH CỦA ỨNG DỤNG SẼ THUỘC VỀ NGƯỜI SỬ DỤNG TRONG GIỚI HẠN TỐI ĐA PHÁP LUẬT CHO PHÉP. </p>
                    <p> </p>
                    <p>13.3 BANNY VIỆT NAM KHÔNG KIỂM SOÁT VÀ KHÔNG ĐẢM BẢO HOẶC CHẤP NHẬN TRÁCH NHIỆM ĐỐI VỚI CÁC TRANH CHẤP LIÊN QUAN ĐẾN MỘT HOẶC NHIỀU NGƯỜI SỬ DỤNG, NGƯỜI SỬ DỤNG ĐỒNG Ý TỰ GIẢI QUYẾT TRANH CHẤP TRỰC TIẾP VỚI NHAU VÀ MIỄN TRỪ BANNY VIỆT NAM KHỎI KHIẾU NẠI, YÊU CẦU VÀ TỔN THẤT PHÁT SINH HOẶC LIÊN QUAN ĐẾN TRANH CHẤP. </p>
                    <p> </p>
                    <p>13.4 BANNY VIỆT NAM KHÔNG CHỊU TRÁCH NHIỆM PHÁT SINH TỪ </p>
                    <p> </p>
                    <p>(I) TỔN THẤT VỀ SỬ DỤNG; TỔN THẤT VỀ LỢI NHUẬN; TỔN THẤT VỀ DOANH THU; TỔN THẤT VỀ DỮ LIỆU; TỔN THẤT VỀ UY TÍN; HOẶC KHÔNG THỰC HIỆN ĐƯỢC CÁC BIỆN PHÁP NGUY CẤP DỰ TRÙ, ĐỐI VỚI TỪNG TRƯỜNG HỢP DÙ TRỰC TIẾP HOẶC GIÁN TIẾP; HOẶC </p>
                    <p> </p>
                    <p>(II) THIỆT HẠI GIÁN TIẾP, NGẪU NHIÊN, ĐẶC BIỆT HOẶC MANG TÍNH HỆ QUẢ NÀO (GỒM BẤT KỲ MẤT MÁT NÀO VỀ DỮ LIỆU, GIÁN ĐOẠN DỊCH VỤ, MÁY TÍNH, ĐIỆN THOẠI HOẶC CÁC THIẾT BỊ DI ĐỘNG KHÁC) PHÁT SINH TỪ HOẶC LIÊN QUAN ĐẾN VIỆC SỬ DỤNG ỨNG DỤNG HOẶC DỊCH VỤ, BAO GỒM THIỆT HẠI PHÁT SINH TỪ ĐÓ, NGAY CẢ KHI BANNY VIỆT NAM ĐÃ ĐƯỢC THÔNG BÁO VỀ KHẢ NĂNG CỦA CÁC THIỆT HẠI ĐÓ HOẶC ĐƯỢC GỢI Ý PHẢI CHỊU TRÁCH NHIỆM. </p>
                    <p> </p>
                    <p>13.5 NGƯỜI SỬ DỤNG CÓ QUYỀN YÊU CẦU CHẤM DỨT TÀI KHOẢN CỦA NGƯỜI SỬ DỤNG VÀ/HOẶC DỪNG SỬ DỤNG DỊCH VỤ TRONG TRƯỜNG HỢP KHÔNG THỎA MÃN VỚI DỊCH VỤ. </p>
                    <p> </p>
                    <p>13.6 TRƯỜNG HỢP BANNY VIỆT NAM, THEO PHÁN QUYẾT CỦA TÒA ÁN CÓ THẨM QUYỀN, PHẢI CHỊU TRÁCH NHIỆM TRONG GIỚI HẠN TỐI ĐA PHÁP LUẬT CHO PHÉP (BAO GỒM ĐỐI VỚI LỖI BẤT CẨN KHÔNG ĐÁNG KỂ) THÌ TRÁCH NHIỆM CỦA BANNY VIỆT NAM ĐỐI VỚI NGƯỜI SỬ DỤNG HOẶC BẤT KỲ BÊN THỨ BA NÀO CHỈ GIỚI HẠN TRONG MỨC THẤP HƠN GIỮA (A) GIÁ TRỊ CỦA (05) GIAO DỊCH GẦN NHẤT VỚI CGV VIỆT NAM CỦA NGƯỜI SỬ DỤNG; HOẶC (B) KHOẢN TIỀN KHÁC NHƯ XÁC ĐỊNH CỤ THỂ TRONG PHÁN QUYẾT CHUNG THẨM CỦA TÒA ÁN CÓ THẨM QUYỀN. </p>
                  
                </div>

            </div>

        </div>
        <%@include file="../footer.jsp" %>
    </div>
</body>
</html>

