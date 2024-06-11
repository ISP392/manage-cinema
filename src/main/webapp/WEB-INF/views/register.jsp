<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    
    <style>
        .input-register{
                margin-bottom: 15px;
                text-align: left;
                display: block;
                margin-bottom: 5px;
                width: 100%;
                padding: 10px;
                border: none;
                border-bottom: 2px solid #cccccc;
                outline: none;    
        }
        
        .input-register:focus{
            border-bottom: 2px solid #000;
        }
        
    </style>
</head>
<script>
    function validateForm() {
        var password = document.getElementById("password").value;
        var confirm_password = document.getElementById("confirm_password").value;
        if (password !== confirm_password) {
            document.getElementById("error").innerHTML =
                "Password and Confirm Password are not the same";
            return false;
        }
        return true;
    }
</script>
<body>
<%@include file="header.jsp" %>
<form action="register" onsubmit="return validateForm()" method="post">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div
                    style="width: 100%"
                    class="row d-flex justify-content-center align-items-center h-100"
            >
                <div
                        class="col-12 col-md-9 col-lg-7 col-xl-6"
                        style="margin: 40px 0 40px 0"
                >
                    <div class="card" style="border-radius: 15px">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5" style="font-weight: bold; font-size: xx-large;">
                                Create an account
                            </h2>
                            <h6 id="error" style="color: red">
                                ${requestScope.error}
                            </h6>
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form3Example1cg"
                                >Your Name</label
                                >
                                <input
                                        type="text"
                                        placeholder="Your Name"
                                        name="name"
                                        required
                                        id="form3Example1cg"
                                        class="input-register"
                                />
                            </div>
                            <div class="form-outline mb-4">
                                <h6 style="color: red">${errorUsername}</h6>
                                <label class="form-label" for="form3Example3cg"
                                >Your Username</label
                                >
                                <input
                                        type="text"
                                        placeholder="Your Username"
                                        name="username"
                                        required
                                        id="form3Example3cg"
                                        class="input-register"
                                />
                            </div>
                            <div class="form-outline mb-4">
                                <h6 style="color: red">${errorEmail}</h6>
                                <label class="form-label" for="form3Example3cg"
                                >Your Email</label
                                >
                                <input
                                        type="text"
                                        placeholder="Your Email"
                                        name="email"
                                        required
                                        class="input-register"
                                />
                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label">Password</label>
                                <input
                                        type="password"
                                        placeholder="Password"
                                        required
                                        name="password"
                                        id="password"
                                        class="input-register"
                                />
                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label">Repeat your password</label>
                                <input
                                        type="password"
                                        placeholder="Repeat your password"
                                        required
                                        name="confirmPass"
                                        id="confirm_password"
                                        class="input-register"
                                />
                            </div>
                            <div class="d-flex justify-content-center">
                                <button
                                        type="submit"
                                        class="btn btn-success btn-block btn-lg gradient-custom-4 "
                                        style="color: white; background: #0F8D65; border-radius: 25px">
                                    Register
                                </button>
                            </div>
                            <p class="text-center text-muted mt-5 mb-0">
                                Have already an account?
                                <a href="signin" class="fw-bold text-body"
                                ><u>LOGIN HERE</u></a
                                >
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<%@include file="footer.jsp" %>
</body>
</html>