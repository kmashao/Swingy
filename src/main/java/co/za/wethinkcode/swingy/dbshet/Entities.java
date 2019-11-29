package co.za.wethinkcode.swingy.dbshet;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.*;
import java.util.List;

@Entity

public class Entities {

	private int heroID;
	private String heroName;
	private String heroClass;
	private int heroLevel;
	private int heroExp;
	private int heroDef;
	private int heroAtk;
	private int heroHP;

	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String name){heroName = name;}

	public String getHeroClass() { return heroClass; }
	public void setHeroClass(String heroClass){this.heroClass = heroClass;}

	public int getHeroLevel() {
		return heroLevel;
	}
	public void setHeroLevel(int level){heroLevel = level;}

	public int getHeroExp() {
		return heroExp;
	}
	public void setHeroExp(int xp){heroExp = xp;}

	public void setHeroDef(int def){heroDef = def;}
	public int getHeroDef() {
		return heroDef;
	}

	public void setHeroAtk(int atk){heroAtk = atk;}
	public int getHerAtk() {
		return heroAtk;
	}

	public void setHeroHP(int hp) {heroHP = hp;}
	public int getHeroHP() {return  heroHP;}


	/*public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("swing");

	private static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}

	public void saveUser(String name){

		EntityManager em = getEntityManager();

		Test test = new Test();
		test.setName_(name);
		em.persist(test);
		em.getTransaction().commit();
	}

	public Test getUser(int heroId){
		EntityManager em = getEntityManager();
		Test test = em.find(Test.class, heroId);
		em.detach(test);
		return test;
	}*/

	public void addDB(String heroName, String heroClass, int heroLevel, int heroExp, int heroAtk, int heroDef, int heroHP){

	}

	public void dbConnect(){

	}

	public static  void main(String[] args){

	//	Entities entities = new Entities();

		/*entities.saveUser("Drake");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Swing");
		EntityManager entityManager = emf.createEntityManager();
		Query q = entityManager.createQuery("SELECT s FROM heroes s");
		List heroes = q.getResultList();
		Test test = new Test();
		test.setName_("Drake");
		entityManager.getTransaction().begin();
		entityManager.persist(test);
		entityManager.getTransaction().commit();*/

		Connection conn = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingy","root","123456");
			conn.setAutoCommit(false);
			System.out.println("connected");
			Statement stmt = conn.createStatement();
			String selectStuff = "SELECT * FROM heroes";
			ResultSet rows = stmt.executeQuery(selectStuff);
			while(rows.next()){
				System.out.println(rows.getString("heroName"));
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
