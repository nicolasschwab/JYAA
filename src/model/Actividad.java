package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actividad {

	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	private long id;
	private String nombre;
	
	public Actividad(){
		super();
	}
	
	public Actividad(String nombre){
		setNombre(nombre);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
