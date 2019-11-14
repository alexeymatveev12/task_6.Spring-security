<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 5.10.2019
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login page</title>
    <link href="/res/styles2.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <h1>First page</h1>
  <div class="form-style-2">

  <div class="form-style-2-heading">
    Please Sign Up!
  </div>
  <form method="post" action="/login">
    <label for="username">Username
      <input class="input-field" type="text" id="username" name="username">
    </label>
    <label for="password">Password
      <input class="input-field" type="password" id="password" name="password">
    </label>
    <input type="submit" value="Sign Up">
  </form>



  <form action="/read">
    <input type="submit" value="Read User's List" />
  </form>

  <form action="/registration">
    <input type="submit" value="Create the New User" />
  </form>

  </div>
  </body>
</html>
