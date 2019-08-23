package co.za.wethinkcode.swingy.dbshet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Entities {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("co.za.wethinkcode.swingy.dbshet");

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

	public Test getUser(int user_id){
		EntityManager em = getEntityManager();
		Test test = em.find(Test.class, user_id);
		em.detach(test);
		return test;
	}

	/*public List<?> queryForUser() {
		EntityManager em = getEntityManager();
		List<?> test = em.createQuery("SELECT u from Test u where u.name")
				.setParameter(1, "English")
				.getResultList();
		return test;
	}*/

	public static  void main(String[] args){

	//	Entities entities = new Entities();

//		entities.saveUser("Drake");

		EntityManager entityManager = emf.createEntityManager();
		Test test = new Test();
		test.setName_("Drake");
		entityManager.getTransaction().begin();
		entityManager.persist(test);
		entityManager.getTransaction().commit();


	}

}
