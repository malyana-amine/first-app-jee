<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
<div class="max-w-md mx-auto mt-10 bg-white p-4 rounded shadow-md">
    <h1 class="text-2xl font-semibold mb-4">Login Form</h1>
    <form method="post"> <!-- Specify the action for your login servlet -->
        <div class="mb-4">
            <label for="email" class="block text-gray-700 text-sm font-bold mb-2">email:</label>
            <input type="email" id="email" name="email" class="border rounded py-2 px-3 w-full" required>
        </div>

        <div class="mb-4">
            <label for="password" class="block text-gray-700 text-sm font-bold mb-2">Password:</label>
            <input type="password" id="password" name="password" class="border rounded py-2 px-3 w-full" required>
        </div>

        <div class="mt-6">
            <input type="submit" value="Login" class="bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-700 cursor-pointer">
        </div>
    </form>
</div>
</body>
</html>
