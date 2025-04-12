<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h2>Ride List</h2>
    <table border="1">
        <tr>
            <th>Ride ID</th>
            <th>User ID</th>
            <th>Driver ID</th>
            <th>Pickup</th>
            <th>Dropoff</th>
            <th>Fare</th>
            <th>Status</th>
        </tr>
        <c:forEach var="ride" items="${rideList}">
            <tr>
                <td>${ride.rideId}</td>
                <td>${ride.userId}</td>
                <td>${ride.driverId}</td>
                <td>${ride.pickupLocation}</td>
                <td>${ride.dropoffLocation}</td>
                <td>${ride.fare}</td>
                <td>${ride.status}</td>
            </tr>
        </c:forEach>
    </table>
    <br><a href="index.jsp">Home</a>
</body>
</html>
