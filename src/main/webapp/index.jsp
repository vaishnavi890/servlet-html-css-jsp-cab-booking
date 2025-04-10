<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cab Order Management System</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
  <div class="dashboard">
    <h1>🚕 Cab Order Management System</h1>

    <div class="nav-section">
        <h2>User Module</h2>
        <a href="user-registration.jsp">➕ Register User</a><br>
        <a href="/cab-order-app/user-controller?action=viewAll">👥 View All Users</a>
    </div>

    <div class="nav-section">
        <h2>Driver Module</h2>
        <a href="driver-registration.jsp">➕ Register Driver</a><br>
        <a href="/cab-order-app/driver-controller?action=viewAll">🚖 View All Drivers</a>
    </div>

    <div class="nav-section">
        <h2>Ride Module</h2>
        <a href="ride-booking.jsp">📍 Book a Ride</a><br>
        <a href="/cab-order-app/ride-controller?action=viewAll">🧾 View All Rides</a>
    </div>

    <div class="nav-section">
        <h2>Payment Module</h2>
        <a href="payment.jsp">💳 Make Payment</a><br>
        <a href="/cab-order-app/payment-controller?action=viewAll">📂 View All Payments</a>
    </div>

    <div class="nav-section">
        <h2>Rating Module</h2>
        <a href="rating.jsp">⭐ Rate Ride</a><br>
        <a href="/cab-order-app/rating-controller?action=viewAll">📝 View All Ratings</a>
    </div>
  </div>
</body>
</html>
