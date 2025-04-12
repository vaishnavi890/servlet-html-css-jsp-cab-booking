<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h2>Driver Ratings</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Ride ID</th>
        <th>User ID</th>
        <th>Driver ID</th>
        <th>Rating</th>
        <th>Review</th>
    </tr>
    <c:forEach var="r" items="${ratingList}">
        <tr>
            <td>${r.ratingId}</td>
            <td>${r.rideId}</td>
            <td>${r.userId}</td>
            <td>${r.driverId}</td>
            <td>${r.rating}</td>
            <td>${r.review}</td>
        </tr>
    </c:forEach>
</table>

<c:if test="${not empty avgRating}">
    <h3>Average Rating for Driver: ${avgRating}</h3>
</c:if>

<a href="index.jsp">Back to Home</a>
</body>
</html>
