package dao;

import java.util.List;

public interface GenericDAO<T> {

	public T save(T entity);
	
	public T edit(T entity);
	
	public 	List<T> getAll();
	
	public T get(Long id);
	
	public List<T> get(String nombre);
	
	public void delete(Long id);
	
}
