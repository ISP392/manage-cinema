var userHasLiked;
var userID;

document.addEventListener("DOMContentLoaded", function () {
    userHasLiked = document.getElementById("user-like-movie").value === "true";
    userID = document.getElementById("user-id").value;
    document.querySelector(".Btn").addEventListener("click", function () {

        var btn = this;
        btn.disabled = true;
        btn.classList.add('disabled-button');
        var movieId = this.getAttribute("data-id");


        var xhr = new XMLHttpRequest();
        xhr.open("POST", "updateLikesServlet", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(
            "id=" +
            encodeURIComponent(movieId) +
            "&like=" +
            encodeURIComponent(userHasLiked) +
            "&userID=" +
            encodeURIComponent(userID)
        );

        xhr.onload = function () {
            if (xhr.status === 200) {
                // Cập nhật số lượt thích trên trang
                var likeCountElement = document.querySelector(".likeCount");
                likeCountElement.textContent = xhr.responseText;

                // Đảo ngược trạng thái "thích" của người dùng
                userHasLiked = !userHasLiked;

                // Cập nhật nút "Thích"
                var likeElement = document.querySelector(".like");
                likeElement.textContent = userHasLiked ? "Đã Thích" : "Thích";

                btn.disabled = false;
                btn.classList.remove('disabled-button');

            }
        };

    });
});
