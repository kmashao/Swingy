package co.za.wethinkcode.swingy.database;

import co.za.wethinkcode.swingy.model.characters.*;

import javax.persistence.Entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Entity

public class dbConnect {

	public Connection connect() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:Swingy.db";
			conn = DriverManager.getConnection(url);
			conn.setAutoCommit(false);
			System.out.println("successfully connected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return conn;
	}
}
