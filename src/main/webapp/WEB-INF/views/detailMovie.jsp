<%-- 
    Document   : detailMovie
    Created on : May 29, 2024, 2:30:14 AM
    Author     : caoha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deatil Movie</title>
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
                    <div class="poster-image" style="" >
                        <img style="width: 181px; height:259px; margin-bottom: 10px;border-radius: 8px" src="./assets/images/posterImages/${movie.posterImage}" alt="alt"/>
                    </div>
                </div>
                <div class="col-7">
                    <div class="product-name">
                        <h4 style="font-weight: bold">${movie.title.toUpperCase()}</h4>
                        <h5 style="color: red;">${movie.getDisplay() == 0 ? 'ĐANG BỊ ẨN' :''}</h>
                    </div>
                    <div>
                        <div class="product-detail">Thể loại: 
                            <span class="detail-movie">
                                <c:forEach items="${listGenres}" var="genres" varStatus="status">
                                    <c:out value="${genres.genreID.getName().trim()}"/>
                                    <c:if test="${!status.last}">, </c:if>
                                </c:forEach>
                            </span>
                        </div>
                        <div class="product-detail"> Khởi chiếu:  <span class="detail-movie"> ${movie.getReleaseDate()}</span></div>
                        <div class="product-detail">Thời lượng:  <span class="detail-movie"> ${movie.duration} Phút</span></div>
                    </div>
                    <button style="${isCommingSoon ? 'display: none;' : ''}"><a style="text-decoration: none; color:#fff" href="booking?movieid=${movie.movieID}&date=<%=(daysOfMonth.get(0))%>&direction=2">Mua Vé</a></button>                  
                    <c:if test="${sessionScope.account.role.name.equals('admin')}">
                        <button><a style="text-decoration: none; color:#fff;" href="updateMovie?movieID=${movie.movieID}">Sửa Phim</a></button><br/>
                        <button><a style="text-decoration: none; color:#fff" href="addNewSlot?movieID=${movie.movieID}">Thêm Suất Chiếu</a></button>
                        <c:if test="${movie.getDisplay() == 1}">
                            <button><a style="text-decoration: none; color:#fff" href="updateDisplayMovie?movieID=${movie.getMovieID()}&display=0">Ẩn Phim</a></button>
                        </c:if>
                        <c:if test="${movie.getDisplay() == 0}">
                            <button style="background-color: #57635a; color: #fff;"><a style="text-decoration: none; color:#fff" href="updateDisplayMovie?movieID=${movie.getMovieID()}&display=1">Hiện Phim</a></button>
                        </c:if>
                    </c:if>

                </div>
            </div>
            <div class="description" style="width: 900px; margin-top: 40px; font-size: 20px">
                <p>${movie.description}</p>
            </div>
        </div>
        <%@include file="footer.jsp" %>

    </body>
</html>
