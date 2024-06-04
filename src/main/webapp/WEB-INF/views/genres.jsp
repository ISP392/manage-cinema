<%-- Document : genre Created on : May 28, 2024, 6:24:52 PM Author : caoha --%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="./assets/images/logo_home.png"
    />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Thể loại</title>
  </head>
  <%@include file="header.jsp" %>
  <body>
    <div class="page">
      <div class="main-container">
        <div class="main">
          <div class="home-movie-selection">
            <div>
              <h1 style="padding-bottom: 10px; border-bottom: 2px solid black">
                Phim ${genres}
              </h1>
            </div>
          </div>
          <c:if test="${movies.isEmpty()}">
            <div
              class="no-movie"
              style="
                position: relative;
                top: -60px;
                font-weight: bold;
                color: red;
              "
            >
              <h1>Hiện tại không có phim nào</h1>
            </div>
          </c:if>
          <div class="tab-content">
            <ul class="curr-list">
              <% int movieNumber = 1; %>
              <c:forEach items="${movies}" var="movie">
                <li>
                  <div class="curr-box">
                    <span class="num"><%= movieNumber++ %></span>
                    <span class="img">
                      <a href="detail-movie?movieID=${movie.movieID}">
                        <img
                          src="./assets/images/posterImages/${movie.posterImage}"
                        />
                      </a>
                    </span>
                  </div>
                  <dl class="list-text">
                    <dt>
                      <a href="#">
                        <span>${movie.title.toUpperCase()}</span>
                      </a>
                    </dt>
                    <dd>
                      <span class="rate">${movie.duration} phút</span>
                      <span class="grade">
                        <em>${movie.releaseDate}</em>
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
