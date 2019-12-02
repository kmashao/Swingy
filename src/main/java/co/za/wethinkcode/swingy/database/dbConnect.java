package co.za.wethinkcode.swingy.database;

import co.za.wethinkcode.swingy.model.characters.*;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {

	public Connection connect() {
		return getConnect();
	}

	@Nullable
	public Connection getConnect() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:Swingy.db";
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}
}
