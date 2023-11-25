<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<div class="container-fluid bg-dark">
	<nav class="navbar navbar-expand-lg navbar-dark">
		<div class="container-fluid  mt-2">
			<a class="navbar-brand fw-bold text-light" href="car">Car
				Dealership</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-end mx-auto p-2"
				id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> <i
							class="bi bi-search"></i>
					</a>
						<ul class="dropdown-menu" id="searchBar"
							aria-labelledby="navbarDropdownMenuLink">
							<li>
								<form action="car" method="post"
									class="dropdown-item d-flex mt-2">
									<input class="form-control me-2" type="search"
										placeholder="Search" name="name" aria-label="Search">
									<input type="hidden" name="mode" value="SEARCH">
									<button class="btn btn-outline-primary" type="submit">
										<i class="bi bi-search"></i>
									</button>
								</form>
							</li>

						</ul></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="car">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="car?mode=SHOW_FORM">Sell Your Car?</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> ${ user.name }
							<i class="bi bi-person-circle"></i>
					</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="login?mode=LOGOUT">Logout</a>
							</li>

							<c:if test="${ fn:contains(user.role, 'admin') }">
								<li><a class="dropdown-item" href="car?mode=TO_VALIDATE">Validation</a></li>
							</c:if>
						</ul></li>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</div>