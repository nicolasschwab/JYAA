package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


import util.EntityManagerUtil;
import dao.GenericDAO;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	protected Class<T> persistentClass;

	public GenericDAOImpl(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}

	public GenericDAOImpl() {

	}

	@Override
	public T save(T entity) {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		try{			
			etx.begin();
			em.persist(entity);
			em.flush();
			etx.commit();
		}catch(PersistenceException e){
			System.out.println("Error al registrar el objeto");
			System.out.println(e.getMessage());
			etx.rollback();
		}finally{
			em.close();
		}
		return entity;
	}

	@Override
	public T edit(T entity) {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		try{			
			etx.begin();
			em.merge(entity);
			em.flush();
			etx.commit();
		}catch(PersistenceException e){
			System.out.println("Error al modificar el objeto");
			System.out.println(e.getMessage());
			etx.rollback();
		}finally{
			em.close();
		}
		return entity;
	}

	@Override
	public List<T> getAll() {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		List<T> resultado=null;
		try{			
			etx.begin();
			Query consulta = em.createQuery(
					"select e from " + getPersistentClass().getSimpleName() + " e");
			em.flush();
			resultado = (List<T>) consulta.getResultList();
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

	@Override
	public T get(Long id) {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		T resultado =null;
		try{			
			etx.begin();
			Query consulta = em.createQuery(
					"select e from " + getPersistentClass().getSimpleName()
							+ " e where e.id = " + id);
			resultado = (T) consulta.getSingleResult();
			em.flush();
			etx.commit();
		}catch(PersistenceException e){
			System.out.println("Error al modificar el objeto");
			System.out.println(e.getMessage());
			etx.rollback();
		}finally{
			em.close();
		}
		System.out.println(resultado);
		return resultado;
	}

	@Override
	public List<T> get(String nombre) {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		List<T> resultado =null;
		try{			
			etx.begin();
			Query consulta = em.createQuery(
					"select e from " + getPersistentClass().getSimpleName()
							+ " e where e.nombre = :nombre");
			consulta.setParameter("nombre", nombre);
			resultado = (List<T>) consulta.getResultList();
			em.flush();
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

	@Override
	public void delete(Long id) {
		EntityManager em = getEntityManager();
		EntityTransaction etx = em.getTransaction();
		try{			
			etx.begin();
			em.remove(
					em.find(getPersistentClass(), id));
			em.flush();
			etx.commit();
		}catch(PersistenceException e){
			System.out.println("Error al modificar el objeto");
			System.out.println(e.getMessage());
			etx.rollback();
		}finally{
			em.close();
		}
		
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public EntityManager getEntityManager() {
		return EntityManagerUtil.getEntityManager();
	}

}

