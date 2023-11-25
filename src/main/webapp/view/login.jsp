<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
	
<style type="text/css">
	.container>* {
		width: 100%;
		height: 580px;
		background-image: url("https://img.freepik.com/free-photo/luxurious-car-parked-highway-with-illuminated-headlight-sunset_181624-60607.jpg");
		backdrop-filter: blur(10px);
		background-size: cover;
	}
	
	form {
		filter: blur(0);
	}
</style>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="login-form bg-light mt-4 p-4">
					<form action="login" method="post" class="row g-3">
						<h4>Welcome Back</h4>

						<c:if test="${ not empty success and not success }">
							<p class="text-danger">
								Something went wrong.<br>Email or Password is incorrect!
							</p>
						</c:if>

						<input type="hidden" name="mode" value="LOGIN">
						<div class="col-12">
							<label>Email</label>

							<div class="input-group">
								<span class="input-group-text"> <i
									class="bi bi-envelope-at"></i>
								</span> <input type="email" name="email" class="form-control"
									placeholder="email" required="required">
							</div>
						</div>
						<div class="col-12">
							<label>Password</label>
							<div class="input-group">
								<span class="input-group-text"> <i
									class="bi bi-lock-fill"></i>
								</span> <input type="password" name="password" class="form-control"
									placeholder="Password" required="required">
							</div>
						</div>
						
<!-- 						<div class="col-12"> -->
<!-- 							<div class="form-check"> -->
<!-- 								<input class="form-check-input" type="checkbox" id="rememberMe"> -->
<!-- 								<label class="form-check-label" for="rememberMe"> -->
<!-- 									Remember me</label> -->
<!-- 							</div> -->
<!-- 						</div> -->
						
						<div class="col-12">
							<button type="submit" class="btn btn-dark float-end">Login</button>
						</div>
					</form>
					<hr class="mt-4">
					<div class="col-12">
						<p class="text-center mb-0">
							Don't have an account? <a href="signup">Signup</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>