<%-- 
    Document   : introduce
    Created on : Jun 16, 2024, 9:24:52 PM
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
                            <li style="background-color:${backgroundColorMain}">
                                <a href="introduce" style="color: ${colorMain}">
                                    GIỚI THIỆU
                                </a>
                            </li>
                            <li style="background-color:${backgroundColorSecond}">
                                <a style="color: ${colorSecond}" href="contact">
                                    LIÊN HỆ CGV
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
                    <p class="intro">Giới Thiệu Banny</p>
                    <p><iframe style="width: 790px; height: 400px; text-align: center" src="https://www.youtube.com/embed/e1ZSLVTZ47M?si=PwhrebPce5tDRpn1"></iframe></p>
                    <p> </p>
                    <p> <strong>Banny</strong> là một trong năm Cụm Rạp Chiếu Phim lớn nhất toàn cầu và <strong>Banny Việt Nam</strong> là Nhà Phát Hành, nhà quản lý và vận hành Cụm Rạp Chiếu Phim CGV Cinemas lớn nhất tại Việt Nam. Mục tiêu của <strong>Banny Việt Nam</strong> là trở thành công ty giải trí điển hình, đóng góp cho sự phát triển không ngừng của lĩnh vực điện ảnh Việt Nam nói riêng và công nghiệp văn hóa mang đậm bản sắc Việt Nam nói chung.</p>
                    <p> </p>
                    <p><strong>Banny Việt Nam</strong> hội nhập, hài hòa và góp phần tạo nên khái niệm độc đáo về việc chuyển đổi cụm rạp chiếu phim truyền thống thành tổ hợp văn hóa <strong>“Cultureplex”</strong>, nơi khán giả không chỉ đến để thưởng thức điện ảnh đa dạng thông qua các công nghệ tiên tiến như <strong>SCREENX, IMAX, STARIUM, 4DX, Dolby Atmos</strong>, mà còn để thưởng thức ẩm thực hoàn toàn mới và khác biệt với các trải nghiệm dịch vụ chất lượng nhất tại Cụm Rạp Chiếu Phim CGV Cinemas.</p>
                    <p><strong>Banny Việt Nam</strong> hướng sự quan tâm đến phát triển nội tại của công nghiệp văn hóa tại Việt Nam, đồng hành cùng điện ảnh nước nhà. Thông qua những nỗ lực trong việc xây dựng <strong>chương trình Nhà biên kịch tài năng, Dự án phim ngắn CJ, Lớp học làm phim TOTO, CGV ArtHouse, phối hợp Học Viện Điện Ảnh Hàn Quốc (KAFA) tổ chức Khóa đào tạo cho các đạo diễn xuất sắc của Dự án phim ngắn CJ, 
                            Banny Việt Nam</strong> mong muốn sẽ đồng hành và hỗ trợ phát triển cho các nhà làm phim trẻ tài năng của Việt Nam. Ngoài ra, bằng những nỗ lực của doanh nghiệp, CGV Việt Nam đã và đang phối hợp với các bên liên quan nhằm đưa các tác phẩm điện ảnh có nội hàm và đậm bản sắc Việt Nam tham gia các Liên Hoan Phim Quốc tế uy tín; tài trợ cho các hoạt động Liên Hoan Phim uy tín tổ chức tại Việt Nam như <strong>Liên Hoan Phim Quốc tế Hà Nội, Liên Hoan Phim Việt Nam,… </p>
                    <p> </p>
                    <p style="font-weight: normal"><strong>Banny Việt Nam</strong> trên hành trình mang điện ảnh đến mọi miền Tổ quốc, cũng tập trung đến đối tượng khán giả ở các khu vực ít có điều kiện tiếp cận với điện ảnh, bằng cách tạo cơ hội để người dân địa phương có thể thưởng thức những 
                        tác phẩm điện ảnh chất lượng thông qua các chương trình vì cộng đồng như <strong>Trăng cười</strong> và <strong>Điện ảnh cho mọi người.</strong></p>
                    <p> </p>
                    <p style="font-weight: normal"><strong>Banny Việt Nam</strong> cam kết nỗ lực, tiếp tục cuộc hành trình bền bỉ trong việc góp phần xây dựng một nền công nghiệp điện ảnh Việt Nam ngày càng vững mạnh cùng các khách hàng tiềm năng, các nhà làm phim, các đối tác kinh doanh uy tín, và cùng toàn thể xã hội.</p>
                    <div class="image">
                        <ul class="image-intro" >
                            <li class="img1"><img class="img" src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/about-1.jpg" alt=""/></li>
                            <li class="img1"><img class="img" src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/about-2.PNG" alt=""/></li>
                            <li class="img1"><img class="img" src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/about-3.PNG" alt=""/></li>
                            <li class="img1"><img class="img" src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/about-4.PNG" alt=""/></li>
                            <li><img class="img" src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/about-5.PNG" alt=""/></li>
                            <li><img class="img" src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/about-6.PNG" alt=""/></li>
                            <li><img class="img" src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/about-7.JPG" alt=""/></li>
                            <li><img class="img" src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/about-8.JPG" alt=""/></li>
                            <li><img class="img" src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/about-9.PNG" alt=""/></li>
                        </ul>

                    </div>
                </div>

            </div>

        </div>
        <%@include file="../footer.jsp" %>
    </div>
</body>
</html>
