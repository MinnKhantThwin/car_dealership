<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../common/header.jsp"></c:import>
<title>Search page</title>
<style>
      #searchBar{
        width: 230px;
      }
</style>
</head>
<body>
		
		<c:import url="../common/nav.jsp"></c:import>
		
		<section id="card-holder" class="mt-5">
			<div class="container-lg align-items-center justify-content-center">
				<div class="row">

					<c:forEach var="car" items="${cars}">
						
						<c:url var="detailsLink" value="car">
							<c:param name="mode" value="SINGLE" />
							<c:param name="id" value="${car.id }" />
						</c:url>

						<div class="col-12 col-sm-8 col-md-6 col-lg-3 g-4">
							<div class="card text-white bg-dark mb-3 h-100">
								<img src=${ car.front } class="card-img-top" alt="...">
								<div
									class="card-body justify-content-center align-content-center">
									<h5 class="card-title">${car.name}</h5>
									<p class="card-text">
										<span class="text-primary display-6"> <fmt:formatNumber
												value="${car.price}" type="currency"
												maxFractionDigits="2" />
										</span>
									</p>
									
									<a href="${detailsLink }" class="btn btn-primary position-absolute start-50 bottom-0 translate-middle">View More</a>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
		</section>
		

	
	<c:import url="../common/footer.jsp"></c:import>
</body>
</html>