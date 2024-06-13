<%-- 
    Document   : Carrer
    Created on : Jun 12, 2024, 1:37:15 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
    </head>
    <%@include file="header.jsp" %>
    <body>
        <div class="page">
            <div class="main-container">
                <div class="main">
                    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>

                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/career/cgv-football.jpg" class="d-block w-100" alt=" ">
                            </div>
                            <div class="carousel-item">
                                <img src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/z4410924643120_ad97087d62f2128232ea4fe89883838b.png" class="d-block w-100" alt=" ">
                            </div>
                            <div class="carousel-item">
                                <img src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/THT_2724.png" class="d-block w-100" alt=" ">
                            </div>
                            <div class="carousel-item">
                                <img src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/career/cgv-outing-2.jpg" class="d-block w-100" alt=" ">
                            </div>

                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    
                    <div>
                        <p style="color: red; font-size: 2.3rem; font-weight: bold; padding-block-start: 100px; text-align: center">ĐỒNG HÀNH CÙNG BANNY CINEMA VIỆT NAM</p>
                    
                        <P>CJ CGV trực thuộc CJ Group, một trong những tập đoàn kinh tế đa ngành lớn nhất Hàn Quốc. CJ CGV nằm trong trong top 05 cụm rạp chiếu phim lớn nhất toàn cầu và là nhà phát hành, cụm rạp chiếu phim lớn nhất tại Việt Nam.</P>
                        
                        <p style="font-weight: bolder; font-size: 1.4rem">Lịch sử phát triển</p>
                        <p>Cùng với việc phát triển các giá trị cốt lõi về nuôi dưỡng nhân tài hàng đầu, kiến tạo văn hóa cương nhu để trở thành doanh nghiệp phong cách sống toàn cầu. CJ CGV Việt Nam mong muốn mang đến nhiều cơ hội việc làm cho các tài năng trẻ, năng động và yêu thích ngành công nghiệp điện ảnh.</p>
                        <p>Chúng tôi chào đón bạn gia nhập đại gia đình CJ CGV Việt Nam thông qua các cơ hội nghề nghiệp cho cả khối văn phòng và khối cụm rạp:</p>
                        <p style="text-align: center">
                            <img src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/member-star.png" alt=" "/>
                        </p>
                        <p style="text-align: center">KÊNH TUYỂN DỤNG</p>
                        
                        <p style="text-align: center">
                            <img src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/member-star.png" alt=" "/>
                        </p>
                        
                    </div>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"
    ></script>
</html>
