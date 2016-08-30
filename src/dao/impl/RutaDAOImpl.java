package dao.impl;

import model.Ruta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dao.RutaDAO;

public class RutaDAOImpl extends GenericDAOImpl<Ruta> implements RutaDAO {
	public RutaDAOImpl() {
		super(Ruta.class);
	}

	@Override
	public List<Ruta> getRutasConActividad(String nombre) {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		List<Ruta> resultado=null;
		try{			
			etx.begin();
			Query consulta = em.createQuery(
					"select e from " + getPersistentClass().getSimpleName() + " e where e.actividad.nombre=:nombre");
			consulta.setParameter("nombre", nombre);
			em.flush();
			resultado = (List<Ruta>) consulta.getResultList();
			etx.commit();
		}catch(PersistenceException e){
			System.out.println("Error al obtener el objeto");
			System.out.println(e.getMessage());
			etx.rollback();
		}finally{
			em.close();
		}		
		return resultado;
	}
}
