<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.User,com.tap.model.Cart" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile - Foodiefly</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="profile.css">
    <link rel="icon" type="image/x-icon" href="images/favicon.ico">
</head>
<body>
    <header>
        <nav>
            <div class="logo">
                <a href="home"><img src="images/foodieFlyU.jpg" alt="Logo"></a>
            </div>
            <div class="nav-items">
                <div class="location">
                    <span><b>Location</b></span>
                    <p>Bangalore, Karnataka, India</p>
                </div>
                <div class="nav-links">
                    <a href="#"><i class="fas fa-search"></i> Search</a>
                    <a href="#"><i class="fas fa-percent"></i> Offers</a>
                    <div class="dropdown">
                        <a href="#"><i class="fas fa-user"></i> Account</a>
                        <div class="dropdown-content">
                            <a href="profile.jsp">Profile</a>
                            <a href="#">Orders</a>
                            <a href="#">Favorites</a>
                            <a href="#">Settings</a>
                            <a href="signin.jsp">Log out</a>
                        </div>
                    </div>
                    <a href="cart.jsp"><i class="fas fa-shopping-cart"></i> Cart</a>
                </div>
            </div>
        </nav>
    </header>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
%>
    <div class="session-expired">
    <br>
    <br>
    <br>
    <br>
       <center> 
          <h2>You're not logged in, You haven't signed in yet.</h2>
        <h2> Please log in or sign up to view your profile and continue using our services.</h2>
          <br>
            <form action="signup.html">
                <button type="submit" class="btn-signin">Sign Up</button>
            </form>
        </center> 
    </div>
</body>
</html>
<%
        return;
    }
%>

<!-- If session is active, show the profile page -->
<div class="container">
    <aside class="sidebar">
        <ul>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Orders</a></li>
            <li><a href="#">Favourites</a></li>
            <li><a href="#">Settings</a></li>
        </ul>
    </aside>

    <main class="profile-content">
        <h2>User Profile</h2>
        <form action="signUpServlet" method="post">
            <div class="user-details">
                <label for="name">Name:</label>
                <span id="name"><%= user.getName() %></span>
            </div>
            <div class="user-details">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" value="<%= user.getUsername() %>">
            </div>
            <div class="user-details">
                <label for="password">Password:</label>
                <input type="text" id="password" name="password" value="<%= user.getPassword() %>">
            </div>
            <div class="user-details">
                <label for="email">Email:</label>
                <span id="email"><%= user.getEmail() %></span>
                <input type="hidden" name="email" value="<%= user.getEmail() %>">
            </div>
            <div class="user-details">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" value="<%= user.getPhone() %>">
            </div>
            <div class="user-details">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" value="<%= user.getAddress() %>">
            </div>
            <div class="user-details">
                <label for="createdDate">Created Date:</label>
                <span id="createdDate"><%= user.getCreatedDate()%></span>
            </div>
            <div class="user-details">
                <label for="lastLoginDate">Last Login Date:</label>
                <span id="lastLoginDate"><%= user.getLastLoginDate() %></span>
            </div>
            <button type="submit">Save</button>
            <input type="hidden" name="action" value="update">
        </form>
    </main>
</div>

</body>
</html>