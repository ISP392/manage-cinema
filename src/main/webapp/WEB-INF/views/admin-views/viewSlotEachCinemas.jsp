<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Styled Dynamic Schedule</title>
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }
            th {
                background-color: #007BFF;
                color: white;
            }
            select {
                padding: 8px;
                margin-right: 5px;
            }
        </style>
    </head>
    <body>
        <h1>Static Schedule for Classes</h1>


        <table>
            <thead>
                <tr>
                    <th style="width:200px">
                        <div style="display: flex; flex-direction: column;">
                            <div style="display: flex; align-items: center;">
                                <label for="yearSelect">Year:</label>
                                <select id="yearSelect" name="year">
                                    <% 
                                        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                                        for (int i = 0; i < 3; i++) {
                                            out.println("<option value='" + (currentYear + i) + "'>" + (currentYear + i) + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                                <div style="display: flex; align-items: center;">

                                <label for="weekSelect">Week:</label>
                                <select id="weekSelect" name="week">
                                    <% 
                                java.util.Calendar cal = java.util.Calendar.getInstance();
                                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM");
                                for (int i = 1; i <= 52; i++) {
                                    cal.set(Calendar.WEEK_OF_YEAR, i);
                                    String start = sdf.format(cal.getTime());
                                    cal.add(Calendar.DAY_OF_MONTH, 6);
                                    String end = sdf.format(cal.getTime());
                                    out.println("<option value='" + i + "'>" + start + " To " + end + "</option>");
                                    cal.add(Calendar.DAY_OF_MONTH, -6); // Reset to start of the week
                                }
                                    %>
                                </select>
                            </div>
                        </div>
                    </th>
                    <th>Monday</th>
                    <th>Tuesday</th>
                    <th>Wednesday</th>
                    <th>Thursday</th>
                    <th>Friday</th>
                    <th>Saturday</th>
                    <th>Sunday</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for (int slot = 0; slot < 13; slot++) {
                        out.println("<tr><td></td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td></tr>");
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
