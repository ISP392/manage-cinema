<%-- 
    Document   : securityPolicy
    Created on : Jun 18, 2024, 2:52:06 PM
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
                            </li><li style="background-color:${backgroundColorSecond}">
                                <a style="color: ${colorSecond}"
                                   href="paymentPolicy">
                                    CHÍNH SÁCH THANH TOÁN
                                </a>
                            </li><li style="background-color:${backgroundColorMain}">
                                <a style="color: ${colorMain}"
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
                    <p class="intro">CHÍNH SÁCH BẢO MẬT THÔNG TIN CÁ NHÂN KHÁCH HÀNG</p>
                    <p> </p>
                    <p> </p>
                    <p>Chào mừng bạn đến với<strong> CÔNG TY TNHH BANNY VIỆT NAM</strong></p>
                    <p>Chúng tôi, <strong>CÔNG TY TNHH BANNY VIỆT NAM</strong>, địa chỉ trụ sở chính tại Lầu 2, số 7/28, đường Thành Thái, Phường 14, Quận 10, Thành phố Hồ Chí Minh, Việt Nam (“<strong>BANNY Việt Nam</strong>”), đơn vị sở hữu và vận hành website cgv.vn và ứng dụng di động BANNY Cinemas (“<strong>Ứng Dụng</strong>”), luôn xem trọng sự riêng tư và bảo vệ dữ liệu cá nhân của bạn.</p>
                    <p>BANNY Việt Nam hiểu rằng, bạn cần được biết một cách minh bạch những thông tin dưới đây liên quan đến toàn bộ cách thức BANNY Việt Nam xử lý và bảo vệ dữ liệu cá nhân của bạn trong khuôn khổ pháp luật cũng như chuẩn mực bảo mật tại BANNY Việt Nam. BANNY Việt Nam cũng sẽ thông tin đến bạn các quyền lợi hợp pháp của bạn, và làm thế nào bạn có thể liên lạc với BANNY Việt Nam.</p>
                    <p>Khi BANNY Việt Nam sử dụng từ “Người Sử Dụng” có nghĩa là BANNY Việt Nam muốn đề cập đến người đăng ký tài khoản thành công với BANNY Việt Nam để sử dụng các Dịch Vụ hoặc Ứng Dụng.</p>
                    <p>Khi nói về “Dữ Liệu Cá Nhân”, “dữ liệu cá nhân”, có nghĩa là BANNY Việt Nam muốn đề cập đến thông tin dưới dạng ký hiệu, chữ viết, chữ số, hình ảnh, âm thanh hoặc dạng tương tự trên môi trường điện tử gắn liền với Người Sử Dụng hoặc giúp xác định Người Sử Dụng, ví dụ: họ, tên, ngày, tháng, năm sinh, thông tin liên lạc.</p>
                    <p>Chúng tôi xử lý dữ liệu cá nhân từ bạn với mục đích đúng đắn, tuân thủ yêu cầu của pháp luật hay các mục đích khác được nêu tại Chính Sách Bảo Mật Thông Tin này.</p>
                    <p><strong>TRONG TRƯỜNG HỢP BẠN KHÔNG THỂ CUNG CẤP DỮ LIỆU CÁ NHÂN CẦN THIẾT ĐỂ BANNY VIỆT NAM CÓ THỂ CUNG CẤP SẢN PHẨM VÀ/HOẶC DỊCH VỤ CỦA CHÚNG TÔI CHO BẠN, RẤT TIẾC LÀ BANNY VIỆT NAM CŨNG SẼ KHÔNG THỂ CUNG CẤP CHO BẠN CÁC SẢN PHẨM VÀ/HOẶC DỊCH VỤ ĐÓ.</strong></p>
                    <p>Bằng việc sử dụng các Dịch Vụ, đăng ký một tài khoản với BANNY Việt Nam hoặc truy cập Ứng Dụng, <strong>BẠN XÁC NHẬN VÀ ĐỒNG Ý RẰNG</strong> bạn chấp nhận các phương pháp, yêu cầu, và/hoặc chính sách được mô tả trong Chính Sách Bảo Mật Thông Tin này, và theo đây bạn xác nhận <strong>BẠN ĐÃ BIẾT RÕ VÀ ĐỒNG Ý TOÀN BỘ </strong>cho phép BANNY Việt Nam thu thập, sử dụng, tiết lộ và/hoặc xử lý dữ liệu cá nhân của bạn như mô tả trong đây. <strong>NẾU BẠN KHÔNG ĐỒNG Ý CHO PHÉP XỬ LÝ DỮ LIỆU CÁ NHÂN CỦA BẠN NHƯ MÔ TẢ TRONG CHÍNH SÁCH BẢO MẬT THÔNG TIN NÀY, VUI LÒNG KHÔNG SỬ DỤNG CÁC DỊCH VỤ CỦA CHÚNG TÔI HAY TRUY CẬP ỨNG DỤNG CỦA BANNY VIỆT NAM</strong>>.</p>
                    <p>Nếu BANNY Việt Nam thay đổi Chính Sách Bảo Mật Thông Tin, BANNY Việt Nam sẽ thông báo cho bạn bao gồm cả thông qua việc đăng tải những thay đổi đó hoặc Chính Sách Bảo Mật Thông Tin sửa đổi trên Ứng Dụng. Trong phạm vi pháp luật cho phép, việc tiếp tục sử dụng các Dịch Vụ hoặc Ứng Dụng, bao gồm giao dịch của bạn, <strong>ĐƯỢC XEM LÀ BẠN ĐÃ CÔNG NHẬN VÀ ĐỒNG Ý VỚI CÁC THAY ĐỔI TRONG CHÍNH SÁCH BẢO MẬT THÔNG TIN NÀY</strong>.</p>
                    <h5><p><strong>1. CÁC LOẠI DỮ LIỆU CÁ NHÂN MÀ BANNY VIỆT NAM SẼ THU THẬP VÀ XỬ LÝ</strong></p></h5>
                    <p>Khi bạn (1) truy cập, liên hệ thông qua Ứng Dụng hoặc các kênh liên hệ/thông tin chính thức khác của BANNY Việt Nam; (2) tham gia vào các chương trình khuyến mại, quảng cáo, marketing và các hình thức xúc tiến thương mại khác của BANNY Việt Nam; (3) sử dụng Dịch Vụ thông qua Ứng Dụng, các Cụm Rạp Chiếu Phim BANNY Cinemas; (4) cung cấp Dữ Liệu Cá Nhân cho BANNY Việt Nam thông qua đăng ký thành viên; (5) gửi bất kỳ biểu mẫu nào, bao gồm đơn đăng ký hoặc các mẫu đơn khác liên quan đến bất kỳ sản phẩm và dịch vụ nào của BANNY Việt Nam, bằng hình thức trực tuyến hay dưới hình thức khác; (6) ký kết bất kỳ thỏa thuận nào hoặc cung cấp các tài liệu hoặc thông tin khác liên quan đến tương tác giữa bạn với BANNY Việt Nam, hoặc khi bạn sử dụng các sản phẩm và dịch vụ của BANNY Việt Nam; (7) sử dụng các dịch vụ điện tử của BANNY Việt Nam, hoặc tương tác với BANNY Việt Nam qua Ứng Dụng hoặc Các Dịch Vụ của chúng tôi. Trường hợp này bao gồm thông qua tập tin cookie mà BANNY Việt Nam có thể triển khai khi bạn tương tác với các Ứng Dụng; (8) cấp quyền trên thiết bị của bạn để chia sẻ thông tin với Ứng Dụng; (9) liên kết tài khoản BANNY Việt Nam với tài khoản mạng xã hội của bạn hoặc các tài khoản bên ngoài khác hoặc sử dụng các tính năng mạng xã hội khác, phù hợp với các chính sách của nhà cung cấp; (10) cung cấp ý kiến phản hồi hoặc gửi khiếu nại cho chúng tôi; (11) gửi dữ liệu cá nhân của bạn cho chúng tôi vì bất kỳ lý do gì; (12) thực hiện các hoạt động khác trên Ứng Dụng của chúng tôi; (13) cung cấp Dữ Liệu Cá Nhân cho BANNY Việt Nam thông qua các hình thức khác, tùy từng thời điểm; BANNY Việt Nam sẽ thu thập và xử lý các Dữ Liệu Cá Nhân bao gồm:</p>
                    <p>(i) Họ và tên; Ngày tháng năm sinh; Số điện thoại; Thư điện tử (email)</p>
                    <p>(ii) Giới tính;</p>
                    <p>(iii) Quốc tịch;</p>
                    <p>(iv) Địa chỉ thanh toán, địa chỉ giao nhận sản phẩm;</p>
                    <p>(v) Tài khoản Ngân hàng, thông tin thanh toán;</p>
                    <p>(vi) Thông tin được gửi bởi hoặc liên quan đến (các) thiết bị được sử dụng để truy cập vào Các Dịch vụ hoặc Ứng Dụng;</p>
                    <p>(vii) Thông tin về mạng, bao gồm danh sách liên hệ của bạn khi đồng ý chia sẻ trên thiết bị của bạn, và những người và tài khoản mà bạn có tương tác;</p>
                    <p>(viii) Hình ảnh hoặc âm thanh hoặc video;</p>
                    <p>(ix) Dữ liệu truyền thông hoặc liên lạc, ví dụ như các tùy chọn nhận thông tin quảng cáo từ chúng tôi hoặc các bên thứ ba của bạn, tùy chọn phương tiện liên lạc và lịch sử thông tin liên lạc với chúng tôi, các nhà cung cấp dịch vụ của chúng tôi, và các bên thứ ba khác;</p>
                    <p>(x) Thông tin sử dụng và giao dịch, bao gồm chi tiết về lịch sử tìm kiếm, giao dịch, quảng cáo và nội dung hiển thị mà tương tác với Nền Tảng, cũng như các sản phẩm và dịch vụ có liên quan của bạn;</p>
                    <p>(xi) Dữ liệu về địa điểm;</p>
                    <p>(xii) Dữ liệu tổng hợp về nội dung người dùng sử dụng.</p>
                    <p>Một số dữ liệu cá nhân mà BANNY Việt Nam thu thập, xử lý có thể là dữ liệu cá nhân cơ bản hoặc nhạy cảm theo quy định pháp luật hay đặc tính tự nhiên. Đối với dữ liệu cá nhân nhạy cảm, BANNY Việt Nam sẽ xử lý theo quy trình xử lý dữ liệu cá nhân nhạy cảm.</p>
                    <p>Nếu bạn đăng nhập để trở thành Người Sử Dụng các Ứng Dụng của chúng tôi bằng cách sử dụng tài khoản mạng xã hội của Bạn (“<strong>Tài khoản Mạng Xã hội</strong>”), liên kết tài khoản của bạn với Tài khoản Mạng Xã hội của bạn, BANNY Việt Nam có quyền truy cập thông tin về bạn mà bạn đã cung cấp một cách tự nguyên cho nhà cung cấp dịch vụ Tài khoản Mạng Xã hội của bạn tuân theo các chính sách của các nhà cung cấp dịch vụ này, và BANNY Việt Nam sẽ quản lý, xử lý và sử dụng các dữ liệu cá nhân này của bạn theo các quy định của Chính Sách Bảo Mật Thông Tin này tại mọi thời điểm.</p>
                    <h5><p><strong>2. THU THẬP DỮ LIỆU KHÁC</strong></p></h5>
                    <p>2.1 Như với hầu hết các trang web và các ứng dụng di động khác, thiết bị của bạn gửi thông tin có thể gồm có dữ liệu về bạn, được một máy chủ web ghi lại khi bạn sử dụng Ứng Dụng. Thông tin này thông thường bao gồm nhưng không giới hạn địa chỉ IP, hệ điều hành của máy tính/thiết bị di động, loại trình duyệt, loại thiết bị di động, các đặc điểm của thiết bị di động, mã định danh thiết bị thống nhất (UDID) hoặc mã định danh thiết bị di động (MEID) của thiết bị di động của bạn, địa chỉ tham chiếu của trang web (nếu có), các trang mà bạn đã truy cập đến trên trang web hoặc ứng dụng di động của BANNY Việt Nam và thời gian truy cập và đôi khi là "cookie" (có thể vô hiệu hóa bằng cách sử dụng tùy chọn trình duyệt của bạn) để giúp trang web ghi nhớ lần truy cập cuối cùng của bạn. Nếu bạn đăng nhập, thông tin này được liên kết với tài khoản cá nhân của bạn. Thông tin này cũng được đưa vào các số liệu thống kê ẩn danh để giúp BANNY Việt Nam hiểu được khách truy cập sử dụng Ứng Dụng của chúng tôi như thế nào.</p>
                    <p>2.2 Các ứng dụng di động của BANNY Việt Nam có thể thu thập thông tin chính xác về địa chỉ của thiết bị di động của bạn sử dụng các công nghệ như GPS, Wi-Fi,…. BANNY Việt Nam thu thập, sử dụng, công bố và/hoặc xử lý các thông tin này cho một hoặc nhiều mục đích bao gồm nhưng không giới hạn các dịch vụ được cung cấp dựa trên vị trí mà bạn yêu cầu hoặc chuyển các nội dung có liên quan đến bạn dựa trên vị trí của bạn hoặc cho phép bạn chia sẻ vị trí của bạn cho các Người sử dụng khác như là một phần của các Dịch vụ được cung cấp bởi các ứng dụng di động của BANNY Việt Nam. Đối với phần lớn các thiết bị di động, bạn có thể rút lại sự cho phép để chúng tôi được thu thập các thông tin này dựa trên vị trí của bạn thông qua các cài đặt trên thiết bị. Nếu bạn có câu hỏi nào về cách thức vô hiệu hóa các dịch vụ vị trí trên thiết bị di động của bạn, vui lòng liên hệ với các nhà cung cấp dịch vụ thiết bị di động hoặc nhà sản xuất thiết bị của bạn.</p>
                    <p>2.3. Như khi bạn xem các trang trên trang web hoặc ứng dụng di động của chúng tôi, khi bạn xem các nội dung và quảng cáo và truy cập vào phần mềm khác trên Ứng Dụng hoặc thông qua Dịch Vụ, các thông tin có thể được gửi đến cho BANNY Việt Nam (bao gồm nhưng không giới hạn, địa chỉ IP, hệ điều hành, v.v..); nhưng, thay vì các số lượt xem trang, thiết bị của bạn gửi đến BANNY Việt Nam các thông tin về nội dung, quảng cáo được xem và/hoặc phần mềm được cài đặt bởi các Dịch vụ và Ứng Dụng và thời điểm.</p>
                    <h5><p><strong>3. COOKIES</strong></p></h5>
                    <p>Ứng Dụng sử dụng cookie để phân biệt bạn với những người dùng khác. Điều này giúp BANNY Việt Nam cung cấp cho bạn trải nghiệm tốt khi bạn sử dụng trang mạng và cũng cho phép BANNY Việt Nam cải thiện trang mạng của mình. Thông tin này còn được sử dụng để theo dõi giỏ hàng, để chuyển tải nội dung phù hợp với sở thích của bạn, để cho phép các đối tác cung cấp dịch vụ quảng cáo cung cấp dịch vụ quảng cáo trên các trang thông qua mạng Internet và để thực hiện phân tích dữ liệu và hoặc theo dõi việc sử dụng Dịch vụ. Cookie là một tệp nhỏ gồm các chữ cái và số mà BANNY Việt Nam lưu trữ trên trình duyệt hoặc ổ cứng máy tính của bạn. Cookie chứa thông tin được lưu trữ trên ổ cứng máy tính của bạn. Bạn có khả năng chấp nhận hoặc từ chối cookie bằng cách sửa đổi cài đặt trong trình duyệt của bạn. Nếu bạn muốn làm điều này, xin vui lòng xem mục trợ giúp trong trình duyệt của bạn.</p>
                    <p>Bằng cách tiếp tục sử dụng Ứng Dụng, bạn chấp nhận BANNY Việt Nam thu thập và sử dụng các loại cookie phù hợp với mục đích nêu trên.</p>
                    <h5><p><strong>4. HỆ THỐNG GIÁM SÁT CCTV</strong></p></h5>
                    <p>Tại các Cụm Rạp Chiếu Phim BANNY Cinemas, BANNY Việt Nam có thể sẽ sử dụng hệ thống giám sát CCTV (như máy quay phim). Những máy quay phim CCTV của BANNY Việt Nam có thể được đặt tại một vài vị trí công cộng của Cụm Rạp Chiếu Phim BANNY Cinemas nhằm ghi âm, ghi hình theo thời gian thực với mục đích góp phần bảo vệ trật tự, an toàn xã hội; bảo vệ quyền và lợi ích hợp pháp của Cụm Rạp Chiếu Phim BANNY Cinemas, của nhân viên, của BANNY Việt Nam và của bạn theo quy định pháp luật; phòng, chống, xác định và điều tra những hành vi vi phạm tại Cụm Rạp Chiếu Phim BANNY Cinemas.</p>
                    <p>Bằng cách tiếp tục hoạt động tại Cụm Rạp Chiếu Phim BANNY Cinemas, bạn chấp nhận để BANNY Việt Nam thực hiện giám sát qua hệ thống CCTV và xử lý dữ liệu theo đúng mục đích đã được đề cập ở trên.</p>
                    <h5><p><strong>5. THU THẬP THÔNG TIN TRẺ EM</strong></p></h5>
                    <p>Bạn cần lưu ý các giao dịch trực tuyến trên Ứng Dụng không được chủ ý thiết kế để giao dịch với trẻ em dưới 16 tuổi. Các giao dịch trực tuyến trên Ứng Dụng cho việc sử dụng Dịch Vụ của trẻ em dưới 16 tuổi do BANNY Việt Nam cung cấp sẽ được thực hiện với sự giám sát cẩn thận của cha/mẹ hoặc người giám hộ và thực hiện thông qua cha/mẹ hoặc người giám hộ. Theo đó, BANNY Việt Nam không cố tình thu thập hay lưu giữ bất kỳ dữ liệu cá nhân hay thông tin không nhận dạng cá nhân nào của bất kỳ ai dưới 16 tuổi. Cha/mẹ hoặc người giám hộ của trẻ em dưới 16 tuổi vui lòng giám sát và đảm bảo thông tin cá nhân của trẻ dưới 16 tuổi mà mình đang giám hộ không đăng tải thông tin cá nhân cho BANNY Việt Nam. Trong trường hợp thông tin cá nhân của của trẻ em dưới 16 tuổi do quý phụ huynh giám hộ được cung cấp cho BANNY Việt Nam, cha/mẹ hoặc người giám hộ theo đồng ý với việc xử lý thông tin của trẻ em dưới 16 tuổi có liên quan, và đồng ý chịu sự điều chỉnh của Chính Sách Bảo Mật Thông Tin này thay mặt cho người được giám hộ. BANNY Việt Nam sẽ khóa bất kỳ tài khoản nào chỉ được sử dụng bởi đối tượng trẻ em như vậy và sẽ gỡ và/hoặc xóa bất kỳ dữ liệu cá nhân nào mà chúng tôi cho là đã được gửi bởi bất kỳ trẻ em nào dưới 16 tuổi.</p>
                    <h5><p><strong>6. THÔNG TIN THU THẬP BỞI CÁC BÊN THỨ BA</strong></p></h5>
                    <p>6.1. Nền tảng của chúng tôi sử dụng Google Analytics, một dịch vụ phân tích web được cung cấp bởi Google, Inc. ("Google"). Google Analytics sử dụng cookie, là các tập tin văn bản trên thiết bị của bạn, để giúp Ứng Dụng phân tích cách thức người dùng sử dụng Ứng Dụng của chúng tôi. Thông tin được tạo bởi cookie về việc bạn sử dụng Ứng Dụng (bao gồm địa chỉ IP của bạn) sẽ được gửi đến và lưu bởi Google trên các máy chủ tại Hoa Kỳ. Google sẽ sử dụng thông tin này để đánh giá việc bạn sử dụng Ứng Dụng của chúng tôi, soạn báo cáo về hoạt động trang web dành cho các nhà điều hành trang web và cung cấp các dịch vụ khác liên quan đến hoạt động trang web và việc sử dụng Internet. Google cũng có thể gửi thông tin này cho các bên thứ ba trong trường hợp luật pháp có quy định như thế, hoặc trường hợp các bên thứ ba đó xử lý thông tin thay mặt Google. Google sẽ không liên kết địa chỉ IP của bạn với bất kỳ dữ liệu nào khác mà Google nắm giữ</p>
                    <p>6.2. BANNY Việt Nam, và các bên thứ ba, có thể trong từng thời điểm cung cấp các bản tải về ứng dụng phần mềm cho bạn sử dụng bởi Ứng Dụng hoặc thông qua Các Dịch Vụ. Những ứng dụng này có thể truy cập riêng, và cho phép một bên thứ ba xem, thông tin nhận dạng của bạn, chẳng hạn như tên, ID người dùng của bạn, Địa chỉ IP của thiết bị của bạn hoặc thông tin khác chẳng hạn như game bạn đang chơi trong bất kỳ phiên truy cập cụ thể nào, và bất kỳ cookie nào trước đây bạn có thể đã cài đặt hoặc đã được cài đặt cho bạn bởi một ứng dụng phần mềm hoặc trang web của bên thứ ba. Ngoài ra, các ứng dụng này có thể yêu cầu bạn cung cấp thêm thông tin trực tiếp cho các bên thứ ba. Các sản phẩm hoặc dịch vụ của bên thứ ba được cung cấp thông qua các ứng dụng này không thuộc sở hữu hay quyền kiểm soát của BANNY Việt Nam. Bạn nên đọc các điều khoản và các chính sách khác được công bố bởi các bên thứ ba đó trên trang web của họ hoặc nơi khác.</p>
                    <h5><strong>7. MỤC ĐÍCH XỬ LÝ DỮ LIỆU CÁ NHÂN</strong></h5>
                    <p>BANNY Việt Nam thu thập, sử dụng, tiết lộ, và thực hiện các biện pháp xử lý dữ liệu cá nhân của bạn cho các mục đích sau đây:</p>
                    <p>(i) Định danh, xác thực và kiểm tra thông tin của bạn;</p>
                    <p>(ii) Để giải quyết hoặc tạo điều kiện thuận lợi cho dịch vụ khách hàng, thực hiện các chỉ thị của bạn, duy trì liên lạc với bạn, hỗ trợ cho bạn trong việc sử dụng Ứng Dụng, sử dụng Dịch Vụ và giải đáp thắc mắc của bạn liên quan đến Ứng Dụng, Dịch Vụ do BANNY Việt Nam cung cấp;</p>
                    <p>(iii) Để quản lý, điều hành, cung cấp và/hoặc quản lý việc bạn sử dụng và/hoặc truy cập Các Dịch Vụ và Ứng Dụng (bao gồm các sở thích của bạn), cũng như quan hệ và tài khoản người dùng của bạn với chúng tôi;</p>
                    <p>(iv) Để đáp ứng, xử lý, giải quyết hoặc hoàn tất một giao dịch và/hoặc đáp ứng các yêu cầu của bạn đối với các sản phẩm và dịch vụ nhất định và thông báo cho bạn về các vấn đề dịch vụ và các hoạt động tài khoản bất thường;</p>
                    <p>(v) Thông báo nhanh chóng và kịp thời đến bạn các thông tin của chương trình khuyến mại, các chương trình ưu đãi, thông tin quảng cáo và/hoặc thông tin của các hoạt động xúc tiến thương mại khác. Vì mục đích tiếp thị và quảng cáo, trong trường hợp này, để gửi cho bạn qua các phương tiện và phương thức liên lạc khác nhau, thông tin và tài liệu tiếp thị và quảng bá liên quan đến các sản phẩm và/hoặc dịch vụ (bao gồm, nhưng không giới hạn các sản phẩm và/hoặc dịch vụ của các bên thứ ba màBANNY Việt Nam có thể hợp tác hoặc liên kết) mà BANNY Việt Nam (và/hoặc các bên liên kết hoặc công ty có liên quan của nó) có thể bán, tiếp thị hoặc quảng bá, cho dù các sản phẩm hoặc dịch vụ đó tồn tại vào lúc này hoặc được tạo ra trong tương lai. Bạn có thể hủy đăng ký nhận các thông tin tiếp thị tại bất cứ thời điểm nào bằng cách sử dụng chức năng hủy đăng ký trong các tài liệu tiếp thị điện tử. BANNY Việt Nam có thể sử dụng các thông tin liên hệ của bạn để gửi các bản tin và/hoặc tài liệu truyền thông từ chúng tôi hoặc từ các công ty có liên quan của BANNY Việt Nam.</p>
                    <p>(vi) Để duy trì và quản lý bất kỳ bản cập nhật phần mềm nào và/hoặc các bản cập nhật khác và sự hỗ trợ có thể được yêu cầu tùy lúc nhằm đảm bảo Các Dịch Vụ của BANNY Việt Nam hoạt động suôn sẻ;</p>
                    <p>(vii) Giải quyết các vấn đề phát sinh liên quan đến việc sử dụng Ứng Dụng;</p>
                    <p>(viii) Khảo sát thị trường, nghiên cứu và phát triển sản phẩm, dịch vụ mới, thống kê và phân tích thông tin khách hàng, thói quen tiêu dùng để hỗ trợ việc vận hành và kinh doanh của BANNY Việt Nam và các công ty liên kết, các công ty khác cùng thuộc Tập Đoàn CJ;</p>
                    <p>(ix) Để cho phép kiểm tra và khảo sát khác để, ngoài những hoạt động khác, xác thực quy mô và thành phần của đối tượng mục tiêu của chúng tôi, và hiểu được trải nghiệm của họ với Các Dịch Vụ của BANNY Việt Nam;</p>
                    <p>(x) Để lập số liệu thống kê và nghiên cứu đáp ứng yêu cầu báo cáo và/hoặc duy trì sổ sách nội bộ hoặc theo quy định;</p>
                    <p>(xi) Lưu trữ, quản lý, dự phòng cho việc phục hồi sự cố hay cho các mục đích tương tự khác;</p>
                    <p>(xii) Điều tra tai nạn, giải quyết tranh chấp, khiếu nại và các hoạt động khác nhằm tuân thủ các nghĩa vụ theo quy định của pháp luật Việt Nam;</p>
                    <p>(xiii) Để đáp ứng bất cứ các mối đe dọa hoặc yêu cầu thực tế nào được khẳng định chống lại BANNY Việt Nam hoặc các yêu cầu khác liên quan đến các nội dung vi phạm quy định của các bên thứ ba;</p>
                    <p>(xiv) Phát hiện, ngăn chặn, điều tra và xử lý những hoạt động vi phạm chính sách, quy định của BANNY Việt Nam và/hoặc vi phạm quy định pháp luật Việt Nam;</p>
                    <p>(xv) Tuân thủ các quy định của pháp luật, yêu cầu của cơ quan nhà nước có thẩm quyền bao gồm nhưng không giới hạn nghĩa vụ công bố thông tin, báo cáo theo quy định pháp luật về khuyến mại, lưu trữ hồ sơ, kiểm toán;</p>
                    <p>(xvi) Chia sẻ, truyền, đưa dữ liệu cá nhân cho các bên thứ ba khác (cho việc thực hiện các mục đích nêu trên và các mục đích phù hợp khác), bao gồm nhưng không giới hạn: các công ty liên kết, các công ty khác cùng thuộc Tập Đoàn CJ; đối tác, đại lý, nhà cung cấp hàng hóa/dịch vụ, nhà thầu, bên tư vấn của BANNY Việt Nam; bên thứ ba có quyền khác; hoặc theo yêu cầu của các đơn vị, cơ quan nhà nước có thẩm quyền.</p>
                    <p>(gọi chung là “<strong>Các Mục Đích</strong>”).</p>
                    <p>Vì Các Mục Đích mà BANNY Việt Nam sẽ/có thể thu thập, sử dụng, tiết lộ hoặc xử lý dữ liệu cá nhân của bạn phụ thuộc vào hoàn cảnh hiện có, mục đích đó có thể không xuất hiện bên trên. Tuy nhiên, chúng tôi sẽ thông báo cho bạn biết mục đích khác tại thời điểm xin sự cho phép của bạn, trừ khi việc xử lý dữ liệu áp dụng mà không cần sự đồng ý của bạn là được phép theo các quy định của pháp luật.</p>
                    <h5><p><strong>8. BẢO VỆ VÀ LƯU TRỮ DỮ LIỆU CÁ NHÂN</strong></p></h5>
                    <p>Dữ liệu cá nhân của bạn do BANNY Việt Nam lưu trữ sẽ được bảo mật bằng việc thực hiện các biện pháp hợp lý. Tuy nhiên, <strong>CHẮC CHẮN KHÔNG THỂ CÓ SỰ ĐẢM BẢO AN NINH TUYỆT ĐỐI</strong>.</p>
                    <p>Trong phạm vi pháp luật cho phép, BANNY Việt Nam có thể lưu trữ dữ liệu cá nhân của bạn trong khoảng thời gian cần thiết để hoàn thành đúng và đủ các mục đích xử lý dữ liệu cá nhân được nêu cụ thể trong Chính Sách Bảo Mật Thông Tin.</p>
                    <p>BANNY Việt Nam <strong>có thể phải lưu trữ dữ liệu cá nhân của bạn lâu hơn</strong> dựa trên nhu cầu thực tế như (i) bất cứ các mối đe dọa hoặc yêu cầu thực tế nào được khẳng định chống lại BANNY Việt Nam; (ii) Điều tra gian lận nội bộ; (iii) điều tra tham nhũng nội bộ; (iv) phát hiện, ngăn chặn, điều tra và xử lý những hoạt động vi phạm chính sách, quy định nội bộ của BANNY Việt Nam và/hoặc vi phạm quy định pháp luật Việt Nam; (v) yêu cầu của pháp luật có hiệu lực tại từng thời điểm như pháp luật về Thuế, Phòng, chống rửa tiền, hay (vi) nhằm giải quyết tranh chấp, vấn đề pháp lý, nếu có. <strong>MẶC DÙ CÓ CÁC QUY ĐỊNH KHÁC ĐI, BẠN CẦN LƯU Ý, BẠN KHÔNG THỂ RÚT LẠI SỰ ĐỒNG Ý, KHÔNG THỂ PHẢN ĐỐI XỬ LÝ, KHÔNG THỂ HẠN CHẾ XỬ LÝ, HOẶC ĐỀ NGHỊ BANNY VIỆT NAM XÓA DỮ LIỆU CÁ NHÂN CỦA BẠN NẾU DỮ LIỆU CÁ NHÂN CỦA BẠN ĐANG ĐƯỢC SỬ DỤNG CHO CÁC MỤC ĐÍCH NÊU TẠI ĐOẠN NÀY</strong>.</p>
                    <p>BANNY Việt Nam sẽ hủy hoặc xóa thông tin nhận dạng ra khỏi dữ liệu cá nhân của bạn khi BANNY Việt Nam nhận được yêu cầu của bạn phù hợp với các quy định pháp luật hoặc khi BANNY Việt Nam có lý do hợp lý để xác định rằng (i) việc lưu trữ dữ liệu cá nhân đó không còn phục vụ mục đích thu thập dữ liệu cá nhân đó nữa; (ii) việc lưu giữ không còn cần thiết cho bất kỳ mục đích hợp pháp hay mục đích kinh doanh nào và (iii) không còn các lợi ích hợp pháp nào khác để tiếp tục lưu giữ các dữ liệu cá nhân này. Nếu bạn ngưng sử dụng Ứng Dụng, hoặc quyền của bạn được sử dụng Ứng Dụng và/hoặc Các Dịch Vụ bị chấm dứt hoặc hủy bỏ, BANNY Việt Nam có thể tiếp tục lưu, sử dụng và/hoặc tiết lộ dữ liệu cá nhân của bạn tuân theo Chính Sách Bảo Mật Thông Tin này và quy định pháp luật. Tùy thuộc vào quy định của pháp luật, BANNY Việt Nam có thể tiêu hủy dữ liệu cá nhân của bạn một cách an toàn mà không cần thông báo trước cho bạn. <strong>BẠN CŨNG CẦN LƯU Ý, BANNY VIỆT NAM CŨNG BẢO LƯU QUYỀN TỪ CHỐI XÓA, PHẢN ĐỐI XỬ LÝ, HẠN CHẾ XỬ LÝ, XÓA DỮ LIỆU CÁ NHÂN TRONG TRƯỜNG HỢP YÊU CẦU CỦA BẠN KHÔNG PHÙ HỢP VỚI QUY ĐỊNH PHÁP LUẬT, HOẶC MẶC DÙ PHÙ HỢP NHƯNG THUỘC TRƯỜNG HỢP BANNY VIỆT NAM KHÔNG ĐƯỢC XÓA THEO QUY ĐỊNH PHÁP LUẬT</strong>.</p>
                    <h5><p><strong>9. XỬ LÝ DỮ LIỆU CÁ NHÂN NHẠY CẢM</strong></p></h5>
                    <p>BANNY Việt Nam hiểu rõ dữ liệu cá nhân nhạy cảm gắn liền với quyền riêng tư mà khi bị xâm phạm sẽ gây ảnh hưởng trực tiếp tới quyền, lợi ích hợp pháp của bạn, do đó BANNY Việt Nam sẽ không tiến hành thu thập, xử lý dữ liệu cá nhân nhạy cảm của bạn nếu chưa được sự đồng ý của bạn. Việc thu thập, xử lý dữ liệu cá nhân nhạy cảm của bạn sẽ được thực hiện riêng biệt và từng lần cho các mục đích tại từng thời điểm nếu phát sinh. Tuy nhiên, để phục vụ cho quá trình đăng nhập Ứng Dụng, kiểm tra, xác thực cho quá trình sử dụng Ứng Dụng và/hoặc xác nhận Dịch Vụ, BANNY Việt Nam có thể truy xuất dữ liệu cá nhân nhạy cảm của bạn thông qua các thiết bị cá nhân mà bạn đang sử dụng Ứng Dụng, chẳng hạn như thông tin liên quan đến định danh sinh trắc học. Mặc dù vậy, BANNY Việt Nam không thu thập, xử lý các dữ liệu cá nhân nhạy cảm này.</p>
                    <h5><p><strong>10. QUYỀN VÀ NGHĨA VỤ CỦA BẠN</strong></p></h5>
                    <p>10.1. Quyền của bạn:</p>
                    <p>a) <strong>Quyền được biết</strong>: bạn được biết về hoạt động Xử Lý Dữ Liệu Cá Nhân của mình, trừ trường hợp luật có quy định khác.</p>
                    <p>b) <strong>Quyền đồng ý</strong>: bạn được đồng ý hoặc không đồng ý cho phép Xử Lý Dữ Liệu Cá Nhân của mình, trừ trường hợp theo quy định của pháp luật.</p>
                    <p>c) <strong>Quyền rút lại sự đồng ý</strong>: bạn được quyền rút lại sự đồng ý của mình, trừ trường hợp luật có quy định khác.</p>
                    <p>d) <strong>Quyền truy cập</strong>: nếu bạn đã đăng ký một tài khoản với BANNY Việt Nam, cá nhân bạn có thể truy cập và/hoặc sửa dữ liệu cá nhân của bạn mà BANNY Việt Nam đang lưu giữ hoặc kiểm soát thông qua trang Thiết Lập Tài Khoản trên Ứng Dụng. Nếu bạn chưa đăng ký tài khoản với BANNY Việt Nam, cá nhân bạn có thể yêu cầu truy cập và/hoặc sửa dữ liệu cá nhân của bạn mà BANNY Việt Nam đang lưu giữ hoặc kiểm soát bằng cách gửi yêu cầu bằng văn bản cho BANNY Việt Nam. BANNY Việt Nam sẽ cần có đủ thông tin từ bạn để xác định danh tính của bạn cũng như bản chất yêu cầu của bạn để có thể giải quyết yêu cầu của bạn. Do đó, vui lòng gửi yêu cầu bằng văn bản của bạn bằng cách gửi email cho Bộ phận Bảo Mật của BANNY Việt Nam <strong>tại địa chỉ email <a href="#"style="color: red">Security@cgv.vn</a></strong>. BANNY Việt Nam có thể tính một khoản phí hợp lý cho bạn để giải quyết và xử lý yêu cầu truy cập dữ liệu cá nhân của bạn. Nếu BANNY Việt Nam có tính phí, BANNY Việt Nam sẽ cung cấp cho bạn ước tính lệ phí bằng văn bản. Vui lòng lưu ý rằng BANNY Việt Nam không buộc phải đáp ứng hay giải quyết yêu cầu truy cập của bạn trừ phi bạn đã đồng ý đóng phí.</p>
                    <p>BANNY Việt Nam bảo lưu quyền từ chối sửa dữ liệu cá nhân của bạn theo các quy định của pháp luật về bảo vệ bí mật thông tin cá nhân, trường hợp các điều luật đó yêu cầu và/hoặc cho phép một tổ chức từ chối sửa dữ liệu cá nhân trong các trường hợp như thế.</p>
                    <p>e) <strong>Quyền xóa dữ liệu</strong>: bạn được xóa hoặc yêu cầu xóa Dữ Liệu Cá Nhân của mình, trừ trường hợp luật có quy định khác.</p>
                    <p>f)  <strong>Quyền hạn chế xử lý dữ liệu</strong>: bạn được yêu cầu hạn chế xử lý Dữ Liệu Cá Nhân của mình, trừ trường hợp luật có quy định khác;</p>
                    <p>g) <strong>Quyền cung cấp dữ liệu</strong>: bạn được yêu cầu cung cấp cho bản thân Dữ Liệu Cá Nhân của mình, trừ trường hợp luật có quy định khác. BANNY Việt Nam có thể tính một khoản phí hợp lý cho bạn để giải quyết và xử lý yêu cầu cung cấp dữ liệu cá nhân của bạn. Nếu BANNY Việt Nam có tính phí, chúng tôi sẽ cung cấp cho bạn ước tính lệ phí bằng văn bản tùy thuộc vào từng trường hợp cụ thể. Vui lòng gửi yêu cầu cho Bộ phận Bảo Mật của BANNY Việt Nam <strong>tại địa chỉ email <a href="#" style="color: red"> Security@cgv.vn</a></strong>.</p>
                    <p>h) <strong>Quyền phản đối xử lý dữ liệu</strong>: bạn được phản đối việc Xử Lý Dữ Liệu Cá Nhân, trừ trường hợp luật có quy định khác;</p>
                    <p>i) <strong>Quyền khiếu nại, tố cáo, khởi kiện</strong>: bạn có quyền khiếu nại, tố cáo hoặc khởi kiện theo quy định của pháp luật.</p>
                    <p>j) <strong>Quyền yêu cầu bồi thường thiệt hại</strong>: bạn có quyền yêu cầu bồi thường thiệt hại theo quy định của pháp luật khi xảy ra vi phạm quy định về bảo vệ Dữ Liệu Cá Nhân của mình, trừ trường hợp các bên có thỏa thuận khác hoặc pháp luật có quy định khác.</p>
                    <p>k) <strong>Quyền tự bảo vệ</strong>: bạn có quyền tự bảo vệ theo quy định của pháp luật liên quan, hoặc yêu cầu cơ quan, tổ chức có thẩm quyền thực hiện các phương thức bảo vệ quyền dân sự theo quy định của pháp luật liên quan.</p>
                    <p>10.2.    Nghĩa vụ của Bạn</p>
                    <p>a) Tự bảo vệ Dữ Liệu Cá Nhân của mình; yêu cầu các tổ chức, cá nhân khác có liên quan bảo vệ Dữ Liệu Cá Nhân của mình.</p>
                    <p>b) Tôn trọng, bảo vệ Dữ Liệu Cá Nhân của người khác.</p>
                    <p>c) Cung cấp đầy đủ, chính xác Dữ Liệu Cá Nhân khi đồng ý cho phép xử lý Dữ Liệu Cá Nhân.</p>
                    <p>d) Tham gia tuyên truyền, phổ biến kỹ năng bảo vệ Dữ Liệu Cá Nhân.</p>
                    <p>e) Thực hiện quy định của pháp luật về bảo vệ Dữ Liệu Cá Nhân và tham gia phòng, chống các hành vi vi phạm quy định về bảo vệ Dữ Liệu Cá Nhân.</p>
                    <h5><p><strong>11. SỰ ĐỒNG Ý CHO TIẾP THỊ, GIỚI THIỆU SẢN PHẨM, QUẢNG CÁO VÀ KHUYẾN MẠI</strong></p></h5>
                    <p>Theo yêu cầu của pháp luật, BANNY Việt Nam sẽ cần bạn đồng ý trước khi xử lý dữ liệu cá nhân để gửi đến bạn thông tin tiếp thị, giới thiệu, quảng cáo và khuyến mại liên quan đến các sản phẩm được cá nhân hóa (điều mà bạn có thể thấy thú vị, hoặc được thiết kế dành riêng cho sở thích của bạn) theo nguyên tắc bạn biết rõ nội dung, phương thức, hình thức, tần suất giới thiệu sản phẩm phù hợp với từng loại sản phẩm, chương trình, chiến dịch tương ứng và quy định pháp luật có liên quan. BANNY Việt Nam, đối tác kinh doanh của BANNY Việt Nam, và đối tác tiếp thị vẫn sẽ sử dụng các loại dữ liệu đã thu thập từ bạn để xử lý nhằm mục đích tiếp thị, giới thiệu sản phẩm, quảng cáo và khuyến mại qua hình thức các bài đăng về các sản phẩm và dịch vụ của BANNY Việt Nam và các bên thứ ba được lựa chọn cẩn thận. Theo thời gian, BANNY Việt Nam, đối tác kinh doanh của BANNY Việt Nam, và đối tác tiếp thị có thể gửi thêm thông tin chi tiết về sản phẩm, dịch vụ và các ưu đãi đặc biệt cho bạn qua các phương tiện điện tử và/hoặc phi điện tử. BANNY Việt Nam sẽ chỉ làm điều này nếu bạn đồng ý cho chúng tôi liên lạc với bạn bằng phương thức phù hợp. Bạn có đầy đủ các quyền và nghĩa vụ đối với dữ liệu cá nhân bạn đã cung cấp cho chúng tôi theo Chính Sách Bảo Mật Thông Tin này. Và, trường hợp bạn thay đổi ý định và/hoặc bạn muốn từ chối nhận thông tin tiếp thị, giới thiệu sản phẩm, quảng cáo và khuyến mại, bạn có thể cho chúng tôi biết bất kỳ lúc nào bằng việc gửi yêu cầu theo một trong các tùy chọn trong mục Liên hệ với chúng tôi.</p>
                    <h5><p><strong>12. RÚT LẠI SỰ ĐỒNG Ý, YÊU CẦU HẠN CHẾ XỬ LÝ, VÀ PHẢN ĐỐI XỬ LÝ DỮ LIỆU CÁ NHÂN</strong></p></h5>
                    <p>Bạn có thể rút lại sự đồng ý cho phép, yêu cầu hạn chế, phản đối trong việc thu thập, xử lý, sử dụng và/hoặc tiết lộ dữ liệu cá nhân của bạn mà chúng tôi đang lưu giữ hoặc kiểm soát bằng cách gửi email cho Bộ phận Bảo Mật của BANNY Việt Nam <strong>tại địa chỉ email <a href="#" style="color: red"> Security@cgv.vn</a></strong>, và chúng tôi sẽ xử lý các yêu cầu này theo Chính Sách Bảo Mật Thông Tin cũng như quy định pháp luật có liên quan.</p>
                    <p>Tuy nhiên, việc bạn rút lại sự cho phép, yêu cầu hạn chế, phản đối xử lý dữ liệu cá nhân của bạn có thể đồng nghĩa với việc BANNY Việt Nam sẽ không thể tiếp tục cung cấp các Dịch vụ đến bạn và BANNY Việt Nam có thể cần phải chấm dứt mối quan hệ hiện tại giữa bạn và/hoặc hợp đồng mà bạn có với BANNY Việt Nam.</p>
                    <h5><p><strong>13. CHUYỂN THÔNG TIN RA NƯỚC NGOÀI</strong></p></h5>
                    <p>Thông tin và/hoặc dữ liệu cá nhân của bạn có thể được chuyển ra nước ngoài, lưu trữ hoặc xử lý bên ngoài quốc gia của bạn cho một hoặc nhiều Mục đích. BANNY Việt Nam sẽ chỉ chuyển dữ liệu cá nhân của bạn ra nước ngoài khi phù hợp với các quy định của pháp luật về bảo vệ dữ liệu cá nhân.</p>
                    <h5><p><strong>14. HẬU QUẢ, THIỆT HẠI KHÔNG MONG MUỐN CÓ THỂ XẢY RA</strong></p></h5>
                    <p>Như đã đề cập tại Chính Sách Bảo Mật Thông Tin này, bạn có những quyền theo luật định và yêu cầu chúng tôi thực hiện trong khi đang xử lý dữ liệu cá nhân của bạn. Lúc này, BANNY Việt Nam có thể cần thời gian hợp lý (tùy thuộc vào mức độ phức tạp và sự ảnh hưởng của yêu cầu của bạn đối với mối quan hệ giữa chúng tôi và bạn) để xử lý yêu cầu của bạn và/hoặc để thông báo cho bạn biết hậu quả, thiệt hại không mong muốn có thể xảy ra nếu yêu cầu của bạn được thực hiện.</p>
                    <p><strong>BANNY Việt Nam mong bạn lưu ý rằng:</strong></p>
                    <p>-  Căn cứ vào bản chất và phạm vi yêu cầu của bạn, chúng tôi có thể sẽ không thể tiếp tục cung cấp Dịch Vụ cho bạn, và theo yêu cầu của pháp luật tùy từng trường hợp, chúng tôi cũng sẽ thông báo cho bạn trước khi hoàn tất việc xử lý yêu cầu của bạn.</p>
                    <p>-  Trong một số trường hợp nhất định, chúng tôi không thể chấp nhận yêu cầu của bạn. Ví dụ như các trường hợp quy định tại Điều 8 Chính Sách Bảo Mật Thông Tin này, hoặc ví dụ nếu bạn yêu cầu BANNY Việt Nam xóa dữ liệu cá nhân, giao dịch trong khi về mặt pháp lý, BANNY Việt Nam có nghĩa vụ phải lưu trữ hồ sơ về cá nhân, hợp đồng, giao dịch đó để tuân thủ và cung cấp theo quy định pháp luật.</p>
                    <p>-  Hay như trong trường hợp BANNY Việt Nam không thể thực hiện yêu cầu rút lại sự đồng ý của bạn trong khi BANNY Việt Nam đang thực hiện nghĩa vụ theo hợp đồng giữa BANNY Việt Nam với bạn; hay cần xử lý ngay dữ liệu cá nhân có liên quan để bảo vệ tính mạng, sức khỏe của chủ thể dữ liệu hoặc người khác theo luật định.</p>
                    <p><strong>Khi xử lý dữ liệu của bạn</strong>, BANNY Việt Nam sử dụng các biện pháp bảo vệ và xử lý dữ liệu cá nhân của bạn theo quy định của pháp luật. Trong trường hợp hạn hữu, những hành vi vi phạm khi xử lý dữ liệu cá nhân (như sự mất mát, phá hủy hoặc thiệt hại do sự cố, sử dụng các biện pháp kỹ thuật) có thể xảy ra, và nó hoàn toàn không phải những điều mà BANNY Việt Nam mong muốn. Trong khuôn khổ pháp luật, BANNY Việt Nam sẽ tiến hành thông báo hành vi vi phạm đến các bên liên quan trong thời hạn luật định. Việc bồi thường thiệt hại, nếu có, khi xảy ra hành vi vi phạm quy định về bảo vệ dữ liệu cá nhân cũng sẽ được thực hiện theo thỏa thuận hoặc theo luật định.</p>
                    <h5><p><strong>15. CÁCH THỨC XỬ LÝ DỮ LIỆU CÁ NHÂN</strong></p></h5>
                    <p>Tùy từng thời điểm và tùy theo từng mục đích kể trên, BANNY Việt Nam sẽ thực hiện một hoặc nhiều hoạt động tác động tới Dữ Liệu Cá Nhân, như: thu thập, ghi, phân tích, xác nhận, lưu trữ, chỉnh sửa, công khai, kết hợp, truy cập, truy xuất, thu hồi, mã hóa, giải mã, sao chép, chia sẻ, truyền đưa, cung cấp, chuyển giao, xóa, hủy Dữ Liệu Cá Nhân hoặc các hành động khác có liên quan.</p>
                    <p>Các hoạt động Xử Lý Dữ Liệu Cá Nhân có thể được BANNY Việt Nam thực hiện theo cách thức tự động hoặc không tự động, bằng các phương tiện điện tử hoặc các cách thức thủ công hoặc bất kỳ cách thức nào khác mà BANNY Việt Nam cho là phù hợp.</p>
                    <p>BANNY Việt Nam áp dụng triệt để các biện pháp bảo vệ, bảo mật trong quá trình Xử Lý Dữ Liệu Cá Nhân, bao gồm cả việc bảo vệ trước các hành vi vi phạm quy định về bảo vệ Dữ Liệu Cá Nhân và phòng, chống sự mất mát, phá hủy hoặc thiệt hại do sự cố, sử dụng các biện pháp kỹ thuật. Tuy nhiên, xin lưu ý rằng, BANNY Việt Nam không thể loại bỏ hoàn toàn các rủi ro bảo mật liên quan đến việc Xử Lý Dữ Liệu Cá Nhân.</p>
                    <h5><p><strong>16. DỮ LIỆU CỦA BẠN CÓ THỂ ĐƯỢC CHIA SẺ VỚI AI</strong></p></h5>
                    <p>BANNY Việt Nam không tiết lộ cho bên thứ ba thông tin cá nhân của bạn, cũng như thông tin cá nhân và nhân khẩu học kết hợp, hoặc thông tin về việc sử dụng Ứng Dụng của bạn (chẳng hạn các khu vực bạn ghé thăm, hay các dịch vụ mà bạn truy cập), trừ các trường hợp sau đây:</p>
                    <p>(i) BANNY Việt Nam có thể tiết lộ thông tin như vậy cho các bên thứ ba nếu bạn đồng ý.</p>
                    <p>(ii) BANNY Việt Nam có thể tiết lộ thông tin như vậy cho các công ty và cá nhân mà BANNY Việt Nam thuê để thay mặt chúng tôi thực hiện các chức năng của công ty. Ví dụ, việc lưu giữ các máy chủ web, phân tích dữ liệu, cung cấp các trợ giúp về marketing, xử lý thẻ tín dụng hoặc các hình thức thanh toán khác, và dịch vụ cho khách hàng. Những công ty và cá nhân này sẽ truy cập tới thông tin cá nhân của bạn khi cần để thực hiện các chức năng của họ, nhưng không chia sẻ thông tin đó với bất kỳ bên thứ ba nào khác.</p>
                    <p>(iii) Chúng tôi có thể tiết lộ thông tin như vậy nếu có yêu cầu pháp lý, hay từ một cơ quan chính phủ hoặc nếu chúng tôi tin rằng hành động đó là cần thiết nhằm: (a) tuân theo các yêu cầu pháp lý hoặc chiếu theo quy trình của luật pháp; (b) bảo vệ các quyền hay tài sản của BANNY Việt Nam, hoặc các công ty đối tác; (c) ngăn chặn tội phạm hoặc bảo vệ an ninh quốc gia; hoặc (d) bảo vệ an toàn cá nhân của những người sử dụng hay công chúng</p>
                    <p>(iv) BANNY Việt Nam có thể tiết lộ và chuyển thông tin như vậy tới một nhóm thứ ba, đối tượng mua lại toàn bộ hay phần lớn công việc kinh doanh của BANNY Việt Nam, bằng cách liên kết, hợp nhất hoặc mua toàn bộ hay phần lớn các tài sản của BANNY Việt Nam. Ngoài ra, trong tình huống BANNY Việt Nam trở thành đối tượng của một vụ khởi kiện phá sản, dù tự nguyện hay miễn cưỡng, thì BANNY Việt Nam hay người được uỷ thác có thể bán, cho phép hoặc tiết lộ thông tin như vậy theo cách khác trong quá trình chuyển giao được toà án về phá sản đồng ý.</p>
                    <p>(v) BANNY Việt Nam có thể dùng tên bạn, hay thông tin khác về hoặc từ các quảng cáo tuyển dụng hoặc tài khoản xem hồ sơ ứng viên của bạn cho bất kỳ hay tất cả các mục đích tiếp thị của CJ Group (hay Nền tảng của CJ Groups).</p>
                    <p>BANNY Việt Nam cũng có thể chia sẻ thông tin đã khử định danh về khách ghé thăm một trong các Ứng Dụng của công ty với các khách hàng, đối tác và bên thứ ba khác để họ có thể hiểu về các loại khách tới thăm Ứng Dụng của BANNY Việt Nam và cách họ sử dụng site.</p>
                    <h5><p><strong>17. THỜI GIAN BẮT ĐẦU VÀ KẾT THÚC QUÁ TRÌNH XỬ LÝ DỮ LIỆU CÁ NHÂN</strong></p></h5>
                    <p>BANNY Việt Nam sẽ bắt đầu việc Xử Lý Dữ Liệu Cá Nhân ngay khi nhận được Dữ Liệu Cá Nhân cho đến khi Dữ Liệu Cá Nhân được xóa, hủy theo các quy định của pháp luật và/hoặc quy định, quyết định tại từng thời điểm của BANNY Việt Nam.</p>
                    <h5><p><strong>18. TỔ CHỨC CHỊU TRÁCH NHIỆM CHÍNH VỀ BẢO VỆ DỮ LIỆU CÁ NHÂN</strong></p></h5>
                    <p><strong>CÔNG TY TNHH BANNY VIỆT NAM</strong></p>
                    <p>MST: 0303675393</p>
                    <p>Địa chỉ: Lầu 2, Số 7/28, đường Thành Thái, Phường 14, Quận 10, Thành phố Hồ Chí Minh, Việt Nam</p>
                    <p>Điện thoại: 028. 3636 5757</p>
                    <p>Email: <a href="#" style="color: red">hoidap@cgv.vn</a></p>
                    <h5><p><strong>19. LIÊN HỆ</strong></p></h5>
                    <p>Gọi cho đường dây nóng của BANNY Việt Nam: 1900 6017</p>
                    <p>Gửi thư điện tử cho BANNY Việt Nam theo địa chỉ: <a href="#" style="color: red">hoidap@cgv.vn</a></p>
                    <p>Hoặc liên hệ trực tiếp với BANNY Việt Nam tại văn phòng: Lầu 2, Số 7/28, đường Thành Thái, Phường 14, Quận 10, Thành phố Hồ Chí Minh, Việt Nam.</p>
                    <p>Nếu bạn muốn ngừng nhận quảng cáo từ BANNY Việt Nam, vui lòng nhấn vào đường link Unsubscribe ở dưới cùng trong mọi email quảng cáo.</p>
                    <p></p>
                    <h5><p><strong>20. BỘ PHẬN PHỤ TRÁCH BẢO MẬT THÔNG TIN</strong></p></h5>
                    <p>Người phụ trách chính: IT Security</p>
                    <p>Email: <a href="#" style="color: red">Security@cgv.vn</a></p>
                    <p>Điện thoại: 028.36365757</p>
                    <p>Địa chỉ: Lầu 2, Số 7/28, đường Thành Thái, Phường 14, Quận 10, Thành phố Hồ Chí Minh, Việt Nam.</p>
                    <p></p>
                    <p><strong>THỰC HIỆN DƯỚI SỰ ỦY QUYỀN VÀ CHỈ ĐỊNH TỪ TỔNG GIÁM ĐỐC CÔNG TY TNHH BANNY VIỆT NAM</strong></p>
                </div>

            </div>

        </div>
        <%@include file="../footer.jsp" %>
    </div>
</body>
</html>
