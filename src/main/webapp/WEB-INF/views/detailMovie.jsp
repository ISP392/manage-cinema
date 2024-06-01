<%-- 
    Document   : detailMovie
    Created on : May 29, 2024, 2:30:14 AM
    Author     : caoha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="./assets/images/logo_home.png"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Xem phim</title>
</head>
<body>
<%
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    int today = calendar.get(java.util.Calendar.DAY_OF_MONTH);

    java.util.List<Integer> daysOfMonth = new java.util.ArrayList<>();
    java.util.List<String> dayOfWeeks = new java.util.ArrayList<>();
    java.util.Date date = new java.util.Date();
    java.util.Calendar cal = java.util.Calendar.getInstance();
    cal.setTime(date);
    for (int i = 0; i < 10; i++) {
        int day = cal.get(java.util.Calendar.DAY_OF_MONTH);
        daysOfMonth.add(day);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        String dayOfWeekName = "";
        switch (dayOfWeek) {
            case java.util.Calendar.SUNDAY:
                dayOfWeekName = "Chủ nhật";
                break;
            case java.util.Calendar.MONDAY:
                dayOfWeekName = "Thứ hai";
                break;
            case java.util.Calendar.TUESDAY:
                dayOfWeekName = "Thứ ba";
                break;
            case java.util.Calendar.WEDNESDAY:
                dayOfWeekName = "Thứ tư";
                break;
            case java.util.Calendar.THURSDAY:
                dayOfWeekName = "Thứ năm";
                break;
            case java.util.Calendar.FRIDAY:
                dayOfWeekName = "Thứ sáu";
                break;
            case java.util.Calendar.SATURDAY:
                dayOfWeekName = "Thứ bảy";
                break;
        }
        dayOfWeeks.add(dayOfWeekName);
        cal.add(java.util.Calendar.DAY_OF_MONTH, 1);
    }
%>
<%@include file="header.jsp" %>
<div class="container" style="width:980px">
    <div class="row" style="width: 100%">
        <div class="col-3">
            <div class="poster-image" style="">
                <img style="width: 181px; height:259px; margin-bottom: 10px;border-radius: 8px"
                     src="./assets/images/posterImages/${movie.posterImage}" alt="alt"/>
            </div>
        </div>
        <div class="col-7">
            <div class="product-name">
                <h4 style="font-weight: bold">${movie.title.toUpperCase()}</h4>
                <h5 style="color: red;">${movie.getDisplay() == 0 ? 'ĐANG BỊ ẨN' :''}</h5>
            </div>
            <div>
                <c:set var="genresString" value="" scope="page"/>
                <c:forEach items="${listGenres}" var="genres" varStatus="status">
                    <c:set var="genresString" value="${genresString}${genres.genreID.getName().trim()}" scope="page"/>
                    <c:if test="${!status.last}">
                        <c:set var="genresString" value="${genresString}, " scope="page"/>
                    </c:if>
                </c:forEach>

                <div class="product-detail" style="margin-bottom: 10px"><span
                        style="padding-right: 10px">Thể Loại: </span>
                    <span class="detail-movie">
                        <c:out value="${genresString}"/>
                </span>
                </div>
                <div style="margin-bottom: 10px">
                    <div class="product-detail"><span style="padding-right: 10px">Khởi Chiếu: </span><span
                            class="detail-movie"> ${movie.getReleaseDate()}</span></div>
                </div>
                <div style="margin-bottom: 10px">
                    <div class="product-detail"><span style="padding-right: 10px">Thời Lượng: </span><span
                            class="detail-movie"> ${movie.duration} Phút</span>
                    </div>
                </div>
            </div>
            <button style="${isCommingSoon ? 'display: none;' : ''}">
                <a style="text-decoration: none; color:#fff"
                   href="booking?movieid=${movie.movieID}&date=<%=(daysOfMonth.get(0))%>&direction=2">
                    Mua Vé
                </a>
            </button>
            <c:if test="${sessionScope.account.role.name.equals('admin')}">
                <button>
                    <a style="text-decoration: none; color:#fff;" href="updateMovie?movieID=${movie.movieID}">
                        Sửa Phim
                    </a>
                </button>
                <br/>
                <button>
                    <a style="text-decoration: none; color:#fff" href="addNewSlot?movieID=${movie.movieID}">
                        Thêm Suất Chiếu
                    </a>
                </button>
                <c:if test="${movie.getDisplay() == 1}">
                    <button>
                        <a style="text-decoration: none; color:#fff"
                           href="updateDisplayMovie?movieID=${movie.getMovieID()}&display=0">Ẩn Phim
                        </a>
                    </button>
                </c:if>
                <c:if test="${movie.getDisplay() == 0}">
                    <button style="background-color: #57635a; color: #fff;">
                        <a style="text-decoration: none; color:#fff"
                           href="updateDisplayMovie?movieID=${movie.getMovieID()}&display=1">
                            Hiện Phim
                        </a>
                    </button>
                </c:if>
            </c:if>

        </div>
    </div>
    <div class="description" style="width: 900px; margin-top: 40px; font-size: 20px">
        <p>${movie.description}</p>
    </div>
    <c:if test="${movie.trailerURL != null}">
        <div class="trailer" style="margin-top: 20px; color: cadetblue">
            <h1 style="font-weight: bold; font-size: 35px">Trailer</h1>
            <iframe style="margin-top: 20px; border-radius: 12px" width="980" height="551" src="${movie.trailerURL}"
                    title="YouTube video player" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                    referrerpolicy="strict-origin-when-cross-origin" allowfullscreen>
            </iframe>
        </div>
    </c:if>
    <c:if test="${movie.trailerURL == null}">
        <div class="trailer" style="margin-top: 20px">
            <h1 style="font-weight: bold; font-size: 35px">Trailer</h1>
            <h3 style="font-size: 20px;color: red">Không có trailer</h3>
        </div>
    </c:if>
</div>
<%@include file="footer.jsp" %>

</body>
</html>
