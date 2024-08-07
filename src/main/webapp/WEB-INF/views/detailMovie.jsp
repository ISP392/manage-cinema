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
        <link rel="stylesheet" type="text/css" href="./assets/css/detailPage.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xem phim</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="./assets/JS/detailScript.js"></script>
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
            }
        %>
        <%@include file="header.jsp" %>
        <div class="container" style="width:980px">
            <div class="row" style="width: 100%">
                <div class="col-3">
                    <div class="poster-image" style="">
                        <img style="width: 181px; height:259px; margin-bottom: 10px;border-radius: 8px"
                             src="${movie.posterImage}" alt="alt"/>
                    </div>
                    <c:if test="${not empty sessionScope.account}">
                        <button class="Btn" data-id="${movie.movieID}">
                            <span class="leftContainer">
                                <svg fill="white" viewBox="0 0 512 512" height="1em" xmlns="http://www.w3.org/2000/svg">
                                <path d="M47.6 300.4L228.3 469.1c7.5 7 17.4 10.9 27.7 10.9s20.2-3.9 27.7-10.9L464.4 300.4c30.4-28.3 47.6-68 47.6-109.5v-5.8c0-69.9-50.5-129.5-119.4-141C347 36.5 300.6 51.4 268 84L256 96 244 84c-32.6-32.6-79-47.5-124.6-39.9C50.5 55.6 0 115.2 0 185.1v5.8c0 41.5 17.2 81.2 47.6 109.5z"></path>
                                </svg>
                                <span class="like">${isLiked ? 'Đã Thích' : 'Thích'}</span>
                            </span>
                            <span class="likeCount">
                                ${userLikeMovie}
                                <input id="user-like-movie" type="hidden" value="${isLiked}">
                                <input id="user-id" type="hidden" value="${sessionScope.account.userID}">
                            </span>
                        </button>
                    </c:if>
                </div>
                <div class="col-7">
                    <div class="product-name">
                        <h4 style="font-weight: bold">${movie.title.toUpperCase()}</h4>
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
                           href="booking?movieid=${movie.movieID}&date=<%=(daysOfMonth.get(0))%>&direction=1">
                            Mua Vé
                        </a>
                    </button>
                </div>
            </div>
            <div class="description" style="width: 900px; margin-top: 40px; font-size: 20px">
                <p>${movie.description}</p>
            </div>
            <c:if test="${movie.trailerURL != null && isTrailer}">
                <div class="trailer" style="margin-top: 20px; color: cadetblue">
                    <h1 style="font-weight: bold; font-size: 35px">Trailer</h1>
                    <iframe style="margin-top: 20px; border-radius: 12px" width="980" height="551" src="${movie.trailerURL}"
                            title="YouTube video player" frameborder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                            referrerpolicy="strict-origin-when-cross-origin" allowfullscreen>
                    </iframe>
                </div>
            </c:if>
            <c:if test="${movie.trailerURL == null || !isTrailer}">
                <div class="trailer" style="margin-top: 20px">
                    <h1 style="font-weight: bold; font-size: 35px">Trailer</h1>
                    <h3 style="font-size: 20px;color: red">Không có trailer</h3>
                </div>
            </c:if>

            <c:forEach items="${REVIEWS}" var="review">
                <div class="row p-3" id="faq" style="width: 100%;     display: flex;
                     justify-content: space-between;
                     align-items: center;">
                    <div>
                        <div class="col-md-11">
                            <p class="heading-md"><b>${review.user.displayName}</b></p>
                            <span>Star: ${review.starRating}</span>
                            <span style="color: gray">Date: ${review.reviewDate}</span>
                            <p style="padding-top: 10px; font-size: 18px">
                                ${review.comment}
                            </p>
                        </div>
                    </div>
                    <div>
                        <a href="review?action=delete&reviewId=${review.reviewID}&movieId=${movie.movieID}">X</a>
                    </div>

                </div>
            </c:forEach>

            <div class="p-3" style="width: 100%">
                <form action="review" method="POST">
                    <div class="form-group">
                        <input type="hidden" name="movieId" value="${movie.movieID}"/>
                        <label for="exampleFormControlTextarea1">Your Feedback</label >
                        <textarea
                            class="form-control"
                            id="feedback" name="comment"
                            rows="3"
                            ></textarea>
                        Stars: <input type="number" name="star"/>

                    </div>

                    <button type="submit" class="btn btn-primary mt-2">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
                        <path d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76z"></path>
                        </svg>
                        Send
                    </button>
                </form>

            </div>

        </div>

        <%@include file="footer.jsp" %>
        <script href="./assets/JS/detailScript.js"></script>
    </body>
</html>
