<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List, com.tap.model.Menu, com.tap.model.Restaurant" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Menu - Foodie Fly</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="menu.css">
    <link rel="icon" type="image/x-icon" href="images\favicon.ico">
</head>
<body>
    <!-- Header Section -->
    <header>
        <nav>
            <div class="logo">
               <a href="home"><img src="images/foodieFlyU.jpg" alt="Logo"></a>
            </div>
            <div class="nav-items">
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
    
    <% Restaurant r = (Restaurant) request.getAttribute("restaurant"); %>

    <!-- Restaurant Info Section -->
    <section class="restaurant-info">
        <div class="restaurant-details">
            <div class="restaurant-name">
                <h1><%= r.getName() %></h1>
                <div class="restaurant-meta">
                    <p><%= r.getCuisineType() %></p>
                    <p><%= r.getAddress() %></p>
                </div>
            </div>
            <div class="restaurant-rating">
                <div style="font-size: 20px; font-weight: 600;">★ <%= r.getRating() %></div>
                <div style="color: #b5b5b5; font-size: 12px;">500+ ratings</div>
            </div>
        </div>
    </section>

    <!-- Menu Section -->
    		<div class="menu-container"> 
    <h2 id="menu">Menu</h2>
    <div class="menu-grid">
        <% 
            List<Menu> restaurantMenu = (List<Menu>) request.getAttribute("restaurantMenu");
        	if (restaurantMenu != null && !restaurantMenu.isEmpty()) {
            	for (Menu m : restaurantMenu) { 
        %>
        <div class="menu-card">
            <div class="card-content">
                <span class="item-name"><%= m.getItemName() %></span>
                <div class="item-price">₹<%= m.getPrice() %></div>
                <div class="item-rating">★ <%= m.getRating() %></div>
                <p class="item-description"><%= m.getDescription() %></p>
            </div>

            <div class="image-container">
                <img src="<%= m.getImagePath() %>" alt="Food Image" class="food-image">
                <form action="CartServlet" method="post">
                    <input type="hidden" name="menuId" value="<%= m.getMenuId() %>">
                    <input type="hidden" name="restaurantId" value="<%= m.getRestaurantId() %>">
                    <input type="hidden" name="quantity" value="1">
                    <input type="hidden" name="action" value="add">
                    <button class="add-btn">ADD</button>
                </form>
            </div>
        </div>
         <%
        	}
    		} else {
		%>
            
             <center>
  					<p style="font-size: 24px; color: green;">No MenuItems are available.</p>
			</center>
             
        <% } %>
    </div>
</div>
    		


    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const descriptions = document.querySelectorAll('.item-description');
            
            descriptions.forEach(desc => {
                const container = desc.parentElement;
                const showMore = container.querySelector('.show-more');
                
                // Check if content is overflowing
                if (desc.scrollHeight > desc.clientHeight) {
                    showMore.style.display = 'block';
                    
                    showMore.addEventListener('click', () => {
                        container.classList.toggle('expanded');
                        showMore.textContent = container.classList.contains('expanded') ? 'Show less' : 'Show more';
                    });
                }
            });
        });
    </script>
    
    <footer>
        <div class="footer-content">
            <div class="footer-section">
                <h3>Company</h3>
                <ul>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Team</a></li>
                    <li><a href="#">Careers</a></li>
                    <li><a href="#">Blog</a></li>
                </ul>
            </div>
            <div class="footer-section">
                <h3>Contact</h3>
                <ul>
                    <li><a href="#">Help & Support</a></li>
                    <li><a href="#">Partner with Us</a></li>
                    <li><a href="#">Ride with Us</a></li>
                </ul>
            </div>
            <div class="footer-section">
                <h3>Legal</h3>
                <ul>
                    <li><a href="#">Terms & Conditions</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Cookie Policy</a></li>
                </ul>
            </div>
            <div class="footer-section">
                <h3>Follow Us</h3>
                <div class="social-links">
                    <a href="#"><i class="fab fa-facebook"></i></a>
                    <a href="#"><i class="fab fa-twitter"></i></a>
                    <a href="#"><i class="fab fa-instagram"></i></a>
                    <a href="#"><i class="fab fa-linkedin"></i></a>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2025 Foodie Fly. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>