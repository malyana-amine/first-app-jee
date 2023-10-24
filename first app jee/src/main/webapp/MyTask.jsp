<%@ page import="java.util.List" %>
<%@ page import="com.example.first_app_jee.Entities.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tailwind Admin Template</title>
  <meta name="author" content="David Grzyb">
  <meta name="description" content="">

  <!-- Tailwind -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.css" rel="stylesheet" />
  <style>
    @import url('https://fonts.googleapis.com/css?family=Karla:400,700&display=swap');
    .font-family-karla { font-family: karla; }
    .bg-sidebar { background: #3d68ff; }
    .cta-btn { color: #3d68ff; }
    .upgrade-btn { background: #1947ee; }
    .upgrade-btn:hover { background: #0038fd; }
    .active-nav-link { background: #1947ee; }
    .nav-item:hover { background: #1947ee; }
    .account-link:hover { background: #3d68ff; }
  </style>
</head>
<body class="bg-gray-100 font-family-karla flex">
<aside class="relative bg-sidebar h-screen w-64 hidden sm:block shadow-xl">
  <div class="p-6">
    <a href="index.html" class="text-white text-3xl font-semibold uppercase hover:text-gray-300">Admin</a>
  </div>
  <nav class="text-white text-base font-semibold pt-3">
    <a href="index.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
      <i class="fas fa-tachometer-alt mr-3"></i>
      Dashboard
    </a>
    <a href="blank.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
      <i class="fas fa-sticky-note mr-3"></i>
      Blank Page
    </a>
    <a href="tables.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
      <i class="fas fa-table mr-3"></i>
      Tables
    </a>
    <a href="forms.html" class="flex items-center active-nav-link text-white py-4 pl-6 nav-item">
      <i class="fas fa-align-left mr-3"></i>
      Forms
    </a>
    <a href="tabs.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
      <i class="fas fa-tablet-alt mr-3"></i>
      Tabbed Content
    </a>
    <a href="calendar.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
      <i class="fas fa-calendar mr-3"></i>
      Calendar
    </a>
  </nav>
</aside>

<div class="relative w-full flex flex-col h-screen overflow-y-hidden">
  <!-- Desktop Header -->
  <header class="w-full items-center bg-white py-2 px-6 hidden sm:flex">
    <div class="w-1/2"></div>
    <div x-data="{ isOpen: false }" class="relative w-1/2 flex justify-end">
      <button @click="isOpen = !isOpen" class="realtive z-10 w-12 h-12 rounded-full overflow-hidden border-4 border-gray-400 hover:border-gray-300 focus:border-gray-300 focus:outline-none">
        <img src="https://source.unsplash.com/uJ8LNVCBjFQ/400x400">
      </button>
      <button x-show="isOpen" @click="isOpen = false" class="h-full w-full fixed inset-0 cursor-default"></button>
      <div x-show="isOpen" class="absolute w-32 bg-white rounded-lg shadow-lg py-2 mt-16">
        <a href="#" class="block px-4 py-2 account-link hover:text-white">Account</a>
        <a href="#" class="block px-4 py-2 account-link hover:text-white">Support</a>
        <a href="#" class="block px-4 py-2 account-link hover:text-white">Sign Out</a>
      </div>
    </div>
  </header>

  <!-- Mobile Header & Nav -->
  <header x-data="{ isOpen: false }" class="w-full bg-sidebar py-5 px-6 sm:hidden">
    <div class="flex items-center justify-between">
      <a href="index.html" class="text-white text-3xl font-semibold uppercase hover:text-gray-300">Admin</a>
      <button @click="isOpen = !isOpen" class="text-white text-3xl focus:outline-none">
        <i x-show="!isOpen" class="fas fa-bars"></i>
        <i x-show="isOpen" class="fas fa-times"></i>
      </button>
    </div>

    <!-- Dropdown Nav -->
    <nav :class="isOpen ? 'flex': 'hidden'" class="flex flex-col pt-4">
      <a href="index.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
        <i class="fas fa-tachometer-alt mr-3"></i>
        Dashboard
      </a>
      <a href="blank.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
        <i class="fas fa-sticky-note mr-3"></i>
        Blank Page
      </a>
      <a href="tables.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
        <i class="fas fa-table mr-3"></i>
        Tables
      </a>
      <a href="forms.html" class="flex items-center active-nav-link text-white py-2 pl-4 nav-item">
        <i class="fas fa-align-left mr-3"></i>
        Forms
      </a>
    </nav>
  </header>
      </div>
    </main>
    <footer class="w-full bg-white text-right p-4">
      <!-- Footer content goes here -->
    </footer>
  </div>
</div>

<!-- AlpineJS -->
<script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
<!-- Font Awesome -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" integrity="sha256-KzZiKy0DWYsnwMF+X1DvQngQ2/FxF7MF3Ff72XcpuPs=" crossorigin="anonymous"></script>
</body>
</html>