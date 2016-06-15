package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
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
		this.getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public T edit(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
	}

	@Override
	public List<T> getAll() {
		Query consulta = getEntityManager().createQuery(
				"select e from " + getPersistentClass().getSimpleName() + " e");
		@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>) consulta.getResultList();
		return resultado;
	}

	@Override
	public T get(Long id) {
		try {
			Query consulta = getEntityManager().createQuery(
					"select e from " + getPersistentClass().getSimpleName()
							+ " e where e.id = " + id);
			@SuppressWarnings("unchecked")
			T resultado = (T) consulta.getSingleResult();
			return resultado;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<T> get(String nombre) {
		Query consulta = getEntityManager().createQuery(
				"select e from " + getPersistentClass().getSimpleName()
						+ " e where e.nombre = :nombre");
		consulta.setParameter("nombre", nombre);
		@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>) consulta.getResultList();
		return resultado;
	}

	@Override
	public void delete(Long id) {
		getEntityManager().remove(
				getEntityManager().find(getPersistentClass(), id));
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

