<%-- Document : account Created on : Feb 28, 2024, 11:21:11 PM Author : bquoc
--%> <%@page contentType="text/html" pageEncoding="UTF-8" %> <%@taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="./assets/images/logo_home.png"
    />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="./assets/css/style.css" />
    <title>Cá nhân</title>
    <style>
      .box-account {
        float: left;
        width: 100%;
        border: 1px solid silver;
        border-radius: 10px;
        padding: 10px;
        margin-top: 20px;
      }

      .status-member {
        margin-right: 600px;
        display: grid;
        flex-direction: column;
        gap: 2px; /* Reduced gap to make items closer */
      }

      .tier {
        display: flex;
        align-items: center;
        width: 100%;
      }

      .member-icon {
        width: 36px;
        height: 32px;
        background-position: -102px 3px;
        margin-left: 10px;
      }

      .total-spending,
      .point {
        display: flex;
        align-items: center;
        width: 100%;
        margin-top: 2px; /* Reduced margin to make items closer */
      }

      .acc-spend,
      .acc-point {
        display: flex;
        align-items: center;
        justify-content: space-between;
        width: 100%;
      }

      .show-point {
        font-weight: 600;
        color: #595959;
      }

      .inf {
        border-radius: 15px;
        background-color: #445760;
        height: 55px;
        text-align: center;
        padding-top: 6px;
        color: #ccffff;
        margin-bottom: 20px;
      }
    </style>
  </head>
  <body>
    <%@include file="header.jsp" %>
    <div class="container">
      <div class="my-account">
        <div class="left-content">
          <h1 class="block-title" style="color: red">TÀI KHOẢN</h1>
          <div class="block-cotent">
            <ul style="padding: 0">
              <li style="background-color:${backgroundColorMain}">
                <a href="#" style="color: ${colorMain}"> THÔNG TIN CHUNG </a>
              </li>
              <li style="background-color:${backgroundColorSecond}">
                <a style="color: ${colorSecond}" href="update">
                  CHI TIẾT TÀI KHOẢN
                </a>
              </li>
              <li style="background-color:${backgroundColorSecond}">
                <a
                  style="color: ${colorSecond}"
                  href="historyPayment?userID=${sessionScope.account.getUserID()}"
                >
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
          <div class="inf">
            <h1>THÔNG TIN CHUNG</h1>
          </div>
          <div class="format-profile">
            <div class="welcome-msg">
              <p class="hello">
                Xin chào <strong>${sessionScope.account.displayName}</strong>
              </p>
              <p>
                Với trang này, bạn sẽ quản lý được tất cả thông tin tài khoản
                của mình.
              </p>
            </div>

            <div class="box-account">
              <div class="status-member">
                <div class="total-spending">
                  <div class="acc-spend">
                    <label>Cấp độ thẻ: </label>
                    <span class="show-point">${userRank}</span>
                  </div>
                </div>
                <div class="total-spending">
                  <div class="acc-spend">
                    <label>Tổng Chi Tiêu: </label>
                    <span class="show-point">0 đ</span>
                  </div>
                </div>
                <div class="point">
                  <div class="acc-point">
                    <label>Điểm: </label>
                    <span class="show-point">0 P</span>
                  </div>
                </div>
              </div>
            </div>

            <div class="box-account box-info">
              <div
                style="
                  border-bottom: 2px solid #cccccc;
                  margin-bottom: 12px;
                  display: flex;
                  justify-content: space-between;
                "
              >
                <span style="font-weight: bold; font-size: 25px"
                  >Thông tin tài khoản</span
                >
                <div
                  style="
                    padding-left: 15px;
                    font-size: 20px;
                    white-space: nowrap;
                    text-transform: uppercase;
                  "
                >
                  <ul style="margin: 0; padding: 0; list-style: none">
                    <li>
                      <button
                        style="
                          background-color: #445760;
                          border-radius: 7px;
                          margin-bottom: 13px;
                        "
                      >
                        <a href="update" style="color: #ccffff">Thay đổi</a>
                      </button>
                    </li>
                  </ul>
                </div>
              </div>

              <div class="box" style="display: inline-block">
                <div class="box-title">
                  <h3 class="title-my-account">LIÊN HỆ</h3>
                </div>
                <div class="box-content">
                  <span>Tên: ${sessionScope.account.displayName}</span>
                  <span>Email: ${sessionScope.account.email}</span>
                  <span>Tài Khoản: ${sessionScope.account.userName}</span>
                  <span>Chức danh: ${sessionScope.account.roleID.name}</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <%@include file="footer.jsp" %>
  </body>
</html>
