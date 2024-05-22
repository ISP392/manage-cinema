<%-- Document : signIn Created on : Jan 11, 2024, 11:25:00 PM Author : bquoc
--%> <%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">-->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
  </head>
  <style>
    label {
      font-size: medium;
      font-weight: bold;
      float: left;
    }

    .form-control {
      border: 2px solid #ced4da !important;
    }

    @media (min-width: 992px) {
      .col-lg-6 img {
        display: block; /* Hiển thị ảnh */
      }
    }

    /* CSS cho màn hình nhỏ (bé hơn 992px) */
    @media (max-width: 992px) {
      .col-lg-6 img {
        display: none; /* Ẩn ảnh */
      }
    }
  </style>
  <%@include file="header.jsp" %>
  <!-- Section: Design Block -->
  <section class="">
    <!-- Jumbotron -->
    <form action="signin" method="post">
      <div
        class="px-4 py-5 px-md-5 text-center text-lg-start"
        style="
          background-color: hsl(0, 0%, 96%);
          width: 940px;
          border-radius: 10px;
          margin: 35px auto;
        "
      >
        <div class="container">
          <div class="row gx-lg-5 align-items-center">
            <div class="col-lg-6 mb-5 mb-lg-0">
              <img
                src="https://img.freepik.com/premium-vector/movie-cinema-premiere-background_41737-251.jpg"
                alt="alt"
                style="
                  width: 398px;
                  height: 451px;
                  object-fit: cover;
                  border-radius: 2.25rem;
                "
              />
            </div>

            <div class="col-lg-6 mb-5 mb-lg-0">
              <div class="card" style="border-radius: 2.25rem">
                <div class="card-body py-5 px-md-5" style="height: 450px">
                  <form>
                    <h2
                      style="
                        display: flex;
                        justify-content: start;
                        font-weight: 700;
                      "
                    >
                      Log In
                    </h2>
                    <h6 style="color: red">${requestScope.error}</h6>
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                      <label class="form-label" for="form3Example3"
                        >User Name</label
                      >
                      <input
                        type="text"
                        required
                        name="username"
                        value="${username}"
                        id="form3Example3"
                        class="form-control"
                      />
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-4">
                      <label class="form-label" for="form3Example4"
                        >Password</label
                      >
                      <input
                        type="password"
                        required
                        value="${password}"
                        name="password"
                        id="form3Example4"
                        class="form-control"
                      />
                    </div>

                    <!-- Submit button -->
                    <div>
                      <button
                        type="submit"
                        class="btn btn-primary btn-block mb-4"
                      >
                        Sign up
                      </button>
                      <div class="row mb-4">
                        <div
                          style="height: 20px"
                          class="col-md-6 d-flex justify-content-center"
                        >
                          <!-- Simple link -->
                          <input
                            checked
                            style="margin-right: 5px"
                            type="checkbox"
                            id="rememberMe"
                            name="rememberMe"
                          />
                          <p>Rememmber me!</p>
                        </div>
                        <a
                          href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/manage-cinema/LoginGoogleHandler&response_type=code&client_id=289651568773-962elblss4e85nrbgrri0i3kcor4pfl8.apps.googleusercontent.com&approval_prompt=force"
                        >
                          Login with Google
                        </a>
                        <div class="text-center">
                          <p>Not a member? <a href="register">Register</a></p>
                          <p>${null}</p>
                        </div>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
    <!-- Jumbotron -->
  </section>
  <!-- Section: Design Block -->
  <!--Footer-->
  <%@include file="footer.jsp" %>
</html>
