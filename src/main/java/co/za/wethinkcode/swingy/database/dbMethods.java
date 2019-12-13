package co.za.wethinkcode.swingy.database;

import co.za.wethinkcode.swingy.model.characters.Hero;
import co.za.wethinkcode.swingy.model.characters.HeroBuild;
import co.za.wethinkcode.swingy.model.characters.HeroCreator;
import co.za.wethinkcode.swingy.model.characters.heroes.Fighter;
import co.za.wethinkcode.swingy.model.characters.heroes.Mage;
import co.za.wethinkcode.swingy.model.characters.heroes.Witcher;

import java.sql.*;

public class dbMethods {

	protected void createDb(){

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

	protected void createTable(){

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

	public void addHero(String heroName, String heroClass, int heroLevel, int heroExp, int heroAtk, int heroDef, int heroHP) {

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
				System.out.println("\nNew hero added to database");
		}catch (SQLException ex){
			System.out.println("\nError: Hero name '" + heroName + "' already in use");
		//	System.exit(0);
		}
	}

	public void selectAll(){

		dbConnect dbCon = new dbConnect();
		String sql = "SELECT * FROM heroes";
		try(Connection conn = dbCon.connect();
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql)){

			System.out.println("These are all saved heroes");
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
			System.out.println(ex.getMessage() + "selection error");
		//	System.exit(0);
		}
	}

	public void selectHero(String heroName){

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

	public Hero getHerodb(int id){

		int heroLvl, heroExp, heroHP, heroAtk, heroDef;
		String heroName, heroClass;
		HeroCreator heroCreator;
		Hero hero= null;

		dbConnect dbcon = new dbConnect();
		String sql = "SELECT * FROM heroes WHERE heroID = '" + id + "'";
		
		try(Connection conn = dbcon.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);){
			while(rs.next()){
				heroName = rs.getString("heroName");
				heroClass = rs.getString("heroClass");
				heroLvl = rs.getInt("heroLevel");
				heroExp = rs.getInt("heroExp");
				heroHP = rs.getInt("heroHP");
				heroAtk = rs.getInt("heroAtk");
				heroDef = rs.getInt("heroDef");

				switch(heroClass.toLowerCase()){
					case "witcher":
						HeroBuild witcher = new Witcher(heroName);
						heroCreator = new HeroCreator(witcher);
						break;
					case "mage":
						HeroBuild mage = new Mage(heroName);
						heroCreator = new HeroCreator(mage);
						break;
					case "fighter":
						HeroBuild fighter = new Fighter(heroName);
						heroCreator = new HeroCreator(fighter);
						break;
					default:
						throw new IllegalStateException("Unexpected value: " + heroClass);
				}
				heroCreator.createHero();
				hero = heroCreator.getHero();
				hero.setLevel(heroLvl);
				hero.setExperience(heroExp);
				hero.setHitPoints(heroHP);
				hero.setAttack(heroAtk);
				hero.setDefense(heroDef);
			}
			return hero;
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		return null;
	}
	

	public void updateHero(String heroName, int heroLvl, int heroExp, int heroHP, int heroAtk, int heroDef){
		dbConnect dbCon = new dbConnect();
		String sql = "UPDATE heroes SET heroLevel = ?," +
				"heroExp = ?," +
				"heroHP = ?," +
				"HeroAtk = ?," +
				"heroDef = ?" +
				"WHERE heroName = ?";
		try(Connection conn = dbCon.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			//set Parameters
			pstmt.setInt(1, heroLvl);
			pstmt.setInt(2,heroExp);
			pstmt.setInt(3, heroHP);
			pstmt.setInt(4, heroAtk);
			pstmt.setInt(5, heroDef);
			pstmt.setString(6,heroName);
			//update Hero stats
			pstmt.executeUpdate();
		}catch (SQLException ex){
			System.out.println(ex.getMessage());
		}
}

	public void deleteHero(String heroName){
		dbConnect dbCon = new dbConnect();
		String sql = "DELETE * FROM heroes WHERE heroName = ?";
		try(Connection conn = dbCon.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1,heroName);
			pstmt.executeUpdate();
		}catch (SQLException ex){
			System.out.println("Error: cannot delete hero");
		}
}

}
