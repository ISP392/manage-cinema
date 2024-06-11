<%--
  Created by IntelliJ IDEA.
  User: baoquoc
  Date: 08/06/2024
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <title>Login Admin</title>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <link
            rel="stylesheet"
            type="text/css"
            href="./assets/fonts/Linearicons-Free-v1.0.0/icon-font.min.css"
            />

        <link rel="stylesheet" type="text/css" href="./assets/css/main-style-admin.css"/>

        <meta name="robots" content="noindex, follow"/>
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100"
                style="background-image: url('./assets/images/cinema-image.jpeg')"
            >
            <div class="wrap-login100 p-t-30 p-b-50">
                <span class="login100-form-title p-b-41"> Login With Admin </span>
                <form method="post"
                    class="login100-form validate-form p-b-33 p-t-5"
                    style="padding-bottom: 32px"
                    >
                    <div
                        class="wrap-input100 validate-input"
                        data-validate="Enter username"
                        >
                        <input
                            class="input100"
                            type="text"
                            name="username"
                            placeholder="User name"
                            />
                        <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                    </div>
                    <div
                        class="wrap-input100 validate-input"
                        data-validate="Enter password"
                        >
                        <input
                            class="input100"
                            type="password"
                            name="pass"
                            placeholder="Password"
                            />
                        <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                    </div>
                    <div
                        class="container-login100-form-btn m-t-32"
                        style="margin-top: 32px"
                        >
                        <button class="login100-form-btn">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>