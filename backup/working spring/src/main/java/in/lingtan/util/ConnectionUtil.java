package in.lingtan.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	
	private ConnectionUtil() {
		//Default constructor
	}
	private static String driverClass = System.getenv("spring.datasource.driver-class-name");
	private static String url = System.getenv("spring.datasource.url");
	private static String username = System.getenv("spring.datasource.username");
	private static String password = System.getenv("spring.datasource.password");
	
	/**
	 * This method creates a database connection.
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(driverClass);
		
		return DriverManager.getConnection(url, username, password);
		
	//org.postgresql.Driver  jdbc:postgresql://localhost/employeedb postgres @Lingtan1112
	}
	
	/**
	 * This method is used to close the connection of Resultset connection and prepared statement
	 * Method overloading
	 * @param con
	 */
	public static void close( ResultSet rs, Statement statement, Connection con) {
		try {
			
			if(rs!=null) {
				rs.close();
			}
			
			if(statement!= null) {
				statement.close();
			}
			
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method closes the connections for statement and connection.
	 * @param statement
	 * @param con
	 */
	public static void close(Statement statement, Connection con) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
