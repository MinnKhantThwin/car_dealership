package com.hostmdy.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.Car;
import com.hostmdy.model.CarDAO;
import com.hostmdy.model.ImageDAO;
import com.hostmdy.model.Images;

/**
 * Servlet implementation class CarController
 */
public class CarAndImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Resource(name = "jdbc/car_dealership")
	private DataSource dataSource;
	private CarDAO carDAO;
	private ImageDAO imageDAO;
	
    public CarAndImageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		carDAO = new CarDAO(dataSource);
		imageDAO = new ImageDAO(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mode = request.getParameter("mode");
		
		if(mode == null) {
			mode = "SHOW";
		}
		
		switch (mode) {
		case "SHOW":
			showAllCarsWithImages(request, response);
			break;
			
		case "SINGLE":			
			showCarWithImage(request, response);
			break;
			
		case "SHOW_FORM":
			showCarForm(request, response);
			break;

		case "CREATE":
			createCar(request, response);
			break;
			
		case "LOAD":
			loadCarUpdateForm(request, response);
			break;

		case "UPDATE":
			updateCar(request, response);
			break;

		case "REMOVE":
			removeCar(request, response);
			break;
			
		case "SEARCH":
			searchCar(request, response);
			break;
			
		case "TO_VALIDATE":
			carsToValidate(request, response);
			break;
			
		case "SINGLE_INVALID":
			showInvalidCar(request, response);
			break;
			
		case "VALIDATE":
			validateCar(request, response);
			break;
			
		case "DELETE":
			deleteCar(request, response);
			break;

		default:
			break;
		}
		
	}

	private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		boolean success = carDAO.deleteCar(id);
		if(success) {
			response.sendRedirect("car");
		} else {
			response.sendRedirect("car?mode=SINGLE&id="+id);
		}
	}

	private void validateCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		boolean success = carDAO.validateCar(id);
		
		if(success) {
			response.sendRedirect("car");
		} else {
			response.sendRedirect("car?mode=SINGLE_INVALID&id="+id);
		}
	}

	private void showInvalidCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		Car car = carDAO.getInvalidCarById(id);
		request.setAttribute("car", car);
		Images images = imageDAO.getImageById(car.getImage_id());
		request.setAttribute("images", images);

		RequestDispatcher dispatcher = request.getRequestDispatcher("view/invalid-car-details.jsp");
		dispatcher.forward(request, response);
	}

	private void carsToValidate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Car> cars = carDAO.getAllInvalidatedCars();
		List<Car> carWithImage = new ArrayList<>();
		for (Car car : cars) {
			carWithImage.add(new Car(car.getId(), car.getName(), car.getBrand(), car.getModel(), 
					car.getPrice(), car.getMileage(), car.getEngine(), car.getHorsepower(), 
					car.getLicense(), car.getFeatures(), imageDAO.getFrontImageById(car.getImage_id())));
		}
		request.setAttribute("cars", carWithImage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/invalid.jsp");
		dispatcher.forward(request, response);
	}

	private void searchCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		List<Car> cars = carDAO.searchCarByName(name);
		List<Car> carWithImage = new ArrayList<>();
		for (Car car : cars) {
			carWithImage.add(new Car(car.getId(), car.getName(), car.getBrand(), car.getModel(), 
					car.getPrice(), car.getMileage(), car.getEngine(), car.getHorsepower(), 
					car.getLicense(), car.getFeatures(), imageDAO.getFrontImageById(car.getImage_id())));
		}
		request.setAttribute("cars", carWithImage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/index.jsp");
		dispatcher.forward(request, response);
		
	}

	private void removeCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		boolean success = carDAO.removeCar(id);
		
		if(success) {
			response.sendRedirect("car");
		} else {
			response.sendRedirect("car?mode=SINGLE&id="+id);
		}
	}

	private void createCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		Double price = Double.parseDouble(request.getParameter("price"));
		Integer mileage = Integer.parseInt(request.getParameter("mileage"));
		String engine = request.getParameter("engine");
		Integer horsepower = Integer.parseInt(request.getParameter("horsepower"));
		String license = request.getParameter("license");
		String features = request.getParameter("features");
		Long image_id = createImage(request, response);
		
		boolean success = false;
		if(image_id > 0 ) {
			Car car = new Car(name, brand, model, price, mileage, engine, horsepower, license, features, image_id);
			success = carDAO.registerCar(car);
		}
		request.setAttribute("success", success);

		RequestDispatcher dispatcher = request.getRequestDispatcher("view/register-car.jsp");
		dispatcher.forward(request, response);
	}
	
	private Long createImage(HttpServletRequest request, HttpServletResponse response) {
		String front = request.getParameter("front");
		String back = request.getParameter("back");
		String left = request.getParameter("left");
		String right = request.getParameter("right");
		String front_interior = request.getParameter("frontinterior");
		String back_interior = request.getParameter("backinterior");
		String engine_image = request.getParameter("engineimage");
		
		Images images = new Images(front, back, left, right, front_interior, back_interior, engine_image);
		
		boolean success = imageDAO.CreateImages(images);
		if(success) {
			return imageDAO.getImageByFrontImage(front).getId();
		}
		return 0L;
	}

	private void showCarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/register-car.jsp");
		dispatcher.forward(request, response);
	}

	private void updateCar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		Double price = Double.parseDouble(request.getParameter("price"));
		Integer mileage = Integer.parseInt(request.getParameter("mileage"));
		String engine = request.getParameter("engine");
		Integer horsepower = Integer.parseInt(request.getParameter("horsepower"));
		String license = request.getParameter("license");
		String features = request.getParameter("features");
		Long image_id = carDAO.getCarById(id).getImage_id();
		
		Car car = new Car(id, name, brand, model, price, mileage, engine, horsepower, license, features, image_id);
		
		String front = request.getParameter("front");
		String back = request.getParameter("back");
		String left = request.getParameter("left");
		String right = request.getParameter("right");
		String front_interior = request.getParameter("frontinterior");
		String back_interior = request.getParameter("backinterior");
		String engine_image = request.getParameter("engineimage");
		
		Images images = new Images(image_id, front, back, left, right, front_interior, back_interior, engine_image);
		
		boolean carSuccess = carDAO.updateCar(car);
		boolean imageSuccess = imageDAO.updateImages(images);
		
		if(carSuccess && imageSuccess) {
			response.sendRedirect("car");
		} else {
			boolean success = carSuccess && imageSuccess;
			request.setAttribute("success", success);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/update-car.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void loadCarUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		Car car = carDAO.getCarById(id);
		Images images = imageDAO.getImageById(car.getImage_id());
		if (car != null && images != null) {
			request.setAttribute("car", car);
			request.setAttribute("images", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/update-car.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void showCarWithImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		Car car = carDAO.getCarById(id);
		request.setAttribute("car", car);
		Images images = imageDAO.getImageById(car.getImage_id());
		request.setAttribute("images", images);

		RequestDispatcher dispatcher = request.getRequestDispatcher("view/details.jsp");
		dispatcher.forward(request, response);
	}

	private void showAllCarsWithImages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Car> cars = carDAO.getAllCars();
		List<Car> carWithImage = new ArrayList<>();
		for (Car car : cars) {
			carWithImage.add(new Car(car.getId(), car.getName(), car.getBrand(), car.getModel(), 
					car.getPrice(), car.getMileage(), car.getEngine(), car.getHorsepower(), 
					car.getLicense(), car.getFeatures(), imageDAO.getFrontImageById(car.getImage_id())));
		}
		request.setAttribute("cars", carWithImage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
