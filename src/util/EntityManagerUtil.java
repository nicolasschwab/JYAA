package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jyaa" );
	
	public static EntityManager  getEntityManager(){
		return emf.createEntityManager();
	}
	
}
