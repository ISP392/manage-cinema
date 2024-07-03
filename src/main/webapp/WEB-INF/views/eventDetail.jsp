<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Event Details</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .event-detail-container {
                display: flex;
                align-items: flex-start; /* Align items to the top */
                padding: 20px;
            }
            .event-image {
                max-width: 300px;
                margin-right: 20px;
            }
            .event-details {
                flex-grow: 1;
            }
            .event-title {
                font-size: 2em;
                margin-bottom: 10px;
            }
            .event-description {
                font-size: 1.2em;
                margin-bottom: 20px;
            }
            .event-time {
                font-size: 1em;
                color: #555;
            }
        </style>
    </head>

    <body>
        <%@include file="header.jsp" %>   
        <div class="container event-detail-container">
            <div>
                <div class="event-title">${event.getEventName()}</div>
                <img src="${pageContext.request.contextPath}/${event.getEventImg()}" class="event-image" alt="Event Image">
            </div>
            <div class="event-details">
                <div class="event-description">${event.getEventDescription()}</div>
                <div class="event-time"><strong>Start Time:</strong> ${event.getStartTime()}</div>
                <div class="event-time"><strong>End Time:</strong> ${event.getEndTime()}</div>
                <a href="updateEvent?eventID=${event.getEventID()}">Update</a>
                <a></a>
                <a href="deleteEvent?eventID=${event.getEventID()}">Delete</a>
            </div>
        </div>
        <%@include file="footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
