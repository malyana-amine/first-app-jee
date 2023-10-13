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
<form method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required>
  <br>
  <input type="submit" value="Submit">
</form>
</body>
</html>
