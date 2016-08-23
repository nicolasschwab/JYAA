package dao.impl;

import model.Actividad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dao.ActividadDAO;

public class ActividadDAOImpl extends GenericDAOImpl<Actividad> implements
		ActividadDAO {
	public ActividadDAOImpl() {
		super(Actividad.class);
	}

	@Override
	public List<Actividad> getAllByHabilitada(boolean estado) {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		List<Actividad> resultado =null;
		try{			
			etx.begin();
			Query consulta = em.createQuery(
					"select e from " + getPersistentClass().getSimpleName()
							+ " e where e.habilitada = :estado");
			consulta.setParameter("estado", estado);
			resultado = (List<Actividad>) consulta.getResultList();
			em.flush();
			etx.commit();
		}catch(PersistenceException e){
			System.out.println("Error al recuperar los objetos");
			System.out.println(e.getMessage());
			etx.rollback();
		}finally{
			em.close();
		}
		return resultado;
	}
}
