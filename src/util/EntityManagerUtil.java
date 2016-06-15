package util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	public static EntityManager  getEntityManager(){
		return Persistence.createEntityManagerFactory( "jyaa" ).createEntityManager();
	}
	
}
