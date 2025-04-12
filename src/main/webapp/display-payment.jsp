<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h2>Payment Records</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Ride</th>
            <th>User</th>
            <th>Amount</th>
            <th>Method</th>
            <th>Status</th>
        </tr>
        <c:forEach var="p" items="${paymentList}">
            <tr>
                <td>${p.paymentId}</td>
                <td>${p.rideId}</td>
                <td>${p.userId}</td>
                <td>${p.amount}</td>
                <td>${p.paymentMethod}</td>
                <td>${p.status}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="index.jsp">Home</a>
</body>
</html>
