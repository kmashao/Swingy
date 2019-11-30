package co.za.wethinkcode.swingy.database;

import java.sql.*;

import co.za.wethinkcode.swingy.database.dbConnect;
import org.jetbrains.annotations.Nullable;

public class createDB {

	private static String url = "jdbc:sqlite:/Swingy.db";
	//static dbConnect con = new dbConnect();

	public Connection connect() {
		return getConnection();
	}

	@Nullable
	static Connection getConnection() {
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

	public  static void createDb(){

		try{
			Connection conn = DriverManager.getConnection(url);
			if (conn != null){
				DatabaseMetaData dbMeta =conn.getMetaData();
				System.out.println("meta is " + dbMeta);
				System.out.println("db created");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

	public static void createTable(){
		String sql = "CREATE TABLE IF NOT EXISTS heroes (\n"
				+ "heroID INTEGER PRIMARY KEY AUTO_INCREMENT, \n"
				+ "heroName TEXT NOT NULL,\n"
				+ "heroClass TEXT NOT NULL,\n"
				+ "heroLevel INTEGER NOT NULL ,\n"
				+ "heroExp INTEGER NOT NULL ,\n"
				+ "heroHP INTEGER NOT NULL ,\n"
				+ "heroAtk INTEGER NOT NULL ,\n"
				+ "heroDef INTEGER NOT NULL \n"
				+ " );";

		try (Connection conn = DriverManager.getConnection(url);
		     Statement stmt = conn.createStatement()){
			//create table
			stmt.executeQuery(sql);
			System.out.println("table added");
		}catch (SQLException ex){
			System.out.println(ex.getMessage());
		}

	}

	public void addHero(String heroName, String heroClass, int heroLevel, int heroExp, int heroAtk, int heroDef, int heroHP) {
		String sql = "INSERT INTO heroes (heroName, heroClass, heroLevel, heroExp, heroHP, heroAtk, heroDef) VALUES (?,?,?,?,?,?,?)";
		try(Connection conn = this.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1,heroName);
				pstmt.setString(2,heroClass);
				pstmt.setInt(3,heroLevel);
				pstmt.setInt(4,heroExp);
				pstmt.setInt(5,heroHP);
				pstmt.setInt(6,heroAtk);
				pstmt.setInt(7,heroDef);
				pstmt.executeUpdate();
		}catch (SQLException ex){
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args){
		createDb();
		createTable();
		createDB db = new createDB();
		db.addHero("jj","witcher",1,1000,120,50,200);
	}

}
