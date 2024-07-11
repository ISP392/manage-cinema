<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update Event</title>
    <link href="${pageContext.request.contextPath}/assets/css/dashboard-admin.css" rel="stylesheet">
    <style>
        .avatar-preview {
            width: 200px; /* Adjust the size as needed */
            height: 200px; /* Adjust the size as needed */
            position: relative;
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center center;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div id="main-wrapper">
        <!-- Nav header start -->
        <div class="nav-header">
            <a href="home_admin" class="brand-logo">
                <!-- Logo SVG -->
            </a>
            <div class="nav-control">
                <div class="hamburger">
                    <span class="line"></span>
                    <span class="line"></span>
                    <span class="line"></span>
                </div>
            </div>
        </div>
        <!-- Nav header end -->

        <!-- Header start -->
        <div class="header">
            <div class="header-content">
                <nav class="navbar navbar-expand">
                    <div class="collapse navbar-collapse">
                        <div class="header-left">
                            <div class="dashboard_bar">Update Event</div>
                        </div>
                        <ul class="navbar-nav header-right" style="margin-left: 15px">
                            <li class="nav-item dropdown notification_dropdown">
                                <a class="nav-link bell dz-theme-mode p-0" href="javascript:void(0);">
                                    <i id="icon-light" class="fa fa-sun"></i>
                                    <i id="icon-dark" class="fa fa-moon"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
            <h2 style="color: red; margin-top: -25px; padding-left: 45px">
                ${message}
            </h2>
        </div>
        <!-- Header end -->

        <!-- Sidebar start -->
        <div class="dlabnav">
            <div class="dlabnav-scroll">
                <ul class="metismenu" id="menu">
                    <li class="dropdown header-profile">
                        <a class="nav-link" href="javascript:void(0);" role="button" data-bs-toggle="dropdown">
                            <div class="header-info ms-3">
                                <span class="font-w600">Hi, <b>${admin.displayName}</b></span>
                                <small class="text-end font-w400">${admin.email}</small>
                            </div>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end">
                            <a href="page-login.html" class="dropdown-item ai-icon">
                                <svg id="icon-logout" xmlns="http://www.w3.org/2000/svg" class="text-danger" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    <path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4"></path>
                                    <polyline points="16 17 21 12 16 7"></polyline>
                                    <line x1="21" y1="12" x2="9" y2="12"></line>
                                </svg>
                                <span class="ms-2">Logout </span>
                            </a>
                        </div>
                    </li>
                    <li>
                        <a class="" href="home_admin">
                            <i class="flaticon-025-dashboard"></i>
                            <span class="">Dashboard</span>
                        </a>
                    </li>
                    <li>
                        <a class="has-arrow ai-icon" href="javascript:void(0)" aria-expanded="false">
                            <i class="fa fa-gear fw-bold"></i>
                            <span class="nav-text">CMS</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="list_event">Event</a></li>
                            <li><a href="menu.html">Slot</a></li>
                            <li><a href="manager_user">Staff</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- Sidebar end -->

        <!-- Content body start -->
        <div class="content-body">
            <div class="container-fluid">
                <form action="updateEvent" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="row">
                                <div class="col-xl-12">
                                    <div class="mb-3">
                                        <label class="form-label">Event Name</label>
                                        <input type="text" class="form-control" placeholder="Event Name" name="eventName" value="${event.getEventName()}" required />
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Event Description</label>
                                        <div class="card h-auto">
                                            <div class="card-body pt-3">
                                                <textarea id="eventDescription" style="margin-top: 10px" class="form-control" name="eventDescription" required>${event.getEventDescription().trim()}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="filter cm-content-box box-primary">
                                        <div class="content-title">
                                            <div class="cpa">Start Time</div>
                                            <div class="tools">
                                                <a href="javascript:void(0);" class="expand SlideToolHeader"><i class="fal fa-angle-down"></i></a>
                                            </div>
                                        </div>
                                        <div class="cm-content-body form excerpt">
                                            <div class="card-body">
                                                <div class="row">
                                                    <div class="col-xl-6 col-sm-6">
                                                        <div class="mb-3">
                                                            <input type="date" id="startTime" name="startTime" class="form-control" value="${event.getStartTime()}" required />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="filter cm-content-box box-primary">
                                        <div class="content-title">
                                            <div class="cpa">End Time</div>
                                            <div class="tools">
                                                <a href="javascript:void(0);" class="expand SlideToolHeader"><i class="fal fa-angle-down"></i></a>
                                            </div>
                                        </div>
                                        <div class="cm-content-body form excerpt">
                                            <div class="card-body">
                                                <input type="date" class="form-control" name="endTime" value="${event.getEndTime()}" required />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="filter cm-content-box box-primary">
                                        <div class="content-title">
                                            <div class="cpa">Event Image</div>
                                            <div class="tools">
                                                <a href="javascript:void(0);" class="expand SlideToolHeader"><i class="fal fa-angle-down"></i></a>
                                            </div>
                                        </div>
                                        <div class="cm-content-body publish-content form excerpt">
                                            <div class="card-body">
                                                <div class="avatar-upload d-flex align-items-center">
                                                    <div class="position-relative">
                                                        <div class="avatar-preview">
                                                            <div id="imagePreview" style="background-image: url(${pageContext.request.contextPath}/${event.getEventImg()});"></div>
                                                        </div>
                                                        <div class="change-btn d-flex align-items-center flex-wrap">
                                                            <input type="file" class="form-control" id="eventImg" name="eventImg" />
                                                            <input type="hidden" class="form-control d-none" id="imageUpload" name="currentEventImg" value="${event.getEventImg()}" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="hidden" name="eventID" value="${event.getEventID()}" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <button id="submitButton" type="submit" class="btn btn-primary mb-3 open">Update Event</button>
                    <button class="btn btn-primary mb-3 open" style="background-color: #ee2279; border: #ee2279" onclick="window.location.href = 'list_event'">Cancel</button>
                </form>
            </div>
        </div>
        <!-- Content body end -->
    </div>
    <!-- Main wrapper end -->

    <!-- Scripts -->
    <script src="${pageContext.request.contextPath}/assets/JS/vendor/global/global.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/JS/vendor/ckeditor/ckeditor.js"></script>
    <script src="${pageContext.request.contextPath}/assets/JS/vendor/apexchart/apexchart.js"></script>
    <script src="${pageContext.request.contextPath}/assets/JS/js/dashboard/dashboard-1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/JS/js/custom.min.js"></script>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            function updatePreview() {
                var input = document.querySelector('input[name="eventImg"]');
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        document.querySelector("#imagePreview").style.backgroundImage = "url(" + e.target.result + ")";
                    };
                    reader.readAsDataURL(input.files[0]);
                }
            }
            document.querySelector('input[name="eventImg"]').addEventListener("change", updatePreview);
        });
    </script>
</body>
</html>