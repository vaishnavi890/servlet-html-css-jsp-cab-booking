<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
  <h2>Make Payment - Cab Order Management System</h2>

  <form action="/cab-order-app/payment-controller" method="POST">
      <label for="rideId">Ride ID:</label>
      <input type="number" name="rideId" id="rideId" required><br><br>

      <label for="userId">User ID:</label>
      <input type="number" name="userId" id="userId" required><br><br>

      <label for="amount">Amount:</label>
      <input type="number" name="amount" id="amount" required><br><br>

      <label for="method">Payment Method:</label>
      <input type="text" name="paymentMethod" id="method" required><br><br>

      <button type="submit">Pay Now</button>
  </form>

  <br>
  <a href="index.jsp">Home</a>
</body>
</html>
