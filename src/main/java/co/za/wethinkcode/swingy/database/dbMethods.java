package co.za.wethinkcode.swingy.database;

import java.sql.*;

public class dbMethods {

	private void createDb(){

		dbConnect dbCon = new dbConnect();
		try{
			Connection conn = dbCon.connect();
			if (conn != null){
				DatabaseMetaData dbMeta = conn.getMetaData();
				System.out.println("meta is " + dbMeta);
				System.out.println("database created");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage() + "\nError: cannot create database");
			System.exit(0);
		}
	}

	private void createTable(){

		dbConnect dbCon = new dbConnect();

		String sql = "CREATE TABLE IF NOT EXISTS heroes (\n"
				+ "heroID INTEGER PRIMARY KEY,\n"
				+ "heroName TEXT NOT NULL UNIQUE ,\n"
				+ "heroClass TEXT NOT NULL ,\n"
				+ "heroLevel INTEGER NOT NULL ,\n"
				+ "heroExp INTEGER NOT NULL ,\n"
				+ "heroHP INTEGER NOT NULL ,\n"
				+ "heroAtk INTEGER NOT NULL ,\n"
				+ "heroDef INTEGER NOT NULL \n"
				+ " );";

		try (Connection conn = dbCon.connect();
		     Statement stmt = conn.createStatement()){
			//create table
			stmt.executeUpdate(sql);
			System.out.println("table added");
		}catch (SQLException ex){
			System.out.println(ex.getMessage() + "\nError: cannot create table");
			System.exit(0);
		}
	}

	private void addHero(String heroName, String heroClass, int heroLevel, int heroExp, int heroAtk, int heroDef, int heroHP) {

		dbConnect dbCon = new dbConnect();
		String sql = "INSERT INTO heroes (heroName, heroClass, heroLevel, heroExp, heroHP, heroAtk, heroDef) VALUES (?,?,?,?,?,?,?)";
		try(Connection conn = dbCon.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1,heroName);
				pstmt.setString(2,heroClass);
				pstmt.setInt(3,heroLevel);
				pstmt.setInt(4,heroExp);
				pstmt.setInt(5,heroHP);
				pstmt.setInt(6,heroAtk);
				pstmt.setInt(7,heroDef);
				pstmt.execute();
				System.out.println("\nNew hero added to database\n");
		}catch (SQLException ex){
			System.out.println("\nError: Hero name '" + heroName + "' already in use");
		//	System.exit(0);
		}
	}

	private void selectAll(){

		dbConnect dbCon = new dbConnect();
		String sql = "SELECT * FROM heroes";
		try(Connection conn = dbCon.connect();
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()){
				System.out.println( "\nid: " + rs.getInt("heroID" ) +
									"\nName: " + rs.getString("heroName") +
									"\nClass: " + rs.getString("heroClass") +
									"\nLevel: " + rs.getInt("heroLevel") +
									"\nExperience: " + rs.getInt("heroExp") +
									"\nHit Points: " + rs.getInt("heroHP") +
									"\nAttack: " + rs.getInt("HeroAtk") +
									"\nDefense: " + rs.getInt("HeroDef"));
			}
		}catch(SQLException ex){
			System.out.println(ex.getMessage() + "selection error");
		//	System.exit(0);
		}
	}

	private void selectHero(String heroName){

		dbConnect dbCon = new dbConnect();
		String sql = "SELECT * FROM heroes WHERE heroName = '" + heroName + "'";
		try(Connection conn = dbCon.connect();
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()){
				System.out.println( "\nID: " + rs.getInt("heroID" ) +
									"\nName: " + rs.getString("heroName") +
									"\nClass: " + rs.getString("heroClass") +
									"\nLevel: " + rs.getInt("heroLevel") +
									"\nExperience: " + rs.getInt("heroExp") +
									"\nHit Points: " + rs.getInt("heroHP") +
									"\nAttack: " + rs.getInt("HeroAtk") +
									"\nDefense: " + rs.getInt("HeroDef"));
			}
		}catch(SQLException ex){
			System.out.println(ex.getMessage() + "\nError: Hero Does not exist");
		//	System.exit(0);
		}
	}



	public static void main(String[] args){
		dbMethods db = new dbMethods();
//		db.createDb();
//		db.createTable();
		db.addHero("Geralt","Witcher",2,1500,120,0,200);
		db.selectHero("Princess");
		db.selectAll();
	}

}
