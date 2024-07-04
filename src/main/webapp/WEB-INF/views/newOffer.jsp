<%-- 
    Document   : newOffer
    Created on : Jun 21, 2024, 1:05:45 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .newOffers{
                margin-top: 125px;
                background: url(https://www.cgv.vn/skin/frontend/cgv/default/images/bg-cgv/bg_h3_line.jpg)
                    repeat-x scroll left center rgba(0, 0, 0, 0);
                height: 60px;
                text-align: center;
                width: 100%;
            }

            .all-movie{
                border: 2px solid black; /* Thêm màu cho border để dễ nhìn thấy */
                background: red;
                display: inline-block;
                padding: 5px 10px; /* Giảm kích thước padding */
                text-align: center;
                margin: 0 auto; /* Căn giữa phần tử */
            }

        </style>
    </head>

    <body style="text-align: center">
        <%@include file="header.jsp" %> 
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <div class="newOffers">
                    <h2 style="background: url(../images/bg-cgv/bg-new-offer-vn.png) no-repeat scroll top center #FDFCF0;
                        background-size: 410px 46px;
                        display: inline-block;
                        width: 410px;
                        ">
                        <img
                            src="https://www.cgv.vn/skin/frontend/cgv/default/images/bg-cgv/bg-new-offer-vn.png"
                            alt=" "
                            />
                    </h2>                  
                </div>

                <div class="all-movie">
                    <a href="nowShowing">Xem Phim Ngay!</a>

                </div>
            </div>
            <div class="col-2"></div>

            <img src="	https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/2024/062024/DM4_GCard_240x201.jpg" class="rounded float-start" alt="...">
            <img src="	https://iguov8nhvyobj.vcdn.cloud/media/wysiwyg/2024/062024/DM4_GCard_240x201.jpg" class="rounded float-end" alt="...">
        </div>
        <%@include file="footer.jsp" %>
    </body>


</html>
