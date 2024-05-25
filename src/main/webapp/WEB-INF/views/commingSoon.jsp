<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
    </head>
    <%@include file="header.jsp" %>
    <!--    <body>
            <div class="page" >
                <div class="main-container">
                    <div class="main">
                        <div class="home-movie-selection">
                            <div>
                                <h1 style="padding-bottom: 20px; border-bottom: 2px solid black;">Phim Sắp Chiếu</h1>
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
                    <a href="detail-movie?movieID=${commingSoon.getMovieID()}">
                        <img src="./assets/images/posterImages${commingSoon.getPosterImage()}" />
                    </a>
                </span>
            </div>
            <dl class="list-text">
                <dt>
                    <a href="detail-movie?movieID=">

                        <span>${commingSoon.getTitle().toUpperCase()}</span>
                    </a>
                </dt>
                <dd>
                    <span class="rate">${commingSoon.getDuration()} phút</span>
                    <span class="grade">
                        <em>${commingSoon.getDescription()}</em>
                    </span>
                </dd>
            </dl>
        </li>
    </c:forEach>
</ul>
</div>
</div>
</div>
Footer
    <%--<%@include file="footer.jsp" %>--%>
</div>
</body>-->
    <body>
        <c:forEach items="${moviesCommingSoon}" var="c" >
            <h1>${c.title}</h1>
        </c:forEach>
    </body>
</html>
