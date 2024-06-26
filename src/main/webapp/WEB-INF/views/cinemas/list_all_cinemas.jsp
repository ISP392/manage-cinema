<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Movie Schedule</title>
        <link rel="stylesheet" href="./assets/css/list_all_cinemas_style.css" />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
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
        <%@include file="/WEB-INF/views/header.jsp" %>
        <div class="header">
            <h2>Lịch chiếu phim BANNY</h2>
        </div>
        <div class="container-list-movie">
            <div class="sidebar">
                <div class="dropdown" style="margin: 20px 20px 20px 20px; width: 88%">
                    <button class="dropbtn">Vị Trí</button>
                    <ul style="padding: 0" class="dropdown-content">
                        <c:forEach items="${locations}" var="location">
                            <li>
                                <a
                                    href="list_all_cinemas?locationID=${location.locationID}&date=<%= daysOfMonth_header.get(0) %>"
                                    >${location.name}</a
                                >
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <c:forEach items="${cinemas}" var="cinema_for">
                    <div
                        class="theater-list ${cinema_for.name eq cinema ? 'select' : ''}"
                        >
                        <div class="theater-detail">
                            <a href="list_all_cinemas?locationID=${locationID}&date=<%= daysOfMonth_header.get(0) %>&cinemaName=${cinema_for.name}">
                                <img
                                    src="./assets/images/logo_home.png"
                                    alt="alt"
                                    width="34px"
                                    height="34px"
                                    />
                                <div style="font-weight: 400; display: inline-block" class="theater-name">
                                    ${cinema_for.name}
                                </div>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="content">
                <div class="date-buttons">
                    <!--//create five date buttons-->
                    <% for (int i = 0; i < 5; i++) {%>
                    <input type="hidden" name="mainDate" value="<%= String.format("%tF", cal.getTime()) %>">
                        <a href="list_all_cinemas?date=<%= daysOfMonth.get(i) %>&locationID=${locationID}&cinemaName=${cinema}">
                            <!--check the i = 0 class date-button has selected-->
                            <div class="date-button <%= (Integer.parseInt(String.valueOf(request.getParameter("date"))) == daysOfMonth.get(i) ? "selected" : "") %>">
                                <div class="date-number"><%= daysOfMonth.get(i) %></div>
                                <div class="date-label"><%= dayOfWeeks.get(i) %></div>
                            </div>
                        </a>
                    <% }%>    
                    
                </div>
                <div class="movie-schedule-container">
                    <c:if test="${empty moviesMap}">
                        <div style="display: flex; flex-direction: column">
                            <div class="no-movie" style="padding-top: 1.25rem">
                                <img style="display:block; margin: 0 auto" src="https://homepage.momocdn.net/next-js/_next/static/public/cinema/not-found.svg" alt="alt"/>
                            </div>
                            <div style="font-weight: 600; font-size: 1.125rem; line-height: 1.75rem; display:block; margin: 0 auto">Úi, Suất chiếu không tìm thấy.</div>
                            <div style="color:#737373; font-size: 0.875rem; line-height: 1.25rem; display:block; margin: 0 auto">Bạn hãy thử tìm ngày khác nhé</div>
                        </div>
                    </c:if>
                    <c:forEach items="${moviesMap}" var="moviesMapEntry">
                        <div class="movie-schedule">
                            <div class="container-img">
                                <div class="left-container">
                                    <img
                                        src="${moviesMapEntry.key.posterImage}"
                                        height="171px"
                                        width="120px"
                                        />
                                </div>
                                <div class="right-container">
                                    <a
                                        href="home"
                                        style="font-size: 16px; font-weight: 700; color: black"
                                        >${moviesMapEntry.key.title}</a
                                    >
                                    <div style="font-size: 13px; color: #3a3a3a">
                                        Hài, Hoạt Hình, Chính Kịch, Gia Đình
                                    </div>
                                    <div class="schedule-times">
                                        <c:forEach items="${moviesMapEntry.value}" var="list_screen_time">
                                            <div class="time-slot"><span style="font-size: 15px; font-weight: 700"><fmt:formatDate value="${list_screen_time.startTime}" pattern="HH:mm" /></span> ~ <fmt:formatDate value="${list_screen_time.endTime}" pattern="HH:mm" /></div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/views/footer.jsp" %>
    </body>
</html>
