package bean;

import javax.persistence.*;

@Entity
public class Foto {

	@Id
	long id;
	String nombre;
	@Lob
	@Column(length=16777215)
	private byte[] contenido;
	
	public Foto(){
		
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

	public byte[] getContenido() {
		return contenido;
	}

	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}
	
	
}
