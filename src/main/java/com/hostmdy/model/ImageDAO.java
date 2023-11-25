package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ImageDAO {
	
	private final DataSource dataSource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ImageDAO(DataSource dataSource) {
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
	
	public String getFrontImageById(Long id) {
		String front = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from car_image where id='"+id+"';");
			while (rs.next()) { 
				front = rs.getString("front");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return front;
	}
	
	public Images getImageByFrontImage(String frontImage) {
		Images images = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from car_image where front='"+frontImage+"';");
			while (rs.next()) { 
				images = new Images(
						rs.getLong("id"),
						rs.getString("front"), 
						rs.getString("back"), 
						rs.getString("left_image"), 
						rs.getString("right_image"), 
						rs.getString("front_interior"), 
						rs.getString("back_interior"), 
						rs.getString("engine")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return images;
	}
	
	public Images getImageById(Long id) {
		Images images = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from car_image where id='"+id+"';");
			while (rs.next()) { 
				images = new Images(
						rs.getLong("id"),
						rs.getString("front"), 
						rs.getString("back"), 
						rs.getString("left_image"), 
						rs.getString("right_image"), 
						rs.getString("front_interior"), 
						rs.getString("back_interior"), 
						rs.getString("engine")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return images;
	}
	
	public List<Images> getAllImages() {
		List<Images> images = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from car_image;");
			while (rs.next()) { 
				images.add(new Images(
						rs.getLong("id"),
						rs.getString("front"), 
						rs.getString("back"), 
						rs.getString("left_image"), 
						rs.getString("right_image"), 
						rs.getString("front_interior"), 
						rs.getString("back_interior"), 
						rs.getString("engine")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return images;
	}
	
	public boolean CreateImages(Images images) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("insert into car_image "
					+ "(front,back,left_image,right_image,front_interior,back_interior,engine) values(?,?,?,?,?,?,?);");
			pstmt.setString(1, images.getFront());
			pstmt.setString(2, images.getBack());
			pstmt.setString(3, images.getLeft());
			pstmt.setString(4, images.getRight());
			pstmt.setString(5, images.getFront_interior());
			pstmt.setString(6, images.getBack_interior());
			pstmt.setString(7, images.getEngine());
			
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
	
	public boolean updateImages(Images images) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update car_image set "
					+ "front=?, "
					+ "back=?, "
					+ "left_image=?, "
					+ "right_image=?, "
					+ "front_interior=?, "
					+ "back_interior=?, "
					+ "engine=? where id=?;");
			pstmt.setString(1, images.getFront());
			pstmt.setString(2, images.getBack());
			pstmt.setString(3, images.getLeft());
			pstmt.setString(4, images.getRight());
			pstmt.setString(5, images.getFront_interior());
			pstmt.setString(6, images.getBack_interior());
			pstmt.setString(7, images.getEngine());
			pstmt.setLong(8, images.getId());
			
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
	
	public boolean deleteImages(Long id) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete car_image set where id=?;");
			pstmt.setLong(1, id);
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
