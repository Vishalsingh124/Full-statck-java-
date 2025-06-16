<%@ page import="java.util.*, com.tap.model.Cart, com.tap.model.CartItem, com.tap.DAOImpl.RestaurantDAOImpl, com.tap.model.Restaurant" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            border-collapse: collapse;
            width: 90%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #aaa;
            padding: 10px;
            text-align: center;
        }
        img {
            max-height: 100px;
            width: auto;
        }
        .total {
            font-weight: bold;
            color: green;
        }
        .btn {
            padding: 6px 12px;
            margin: 4px;
        }
    </style>
</head>
<body>

<h2 align="center">🛒 Your Cart</h2>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null || cart.getItem().isEmpty()) {
%>
    <h3 align="center">Your cart is empty.</h3>
<%
    } else {
        Map<Integer, CartItem> items = cart.getItem();
        RestaurantDAOImpl rdao = new RestaurantDAOImpl();
%>
    <table>
        <tr>
            <th>Image</th>
            <th>Item Name</th>
            <th>Restaurant</th>
            <th>Price (₹)</th>
            <th>Quantity</th>
            <th>Total (₹)</th>
            <th>Actions</th>
        </tr>
<%
        for (CartItem item : items.values()) {
            Restaurant restaurant = rdao.getRestaurant(item.getRestaurantId());
%>
        <tr>
            <td>
                <img src="<%= restaurant != null && restaurant.getImagePath() != null ? restaurant.getImagePath() : "images/default-restaurant.jpg" %>" alt="Food Image">
            </td>
            <td><%= item.getName() %></td>
            <td><%= restaurant != null ? restaurant.getName() : "Unknown" %></td>
            <td><%= item.getPrice() %></td>
            <td>
                <form action="CartServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1">
                    <input type="submit" value="Update" class="btn">
                </form>
            </td>
            <td><%= item.getPrice() * item.getQuantity() %></td>
            <td>
                <form action="CartServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="remove">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <input type="submit" value="Remove" class="btn">
                </form>
            </td>
        </tr>
<%
        } // end for
%>
        <tr>
            <td colspan="5" class="total">Total Amount:</td>
            <td colspan="2" class="total">₹<%= cart.getTotalPrice() %></td>
        </tr>
    </table>
<%
    } // end else
%>

</body>
</html>
