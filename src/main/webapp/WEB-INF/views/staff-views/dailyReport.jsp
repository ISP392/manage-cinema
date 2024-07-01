<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Daily Report</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #faf3e0; /* Màu nền nhạt */
            margin: 0;
            padding: 0;
            color: #333;
        }
        .background-container {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            overflow: hidden;
            z-index: -1;
        }
        .background-blur {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: url('<c:url value="/assets/images/Movie-background.jpg"/>') no-repeat center center fixed;
            background-size: cover;
            filter: blur(10px); /* Làm mờ ảnh nền */
        }
        .container {
            margin: 20px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9); /* Màu nền trắng mờ */
            max-width: 1200px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .content {
            margin: 20px 0;
        }
        .filter {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
            padding: 20px;
            background-color: #fce4ec;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .filter label {
            font-size: 1.2em;
            margin-right: 10px;
        }
        .filter select, .filter button {
            padding: 10px;
            font-size: 1em;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-right: 10px;
        }
        .filter button {
            background-color: #e74c3c;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .filter button:hover {
            background-color: #c0392b;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f7c6c7; /* Màu nền nhạt cho tiêu đề bảng */
            color: #333;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .summary {
            margin: 20px 0;
            padding: 20px;
            background-color: #f7c6c7; /* Màu nền nhạt */
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .summary h2 {
            margin: 0 0 15px 0;
            color: #e74c3c; /* Màu đỏ chủ đạo */
        }
        .summary p {
            margin: 5px 0;
            font-size: 1.2em;
        }
    </style>
    <script>
        function fetchCinemas() {
            var locationID = document.getElementById('locationSelect').value;
            var xhr = new XMLHttpRequest();
            xhr.open('GET', 'LocationServlet?locationID=' + locationID, true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById('cinemaSelectContainer').innerHTML = xhr.responseText;
                }
            };
            xhr.send();
        }
    </script>
</head>
<body>
    <div class="background-container">
        <div class="background-blur"></div>
    </div>
    <%@include file="header.jsp" %>
    <div class="container">
        <div class="content">
            <div class="filter">
                <form action="CinemasServlet" method="get">
                    <div>
                        <label for="locationSelect">Select Location:</label>
                        <select id="locationSelect" name="locationID" onchange="fetchCinemas()">
                            <option value="all">All Locations</option>
                            <c:forEach var="location" items="${locationList}">
                                <option value="${location.locationID}">${location.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div id="cinemaSelectContainer">
                        <label for="cinemaSelect">Select Cinema:</label>
                        <select id="cinemaSelect" name="cinemaID">
                            <option value="all">All Cinemas</option>
                            <c:forEach var="cinema" items="${cinemasList}">
                                <option value="${cinema.cinemaID}">${cinema.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <input type="hidden" name="movieID" value="${param.movieID}">
                    <input type="hidden" name="movieDate" value="${param.movieDate}">
                    <button type="submit">Filter</button>
                </form>
            </div>
            <div class="summary">
                <h2>Summary</h2>
                <p>Total Transfer Payments: $600</p>
                <p>Total Revenue: $1200</p>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Shift</th>
                        <th>Start Cash</th>
                        <th>End Cash</th>
                        <th>Transfer Payments</th>
                        <th>Revenue</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="shift" items="${shiftsList}">
                        <tr>
                            <td>${shift.date}</td>
                            <td>${shift.startTime} - ${shift.endTime}</td>
                            <td>${shift.startCash}</td>
                            <td>${shift.endCash}</td>
                            <td>${shift.transferPayments}</td>
                            <td>${shift.revenue}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
