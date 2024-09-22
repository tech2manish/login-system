<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="dashboard.css">
</head>
<body>
    <!-- Navbar -->
    <nav>
        <div class="nav-left">
            <h1>Authentication App</h1>
        </div>
        <div class="nav-right">
            <span id="welcomeUser">Welcome, <%= request.getParameter("username") %></span>
            <button id="logoutBtn">Logout</button>
        </div>
    </nav>

    <!-- Main Dashboard Layout -->
    <div class="dashboard">
        <!-- Left Sidebar -->
        <aside class="sidebar">
            <h2>Dashboard</h2>
            <ul>
                <li class="menu-item" data-content="profile">Profile</li>
                <li class="menu-item" data-content="settings">Settings</li>
                <li class="menu-item" data-content="help">Help</li>
            </ul>
        </aside>

        <!-- Right Content Area -->
        <section class="content" id="contentArea">
            <h2>Welcome to your Dashboard</h2>
            <p>Coming soon!!!!</p>
        </section>
    </div>

    <script src="dashboard.js"></script>
</body>
</html>
