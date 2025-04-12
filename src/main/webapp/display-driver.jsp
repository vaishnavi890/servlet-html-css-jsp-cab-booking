<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h2>Driver List</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Cab Details</th></tr>
        <c:forEach var="driver" items="${driverList}">
            <tr>
                <td>${driver.driverId}</td>
                <td>${driver.name}</td>
                <td>${driver.email}</td>
                <td>${driver.phone}</td>
                <td>${driver.cabDetails}</td>
            </tr>
        </c:forEach>
    </table>
    <br><a href="index.jsp">Home</a>
</body>
</html>
