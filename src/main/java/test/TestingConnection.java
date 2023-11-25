package test;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.hostmdy.model.Car;
import com.hostmdy.model.CarDAO;

/**
 * Servlet implementation class TestingConnection
 */
public class TestingConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Resource(name = "jdbc/car_dealership")
	private DataSource dataSource;
	private CarDAO carDAO;
	
    public TestingConnection() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		carDAO = new CarDAO(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		if(dataSource != null) {
			out.println("<h1>Successfully Connected to Database</h1>");
			
			
//			List<Car> cars = carDAO.getCarByName("Fit");
//			
//			for (Car car : cars) {
//				out.print(car);
//			}
			
		} else {
			out.println("<h1>Fail to Connect to Database</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
