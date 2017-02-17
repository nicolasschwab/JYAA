package dao.impl;

import model.Actividad;
import model.Ruta;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TemporalType;

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
	public List<Ruta> buscar(Ruta ruta, ActividadBean actividad, String ordenar) throws ParseException {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		List<Ruta> resultado=null;
		try{
			etx.begin();
			String dateQuery = ruta.getBuscarFecha() != null ? " and fechaRealizacion = :fecha " : "" ;
			ordenar = ordenar == null ? "e.distancia ASC" :"e."+ordenar+" ASC";
			Query consulta = em.createQuery(
					"select e from " + getPersistentClass().getSimpleName() + " e where e.actividad.nombre like :nombreActividad and e.nombre like :nombre and e.dificultad like :dificultad and e.formato like :formato and e.distancia >= :distancia and e.tiempoEstimado like :tiempoEstimado " + dateQuery + "ORDER BY "+ordenar
			);
			consulta.setParameter("nombre", ruta.getBuscarNombre());
			consulta.setParameter("nombreActividad", actividad.getBuscarNombre());
			consulta.setParameter("dificultad", ruta.getBuscarDificultad());
			consulta.setParameter("formato", ruta.getBuscarFormato());
			
			Double distancia = ruta.getBuscarDistancia();
			if(distancia != null){
				consulta.setParameter("distancia", distancia);
			}else{
				consulta.setParameter("distancia", Double.parseDouble("0"));
			}			
			consulta.setParameter("tiempoEstimado", ruta.getBuscarTiempoEstimado());
			if(ruta.getBuscarFecha() != null){
				consulta.setParameter("fecha", ruta.getBuscarFecha(), TemporalType.DATE);
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
		return resultado;
	}
}
