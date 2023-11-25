package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CarDAO {
	
	private final DataSource dataSource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CarDAO(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.dataSource = dataSource;
	}
	
	private void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Car> searchCarByName(String name) {
		
		List<Car> allCars = getAllCars();
		List<Car> resultCars = new ArrayList<>();
		
		if(name.contains(" ")) {
			for (Car car : allCars) {
				if(car.getName().contains(name) || car.getName().contains(name.subSequence(0, name.indexOf(" "))) || car.getName().contains(name.subSequence(name.indexOf(" "), (name.lastIndexOf(name)-1)))) {
					resultCars.add(car);
				}
			}
		}
		
		for (Car car : allCars) {
			if(car.getName().contains(name)) {
				resultCars.add(car);
			}
		}
		
		return resultCars;
	}
	
	public Car getCarById(Long id) {
		Car car = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from car where id='"+id+"' && available='1';");
			while (rs.next()) { 
				car = new Car(
						rs.getLong("id"),
						rs.getString("name"), 
						rs.getString("brand"), 
						rs.getString("model"), 
						rs.getDouble("price"), 
						rs.getInt("mileage"), 
						rs.getString("engine"), 
						rs.getInt("horsepower"), 
						rs.getString("license"), 
						rs.getString("features"), 
						rs.getLong("image_id")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return car;
	}
	
	public Car getInvalidCarById(Long id) {
		Car car = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from car where id='"+id+"';");
			while (rs.next()) { 
				car = new Car(
						rs.getLong("id"),
						rs.getString("name"), 
						rs.getString("brand"), 
						rs.getString("model"), 
						rs.getDouble("price"), 
						rs.getInt("mileage"), 
						rs.getString("engine"), 
						rs.getInt("horsepower"), 
						rs.getString("license"), 
						rs.getString("features"), 
						rs.getLong("image_id")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return car;
	}
	
	public Car getCarByBrand(String brand) {
		Car car = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from car where brand='"+brand+"' && available='1';");
			while (rs.next()) { 
				car = new Car(
						rs.getLong("id"),
						rs.getString("name"), 
						rs.getString("brand"), 
						rs.getString("model"), 
						rs.getDouble("price"), 
						rs.getInt("mileage"), 
						rs.getString("engine"), 
						rs.getInt("horsepower"), 
						rs.getString("license"), 
						rs.getString("features"), 
						rs.getLong("image_id")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return car;
	}
	
	public List<Car> getAllInvalidatedCars() {
		List<Car> cars = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from car where available='NULL' or available='0';");
			while (rs.next()) { 
				cars.add(new Car(
						rs.getLong("id"),
						rs.getString("name"), 
						rs.getString("brand"), 
						rs.getString("model"), 
						rs.getDouble("price"), 
						rs.getInt("mileage"), 
						rs.getString("engine"), 
						rs.getInt("horsepower"), 
						rs.getString("license"), 
						rs.getString("features"), 
						rs.getLong("image_id")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cars;
	}
	
	public List<Car> getAllCars() {
		List<Car> cars = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from car where available='1';");
			while (rs.next()) { 
				cars.add(new Car(
						rs.getLong("id"),
						rs.getString("name"), 
						rs.getString("brand"), 
						rs.getString("model"), 
						rs.getDouble("price"), 
						rs.getInt("mileage"), 
						rs.getString("engine"), 
						rs.getInt("horsepower"), 
						rs.getString("license"), 
						rs.getString("features"), 
						rs.getLong("image_id")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cars;
	}
	
	public boolean registerCar(Car car) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("insert into car "
					+ "(name,brand,model,price,mileage,engine,horsepower,license,features,image_id,available) values(?,?,?,?,?,?,?,?,?,?,?);");
			pstmt.setString(1, car.getName());
			pstmt.setString(2, car.getBrand());
			pstmt.setString(3, car.getModel());
			pstmt.setDouble(4, car.getPrice());
			pstmt.setInt(5, car.getMileage());
			pstmt.setString(6, car.getEngine());
			pstmt.setInt(7, car.getHorsepower());
			pstmt.setString(8, car.getLicense());
			pstmt.setString(9, car.getFeatures());
			pstmt.setLong(10, car.getImage_id());
			pstmt.setBoolean(11, false);
			
			int rowEffected = pstmt.executeUpdate();
			success = rowEffected > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return success;
	}
	
	public boolean updateCar(Car car) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update car set "
					+ "name=?,"
					+ "brand=?,"
					+ "model=?,"
					+ "price=?,"
					+ "mileage=?,"
					+ "engine=?,"
					+ "horsepower=?,"
					+ "license=?,"
					+ "features=? where id=?;");
			pstmt.setString(1, car.getName());
			pstmt.setString(2, car.getBrand());
			pstmt.setString(3, car.getModel());
			pstmt.setDouble(4, car.getPrice());
			pstmt.setInt(5, car.getMileage());
			pstmt.setString(6, car.getEngine());
			pstmt.setInt(7, car.getHorsepower());
			pstmt.setString(8, car.getLicense());
			pstmt.setString(9, car.getFeatures());
			pstmt.setLong(10, car.getId());
			
			int rowEffected = pstmt.executeUpdate();
			success = rowEffected > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return success;
	}
	
	public boolean removeCar(Long id) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update car set available=? where id=?;");
			pstmt.setBoolean(1, false);
			pstmt.setLong(2, id);
			int rowEffected = pstmt.executeUpdate();
			
			success = rowEffected > 0? true : false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return success;
	}
	
	public boolean deleteCar(long id) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from car where id=?;");
			pstmt.setLong(1, id);
			int rowEffected = pstmt.executeUpdate();
			
			success = rowEffected > 0 ? true : false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return success;
	}
	
	public boolean validateCar(Long id) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update car set available=? where id=?;");
			pstmt.setBoolean(1, true);
			pstmt.setLong(2, id);
			int rowEffected = pstmt.executeUpdate();
			
			success = rowEffected > 0? true : false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return success;
	}
	
}
