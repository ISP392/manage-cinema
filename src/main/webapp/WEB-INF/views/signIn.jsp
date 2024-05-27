<%-- Document : signIn Created on : Jan 11, 2024, 11:25:00 PM Author : bquoc
--%> <%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">-->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
  </head>
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
                    <form action="./signin" method="post">
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
                   <h6 style="color: red">${requestScope.error_1}</h6>
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                      <label class="form-label" for="form3Example3"
                        >User Name</label
                      >
                      <input
                        type="text"
                        required
                        name="username"
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
                        name="password"
                        id="form3Example4"
                        class="form-control"
                      />
                    </div>

                    <!-- Submit button -->
                    <div >
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

                        <div class="text-center">
                          <p>Not a member? <a href="register">Register</a></p>
                          <p>${null}</p>
                        </div>
                        <div style="display: flex; flex: 1; margin: 0 15px">
                        <div class="gsi-material-button">
                          <a
                                  href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=${localhost}/manage-cinema/LoginGoogleHandler&response_type=code&client_id=289651568773-962elblss4e85nrbgrri0i3kcor4pfl8.apps.googleusercontent.com&approval_prompt=force"
                          >
                          <div class="gsi-material-button-state"></div>
                          <div class="gsi-material-button-content-wrapper">
                            <div class="gsi-material-button-icon">
                              <svg version="1.1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" xmlns:xlink="http://www.w3.org/1999/xlink" style="display: block;">
                                <path fill="#EA4335" d="M24 9.5c3.54 0 6.71 1.22 9.21 3.6l6.85-6.85C35.9 2.38 30.47 0 24 0 14.62 0 6.51 5.38 2.56 13.22l7.98 6.19C12.43 13.72 17.74 9.5 24 9.5z"></path>
                                <path fill="#4285F4" d="M46.98 24.55c0-1.57-.15-3.09-.38-4.55H24v9.02h12.94c-.58 2.96-2.26 5.48-4.78 7.18l7.73 6c4.51-4.18 7.09-10.36 7.09-17.65z"></path>
                                <path fill="#FBBC05" d="M10.53 28.59c-.48-1.45-.76-2.99-.76-4.59s.27-3.14.76-4.59l-7.98-6.19C.92 16.46 0 20.12 0 24c0 3.88.92 7.54 2.56 10.78l7.97-6.19z"></path>
                                <path fill="#34A853" d="M24 48c6.48 0 11.93-2.13 15.89-5.81l-7.73-6c-2.15 1.45-4.92 2.3-8.16 2.3-6.26 0-11.57-4.22-13.47-9.91l-7.98 6.19C6.51 42.62 14.62 48 24 48z"></path>
                                <path fill="none" d="M0 0h48v48H0z"></path>
                              </svg>
                            </div>
                            <span class="gsi-material-button-contents">Sign in with Google</span>
                            <span style="display: none;">Sign in with Google</span>
                          </div>
                          </a>
                        </div>
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
