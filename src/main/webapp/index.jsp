<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>World Database</title>
</head>
<body>
<div class="text-center">
    <h1><%= "Explore the World!" %></h1><br/>
    <form action="citiesInACountry.jsp" method="post">
        Cities in a Country<br>
        Enter a Country:
        <input type="text" name="country">
        <input type="submit" value="Submit">
        <br>
        <br>

        Expanded city information<br>
        Enter a city:
        <input type="text" name="country">
        <input type="submit" value="Submit">
        <br>
        <br>

        Countries on continent:<br>
        Enter a continent
        <input type="text" name="country">
        <input type="submit" value="Submit">
        <br>
        <br>

        Countries speaking language<br>
        Enter a language:
        <input type="text" name="country">
        <input type="submit" value="Submit">
        <br>
        <br>

        Countries starting with letter<br>
        Enter a letter:
        <input type="text" name="country">
        <input type="submit" value="Submit">
        <br>
        <br>
    </form>
</div>
</body>
</html>