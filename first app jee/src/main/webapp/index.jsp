<%@ page import="com.example.first_app_jee.Dao.Users.UserDao" %>
<%@ page import="com.example.first_app_jee.Dao.Users.UserDaoImp" %>
<%@ page import="com.example.first_app_jee.Entities.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Name Input Form</title>
</head>
<body>
<h1>Enter Your Name:?</h1>
<form action="index.jsp" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required>
  <br>
  <input type="submit" value="Submit">
</form>
<%
  String userName = request.getParameter("name"); // Get the user input
  if (userName != null && !userName.isEmpty()) {
    Users user = new Users();
    user.setName(userName);

    UserDao userDao = new UserDaoImp();
    userDao.add(user);

//    System.out.println(user.getName());

    System.out.println("fdfsfd");
  }
%>
</body>
</html>
