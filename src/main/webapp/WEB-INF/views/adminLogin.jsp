<%-- 
    Document   : adminLogin
    Created on : Jun 8, 2024, 4:32:48 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .login{
                width: 350px;
                height: 300px;
                border: 1px solid gray;
                border-radius: 20px;
                text-align: center;
                margin: auto;
            }

            .login h2{
                color: gray;
                font-family: sans-serif;

            }

            .login input{
                width: 200px;
                height: 40px;
                margin-bottom: 10px;
                border-radius: 5px;
                border: 1px solid gray;
                padding-left: 20px;
            }

            .login button{
                width: 220px;
                height: 40px;
                margin-bottom: 10px;
                border-radius: 5px;
                border: none;
                background: #009933;
                color: white
            }
            .login button:hover{
                font-size: 15px;
            }
            .body{
                display: grid;
                justify-content: center;
                align-items: center;
                height: 80vh;
                margin: 0;
            }
        </style>
    </head>
    <%@include file="header.jsp" %>
    <section class="">
        <body>
            <div class="adminLogin">
                <form method="post" action="adminLogin">
                    <h2> Admin Login</h2>
                    <h6 style="color: red">${requestScope.error}</h6>
                                        <% String error = (String) session.getAttribute("error_1");
                                        %> <% if (error != null) { %>
                                        <h6 style="color: red"><%= error %></h6>
                                        <% } %>
                    <input
                                                type="text"
                                                placeholder="Type your username "
                                                name="username"
                                                value="${username}"
                                                id="form3Example3"
                                                class="input-group"
                                                /><br>
                    <div class="invalid-feedback">${message}</div>
                    <input
                                                type="password"
                                                placeholder="Type your password"
                                                required
                                                value="${password}"
                                                name="password"
                                                id="form3Example4"
                                                class="input-group"
                                                /><br>
                    <button type="submit">Login</button>
                    <div class="mb-3"> <a href="Signup"><p class="fw-bold mb-1">Do not have account</p></a> </div>
                    <div class="success-data">
                        <div class="text-center d-flex flex-column"><span class="text-center fs-1">${message}</span> 
                        </div>
                    </div>
                </form>
            </div>
        </body>
    </section>
    <%@include file="footer.jsp" %>

</html>