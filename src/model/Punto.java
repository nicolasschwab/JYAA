package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Punto {

	@Id
	private Long id;
	private Long latitud;
	private Long longitud;
	private String descripcion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLatitud() {
		return latitud;
	}
	public void setLatitud(Long latitud) {
		this.latitud = latitud;
	}
	public Long getLongitud() {
		return longitud;
	}
	public void setLongitud(Long longitud) {
		this.longitud = longitud;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	 
}

