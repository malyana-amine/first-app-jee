<%@ page import="com.example.first_app_jee.Entities.Equipment" %>

<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
    <a href="index.html" class="flex items-center active-nav-link text-white py-4 pl-6 nav-item">
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
    <a href="forms.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
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

<div class="w-full flex flex-col h-screen overflow-y-hidden">
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
      <a href="index.html" class="flex items-center active-nav-link text-white py-2 pl-4 nav-item">
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
      <a href="forms.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
        <i class="fas fa-align-left mr-3"></i>
        Forms
      </a>
      <a href="tabs.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
        <i class="fas fa-tablet-alt mr-3"></i>
        Tabbed Content
      </a>
      <a href="calendar.html" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
        <i class="fas fa-calendar mr-3"></i>
        Calendar
      </a>
      <a href="#" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
        <i class="fas fa-cogs mr-3"></i>
        Support
      </a>
      <a href="#" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
        <i class="fas fa-user mr-3"></i>
        My Account
      </a>
      <a href="#" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
        <i class="fas fa-sign-out-alt mr-3"></i>
        Sign Out
      </a>
      <button class="w-full bg-white cta-btn font-semibold py-2 mt-3 rounded-lg shadow-lg hover:shadow-xl hover:bg-gray-300 flex items-center justify-center">
        <i class="fas fa-arrow-circle-up mr-3"></i> Upgrade to Pro!
      </button>
    </nav>
  </header>

  <div class="w-full overflow-x-hidden border-t flex flex-col">
    <main class="w-full flex-grow p-6">
      <h1 class="text-3xl text-black pb-6">Dashboard</h1>






      <!-- Modal toggle -->
      <button data-modal-target="staticModal" data-modal-toggle="staticModal" class="block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" type="button">
        Toggle modal
      </button>

      <!-- Main modal -->
      <div id="staticModal" data-modal-backdrop="static" tabindex="-1" aria-hidden="true" class="fixed top-0 left-0 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-[calc(100%-1rem)] max-h-full">
        <form method="post" class="relative w-full max-w-2xl max-h-full">
          <!-- Modal content -->
          <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
            <!-- Modal header -->
            <div class="flex items-start justify-between p-4 border-b rounded-t dark:border-gray-600">
              <h3 class="text-xl font-semibold text-gray-900 dark:text-white">
                Static modal
              </h3>
              <button type="button" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ml-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white" data-modal-hide="staticModal">
                <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                  <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"/>
                </svg>
                <span class="sr-only">Close modal</span>
              </button>
            </div>
            <!-- Modal body -->

            <div class="p-6 space-y-6">

                <label for="name" class="text-base leading-relaxed text-gray-500 dark:text-gray-400">Equipment Name</label>
                <input type="text" id="name" name="name" class="text-base leading-relaxed text-gray-500 dark:text-gray-400 border rounded-lg border-gray-300 p-2 w-full">

            </div>


            <!-- Modal footer -->
            <div class="flex items-center p-6 space-x-2 border-t border-gray-200 rounded-b dark:border-gray-600">
              <button data-modal-hide="staticModal" type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">I accept</button>
<%--              <button data-modal-hide="staticModal" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Decline</button>--%>
            </div>
          </div>
        </form>
      </div>

      <div class="w-full mt-12">
        <p class="text-xl pb-3 flex items-center">
          <i class="fas fa-list mr-3"></i> Latest Reports
        </p>
        <div class="bg-white overflow-auto">
          <table class="min-w-full bg-white">
            <thead class="bg-gray-800 text-white">
            <tr>
              <th class="w-1/3 text-left py-3 px-4 uppercase font-semibold text-sm">Name</th>
              <th class="w-1/3 text-left py-3 px-4 uppercase font-semibold text-sm">Date de Maintenance</th>
              <th class="w-1/3 text-left py-3 px-4 uppercase font-semibold text-sm">is reserved</th>
              <th class="text-left py-3 px-4 uppercase font-semibold text-sm">status</th>
              <th class="text-left py-3 px-4 uppercase font-semibold text-sm">Edit</th>
            </tr>
            </thead>
            <tbody class="text-gray-700">
            <%
              List<Equipment> equipments = (List<Equipment>) request.getAttribute("equipmentList");
              for (Equipment equipment :equipments){
                %>

<%--              <%= equipment.getId()%>--%>
            <tr>
              <td class="w-1/3 text-left py-3 px-4"><%= equipment.getName()%></td>
              <td class="w-1/3 text-left py-3 px-4">
                <% if (equipment.getDateMaintenance() == null) { %>
                No Maintenance Date
                <% } else { %>
                <%= equipment.getDateMaintenance() %>
                <% } %>
              </td>
              <td class="text-left py-3 px-4">
                <%= equipment.getReserved() %>

              </td>



              <td class="text-left py-3 px-4"><%= equipment.getStatus()%></td>
              <td class="text-left py-3 px-4">
                <a href="dashboardAdmin?action=delete&id=<%= equipment.getId() %>" type="button" class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">Delete</a>
                <a href="dashboardAdmin" type="button" class="focus:outline-none text-white bg-yellow-400 hover:bg-yellow-500 focus:ring-4 focus:ring-yellow-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:focus:ring-yellow-900">update</a>
              </td>
            </tr>
            <%}
            %>

            </tbody>

          </table>
        </div>
      </div>
    </main>
  </div>
</div>

<!-- AlpineJS -->
<script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
<!-- Font Awesome -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" integrity="sha256-KzZiKy0DWYsnwMF+X1DvQngQ2/FxF7MF3Ff72XcpuPs=" crossorigin="anonymous"></script>
<!-- ChartJS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js" integrity="sha256-R4pqcOYV8lt7snxMQO/HSbVCFRPMdrhAFMH+vr9giYI=" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>
