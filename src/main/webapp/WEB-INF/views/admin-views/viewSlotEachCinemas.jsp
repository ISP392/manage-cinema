<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.ParseException" %>

<%
    // Lấy giá trị date từ URL, nếu không có giá trị thì sử dụng ngày hiện tại
    String dateParam = request.getParameter("date");
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    Date today;
    Calendar cal = Calendar.getInstance();

    if (dateParam != null && !dateParam.isEmpty()) {
        try {
            today = sdf1.parse(dateParam);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        cal.setTime(today);
    } else {
        today = cal.getTime();
    }

    String todayStr = sdf1.format(today);

    // Lấy năm hiện tại từ ngày
    int currentYear = cal.get(Calendar.YEAR);
    int defaultYear = cal.get(Calendar.YEAR);

    // Lấy tuần hiện tại từ ngày
    int currentWeek = cal.get(Calendar.WEEK_OF_YEAR);

    // Thiết lập ngày bắt đầu của tuần
    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    Date monday = cal.getTime();

    // Lưu trữ các ngày của tuần hiện tại
    SimpleDateFormat displayFormat = new SimpleDateFormat("MM/dd");
    SimpleDateFormat fullDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date[] weekDays = new Date[7];
    for (int i = 0; i < 7; i++) {
        weekDays[i] = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 1);
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Styled Dynamic Schedule</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 1490px;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
        select {
            padding: 8px;
            margin-right: 5px;
        }
        .selected {
            background-color: #007BFF;
            color: white;
        }
        .slot{
            display: flex;
            flex-direction: column;
            justify-content: center;
            background-color: #D5F8F9;
            border-radius: 10px;
            padding: 10px;
            margin-bottom: 10px;
            height: 100px;
        }
    </style>
</head>
<body>
<h1>Schedule for Cinemas</h1>

<div>
    <label for="cinemaSelect">Cinema:</label>
    <select id="cinemaSelect" name="cinemaName" onchange="navigateToCinema()">
        <c:forEach items="${listCinemas}" var="cinema">
            <option value="${cinema.name}" <c:if test="${cinema.name == param.cinemaName}">selected</c:if>>${cinema.name}</option>
        </c:forEach>
    </select>
</div>
<div>
    <label for="theaterSelect">Theater Number:</label>
    <select id="theaterSelect" name="theaterNumber" onchange="navigateToTheater()">
        <c:forEach var="i" begin="1" end="4">
            <option value="${i}" <c:if test="${i == param.theaterNumber}">selected</c:if>>${i}</option>
        </c:forEach>
    </select>
</div>
<div>
    <label for="yearSelect">Year:</label>
    <select id="yearSelect" name="year" onchange="navigateToYear()">
        <%
            for (int i = 0; i < 3; i++) {
                int year = defaultYear - 1 + i;
                out.println("<option value='" + year + "'" + (currentYear == year ? " selected" : "") + ">" + year + "</option>");
            }
        %>
    </select>
</div>
<div style="display: flex; align-items: center;">
    <label for="weekSelect">Week:</label>
    <select id="weekSelect" name="week" onchange="navigateToWeek()">
        <%
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            SimpleDateFormat hiddenFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 1; i <= 52; i++) {
                cal.set(Calendar.WEEK_OF_YEAR, i);
                String startDisplay = displayFormat.format(cal.getTime());
                cal.add(Calendar.DAY_OF_MONTH, 6);
                String endDisplay = displayFormat.format(cal.getTime());
                out.println("<option value='" + i + "'" + (currentWeek == i ? " selected" : "") + ">" + startDisplay + " To " + endDisplay + "</option>");
                cal.add(Calendar.DAY_OF_MONTH, -6); // Reset to start of the week
            }
        %>
    </select>
</div>
<table>
    <thead>
    <tr>
        <th style="width:200px">Time Slots</th>
        <th>Monday</th>
        <th>Tuesday</th>
        <th>Wednesday</th>
        <th>Thursday</th>
        <th>Friday</th>
        <th>Saturday</th>
        <th>Sunday</th>
    </tr>
    <%-- date for each day of week --%>
    <tr>
        <th style="width: 200px;">Date</th>
        <% for (int i = 0; i < 7; i++) { %>
            <th><%= displayFormat.format(weekDays[i]) %></th>
        <%-- Hidden input để lưu trữ ngày đầy đủ --%>
        <input type="hidden" name="weekStartDate" value="<%= fullDateFormat.format(weekDays[i]) %>">
        <% } %>
    </tr>
    </thead>
    <!-- <tbody>
    <c:forEach var="day" items="${weekDays}">
        <c:set var="formattedDate">
            <fmt:formatDate value="${day}" pattern="MM/dd"/>
        </c:set>
        <tr>
            <c:if test="${showtimeMap[formattedDate] != null}">
                <c:forEach var="showtime" items="${showtimeMap[formattedDate]}">
                    <td>${showtime.theaterID.cinemaID.name}</td>
                    <td>${formattedDate}</td>
                </c:forEach>
                    <td>yes</td>
            </c:if>
            <c:if test="${showtimeMap[formattedDate] == null}">
                <tr>
                    <td>no123</td>
                    <td>${formattedDate}</td>
                </tr>
            </c:if>
        </tr>
        
    </c:forEach>
    </tbody> -->
    <tbody>
        <tr>
            <td>-</td>
            <c:forEach var="day" items="${weekDays}">
                <c:set var="formattedDate">
                    <fmt:formatDate value="${day}" pattern="MM/dd"/>
                </c:set>
                <c:choose>
                    <c:when test="${showtimeMap[formattedDate] != null}">
                        <td style="width: 200px; vertical-align: top;">
                            <c:forEach var="showtime" items="${showtimeMap[formattedDate]}" varStatus="status">
                            <div class="slot">   
                                <div>${showtime.theaterID.cinemaID.name}</div>
                                <div style="font-size: 20px; font-weight: bold; margin-top: 10px;">
                                    <c:set var="parsedDate" value="${fn:substring(showtime.startTime, 0, 19)}" />
                                    <c:set var="parsedDate2" value="${fn:substring(showtime.endTime, 0, 19)}" />


                                    <fmt:parseDate value="${parsedDate}" pattern="yyyy-MM-dd HH:mm:ss" var="dateObj" />
                                    <fmt:parseDate value="${parsedDate2}" pattern="yyyy-MM-dd HH:mm:ss" var="dateObj2" />
                                    <fmt:formatDate value="${dateObj}" pattern="HH:mm" /> ~ <fmt:formatDate value="${dateObj2}" pattern="HH:mm" />
                                </div>
                            </div>
                            </c:forEach>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td>-</td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </tbody>
</table>

<script>
    function navigateToCinema() {
        var date = '<%= todayStr %>';
        var cinemaName = document.getElementById("cinemaSelect").value;
        var theaterNumber = document.getElementById("theaterSelect").value;
        var url = "view-slot?date=" + date + "&cinemaName=" + encodeURIComponent(cinemaName) + "&theaterNumber=" + theaterNumber;
        window.location.href = url;
    }

    function navigateToTheater() {
        var date = '<%= todayStr %>';
        var cinemaName = document.getElementById("cinemaSelect").value;
        var theaterNumber = document.getElementById("theaterSelect").value;
        var url = "view-slot?date=" + date + "&cinemaName=" + encodeURIComponent(cinemaName) + "&theaterNumber=" + theaterNumber;
        window.location.href = url;
    }

    function navigateToYear() {
        var cinemaName = document.getElementById("cinemaSelect").value;
        var theaterNumber = document.getElementById("theaterSelect").value;
        var year = document.getElementById("yearSelect").value;
        var week = document.getElementById("weekSelect").value;

        var cal = new Date();
        cal.setFullYear(year);
        cal.setMonth(0); // January
        cal.setDate(1);
        cal.setDate(cal.getDate() + (week - 1) * 7);

        var date = cal.toISOString().split('T')[0];
        var url = "view-slot?date=" + date + "&cinemaName=" + encodeURIComponent(cinemaName) + "&theaterNumber=" + theaterNumber;
        window.location.href = url;
    }

    function navigateToWeek() {
        var cinemaName = document.getElementById("cinemaSelect").value;
        var theaterNumber = document.getElementById("theaterSelect").value;
        var year = document.getElementById("yearSelect").value;
        var week = document.getElementById("weekSelect").value;

        var cal = new Date();
        cal.setFullYear(year);
        cal.setMonth(0); // January
        cal.setDate(1);
        cal.setDate(cal.getDate() + (week - 1) * 7 + 1);

        var date = cal.toISOString().split('T')[0];
        var url = "view-slot?date=" + date + "&cinemaName=" + encodeURIComponent(cinemaName) + "&theaterNumber=" + theaterNumber;
        window.location.href = url;
    }
</script>
</body>
</html>
