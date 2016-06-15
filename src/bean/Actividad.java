package bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actividad {

	@Id
	long id;
	String nombre;
	
	public Actividad(){
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
