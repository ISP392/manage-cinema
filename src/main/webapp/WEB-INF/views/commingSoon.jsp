<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c"
          uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>
</head>
<%@include file="header.jsp" %>
<body>
<div class="page">
    <div class="main-container">
        <div class="main" style="position: relative; top: 90px">
            <div class="home-movie-selection">
                <div class="nowShowing"
                     style="border-bottom: 3px solid #000; margin-bottom: 35px; position: relative; display: flex; align-items: center; justify-content: space-between;">
                    <h1>Phim Sắp Chiếu</h1>
                    <div class="sub-commingSoon"
                         style="padding-left: 15px; font-size: 20px; white-space: nowrap; text-transform: uppercase;">
                        <ul style="margin: 0; padding: 0; list-style: none;">
                            <li>
                                <a href="http://localhost:8081/manage-cinema/nowShowing" style="color: gray">Phim Đang
                                    Chiếu</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="tab-content">
                <ul class="curr-list">
                    <% int movieNumber = 1; %>
                    <c:forEach items="${moviesCommingSoon}" var="commingSoon">
                        <li>
                            <div class="curr-box">
                                <span class="num"><%= movieNumber++ %></span>
                                <span class="img">
                      <a href="detail-movie?movieID=${commingSoon.movieID}">
                        <img
                                src="./assets/images/posterImages/${commingSoon.posterImage}"
                        />
                      </a>
                    </span>
                            </div>
                            <dl class="list-text">
                                <dt>
                                    <a href="detail-movie?movieID=">
                                        <span>${commingSoon.title.toUpperCase()}</span>
                                    </a>
                                </dt>
                                <dd>
                                    <span class="rate">${commingSoon.duration} phút</span>
                                    <span class="grade">
                        <em>${commingSoon.releaseDate}</em>
                      </span>
                                </dd>
                            </dl>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <!--Footer-->
    <%@include file="footer.jsp" %>
</div>
</body>
</html>
