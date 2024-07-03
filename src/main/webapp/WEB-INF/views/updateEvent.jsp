<%-- 
    Document   : updateEvent
    Created on : Jul 1, 2024, 12:07:36 AM
    Author     : LÊ PHƯƠNG MAI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Update Event</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="header.jsp" %>   
        <div class="container">
            <h2>Update Event</h2>
            <form action="updateEvent" method="post" enctype="multipart/form-data">
                <h3 id="errorMessage" style="color:red">${message}</h3>
                <input type="hidden" name="eventID" value="${event.getEventID()}">
                <div class="mb-3">
                    <label for="eventName" class="form-label">Event Name</label>
                    <input type="text" class="form-control" id="eventName" name="eventName" value="${event.getEventName()}" required>
                </div>
                <div class="mb-3">
                    <label for="eventDescription" class="form-label">Event Description</label>
                    <textarea class="form-control" id="eventDescription" name="eventDescription" required>${event.getEventDescription()}</textarea>
                </div>
                <div class="mb-3">
                    <label for="startTime" class="form-label">Start Time</label>
                    <input type="date" class="form-control" id="startTime" name="startTime" value="${event.getStartTime()}" required>
                </div>
                <div class="mb-3">
                    <label for="endTime" class="form-label">End Time</label>
                    <input type="date" class="form-control" id="endTime" name="endTime" value="${event.getEndTime()}" required>
                </div>
                <div class="mb-3">
                    <label for="eventImg" class="form-label">Event Image</label>
                    <input type="file" class="form-control" id="eventImg" name="eventImg">
                    <img src="${pageContext.request.contextPath}/${event.getEventImg()}" alt="Current Event Image" style="max-width: 200px; margin-top: 10px;">
                </div>
                <button type="submit" class="btn btn-primary">Update Event</button>
            </form>
        </div>
        <%@include file="footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<!--        <script>
            document.querySelector('input[name="eventImg"]').addEventListener('change', function () {
                var imageUrl = URL.createObjectURL(this.files[0]);
                document.querySelector('#imagePreview').style.backgroundImage = 'url(' + imageUrl + ')';
            });

            document.addEventListener("DOMContentLoaded", function () {
                var buttons = document.querySelectorAll(".genre-button");
                var selectedGenresInput = document.getElementById("selectedGenres");
                var selectedGenresBefore = document.getElementById("selectedGenresBefore").value;

                // Chuyển đổi giá trị của selectedGenresBefore thành mảng
                var selectedGenresBeforeArray = selectedGenresBefore.split(", ").map(Number);

                // Active các nút ban đầu dựa trên giá trị của selectedGenresBefore
                buttons.forEach(function (button) {
                    if (selectedGenresBeforeArray.includes(Number(button.value))) {
                        button.classList.add("active");
                    }
                });

                // Thiết lập giá trị ban đầu cho selectedGenres
                selectedGenresInput.value = selectedGenresBefore;

                // Thêm sự kiện click cho các nút
                buttons.forEach(function (button) {
                    button.addEventListener("click", function () {
                        button.classList.toggle("active");

                        // Lấy ra tất cả các nút đã được chọn và đưa vào một mảng
                        var selectedGenres = Array.from(document.querySelectorAll(".genre-button.active")).map((button) => button.value);

                        // Gán giá trị của mảng vào input để hiển thị
                        selectedGenresInput.value = selectedGenres.join(", ");
                    });
                });
            });

            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        document.querySelector("#imagePreview").style.backgroundImage = 'url(' + e.target.result + ')';
                        document.querySelector("#imagePreview").style.display = 'none';
                        document.querySelector("#imagePreview").style.display = 'block';
                    };
                    reader.readAsDataURL(input.files[0]);
                }
            }

            document.querySelector("#eventImg").addEventListener("change", function () {
                readURL(this);
            });

            document.querySelector(".remove-img").addEventListener("click", function () {
                var imageUrl = "images/no-img-avatar.png";
                document.querySelector(".avatar-preview").removeAttribute("style");
                document.querySelector("#imagePreview").style.backgroundImage = 'url(' + imageUrl + ')';
            });
        </script>-->
    </body>
</html>
