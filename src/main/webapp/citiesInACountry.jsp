<%--
  Created by IntelliJ IDEA.
  User: cambo
  Date: 4/26/2023
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="com.example.p5_c00432219.DbUtilities"
         import="java.util.ArrayList" %>
<jsp:useBean id="country" scope="page"
             class="com.example.p5_c00432219.CountryBean" />
<html>
<head>
    <title>Cities in a Country</title>
</head>
<body>
<%
    country.setCountry(request.getParameter("country"));
    DbUtilities utilities = new DbUtilities();
    ArrayList<String> cities =
            (ArrayList)utilities.showCitiesInCountry(country.getCountry());
%>
Cities in <%= country.getCountry() %>
<br>
<%
    if (cities != null) {
        for (String c : cities) {
%>
<%= c %><br>
<%
        }
    }
%>
</body>
</html>
