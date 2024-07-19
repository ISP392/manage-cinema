<%-- 
    Document   : employmentInformation
    Created on : Jul 1, 2024, 5:38:19 PM
    Author     : ACER
--%>

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
    <body>
        <%@include file="header.jsp" %>
        <form action="employmentInformation" method="post" onsubmit="return validateForm()" enctype="multipart/form-data">

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
                                        Ứng Tuyển Ngay !
                                    </h2>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1cg"
                                               >Họ và Tên</label>
                                        <input type="text" id="name" name="name" placeholder="Your Name" class="input-register" required=" "/>

                                    </div>
                                    <div class="form-outline mb-4">
                                        <h6 style="color: red">${errorEmail}</h6>
                                        <label class="form-label" for="form3Example3cg"
                                               >Email</label
                                        >
                                        <input type="text" id="email" name="email" placeholder="Your Email" class="input-register" required=" "/>

                                    </div>
                                    <div class="form-outline mb-4">
                                        <h6 style="color: red">${errorPhone}</h6>
                                        <label class="form-label" for="form3Example3cg"
                                               >Số điện thoại</label
                                        >
                                        <input type="text" id="phone" name="phone" placeholder="Phone number" class="input-register" required=" "/>

                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label">Ngày sinh</label>
                                        <input type="date" id="dob" name="dob" placeholder="Your Date of Birth" class="input-register" required=" "/>

                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label">Địa chỉ</label>
                                        <input type="text" id="address" name="address" placeholder="Your Address" class="input-register" required=" "/>

                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label">Vị trí ứng tuyển</label>
                                        <input type="text" id="position" name="position" placeholder="Position You Apply For" class="input-register" value="Staff" readonly="" required=" "/>

                                    </div>

                                    <div class="form-outline mb-4">
                                        <div>
                                            <label class="form-label">Rạp làm việc</label> 
                                        </div>
                                        <select  style="padding: 10px; width: 100%; margin-top: 5px " class="form-select" aria-label="Select Cinema" name="cinemaId">
                                            <c:forEach var="c" items="${requestScope.cinema}">
                                                <option value="${c.cinemaID}">${c.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                        
                                    <div class="form-outline mb-4">
                                        <label class="form-label">CV</label>
                                        <input type="file" id="cv" name="cv" placeholder="file pdf" class="input-register" required=" "/>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <button
                                            type="submit"
                                            class="btn btn-success btn-block btn-lg gradient-custom-4 "
                                            style="color: white; background: #0F8D65; border-radius: 25px">
                                            SUBMIT
                                        </button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <%@include file="footer.jsp" %>
    </body>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <!-- Display success notification if request contains a success message -->
    <%
        String successMessage = (String) request.getAttribute("success");
        if (successMessage != null) {
    %>
    <script type="text/javascript">
            Swal.fire({
                position: 'top-end',
                icon: 'success',
                title: '<%= successMessage %>',
                showConfirmButton: false,
                timer: 3000,
                timerProgressBar: true
            });
    </script>
    <%
        }
    %>

    <!-- Display error notification if request contains an error message -->
    <%
        String errorMessage = (String) request.getAttribute("error");
        if (errorMessage != null) {
    %>
    <script type="text/javascript">
        Swal.fire({
            position: 'top-end',
            icon: 'error',
            title: '<%= errorMessage %>',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true
        });
    </script>
    <%
        }
    %>
    <script>
        function validateEmail(email) {
            const re = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
            return re.test(String(email).toLowerCase());
        }

        function validatePhone(phone) {
            const re = /^[0-9]{10,11}$/;
            return re.test(String(phone));
        }
        function validateForm() {
            const name = document.getElementById('name').value;
            const email = document.getElementById('email').value;
            const phone = document.getElementById('phone').value;
            const dob = document.getElementById('dob').value;
            const address = document.getElementById('address').value;
            const position = document.getElementById('position').value;
            const cv = document.getElementById('cv').value;

            const dobDate = new Date(dob);
            const today = new Date();
            today.setHours(0, 0, 0, 0);

            if (dobDate >= today) {
                alert('Ngày sinh không hợp lệ.');
                event.preventDefault();
                return false;

            }

            const age = today.getFullYear() - dobDate.getFullYear();
            const month = today.getMonth() - dobDate.getMonth();
            if (month < 0 || (month === 0 && today.getDate() < dobDate.getDate())) {
                age--;

            }
            if (age < 18) {
                alert('Bạn phải từ 18 tuổi trở lên.');
                return false;
            }

            if (!validateEmail(email)) {
                alert('Email không hợp lệ.');
                return false;
            }

            if (!validatePhone(phone)) {
                alert('Số điện thoại không hợp lệ.');
                return false;
            }
            if (name.length > 55) {
                alert('Họ và Tên không được vượt quá 50 ký tự.');
                return false;
            }
        }
    </script>
</html>