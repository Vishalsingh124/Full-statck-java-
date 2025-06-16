<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Order" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Status - Foodie Fly</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="order_status.css">
    <link rel="icon" type="image/x-icon" href="images\favicon.ico">
</head>
<body>
    <div class="order-status-container">
        <div class="success-animation">
            <div class="checkmark">
                <i class="fas fa-check"></i>
            </div>
        </div>

        <div class="order-confirmation">
            <h1>Order Confirmed!</h1>
            <p>Your order has been successfully placed</p>
        </div>
        
        <% Order order = (Order)session.getAttribute("order"); %>

        <div class="order-id">
            Order ID: <span>#<%= order.getOrderId() %></span>
        </div>

        <div class="tracking-status">
            <div class="tracking-timeline">
                <div class="timeline-step step-active">
                    <div class="step-icon">
                        <i class="fas fa-check"></i>
                    </div>
                    <div class="step-label">Confirmed</div>
                </div>
                <div class="timeline-step">
                    <div class="step-icon">
                        <i class="fas fa-utensils"></i>
                    </div>
                    <div class="step-label">Preparing</div>
                </div>
                <div class="timeline-step">
                    <div class="step-icon">
                        <i class="fas fa-motorcycle"></i>
                    </div>
                    <div class="step-label">On the way</div>
                </div>
                <div class="timeline-step">
                    <div class="step-icon">
                        <i class="fas fa-home"></i>
                    </div>
                    <div class="step-label">Delivered</div>
                </div>
            </div>
        </div>

        <div class="delivery-details">
            <h3>Delivery Details</h3>
            <div class="delivery-info">
                <div class="info-item">
                    <div class="info-label">Estimated Time</div>
                    <div class="info-value">35-40 minutes</div>
                </div>
                <div class="info-item">
                    <div class="info-label">Delivery Address</div>
                    <div class="info-value"><%= order.getAddress() %></div>
                </div>
                <div class="info-item">
                    <div class="info-label">Payment Method</div>
                    <div class="info-value"><%= order.getPaymentMode() %></div>
                </div>
            </div>
        </div>

        <div class="action-buttons">
            
            <a href="home" class="action-btn browse-more-btn">
                <i class="fas fa-utensils"></i> Browse More
            </a>
        </div>
    </div>
</body>
</html>