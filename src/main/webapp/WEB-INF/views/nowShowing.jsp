<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@taglib prefix="c"
                                                                 uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="shortcut icon" type="image/x-icon" href="./assets/images/logo_home.png" />
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Phim đang chiếu</title>
        <!-- load local css in assets folder -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"
        ></script>
    </head>
    <style>
        .carousel-inner .carousel-item {
            transition: transform 0.5s ease;
        }
    </style>
    <%@include file="header.jsp" %>
    <body>
        <div class="page">
            <div class="main-container">
                <div class="main">
                    <!-- banner -->

                    <!-- comment <div class="home-movie-selection">
                      <div class="home-title">
                        <h2>MOVIE SELECTION</h2>
                      </div>
                    </div> -->
                    <div class="home-movie-selection">
                        <div class="nowShowing" style="border-bottom: 3px solid #000; margin-bottom: 35px; position: relative; display: flex; align-items: center; justify-content: space-between;">
                            <h1>Phim Đang Chiếu</h1>
                            <div class="sub-commingSoon" style="padding-left: 15px; font-size: 20px; white-space: nowrap; text-transform: uppercase;">
                                <ul style="margin: 0; padding: 0; list-style: none;">
                                    <li>
                                        <a href="commingSoon" style="color: gray">Phim Sắp Chiếu</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>


                    <div class="tab-content">
                        <ul class="curr-list">
                            <% int movieNumber = 1; %>
                            <c:forEach items="${movies}" var="poster">
                                <c:if test="${account.getRoleID().getRoleID() != 1}">
                                    <c:if test="${poster.display == 1}">
                                        <li>
                                            <div class="curr-box">
                                                <span class="num"><%= movieNumber++ %></span>
                                                <span class="img">
                                                    <a href="detail-movie?movieID=${poster.movieID}">
                                                        <img
                                                            src="./assets/images/posterImages/${poster.posterImage}"
                                                            />
                                                    </a>
                                                </span>
                                            </div>
                                            <dl class="list-text">
                                                <dt>
                                                    <a href="detail-movie?movieID=">
                                                        <span>${poster.title.toUpperCase()}</span>
                                                    </a>
                                                </dt>
                                                <dd>
                                                    <span class="rate">${poster.duration} phút</span>
                                                    <span class="grade">
                                                        <em>${poster.releaseDate}</em>
                                                    </span>
                                                </dd>
                                            </dl>
                                        </li>
                                    </c:if>
                                </c:if>
                                <c:if test="${account.getRoleID().getRoleID() == 1}">
                                    <li>
                                        <div class="curr-box">
                                            <span class="num"><%= movieNumber++ %></span>
                                            <span class="img">
                                                <a href="detail-movie?movieID=${poster.movieID}">
                                                    <img
                                                        src="./assets/images/posterImages/${poster.posterImage}"
                                                        />
                                                </a>
                                            </span>
                                        </div>
                                        <dl class="list-text">
                                            <dt>
                                                <a href="detail-movie?movieID=">
                                                    <span>${poster.title.toUpperCase()}</span>
                                                </a>
                                            </dt>
                                            <dd>
                                                <span class="rate">${poster.duration} phút</span>
                                                <span class="grade">
                                                    <em>${poster.releaseDate}</em>
                                                </span>
                                            </dd>
                                        </dl>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <!--Footer-->
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script
        src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"
    ></script>
    <script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"
    ></script>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"
    ></script>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"
    ></script>
</html>
