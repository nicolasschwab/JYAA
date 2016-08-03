package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import model.Usuario;
import dao.UsuarioDAO;


public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO{
	public UsuarioDAOImpl() {
		super(Usuario.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getAllByActivo(Boolean activo) {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		List<Usuario> resultado=null;
		try{			
			etx.begin();
			Query consulta = em.createQuery(
					"select u from " + getPersistentClass().getSimpleName() + " u where u.activo = :activo").setParameter("activo", activo);
			em.flush();
			resultado = (List<Usuario>) consulta.getResultList();
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
