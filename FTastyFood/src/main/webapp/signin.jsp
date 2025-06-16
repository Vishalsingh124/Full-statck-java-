<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Sign In - Foofie Fly</title>
		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<link rel="stylesheet" href="signin.css">
		<link rel="icon" type="image/x-icon" href="images\favicon.ico">
	</head>
	<body>
		<div class="login-card">
			<div class="logo-container">
				<img src="images\foodieFlyU.jpg" alt="Foodie Fly Logo">
			</div>
			
			<div class="form-header">
				<h2>Welcome Back</h2>
				<p>Sign in to continue</p>
			</div>

			<form action="callingLogin" method="post">
				<div class="form-group">
					<label for="email">Email</label>
					<input 
						type="email" 
						id="email" 
						name="email" 
						placeholder="Enter your email"
						required
					>
				</div>

				<div class="form-group">
					<label for="password">Password</label>
					<input 
						type="password" 
						id="password" 
						name="password" 
						placeholder="Enter your password"
						required
					>
				</div>

				<button type="submit" class="submit-btn">Sign In</button>
				<p class="error-message"><%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %></p>
				
				<div class="signup-link">	
					Don't have an account? <a href="signup.html">Sign up</a>
					<p style="margin-top: 10px; font-size: 12px;">
						By continuing, you agree to our <a href="#">Terms of Service</a> & <a href="#">Privacy Policy</a>
					</p>
				</div>
			</form>
		</div>
	</body>
</html>