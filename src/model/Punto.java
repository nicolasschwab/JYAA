package model;

public class Punto {

	private Long longitud;
	private Long latitud;
	private String descripcion;
	
	public Punto(){
		super();
	}
	
	public Punto(Long longitud, Long latitud, String descripcion) {
		super();
		this.longitud = longitud;
		this.latitud = latitud;
		this.descripcion = descripcion;
	}
	
	public Long getLongitud() {
		return longitud;
	}
	public void setLongitud(Long longitud) {
		this.longitud = longitud;
	}
	public Long getLatitud() {
		return latitud;
	}
	public void setLatitud(Long latitud) {
		this.latitud = latitud;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
