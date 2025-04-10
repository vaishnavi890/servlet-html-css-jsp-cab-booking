<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
  <h2>Driver Registration - Cab Order Management System</h2>

  <form action="/cab-order-app/driver-controller" method="POST">
      <label for="name">Name:</label>
      <input type="text" name="name" id="name" required><br><br>

      <label for="email">Email:</label>
      <input type="email" name="email" id="email" required><br><br>

      <label for="phone">Phone:</label>
      <input type="text" name="phone" id="phone" required><br><br>

      <label for="cabNumber">Cab Number:</label>
      <input type="text" name="cabNumber" id="cabNumber" required><br><br>

      <label for="cabType">Cab Type:</label>
      <input type="text" name="cabType" id="cabType"><br><br>

      <label for="cabModel">Cab Model:</label>
      <input type="text" name="cabModel" id="cabModel"><br><br>

      <button type="submit">Register Driver</button>
  </form>

  <br>
  <a href="index.jsp">Home</a>
</body>
</html>
