<%-- Document : Carrer Created on : Jun 12, 2024, 1:37:15 PM Author : ACER --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <style>
            .container {
                margin-top: 50px;
            }
            .carrer1 {
                height: 225px;
                position: relative;
                display: -ms-flexbox;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #f0eedc;
                background-clip: border-box;
                border: 2px solid #bcb890;
                border-radius: 1.45rem;
            }
            .header {
                color: red;
                font-size: 20px;
                font-weight: bolder;
                text-align: center;
            }
            .sub-header {
                padding: 1rem;
                text-align: center;
                font-weight: bold;
                font-size: 16px;
                margin-bottom: 10px;
            }
            .content {
                margin-left: 20px;
            }
        </style>
    </head>
    <%@include file="header.jsp" %>
    <body>
        <div class="page">
            <div class="main-container">
                <div class="main">
                    <div
                        id="carouselExampleIndicators"
                        class="carousel slide"
                        data-bs-ride="carousel"
                        >
                        <div class="carousel-indicators">
                            <button
                                type="button"
                                data-bs-target="#carouselExampleIndicators"
                                data-bs-slide-to="0"
                                class="active"
                                aria-current="true"
                                aria-label="Slide 1"
                                ></button>
                            <button
                                type="button"
                                data-bs-target="#carouselExampleIndicators"
                                data-bs-slide-to="1"
                                aria-label="Slide 2"
                                ></button>
                            <button
                                type="button"
                                data-bs-target="#carouselExampleIndicators"
                                data-bs-slide-to="2"
                                aria-label="Slide 3"
                                ></button>
                            <button
                                type="button"
                                data-bs-target="#carouselExampleIndicators"
                                data-bs-slide-to="3"
                                aria-label="Slide 4"
                                ></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img
                                    src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/career/cgv-football.jpg"
                                    class="d-block w-100"
                                    alt=" "
                                    />
                            </div>
                            <div class="carousel-item">
                                <img
                                    src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/z4410924643120_ad97087d62f2128232ea4fe89883838b.png"
                                    class="d-block w-100"
                                    alt=" "
                                    />
                            </div>
                            <div class="carousel-item">
                                <img
                                    src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/THT_2724.png"
                                    class="d-block w-100"
                                    alt=" "
                                    />
                            </div>
                            <div class="carousel-item">
                                <img
                                    src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/career/cgv-outing-2.jpg"
                                    class="d-block w-100"
                                    alt=" "
                                    />
                            </div>
                        </div>
                        <button
                            class="carousel-control-prev"
                            type="button"
                            data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="prev"
                            >
                            <span
                                class="carousel-control-prev-icon"
                                aria-hidden="true"
                                ></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button
                            class="carousel-control-next"
                            type="button"
                            data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="next"
                            >
                            <span
                                class="carousel-control-next-icon"
                                aria-hidden="true"
                                ></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>

                    <div>
                        <p
                            style="
                            color: red;
                            font-size: 2.3rem;
                            font-weight: bold;
                            padding-block-start: 100px;
                            text-align: center;
                            "
                            >
                            ĐỒNG HÀNH CÙNG BANNY CINEMA VIỆT NAM
                        </p>

                        <P
                            >CJ BANNY trực thuộc CJ Group, một trong những tập đoàn kinh tế đa
                            ngành lớn nhất Hàn Quốc. CJ BANNY nằm trong trong top 05 cụm rạp
                            chiếu phim lớn nhất toàn cầu và là nhà phát hành, cụm rạp chiếu
                            phim lớn nhất tại Việt Nam.</P
                        >

                        <p style="font-weight: bolder; font-size: 1.4rem">
                            Lịch sử phát triển
                        </p>
                        <p>
                            Cùng với việc phát triển các giá trị cốt lõi về nuôi dưỡng nhân
                            tài hàng đầu, kiến tạo văn hóa cương nhu để trở thành doanh nghiệp
                            phong cách sống toàn cầu. CJ BANNY Việt Nam mong muốn mang đến
                            nhiều cơ hội việc làm cho các tài năng trẻ, năng động và yêu thích
                            ngành công nghiệp điện ảnh.
                        </p>
                        <p>
                            Chúng tôi chào đón bạn gia nhập đại gia đình CJ BANNY Việt Nam
                            thông qua các cơ hội nghề nghiệp cho cả khối văn phòng và khối cụm
                            rạp:
                        </p>
                        <p style="text-align: center">
                            <img
                                src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/member-star.png"
                                alt=" "
                                />
                        </p>
                        <p style="text-align: center; font-size: 25px; font-weight: bolder">
                            KÊNH TUYỂN DỤNG
                        </p>
                        <table border="0" ; style="width: 100%">
                            <tbody>
                                <tr style="font-size: 20px; font-weight: bolder">
                                    <td style="width: 50%; text-align: center">
                                        <P>KHỐI VĂN PHÒNG</P>
                                    </td>
                                    <td
                                        style="
                                        width: 50%;
                                        text-align: center;
                                        border-left: solid 1px;
                                        "
                                        >
                                        <p>KHỐI CỤM RẠP</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 50%; text-align: center">
                                        <a href="#" style="padding-right: 1rem">
                                            <img
                                                src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/icon_web.png"
                                                alt="alt"
                                                />
                                        </a>
                                        <a>
                                            <img
                                                src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/icon_linkedin.png"
                                                alt="alt"
                                                />
                                        </a>
                                    </td>
                                    <td
                                        style="
                                        width: 50%;
                                        text-align: center;
                                        border-left: solid 1px;
                                        "
                                        >
                                        <a href="#" style="padding-right: 1rem">
                                            <img
                                                src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/icon_web.png"
                                                alt="alt"
                                                />
                                        </a>
                                        <a href="#">
                                            <img
                                                src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/icon_fb.png"
                                                alt="alt"
                                                />
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <p style="text-align: center; padding-block-start: 15px">
                            <img
                                src="https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/web/member-star.png"
                                alt=" "
                                />
                        </p>
                        <div>
                            <p
                                style="text-align: center; font-size: 25px; font-weight: bolder"
                                >
                                CÁCH THỨC ỨNG TUYỂN
                            </p>
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="header">VỊ TRÍ TOÀN THỜI GIAN</div>
                                        <p></p>
                                        <p></p>
                                        <div class="carrer1">
                                            <div class="sub-header">Khối Văn Phòng/ Cụm Rạp</div>
                                            <div class="content">
                                                <p><strong>Cách 1:</strong> Gửi CV ứng tuyển <strong><a href="employmentInformation">Tại đây!</a></strong> với tiêu đề "[HỌ TÊN] - Ứng tuyển [VỊ TRÍ]".</p>
                                                <p><strong>Cách 2:</strong> Nộp hồ sơ trực tiếp trên các trang tuyển dụng uy tín mà BANNY có đăng tuyển như Linkedin, Vietnamwork, Careerbuilder, Hoteljob, Vieclam24, TopCV ....</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="header">VỊ TRÍ BÁN THỜI GIAN</div>
                                        <p></p>
                                        <p></p>
                                        <div class="carrer1">
                                            <div class="sub-header">Khối Cụm Rạp</div>
                                            <div class="content">
                                                <p><strong>Cách 1:</strong> Nộp hồ sơ trực tiếp tại quầy Guest Service của cụm rạp BANNY mà bạn muốn ứng tuyển.</p>
                                                <p><strong>Cách 2:</strong> Theo dõi thông tin tuyển dụng trên Facebook - BANNY Careers.</p>
                                                <p style="font-weight: bold; color: #666666"><i>*Đối tượng: dành cho sinh viên</i></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div>
                                <p> </p>
                                <p><strong style="font-size: 15px">LƯU Ý: </strong></p>
                                <p> </p>
                                <p>- BANNY <strong style="color: #333333">KHÔNG</strong> thu bất kỳ chi phí tuyển dụng nào dưới mọi hình thức (phí hồ sơ, đồng phục….).</p>
                                <p>- Với những vị trí cho khối Cụm Rạp, BANNY <strong style="color: #333333">KHÔNG</strong> tuyển nhân viên thông qua đơn vị khác.</p>
                                <p>- Việc ứng viên nộp hồ sơ xin việc tại công ty TNHH BANNY Việt Nam đồng nghĩa với việc ứng viên đồng ý cho công ty TNHH BANNY Việt Nam thu thập, sử dụng và/hoặc xử lý dữ liệu cá nhân thể hiện trong hồ sơ xin việc để phục vụ cho việc xác minh danh tính & công tác tuyển dụng, làm việc tại công ty TNHH BANNY Việt Nam. Anh/Chị có thể tham khảo Quy đinh về việc bảo vệ dữ liệu cá nhân đối với ứng viên <a href="securityPolicy" style="color: red">tại đây</a>.
                                </p>
                            </div> 
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
