package dao.impl;

import model.Administrador;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dao.AdministradorDAO;

public class AdministradorDAOImpl extends GenericDAOImpl<Administrador> implements AdministradorDAO {
	public AdministradorDAOImpl() {
		super(Administrador.class);
	}
	
	@Override
	public Administrador getByUsernamePassword(String username, String password) {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		Administrador resultado=null;
		try{			
			etx.begin();
			Query consulta = em.createQuery(
					"select e from " + getPersistentClass().getSimpleName() + " e where e.nombreUsuario=:username and e.contrasenia=:password");
			consulta.setParameter("username", username);
			consulta.setParameter("password", password);
			em.flush();
			resultado = (Administrador) consulta.getSingleResult();
			etx.commit();
		}catch(PersistenceException e){
			System.out.println("Error al modificar el objeto");
			System.out.println(e.getMessage());
			etx.rollback();
		}finally{
			em.close();
		}
		return resultado;		
	}
}
