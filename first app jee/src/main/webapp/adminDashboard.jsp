<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Dashboard</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100">
<!-- Sidebar -->
<div class="bg-gray-800 text-white w-1/4 p-4 h-screen">
  <!-- Sidebar content goes here -->
</div>

<!-- Main Content -->
<div class="w-3/4 p-4">
  <h1 class="text-2xl font-semibold mb-4">Dashboard</h1>

  <!-- Cart Section -->
  <div class="bg-white rounded-lg p-4 shadow-md mb-4">
    <!-- Cart content goes here -->
  </div>

  <!-- Form Section (Hidden by default) -->
  <div id="form-section" class="hidden">
    <h2 class="text-lg font-semibold mb-2">Form</h2>
    <form method="post" action="process-form.jsp">
      <div class="mb-4">
        <label for="input1" class="block text-sm font-medium text-gray-700">Input 1</label>
        <input type="text" id="input1" name="input1" class="form-input">
      </div>
      <div class="mb-4">
        <label for="input2" class="block text-sm font-medium text-gray-700">Input 2</label>
        <input type="text" id="input2" name="input2" class="form-input">
      </div>
      <div class="mb-4">
        <label for="input3" class="block text-sm font-medium text-gray-700">Input 3</label>
        <input type="text" id="input3" name="input3" class="form-input">
      </div>
      <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded-md">Submit</button>
    </form>
  </div>

  <!-- Button to Display the Form -->
  <button id="show-form-btn" class="bg-blue-500 text-white px-4 py-2 rounded-md">Show Form</button>
</div>

<!-- JavaScript to Toggle the Form Visibility -->
<script>
  document.getElementById('show-form-btn').addEventListener('click', function() {
    var formSection = document.getElementById('form-section');
    formSection.classList.toggle('hidden');
  });
</script>
</body>
</html>
