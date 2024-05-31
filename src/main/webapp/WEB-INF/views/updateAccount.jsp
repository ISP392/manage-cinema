<%--
    Document   : updateAccount
    Created on : Mar 1, 2024, 2:51:48 PM
    Author     : bquoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<script>
    var initialEmail;
    var initialDisplayName;

    window.onload = function () {
        initialEmail = document.getElementById("email").value;
        initialDisplayName = document.getElementById("form3Example1cg").value;
    }

    function validateForm() {
        var displayName = document.getElementById("form3Example1cg").value;
        var password = document.getElementById("new-password").value;
        var confirm_password = document.getElementById("confirm-password").value;
        var email = document.getElementById("email").value;
        var oldPassword = document.getElementById("password").value;
        var regex = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;

        if (initialEmail === email && initialDisplayName === displayName && oldPassword === "") {
            document.getElementById("error").innerHTML = "You must change at least one piece of information to update.";
            return false;
        } else if (oldPassword !== "" && password === "") {
            document.getElementById("error").innerHTML = "You must enter old password to change password.";
            return false;
        }

        if (password !== "" && password !== confirm_password) {
            document.getElementById("error").innerHTML = "Password and Confirm Password do not match.";
            return false;
        }

        if (!regex.test(email)) {
            document.getElementById("error").innerHTML = "Invalid email format.";
            return false;
        }

        if (!oldPassword === "" && password === "") {
            document.getElementById("error").innerHTML = "You must enter old password to change password.";
            return false;
        }

        return true;
    }
</script>
<body>
<%@include file="header.jsp" %>
<form action="update" onsubmit="return validateForm()" method="post">
    <div class="container">
        <div class="my-account">
            <div class="left-content">
                <h1 class="block-title" style="color:red">TÀI KHOẢN</h1>
                <h1>${test}</h1>
                <div class="block-cotent">
                    <ul style="padding:0">
                        <li style="background-color:${backgroundColorSecond}">
                            <a href="account" style="color: ${colorSecond}">
                                THÔNG TIN CHUNG
                            </a>
                        </li>
                        <li style="background-color:${backgroundColorMain}">
                            <a style="color: ${colorMain}" href="update">
                                CHI TIẾT TÀI KHOẢN
                            </a>
                        </li>
                        <li style="background-color:${backgroundColorSecond}">
                            <a style="color: ${colorSecond}"
                               href="historyPayment?userID=${sessionScope.account.getUserID()}">
                                LỊCH SỬ GIAO DỊCH
                            </a>
                        </li>
                        <c:if test="${sessionScope.account.roleID.name.equals('admin')}">
                            <li style="background-color:${backgroundColorSecond}">
                                <a style="color: ${colorSecond}" href="addNewMovie">
                                    THÊM PHIM MỚI
                                </a>
                            </li>
                            <li style="background-color:${backgroundColorSecond}">
                                <a style="color: ${colorSecond}" href="detailUsers">
                                    QUẢN LÝ NGƯỜI DÙNG
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
            <div class="dashboard">
                <div class="page-title">
                    <h1>THAY ĐỔI THÔNG TIN</h1>
                </div>
                <h4 id="error" style="color: red">${requestScope.error}</h4>
                <h4 id="errorEmail" style="color: red">${requestScope.errorEmail}</h4>
                <div class="format-profile" style="font-weight: bold; margin-bottom: 15px">
                    <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example1cg">Your Name</label>
                        <input type="text" value="${sessionScope.account.displayName}" name="displayName" required
                               id="form3Example1cg" class="form-control form-control-lg"/>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example3cg">Your Username</label>
                        <input type="text" value="${sessionScope.account.userName}" readonly name="username" required
                               id="form3Example3cg" class="form-control form-control-lg"/>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example3cg">Your Email</label>
                        <input type="text" value="${sessionScope.account.email}" id="email" name="email" required
                               class="form-control form-control-lg"/>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label" for="password">Old Password</label>
                        <input type="password" name="oldPassword" id="password" class="form-control form-control-lg"/>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label" for="new-password">New Password</label>
                        <input type="password" name="newPassword" id="new-password"
                               class="form-control form-control-lg"/>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label" for="confirm-password">Repeat your password</label>
                        <input type="password" name="confirmPassword" id="confirm-password"
                               class="form-control form-control-lg"/>
                    </div>
                    <div class="d-flex justify-content-center" style="width: 300px;">
                        <button type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">
                            Update
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<%@include file="footer.jsp" %>
</body>
</html>
