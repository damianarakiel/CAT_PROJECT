<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/cats" method="post">
    RASA: <input type="text" name="race"/>
    IMIĘ: <input type="text" name="name"/>
    WŁAŚCICIEL: <input type="text" name="owner"/>
    <input type="submit" value="dodaj"/>
</form>
<form action="/cats" method="get">
    WYSZUKAJ: <input type="text" name="search"/>
    <select name="operator">
        <option>race</option>
        <option>name</option>
        <option>owner</option>
    </select>
    <input type="submit" name="searchButton" value="szukaj">
</form>
<br>
KOTY:
<br>
<c:forEach var="cat" items="${allCats}">
    <c:out value="race: ${cat.race}"/><br>
    <c:out value="name: ${cat.name}"/><br>
    <c:out value="owner: ${cat.owner}"/><br><br>
</c:forEach>

</body>
</html>
