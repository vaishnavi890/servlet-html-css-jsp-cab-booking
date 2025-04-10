<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
  <h2>Rate Your Ride - Cab Order Management System</h2>

  <form action="/cab-order-app/rating-controller" method="POST">
      <label for="rideId">Ride ID:</label>
      <input type="number" name="rideId" id="rideId" required><br><br>

      <label for="userId">User ID:</label>
      <input type="number" name="userId" id="userId" required><br><br>

      <label for="driverId">Driver ID:</label>
      <input type="number" name="driverId" id="driverId" required><br><br>

      <label for="rating">Rating (1-5):</label>
      <input type="number" name="rating" id="rating" min="1" max="5" required><br><br>

      <label for="review">Review:</label><br>
      <textarea name="review" id="review" rows="4" cols="40"></textarea><br><br>

      <button type="submit">Submit Rating</button>
  </form>

  <br>
  <a href="index.jsp">Home</a>
</body>
</html>
