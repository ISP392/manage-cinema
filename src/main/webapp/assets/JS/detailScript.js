var userHasLiked;
var userID;

document.addEventListener("DOMContentLoaded", function () {
    userHasLiked = document.getElementById("user-like-movie").value === "true";
    userID = document.getElementById("user-id").value;
    document.querySelector(".Btn").addEventListener("click", function () {

        var movieId = this.getAttribute("data-id");

        // Đảo ngược trạng thái "thích" của người dùng
        console.log(userHasLiked);
        console.log(userID);

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

                // Cập nhật nút "Thích"
                var likeElement = document.querySelector(".like");
                likeElement.textContent = userHasLiked ? "Thích" : "Đã Thích";
            }
        };
        userHasLiked = !userHasLiked;
    });
});
