package dao.impl;

import model.Actividad;
import model.Ruta;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dao.RutaDAO;
import jsf.ActividadBean;

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

	@Override
	public List<Ruta> buscar(String nombre, ActividadBean actividad, Date fecha) {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		List<Ruta> resultado=null;
		try{
			etx.begin();
			String dateQuery = fecha != null ? " and fecha > :fecha" : "" ; 
			Query consulta = em.createQuery(
					"select e from " + getPersistentClass().getSimpleName() + " e where e.actividad.nombre like :nombreActividad and e.nombre like :nombre" + dateQuery
					
			);
			consulta.setParameter("nombre", nombre);
			consulta.setParameter("nombreActividad", actividad.getNombre());
			if(fecha != null){
				consulta.setParameter("fecha", fecha);
			}			
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
		return null;
	}
}
