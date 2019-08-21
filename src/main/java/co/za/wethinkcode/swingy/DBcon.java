package co.za.wethinkcode.swingy;

import java.sql.*;

public class DBcon {
	public static void main(String[] args){
	Connection conn = null;

	try{
		Class.forName("com.mysql.jdbc.Driver");

		conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root","12345678");

		Statement stmt = conn.createStatement();

		String selectStuff = "SELECT name FROM users";

		ResultSet rows = stmt.executeQuery(selectStuff);

		while(rows.next()){
			System.out.println(rows.getString("name"));
		}
	}catch(SQLException ex){
		// print out the exception message
		System.out.println("SQLException : " + ex.getMessage());
		//print vendor error code
		System.out.println("Vendor error: "+ ex.getErrorCode());
	}catch (ClassNotFoundException cnf){
		// executes if driver can't be found
		cnf.printStackTrace();
	}

	}
}
