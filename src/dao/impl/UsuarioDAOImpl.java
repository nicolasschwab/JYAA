package dao.impl;

import model.Usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dao.UsuarioDAO;


public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO{
	public UsuarioDAOImpl() {
		super(Usuario.class);
	}

	@Override
	public Usuario getByUsernamePassword(String username, String password) {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		Usuario resultado=null;
		try{			
			etx.begin();
			Query consulta = em.createQuery(
					"select e from " + getPersistentClass().getSimpleName() + " e where e.nombreUsuario=:username and e.contrasenia=:password");
			consulta.setParameter("username", username);
			consulta.setParameter("password", password);
			em.flush();
			resultado = (Usuario) consulta.getSingleResult();
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

