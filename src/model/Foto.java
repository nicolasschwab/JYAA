package model;

public class Foto {

	private String nombre;
	private Byte[] contenido;

	public Foto(){
		super();
	}
	
	public Foto(String nombre, Byte[] contenido) {
		super();
		this.nombre = nombre;
		this.contenido = contenido;
	}

	public Byte[] getContenido() {
		return contenido;
	}

	public void setContenido(Byte[] contenido) {
		this.contenido = contenido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
