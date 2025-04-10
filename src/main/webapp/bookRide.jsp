<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
  <h2>Book a Ride - Cab Order Management System</h2>

  <form action="/cab-order-app/ride-controller" method="POST">
      <label for="userId">User ID:</label>
      <input type="number" name="userId" id="userId" required><br><br>

      <label for="driverId">Driver ID:</label>
      <input type="number" name="driverId" id="driverId" required><br><br>

      <label for="pickup">Pickup Location:</label>
      <input type="text" name="pickupLocation" id="pickup" required><br><br>

      <label for="dropoff">Dropoff Location:</label>
      <input type="text" name="dropoffLocation" id="dropoff" required><br><br>

      <button type="submit">Book Ride</button>
  </form>

  <br>
  <a href="index.jsp">Home</a>
</body>
</html>
