<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Signup</title>
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

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-5 offset-md-4">
				<div class="login-form bg-light mt-4 p-4">
					<form action="" method="post" class="row g-3">
						<h4>Fill all the required fields</h4>

						<c:if test="${ not empty success and success }">
							<p class="text-success">Your account is created</p>
						</c:if>

						<c:if test="${ not empty success and not success }">
							<p class="text-danger">
								Something went wrong.<br>Fail to create the account!
							</p>
						</c:if>

						<input type="hidden" name="mode" value="CREATE">

						<div class="col-12">
							<label>Name</label>
							<div class="input-group">
								<span class="input-group-text"> <i class="bi bi-person"></i>
								</span> <input type="text" name="name" class="form-control"
									placeholder="name" required="required">
							</div>
						</div>
						<div class="col-12">
							<label>Email</label>
							<div class="input-group">
								<span class="input-group-text"> <i
									class="bi bi-envelope-at"></i>
								</span> <input type="text" name="email" class="form-control"
									placeholder="email" required="required">
							</div>
						</div>
						<div class="col-12">
							<label>Address</label>
							<div class="input-group">
								<span class="input-group-text"> <i class="bi bi-house"></i>
								</span> <input type="text" name="address" class="form-control"
									placeholder="address" required="required">
							</div>
						</div>
						<div class="col-12">
							<label>Phone</label>
							<div class="input-group">
								<span class="input-group-text"> <i class="bi bi-telephone"></i>
								</span> <input type="text" name="phone" class="form-control"
									placeholder="phone" required="required">
							</div>
						</div>
						<div class="col-12">
							<label>Date of Birth</label>
							<div class="input-group">
								<span class="input-group-text"> <i class="bi bi-calendar-event"></i>
								</span> <input type="date" name="birthdate" class="form-control"
									placeholder="birthdate" required="required">
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

						<div class="col-12">
							<button type="submit" class="btn btn-dark float-end">Create</button>
						</div>
					</form>
					<hr class="mt-4">
					<div class="col-12">
						<p class="text-center mb-0">
							Already have an account? <a href="login">Login</a>
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