<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../common/header.jsp"></c:import>
<title>Details page</title>
<style>
#searchBar {
	width: 230px;
}
</style>
</head>
<body>

	<c:import url="../common/nav.jsp"></c:import>

	<div class="container-fluid bg-light">

		<div class="col-12 col-sm-10 col-md-8 col-lg-6 offset-md-3">



			<c:url var="validateLink" value="car">
				<c:param name="mode" value="VALIDATE"></c:param>
				<c:param name="id" value="${ car.id }"></c:param>
			</c:url>
			
			<c:url var="deleteLink" value="car">
				<c:param name="mode" value="DELETE"></c:param>
				<c:param name="id" value="${ car.id }"></c:param>
			</c:url>


			<div id="carouselExampleIndicators" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="3" aria-label="Slide 4"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="4" aria-label="Slide 5"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="5" aria-label="Slide 6"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="6" aria-label="Slide 7"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${images.front }" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="${images.back }" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="${images.left }" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="${images.right }" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="${images.front_interior }" class="d-block w-100"
							alt="...">
					</div>
					<div class="carousel-item">
						<img src="${images.back_interior }" class="d-block w-100"
							alt="...">
					</div>
					<div class="carousel-item">
						<img src="${images.engine }" class="d-block w-100" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		
			<div class="card border-success mb-3 m-3" style="max-width: 46rem;">
				<div class="card-header">Details</div>
				<div class="card-body text-success">
					<h5 class="card-title display-6">${car.name }</h5>
					<p class="card-text"><h3>Brand: </h3> <i class="bi bi-car-front"></i> ${car.brand }</p>
					<p class="card-text"><h3>Model: </h3> <i class="bi bi-car-front-fill"></i> ${car.model }</p>
					<p class="card-text"><h3>Price: </h3> <i class="bi bi-cash-stack"></i>
						<fmt:formatNumber value="${car.price}" type="currency"
							maxFractionDigits="2" />
					</p>
					<p class="card-text"><h3>Mileage: </h3> <i class="bi bi-map"></i> ${car.mileage }</p>
					<p class="card-text"><h3>Engine: </h3> <i>En</i> ${car.engine }</p>
					<p class="card-text"><h3>HorsePower: </h3> <i>Hp</i> ${car.horsepower }</p>
					<p class="card-text"><h3>License: </h3> <i class="bi bi-card-heading"></i> ${car.license }</p>
					<p class="card-text"><h3>Features: </h3> ${car.features }</p>
					
					<c:if test="${ fn:contains(user.role, 'admin') }">
                        	<a href="${validateLink}" class="btn btn-success">Validate</a>
                        	<a href="${deleteLink}" class="btn btn-danger">Delete</a>
                    </c:if>
				</div>
			</div>
		</div>


	</div>

	<c:import url="../common/footer.jsp"></c:import>

</body>
</html>