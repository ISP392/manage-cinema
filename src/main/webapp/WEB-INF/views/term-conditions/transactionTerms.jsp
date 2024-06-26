<%-- 
    Document   : transactionTerms
    Created on : Jun 18, 2024, 1:35:41 PM
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
                            <li style="background-color:${backgroundColorMain}">
                                <a style="color: ${colorMain}"
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
                    <p class="intro">ĐIỀU KHOẢN GIAO DỊCH</p>
                    <p> </p>
                    <p>Chào mừng Quý Khách Hàng đến với <strong>CÔNG TY TNHH BANNY VIỆT NAM</strong> </p>
                    <p> </p>
                    <p>Chúng tôi là <strong>CÔNG TY TNHH BANNY VIỆT NAM</strong>, địa chỉ trụ sở chính tại Lầu 2, số 7/28, đường Thành Thái, Phường 14, Quận 10, Thành phố Hồ Chí Minh, Việt Nam (“<strong>BANNY Việt Nam</strong>”), đơn vị sở hữu và vận hành website banny.vn và ứng dụng di động BANNY Cinemas (“<strong>Ứng Dụng</strong>”) </p>
                    <p> </p>
                    <p>Khi Quý Khách Hàng truy cập vào Ứng Dụng có nghĩa là Quý Khách Hàng đồng ý với các điều kiện và điều khoản này. </p>
                    <p> </p>
                    <p>BANNY Việt Nam có quyền thay đổi, chỉnh sửa, thêm hoặc lược bỏ bất kỳ phần nào trong Điều Khoản Giao Dịch, vào bất cứ lúc nào. Các thay đổi có hiệu lực ngay khi được đăng trên Ứng Dụng mà không cần thông báo trước. Và khi Quý Khách Hàng tiếp tục sử dụng Ứng Dụng, sau khi các thay đổi về Điều Khoản Giao Dịch được đăng tải, có nghĩa là Quý Khách Hàng chấp nhận với những thay đổi đó. Quý khách Hàng vui lòng kiểm tra thường xuyên để cập nhật những thay đổi của BANNY Việt Nam. </p>
                    <p> </p>
                    <p><strong>XIN VUI LÒNG ĐỌC KỸ TRƯỚC KHI QUYẾT ĐỊNH ĐẶT VÉ TRỰC TUYẾN.</strong> </p>
                    <h4><strong>1. PHẠM VI ÁP DỤNG</strong></h4>
                    <p> </p>
                    <p>Điều kiện dưới đây áp dụng riêng cho chức năng giao dịch trực tuyến tại Ứng Dụng. Khi sử dụng chức năng giao dịch trực tuyến, Quý Khách Hàng mặc nhiên đã chấp thuận và tuân thủ tất cả các chỉ dẫn, điều khoản, điều kiện và lưu ý đăng tải trên Ứng Dụng, bao gồm nhưng không giới hạn bởi Điều Khoản Chung, Điều Khoản Giao Dịch nêu ở đây. </p>
                    <p> </p>
                    <p>Nếu Quý Khách Hàng không có ý định giao dịch trực tuyến hay không đồng ý với bất kỳ điều khoản hay điều kiện nào nêu trong Điều Khoản Chung, Điều Khoản Giao Dịch, xin DỪNG VIỆC SỬ DỤNG chức năng này. </p>
                    <h4><strong>2. ĐIỀU KIỆN SỬ DỤNG CHỨC NĂNG GIAO DỊCH TRỰC TUYẾN</strong> </h4>
                    <p>Quý Khách Hàng phải đăng ký Tài Khoản với thông tin xác thực của Quý Khách Hàng và phải cập nhật nếu có bất kỳ thay đổi nào. Mỗi người truy cập phải <strong>có trách nhiệm với mật khẩu, tài khoản và hoạt động của Tài Khoản</strong> trên Ứng Dụng. Quý Khách Hàng phải thông báo đến BANNY Việt Nam khi tài khoản của Quý Khách Hàng bị truy cập trái phép. </p>
                    <p> </p>
                    <p>BANNY Việt Nam không chịu bất kỳ trách nhiệm nào, dù trực tiếp hay gián tiếp, đối với những thiệt hại hoặc mất mát gây ra do: (i) Quý Khách Hàng không tuân thủ quy định, (ii) Quý Khách Hàng không bảo mật hoặc tiết lộ thông tin Tài Khoản, hoặc (iii) bất kỳ cuộc tấn công mạng có chủ đích hoặc không chủ đích nào đối với Ứng Dụng và/hoặc tài khoản cụ thể; (iv) việc Tài Khoản của Quý Khách Hàng bị mất quyền kiểm soát, truy cập hoặc sử dụng trái phép là kết quả của bất kỳ phần mềm, ứng dụng, thiết bị theo dõi, mã hóa, bẻ khóa, điều khiển từ xa, sự xâm phạm trái phép mật khẩu nào được cài đặt trên thiết bị cá nhân của Quý Khách Hàng dù là vô tình hay cố ý; hoặc (v) bất kỳ sự sử dụng trái phép nào đối với Tài Khoản của Quý Khách Hàng trước thời điểm Quý Khách Hàng thông báo đến BANNY Việt Nam. </p>
                    <p> </p>
                    <h4><strong>3. QUY ĐỊNH VỀ THỰC HIỆN GIAO DỊCH TRỰC TUYẾN</strong> </h4>
                    <p> </p>
                    <p>3.1.   Chức năng giao dịch trực tuyến để sử dụng Dịch Vụ của BANNY Việt Nam (bao gồm Vé Xem Phim, các sản phẩm và dịch vụ khác do BANNY Việt Nam cung cấp tại từng thời điểm) hiện chỉ áp dụng cho thành viên của BANNY Việt Nam. Tham khảo thông tin đăng ký thành viên BANNY tại <a href="#">ĐÂY</a> </p>
                    <p> </p>
                    <p><strong>3.2.   Đối với giao dịch trực tuyến để mua Vé Xem Phim:</strong> </p>
                    <p> </p>
                    <p>(i)    BANNY Việt Nam cho phép giao dịch trực tuyến đối với Vé Xem Phim trước thời điểm Bộ Phim được chiếu và trong suốt thời gian Bộ Phim được cấp quyền phổ biến tại các Cụm Rạp Chiếu Phim BANNY Cinemas, tuy nhiên việc sắp xếp suất chiếu Bộ Phim phụ thuộc vào mỗi Bộ phim, mỗi Cụm Rạp Chiếu Phim BANNY Cinemas. </p>
                    <p> </p>
                    <p>Nếu suất chiếu Quý Khách Hàng muốn đặt chưa được hiển thị trên Ứng Dụng vào thời điểm đặt vé, xin vui lòng quay lại sau, hoặc liên hệ tới số đường dây nóng: 1900 6017 để biết thêm thông tin chi tiết. </p>
                    <p> </p>
                    <p>(ii)    Thời gian đóng chức năng giao dịch trực tuyến đối với Vé Xem Phim là 30 phút trước giờ chiếu phim hoặc khi suất chiếu đã được bán hết vé. Sau thời gian này Quý Khách Hàng có thể đến liên hệ trực tiếp tại Cụm Rạp Chiếu Phim BANNY Cinemas cụ thể để mua vé. </p>
                    <p> </p>
                    <p>(iii)   BANNY Việt Nam không cam kết giữ chỗ ngồi cho Quý Khách Hàng cho đến khi Quý Khách Hàng hoàn tất thanh toán cho đơn hàng của mình. </p>
                    <p> </p>
                    <p><strong>Đối với giao dịch trực tuyến để mua các sản phẩm, dịch vụ khác của BANNY Việt Nam</strong> </p>
                    <p> </p>
                    <p>-   Đối với các giao dịch mua sản phẩm bắp nước, sản phẩm sẽ phụ thuộc vào mỗi Cụm Rạp Chiếu Phim BANNY Cinemas. </p>
                    <p> </p>
                    <p>-   Khách hàng mang theo email xác nhận đơn hàng hoặc thông tin đơn hàng trên ứng dụng để nhận hàng tại rạp đã chọn khi đặt hàng. Mã Coupon chỉ được sử dụng 1 lần và chỉ có giá trị sử dụng trong ngày đã chọn khi đặt hàng. BANNY Việt Nam sẽ không chịu trách nhiệm khi Coupon quá hạn sử dụng. Mã Coupon sau khi thanh toán không được hoàn trả và không thể quy đổi thành tiền mặt.  Những giao dịch đã thanh toán đổi vị bắp/nước sẽ không được hoàn trả chênh lệch (nếu có) khi khách hàng có mong muốn đổi sang các vị khác khi nhận hàng. Giao dịch được tích điểm thành viên </p>
                    <p> </p>
                    <p>-   Đối với thẻ quà tặng của BANNY Việt Nam, quý khách có thể mua tặng bạn bè hoặc trực tiếp sử dụng cho các giao dịch thanh toán vé, sản phẩm bắp nước của BANNY Việt Nam. Bao gồm cả mua vé tại quầy và trực tuyến. Hạn sử dụng là một năm cho thẻ quà tặng mới. Quý khách có thể gia hạn thẻ quà tặng của BANNY Việt Nam bằng cách nạp thêm tiền vào tài khoản. </p>
                    <p> </p>
                    <p>-   Các điều kiện riêng biệt đối với các sản phẩm, dịch vụ khác do BANNY Việt Nam cung cấp trong tương lai để tăng cường trải nghiệm và hài lòng của Quý Khách Hàng sẽ được BANNY Việt Nam cập nhật, bổ sung tại từng thời điểm. </p>
                    <p> </p>
                    <p>3.3.   Khi tiến hành các bước thanh toán, Quý Khách Hàng cần đọc kĩ các thông tin mô tả Dịch Vụ trước khi hoàn tất việc xác nhận đơn hàng. <strong>Xác nhận về Dịch Vụ</strong> sẽ được BANNY Việt Nam xuất cho Quý Khách Hàng theo thông tin đơn hàng đã hoàn tất thanh toán. Xác nhận về Dịch Vụ có thể là (i) Vé Xem Phim điện tử hoặc mã đặt chỗ điện tử; và/hoặc (ii) phiếu xác nhận thông tin sản phẩm, dịch vụ khác của Quý Khách Hàng (hoặc bất kỳ tên gọi nào khác mà bản chất là để xác nhận sản phẩm, dịch vụ mà Quý Khách Hàng đã đặt); và/hoặc (iii) là sự kết hợp của (i) và (ii), tùy từng trường hợp. </p>
                    <p> </p>
                    <p>3.4.   Quý Khách Hàng phải hoàn tất thanh toán cho đơn hàng theo quy định tại Chính Sách Thanh Toán (tham khảo tại <a href="#">ĐÂY</a>) trước khi nhận được <strong>Xác nhận về Dịch Vụ</strong> của đơn hàng đó. Khi Quý Khách Hàng nhấn (click) vào ô “<strong>Thanh toán</strong>” để tiến hành thanh toán, có nghĩa là Quý Khách Hàng xác nhận đồng ý với thông tin đơn hàng; và đồng ý Điều Khoản Chung và Điều Khoản Giao Dịch sẽ được áp dụng cho đơn hàng và Xác nhận về Dịch Vụ trong giao dịch đó. </p>
                    <p> </p>
                    <p>3.5.   Quý Khách Hàng sẽ nhận được thư điện tử xác nhận thông tin chi tiết đơn hàng đã thanh toán và/hoặc Xác nhận về Dịch Vụ thông qua địa chỉ thư điện tử (email) mà Quý Khách Hàng đã cung cấp hoặc thông qua Ứng Dụng. Email xác nhận thông tin đơn hàng có thể đi vào hộp thư rác (spam mail) của Quý Khách Hàng, vì vậy hãy kiểm tra chúng trước khi liên lạc với BANNY Việt Nam. </p>
                    <p> </p>
                    <p>3.6.   Quý Khách Hàng đồng ý rằng, trong những trường hợp có sự thay đổi về Dịch Vụ; trong trường hợp bất khả kháng; hoặc trong các trường hợp sự cố xảy ra ngoài tầm kiểm soát của BANNY Việt Nam, BANNY Việt Nam có quyền: </p>
                    <p> </p>
                    <p>(i)     hoàn trả lại bất kỳ khoản thanh toán cho bất kỳ đơn hàng nào từ việc giao dịch trực tuyến qua Ứng Dụng bằng tiền mặt hoặc Phiếu Đổi Vé Xem Phim, phiếu đổi sản phẩm với giá trị tương đương; hoặc </p>
                    <p> </p>
                    <p>(ii)    theo yêu cầu của Quý Khách Hàng, thực hiện thay đổi Dịch Vụ của Quý Khách Hàng thành Dịch Vụ khác có cùng điều kiện, và có cùng giá trị. Việc đổi thành Dịch Vụ có giá trị cao hơn <strong>có thể được BANNY Việt Nam chấp nhận</strong> tùy điều kiện sẵn có của Dịch Vụ được yêu cầu tại thời điểm đó với điều kiện Quý Khách Hàng phải thanh toán phần chênh lệch. Trong mọi trường hợp, BANNY Việt Nam sẽ không hoàn trả cho Quý Khách Hàng khoản tiền chênh lệch nếu Quý Khách Hàng chọn đổi sang Dịch Vụ có giá trị thấp hơn giá trị mà Quý Khách Hàng đã thanh toán. </p>
                    <p> </p>
                    <h4><strong>4. GIÁ VÉ </strong></h4>
                    <p> </p>
                    <p>4.1.  Giá Vé Xem Phim Tiêu Chuẩn được niêm yết tại Cụm Rạp Chiếu Phim BANNY Cinemas và trên Ứng Dụng là Giá Vé Xem Phim Tiêu Chuẩn <strong>đã bao gồm thuế Giá trị gia tăng</strong>. Giá Vé Xem Phim Tiêu Chuẩn có thể thay đổi tùy từng thời điểm, tùy từng chương trình khuyến mại được áp dụng và sẽ được hiển thị rõ tại trang Thanh toán khi Quý Khách Hàng tiến hành đặt hàng. </p>
                    <p> </p>
                    <p>4.2.  <strong>GIÁ VÉ XEM PHIM TIÊU CHUẨN KHI THAM GIA GIAO DỊCH TRỰC TUYẾN TRÊN ỨNG DỤNG LÀ GIÁ VÉ XEM PHIM TIÊU CHUẨN ÁP DỤNG ĐỐI VỚI NGƯỜI LỚN</strong>. Quý Khách Hàng vui lòng thực hiện giao dịch trực tiếp tại các Cụm Rạp Chiếu Phim BANNY Cinemas để được hưởng ưu đãi áp dụng cho đối tượng được hưởng ưu đãi theo quy định pháp luật và BANNY Việt Nam tại từng thời điểm. </p>
                    <h4><strong>5. PHÂN LOẠI PHIM THEO ĐỘ TUỔI </strong></h4>
                    <p> </p>
                    <p><strong>5.1.  Phân loại phim</strong> </p>
                    <p> </p>
                    <p>BANNY Việt Nam thông báo tiêu chí phân loại phim theo độ tuổi, như sau: </p>
                    <p> </p>
                    <p>T18: Phim được phổ biến đến người xem từ đủ 18 tuổi trở lên (18+). </p>
                    <p>T16: Phim được phổ biến đến người xem từ đủ 16 tuổi trở lên (16+). </p>
                    <p>T13: Phim được phổ biến đến người xem từ đủ 13 tuổi trở lên (13+). </p>
                    <p>K: Phim được phổ biến đến người xem dưới 13 tuổi và có người giám hộ đi kèm. </p>
                    <p>P: Phim được phép phổ biến đến người xem ở mọi độ tuổi. </p>
                    <p>C: Phim không được phép phổ biến. </p>
                    <p> </p>
                    <p><strong>5.2.  Lưu ý</strong> </p>
                    <p> </p>
                    <p>-   Quý Khách Hàng xem phim được phân loại T13, T16, T18 vui lòng mang theo giấy tờ tùy thân có ảnh nhận diện và ngày tháng năm sinh để đảm bảo việc tuân thủ theo quy định. BANNY Việt Nam có quyền yêu cầu khách hàng xuất trình Giấy khai sinh, Căn cước công dân, Thẻ học sinh, thẻ sinh viên, bằng lái xe, hoặc các giấy tờ tùy thân khác để xác định độ tuổi Quý Khách Hàng. </p>
                    <p> </p>
                    <p>-   Ban Quản Lý Cụm Rạp Chiếu Phim BANNY Cinemas có quyền kiểm tra và từ chối Quý Khách Hàng nếu không tuân thủ đúng quy định về độ tuổi. </p>
                    <p> </p>
                    <p><strong>5.3.  Hình thức chế tài</strong> </p>
                    <p> </p>
                    <p>Phạt tiền từ 60.000.000 đồng đến 80.000.000 đồng đối với hành vi vi phạm quy định. </p>
                    <p> </p>
                    <h4><strong>6. QUY ĐỊNH VỀ KHUNG GIỜ CHIẾU PHIM CHO TRẺ EM</strong> </h4>
                    <p> </p>
                    <p>BANNY Việt Nam thông báo áp dụng quy định về khung giờ chiếu phim cho trẻ em* như sau: </p>
                    <p> </p>
                    <p>(i)   Giờ chiếu phim cho trẻ em dưới 13 tuổi tại Cụm Rạp Chiếu Phim BANNY Cinemas kết thúc trước 22 giờ. </p>
                    <p> </p>
                    <p>(ii)  Giờ chiếu phim cho trẻ em dưới 16 tuổi tại Cụm Rạp Chiếu Phim BANNY Cinemas kết thúc trước 23 giờ. </p>
                    <p> </p>
                    <p>6.2.  Lưu ý </p>
                    <p> </p>
                    <p>-       Để thực hiện theo quy định trên, BANNY Việt Nam có quyền yêu cầu khách hàng xuất trình Giấy khai sinh, Căn cước công dân, Thẻ học sinh, thẻ sinh viên, bằng lái xe, hoặc các giấy tờ tùy thân khác để xác định độ tuổi Quý Khách Hàng. </p>
                    <p> </p>
                    <p>-       Ban Quản Lý Cụm Rạp Chiếu Phim BANNY Cinemas có quyền kiểm tra và từ chối Quý Khách Hàng nếu không tuân thủ đúng quy định về độ tuổi. </p>
                    <p> </p>
                    <p>6.3.  Hình thức chế tài </p>
                    <p> </p>
                    <p>Phạt tiền từ 40.000.000 đồng đến 60.000.000 đồng đối với hành vi vi phạm quy định. </p>
                    <h4><strong>7. GIÁ TRỊ GIAO DỊCH VÀ HÌNH THỨC THANH TOÁN</strong> </h4>
                    <p> </p>
                    <p>7.1.  Khi Quý Khách Hàng thực hiện thao tác đặt hàng trên Ứng Dụng, BANNY Việt Nam hiểu rằng Quý Khách Hàng đã đọc kỹ, hiểu rõ, nắm bắt đầy đủ thông tin về Dịch Vụ và chấp nhận giao dịch. </p>
                    <p> </p>
                    <p>7.2.  BANNY Việt Nam có quyền từ chối hoặc hủy đơn hàng của Quý Khách Hàng vì bất kỳ lý do gì liên quan đến lỗi kỹ thuật, hệ thống một cách khách quan vào bất kỳ lúc nào. BANNY Việt Nam có thể hỏi thêm về số điện thoại và địa chỉ của quý khách trước khi nhận đơn hàng. </p>
                    <p> </p>
                    <p>7.3.  BANNY Việt Nam cam kết sẽ cung cấp thông tin giá cả chính xác nhất cho khách hàng. Tuy nhiên, đôi lúc vẫn có sai sót xảy ra, ví dụ như trường hợp Đơn Giá không hiển thị chính xác trên Ứng Dụng hoặc sai giá, tùy theo từng trường hợp BANNY Việt Nam sẽ liên hệ hướng dẫn hoặc thông báo hủy đơn hàng đó cho Quý Khách Hàng. BANNY Việt Nam cũng có quyền từ chối hoặc hủy bỏ bất kỳ đơn hàng nào dù đơn hàng đó đã hay chưa được xác nhận hoặc đã thanh toán. </p>
                    <p> </p>
                    <p>7.4.  Ứng Dụng được tích hợp các hình thức thanh toán không dùng tiền mặt, bao gồm: </p>
                    <p> </p>
                    <p>(i)     Thẻ Thanh toán Quốc tế hoặc thẻ Thanh toán Nội địa; </p>
                    <p> </p>
                    <p>(ii)    Ví điện tử (Momo, Zalopay, ShopeePay, Viettelpay); </p>
                    <p> </p>
                    <p>(iii)   Các cổng thanh toán Payoo, VNPAY và ứng dụng QR code; </p>
                    <p> </p>
                    <p>(iv)   Thẻ quà Tặng BANNY Cinemas (BANNY Gift cards, BANNY E-Gift cards), Phiếu đổi vé Xem phim BANNY Cinemas (BANNY vouchers, BANNY E-vouchers); </p>
                    <p> </p>
                    <p>(v)   Thẻ BANNYIANS và thẻ CJ Members; và </p>
                    <p> </p>
                    <p>(vi)  Điểm thưởng tích lũy của Thành viên BANNY Việt Nam theo chương trình tích lũy điểm thưởng tại từng thời điểm. </p>
                    <p> </p>
                    <p>Trừ một số trường hợp có ghi chú riêng, thông thường Quý Khách Hàng có thể lựa chọn một trong các hình thức thanh toán trên khi tiến hành đặt vé. </p>
                    <p> </p>
                    <p>7.5. BANNY Việt Nam có quyền từ chối chấp nhận việc thanh toán bằng thẻ tín dụng của Quý Khách Hàng trong một số trường hợp theo quyết định của BANNY Việt Nam, miễn là BANNY Việt Nam tuân thủ các hướng dẫn của ngân hàng liên quan. </p>
                    <p> </p>
                    <p>7.6. Để đảm bảo an toàn thanh toán, Quý Khách Hàng lưu ý: </p>
                    <p> </p>
                    <p>Chỉ thực hiện thanh toán trực tuyến tại cửa sổ liên kết từ BANNY Việt Nam chuyển đến;Sử dụng và bảo quản thẻ và thông tin tài khoản/thông tin thẻ cẩn thận;Không cho người khác mượn hoặc sử dụng Tài Khoản, thẻ thành viên để giao dịch trên Ứng Dụng. Ngay khi phát hiện giao dịch phát sinh bất thường tại Ứng Dụng, Quý Khách Hàng cần liên hệ ngay với bộ phận chăm sóc Khách Hàng của BANNY Việt Nam để được hỗ trợ kịp thời;Trong mọi trường hợp, với Thẻ Tín Dụng/ Thẻ Ghi Nợ Quốc Tế, Quý Khách Hàng <strong>KHÔNG ĐỂ LỘ</strong> dãy bảo mật CVV/CVC/CSC (là mã số bảo mật, bộ ba kí tự số được in trên Thẻ);Kiểm tra các ứng dụng thanh toán của Quý Khách Hàng thường xuyên để đảm bảo tất cả giao dịch qua Ứng Dụng đều nằm trong tầm kiểm soát. </p>
                    <p> </p>
                    <h4><strong>8. ĐIỂM THƯỞNG VÀ ĐỔI ĐIỂM</strong> </h4>
                    <p> </p>
                    <p>Quy định về tích lũy và quy đổi điểm thưởng được thực hiện theo chương trình khuyến mại của BANNY Việt Nam tại từng thời điểm. </p>
                    <p> </p>
                    <p>BANNY Việt Nam khuyến khích Quý Khách Hàng đăng ký tài khoản thành viên trên Ứng Dụng để tiện theo dõi lịch sử giao dịch, nhận thông tin cập nhật về hàng hóa, các chương trình khuyến mại, hưởng các ưu đãi đối với khách hàng thân thiết </p>
                    <p> </p>
                    <h4>9. QUY TRÌNH GIAO DỊCH TRỰC TUYẾN </h4>
                    <p> </p>
                    <p>Quý Khách Hàng khi giao dịch trực tuyến phải đăng nhập Tài Khoản và thực hiện các thao tác theo trình tự sau: </p>
                    <p> </p>
                    <p>Bước 1: Quý Khách Hàng lựa chọn Dịch Vụ xem phim hoặc sản phẩm, dịch vụ khác của BANNY Việt Nam.</p>
                    <p>Bước 2: </p>
                    <p> </p>
                    <p>-     Nếu Khách Hàng lựa chọn Dịch Vụ Xem Phim: Quý Khách Hàng lựa chọn Bộ Phim theo suất chiếu hoặc theo Cụm Rạm Chiếu Phim BANNY Cinemas; sau đó lựa chọn chỗ ngồi.</p>
                    <p> </p>
                    <p>-     Nếu Khách Hàng lựa chọn sản phẩm, Dịch Vụ khác: Quý Khách Hàng lựa chọn sản phẩm, dịch vụ theo nhu cầu.</p>
                    <p>Bước 3: Thanh toán bằng các hình thức thanh toán quy định tại Điều 7. </p>
                    <p>Bước 4: Quý Khách hàng nhận Xác nhận về Dịch Vụ tại Ứng Dụng và email. </p>
                    <p>Bước 5: Quý Khách hàng cung cấp Xác nhận về Dịch Vụ và các thông tin Tài Khoản dùng đã thực hiện giao dịch để nhận Vé Xem Phim vật lý và/hoặc sản phẩm, dịch vụ khác tại Cụm Rạp Chiếu Phim BANNY Cinemas. Quý Khách Hàng chỉ có thể sử dụng Dịch Vụ tại Cụm Rạp Chiếu Phim BANNY Cinemas đã lựa chọn. Nếu Quý Khách Hàng không cung cấp được thông tin Tài Khoản và/hoặc Xác nhận về Dịch Vụ, BANNY Việt Nam có quyền từ chối cung cấp Dịch Vụ liên quan. </p>
                    <h1>10. THAY ĐỔI, HỦY BỎ GIAO DỊCH TRỰC TUYẾN TRÊN ỨNG DỤNG </h1>>
                    <p> </p>
                    <p>10.1.    Hiện tại BANNY Việt Nam đã ra mắt chức năng “Hoàn vé chủ động”, qua chức năng này của BANNY Việt Nam, Quý Khách Hàng có thể hủy suất chiếu đã đặt trước và đặt lại vào dịp khác thuận tiện hơn mà không cần phải liên lạc với đội ngũ hỗ trợ khách hàng của BANNY Việt Nam. Khách hàng có thể tham khảo thêm về điều kiện và quy định <a href="#">tại đây</a>. </p>
                    <p> </p>
                    <p>BANNY Việt Nam chưa hỗ trợ chức năng hủy hoặc thay đổi thông tin vé đã thanh toán thành công nếu Quý Khách Hàng không thỏa điều kiện sử dụng chức năng “Hoàn vé chủ động”. </p>
                    <p> </p>
                    <p>10.2.    Chức năng “Hoàn vé chủ động” chỉ áp dụng cho dịch vụ xem phim; đối với các sản phẩm và dịch vụ khác của BANNY Việt Nam trên Ứng Dụng, BANNY Việt Nam hiện chưa hỗ trợ các chức năng này và các chức năng tương tự. </p>
                    <p> </p>
                    <h4><strong>11. XỬ LÝ GIAO DỊCH LỖI</strong> </h4>
                    <p> </p>
                    <p>11.1.    Ứng Dụng của BANNY Việt Nam có liên kết với rất nhiều đối tác cung cấp dịch vụ thanh toán, bao gồm các ngân hàng nội địa và các Tổ chức tín dụng quốc tế, các đơn vị cung cấp dịch vụ trung gian thanh toán qua Cổng thanh toán, Ví điện tử. Việc thanh toán thành công hay không phụ thuộc rất nhiều vào kết nối mạng của Quý Khách Hàng, việc truyền dẫn, nhận và trả tín hiệu của đối tác cung cấp dịch vụ thanh toán nêu trên. BANNY Việt Nam <strong>chỉ thực hiện hoàn tiền</strong> trong trường hợp giao dịch, tài khoản của Quý Khách Hàng đã bị trừ tiền nhưng hệ thống của BANNY Việt Nam không ghi nhận Dịch Vụ phát sinh đó, và Quý Khách Hàng không nhận được Xác nhận về Dịch Vụ thành công. Khi đó, Quý Khách Hàng vui lòng liên hệ đường dây nóng: 1900 6017 (từ 8:00 đến 22:00 tất cả các ngày trong tuần) hoặc có thể liên hệ với BANNY Việt Nam qua địa chỉ email: hoidap@cgv.vn để được hỗ trợ. </p>
                    <p> </p>
                    <p>11.2.    Sau khi đã xác nhận các thông tin do Quý Khách Hàng cung cấp về giao dịch không thành công, tùy theo từng loại tài khoản Quý Khách Hàng sử dụng mà việc hoàn tiền sẽ có thời gian khác nhau: </p>
                    <p> </p>
                    <p>Thẻ Ghi nợ/ Thẻ thanh toán Nội địa: hoàn tiền trong 07-15 ngày (không tính Ngày Thứ Bảy, Ngày Chủ Nhật và ngày nghỉ Lễ, Tết theo quy định của pháp luật Lao động). </p>
                    <p>Thẻ Tín Dụng/ Thẻ Ghi Nợ Quốc Tế, Thẻ Thanh Toán Quốc tế: hoàn tiền trong 07-30 ngày (không tính Ngày Thứ Bảy, Ngày Chủ Nhật và ngày nghỉ Lễ, Tết theo quy định của pháp luật Lao động). </p>
                    <p>Ví Điện Tử: sẽ được hoàn trực tiếp vào số dư trên ví trong vòng 05-10 ngày (không tính Ngày Thứ Bảy, Ngày Chủ Nhật và ngày nghỉ Lễ, Tết theo quy định của pháp luật Lao động). Các trường hợp thanh toán bằng ví nhưng thông qua liên kết thẻ sẽ tương tự trường hợp Thẻ Nội Địa Và Quốc Tế như trên. </p>
                    <h4><strong>12. QUYỀN SỞ HỮU TRÍ TUỆ</strong> </h4>
                    <p> </p>
                    <p>Mọi quyền sở hữu trí tuệ (đã đăng ký hoặc chưa đăng ký), nội dung thông tin và tất cả các thiết kế, văn bản, đồ họa, phần mềm, hình ảnh, video, âm nhạc, âm thanh, biên dịch phần mềm, mã nguồn và phần mềm cơ bản đều là tài sản của BANNY Việt Nam. Toàn bộ nội dung của Ứng Dụng được bảo vệ theo pháp luật sở hữu trí tuệ của Việt Nam và các công ước, điều ước quốc tế mà Việt Nam tham gia hoặc là thành viên. </p>
                    <h4><strong>13. LUẬT ÁP DỤNG VÀ GIẢI QUYẾT TRANH CHẤP</strong> </h4>
                    <p> </p>
                    <p>Các điều kiện, điều khoản và nội dung của Điều Khoản Giao Dịch được điều chỉnh và giải thích theo luật pháp Việt Nam. Các tranh chấp phát sinh từ hoặc liên quan đến (các) giao dịch thực hiện tại Ứng Dụng này sẽ được ưu tiên giải quyết thông qua thương lượng, hòa giải. Trường hợp các bên không tự giải quyết, tranh chấp sẽ được đưa ra xét xử tại Tòa án cấp có thẩm quyền của Việt Nam. </p>
                    <h4><strong>14. QUY ĐỊNH VỀ BẢO MẬT</strong> </h4>
                    <p> </p>
                    <p>BANNY Việt Nam coi trọng việc bảo mật thông tin và sử dụng các biện pháp tốt nhất bảo vệ thông tin và việc thanh toán của Quý Khách Hàng. Thông tin của Quý Khách Hàng trong quá trình thanh toán sẽ được mã hóa để đảm bảo an toàn. Sau khi Quý Khách Hàng hoàn thành quá trình đặt hàng, Quý Khách Hàng sẽ thoát khỏi chế độ an toàn. </p>
                    <p> </p>
                    <p>Quý Khách Hàng không được sử dụng bất kỳ chương trình, công cụ hay hình thức nào khác để can thiệp vào hệ thống hay làm thay đổi cấu trúc dữ liệu. Quý Khách Hàng KHÔNG ĐƯỢC phát tán, truyền bá hay cổ vũ cho bất kỳ hoạt động nào nhằm can thiệp, phá hoại hay xâm nhập vào dữ liệu của hệ thống Ứng Dụng. Cá nhân hay tổ chức vi phạm sẽ bị tước bỏ mọi quyền lợi cũng như sẽ bị truy tố trước pháp luật nếu cần thiết. Mọi thông tin giao dịch sẽ được bảo mật trừ trường hợp buộc phải cung cấp theo yêu cầu của tòa án, (các) cơ quan có thẩm quyền hoặc theo quy định của pháp luật. </p>
                    <h4><strong>15. GIẢI QUYẾT HẬU QUẢ DO LỖI NHẬP SAI THÔNG TIN</strong> </h4>
                    <p> </p>
                    <p>Quý Khách hàng có trách nhiệm cung cấp thông tin đầy đủ và chính xác khi tham gia giao dịch trên Ứng Dụng. Trong trường hợp Quý Khách Hàng nhập sai thông tin trên Ứng Dụng, BANNY Việt Nam có quyền từ chối thực hiện giao dịch. </p>
                    <p> </p>
                    <p>Ngoài ra, trong mọi trường hợp, Quý Khách Hàng đều có quyền đơn phương chấm dứt giao dịch nếu đã thông báo cho BANNY Việt Nam qua đường dây nóng: 1900 6017. Hệ quả của chấm dứt giao dịch sẽ được BANNY Việt Nam thông báo rõ đến Quý Khách Hàng. </p>
                    <h4><strong>16. QUY ĐỊNH CHẤM DỨT THỎA THUẬN</strong> </h4>
                    <p> </p>
                    <p>Trong trường hợp có bất kỳ thiệt hại nào phát sinh do việc vi phạm quy định sử dụng Ứng Dụng, BANNY Việt Nam có quyền đình chỉ hoặc khóa tài khoản của Quý Khách Hàng vĩnh viễn, tùy vào mức độ nghiêm trọng hoặc mức độ thường xuyên của vi phạm. Nếu Quý Khách Hàng không hài lòng với Ứng Dụng hoặc bất kỳ điều khoản, điều kiện, quy tắc, chính sách, hướng dẫn, hoặc cách thức vận hành của BANNY Việt Nam thì biện pháp khắc phục duy nhất là ngưng sử dụng Dịch Vụ. </p>
                    <p> </p>
                    <p> </p>
                    <p><strong>QUÝ KHÁCH HÀNG LƯU Ý CHỈ THỰC HIỆN GIAO DỊCH KHI CHẤP NHẬN VÀ HIỂU RÕ NHỮNG QUY ĐỊNH TRÊN.</strong> </p>
                    <p> </p>
                    <p> </p>
                    <p>Khi cần hỗ trợ thêm thông tin, Quý Khách Hàng vui lòng tham khảo tại <a href="#">ĐÂY</a>. </p>
                    <p> </p>
                
                    
                </div>

            </div>

        </div>
        <%@include file="../footer.jsp" %>
    </div>
</body>
</html>
