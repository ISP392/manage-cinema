<%-- Document : home Created on : May 29, 2024, 1:17:53 AM Author : ACER --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="./assets/images/logo_home.png"
    />
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Banny Cinema</title>
    <!-- load local css in assets folder -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
  </head>
  <style>
    .carousel-inner .carousel-item {
      transition: transform 0.5s ease;
    }
    .event {
      margin-top: 125px;
      background: url(https://www.cgv.vn/skin/frontend/cgv/default/images/bg-cgv/bg_h3_line.jpg)
        repeat-x scroll left center rgba(0, 0, 0, 0);
      height: 60px;
      text-align: center;
      width: 100%;
    }
  </style>
  <%@include file="header.jsp" %>
  <body>
    <div class="page">
      <div class="main-container">
        <div class="main">
          <!-- banner -->
          <div
            id="carouselExampleIndicators"
            class="carousel slide"
            data-bs-ride="carousel"
          >
            <div class="carousel-indicators">
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="0"
                class="active"
                aria-current="true"
                aria-label="Slide 1"
              ></button>
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="1"
                aria-label="Slide 2"
              ></button>
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="2"
                aria-label="Slide 3"
              ></button>
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="3"
                aria-label="Slide 4"
              ></button>
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="4"
                aria-label="Slide 5"
              ></button>
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="5"
                aria-label="Slide 6"
              ></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img
                  src="https://iguov8nhvyobj.vcdn.cloud/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/9/8/980wx448h-min_14.jpg"
                  class="d-block w-100"
                  alt=" "
                />
              </div>
              <div class="carousel-item">
                <img
                  src="https://iguov8nhvyobj.vcdn.cloud/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/9/8/980x448_3__27.jpg"
                  class="d-block w-100"
                  alt=" "
                />
              </div>
              <div class="carousel-item">
                <img
                  src="https://iguov8nhvyobj.vcdn.cloud/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/f/l/fl_rolling-banner_1.jpg"
                  class="d-block w-100"
                  alt=" "
                />
              </div>
              <div class="carousel-item">
                <img
                  src="https://iguov8nhvyobj.vcdn.cloud/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/r/o/rolling_banner_980x448_2_.png"
                  class="d-block w-100"
                  alt=" "
                />
              </div>
              <div class="carousel-item">
                <img
                  src="https://iguov8nhvyobj.vcdn.cloud/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/r/o/rolling_8.jpg"
                  class="d-block w-100"
                  alt=" "
                />
              </div>
              <div class="carousel-item">
                <img
                  src="https://iguov8nhvyobj.vcdn.cloud/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/2/0/2024_doraemonn_rbanner.jpg"
                  class="d-block w-100"
                  alt=" "
                />
              </div>
            </div>
            <button
              class="carousel-control-prev"
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide="prev"
            >
              <span
                class="carousel-control-prev-icon"
                aria-hidden="true"
              ></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button
              class="carousel-control-next"
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide="next"
            >
              <span
                class="carousel-control-next-icon"
                aria-hidden="true"
              ></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>

          <div class="home-movie-selection">
            <div class="home-title">
              <h2>MOVIE SELECTION</h2>
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
                              src="${poster.posterImage}";
                              "
                            />
                          </a>
                        </span>
                      </div>
                      <dl class="list-text">
                        <dt>
                          <a href="#">
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
                        <a href="detail-movie?movieID=${commingSoon.movieID}">
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

          <div class="home-movie-selection">
            <div class="event">
              <h2>
                <img
                  src="https://www.cgv.vn/skin/frontend/cgv/default/images/h3_event.gif"
                  alt=" "
                />
              </h2>
            </div>
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
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"
  ></script>
</html>
