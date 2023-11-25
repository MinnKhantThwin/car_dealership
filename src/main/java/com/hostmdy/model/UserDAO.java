package com.hostmdy.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.crypto.PasswordEncoder;
import com.hostmdy.crypto.PasswordValidator;

public class UserDAO {
	private final DataSource dataSource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private void close() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private boolean checkExistingUser(String name, String email) {
		if(getUserByEmail(email) != null) {
			return true;
		}
		return false;
	}
	
	public boolean isEmail(String nickname) {
		if(nickname.contains("@") && nickname.contains(".")) {
			return true;
		} else {
			return false;
		}
	}
		
	public boolean validateUser(String name, String password) {
		User user = null;
		
		if(isEmail(name)) {
			user = getUserByEmail(name);
		} else {
			user = getUserByName(name);
		}
		
		if(user != null) {
			try {
				if(!PasswordValidator.validatePassword(password, user.getPassword()) || user.getLocked()) {
					return false;
				}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return true;
			
		} else {
			return false;
		}
	}
	
	public User getUserByEmail(String email){
		User user = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from user where email='"+email+"';");
			while (rs.next()) {
				user = new User(
						rs.getLong("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("password"),  
						rs.getDate(("date_of_birth")).toLocalDate(),
						rs.getString("address"), 
						rs.getString("phone"), 
						rs.getString("role"), 
						rs.getBoolean("locked")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return user;
	}
	
	public User getUserByName(String name){
		User user = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from user where name='"+name+"';");
			while (rs.next()) {
				user = new User(
						rs.getLong("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("password"),  
						rs.getDate(("date_of_birth")).toLocalDate(),
						rs.getString("address"), 
						rs.getString("phone"),  
						rs.getString("role"), 
						rs.getBoolean("locked")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return user;
	}

	public User getUserById(Long id){
		User user = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from user where id='"+id+"';");
			while (rs.next()) {
				user = new User(
						rs.getLong("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("password"),  
						rs.getDate(("date_of_birth")).toLocalDate(),
						rs.getString("address"), 
						rs.getString("phone"),  
						rs.getString("role"), 
						rs.getBoolean("locked")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return user;
	}
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from user;");
			while (rs.next()) {
				users.add(new User(
						rs.getLong("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("password"),  
						rs.getDate(("date_of_birth")).toLocalDate(),
						rs.getString("address"), 
						rs.getString("phone"),  
						rs.getString("role"), 
						rs.getBoolean("locked")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return users;
	}
	
	public boolean createUser(User user) {
		boolean success = false;
		
		if(checkExistingUser(user.getName(), user.getEmail())) {
			return success;
		}
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("insert into user "
					+ "(name,email,password,date_of_birth,address,"
					+ "phone,locked,role) values(?,?,?,?,?,?,?,?);");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			try {
				pstmt.setString(3, PasswordEncoder.encode(user.getPassword()));
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt.setDate(4, Date.valueOf(user.getDate_of_birth()));
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getPhone());
			pstmt.setBoolean(7, false);
			pstmt.setString(8, "user");
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
	
	public int updateUser(User user) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update user set "
					+ "name=?,"
					+ "email=?,"
					+ "password=?,"
					+ "date_of_birth=?,"
					+ "address=?,"
					+ "phone=? where id=?;");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			try {
				pstmt.setString(3, PasswordEncoder.encode(user.getPassword()));
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt.setDate(4, Date.valueOf(user.getDate_of_birth()));
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getPhone());
			pstmt.setLong(7, user.getId());
			rowEffected = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowEffected;
	}
	
	public int deleteUser(long id) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from user where id=?;");
			pstmt.setLong(1, id);
			rowEffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowEffected;
	}
	
	public int lockUser(long id) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update user set locked=? where id=?;");
			pstmt.setBoolean(1, true);
			pstmt.setLong(2, id);
			rowEffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowEffected;
	}
	
}
