<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<c:import url="../common/header.jsp"></c:import>
<title>Register Car</title>
<style>
#searchBar {
	width: 230px;
}
</style>
</head>
<body>

	<div class="container-fluid bg-dark">

		<c:import url="../common/nav.jsp" />

		<div class="row">
			<div class="col-md-6 col-lg-6 offset-md-3">
				<div class="login-form bg-light mt-4 p-4">

					<form action="car" method="post" class="row g-3">

						<h4>Fill all the required fields</h4>

						<c:if test="${ not empty success and success }">
							<p class="text-success">Car is register for review.</p>
						</c:if>

						<c:if test="${ not empty success and not success }">
							<p class="text-danger">
								Something went wrong.<br>Fail to register the car!
							</p>
						</c:if>
						

						<input type="hidden" name="mode" value="CREATE">
							

						<div class="col-12">
							<label>Name</label>
							<div class="input-group">
								<span class="input-group-text"> N </span> <input type="text"
									name="name" class="form-control"
									placeholder="name" required="required">
							</div>
						</div>
						
						<div class="col-12">
							<label>Brand</label>
							<div class="input-group">
								<span class="input-group-text"> B </span> <input type="text"
									name="brand" class="form-control"
									placeholder="brand" required="required">
							</div>
						</div>
						
						<div class="col-12">
							<label>Model</label>
							<div class="input-group">
								<span class="input-group-text"> M </span> <input type="text"
									name="model" class="form-control"
									placeholder="model" required="required">
							</div>
						</div>
						
						<div class="col-12">
							<label>Price</label>
							<div class="input-group">
								<span class="input-group-text"> $ </span> <input type="text"
									name="price" class="form-control"
									placeholder="price" required="required">
							</div>
						</div>
						<div class="col-12">
							<label>Mileage</label>
							<div class="input-group">
								<span class="input-group-text"> Mi </span> <input type="number"
									name="mileage" class="form-control"
									placeholder="mileage" required="required">
							</div>
						</div>
						<div class="col-12">
							<label>Engine</label>
							<div class="input-group">
								<span class="input-group-text"> E </span> <input type="text"
									name="engine" class="form-control"
									placeholder="engine" required="required">
							</div>
						</div>
						<div class="col-12">
							<label>HorsePower</label>
							<div class="input-group">
								<span class="input-group-text"> Hp </span> <input type="number"
									name="horsepower" class="form-control"
									placeholder="horsepower" required="required">
							</div>
						</div>
						<div class="col-12">
							<label>License</label>
							<div class="input-group">
								<span class="input-group-text"> Li </span> <input type="text"
									name="license" class="form-control"
									placeholder="license" required="required">
							</div>
						</div>
						
						<div class="col-12">
							<label>Features</label>
							<textarea rows="8" class="form-control" name="features"
								required="required">
							</textarea>
						</div>
						
						
						
						<div class="col-12">
							<label>Front-Image</label>
							<div class="input-group">
								<span class="input-group-text"> <i class="bi bi-image"></i> </span> <input type="url"
									name="front" class="form-control"
									placeholder="image url" required="required">
							</div>
						</div>
						
						<div class="col-12">
							<label>Back-Image</label>
							<div class="input-group">
								<span class="input-group-text"> <i class="bi bi-image"></i> </span> <input type="url"
									name="back" class="form-control"
									placeholder="image url" required="required">
							</div>
						</div>
						
						<div class="col-12">
							<label>Left-Image</label>
							<div class="input-group">
								<span class="input-group-text"> <i class="bi bi-image"></i> </span> <input type="url"
									name="left" class="form-control"
									placeholder="image url" required="required">
							</div>
						</div>
						
						<div class="col-12">
							<label>Right-Image</label>
							<div class="input-group">
								<span class="input-group-text"> <i class="bi bi-image"></i> </span> <input type="url"
									name="right" class="form-control"
									placeholder="image url" required="required">
							</div>
						</div>
						
						<div class="col-12">
							<label>Front-Interior-Image</label>
							<div class="input-group">
								<span class="input-group-text"> <i class="bi bi-image"></i> </span> <input type="url"
									name="frontinterior" class="form-control"
									placeholder="image url" required="required">
							</div>
						</div>
						
						<div class="col-12">
							<label>Back-Interior-Image</label>
							<div class="input-group">
								<span class="input-group-text"> <i class="bi bi-image"></i> </span> <input type="url"
									name="backinterior" class="form-control"
									placeholder="image url" required="required">
							</div>
						</div>
						
						<div class="col-12">
							<label>Engine-Image</label>
							<div class="input-group">
								<span class="input-group-text"> <i class="bi bi-image"></i> </span> <input type="url"
									name="engineimage" class="form-control"
									placeholder="image url" required="required">
							</div>
						</div>

						<div class="col-12">
							<button type="submit" class="btn btn-dark float-end">Register</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>

	<c:import url="../common/footer.jsp" />

</body>
</html>