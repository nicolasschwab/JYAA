package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Actividad {

	//@Id @GeneratedValue(strategy=GenerationType.TABLE)
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	private boolean habilitada;
	
	public Actividad(){
		super();
	}
	
	public Actividad(String nombre, boolean habiiltada){
		setNombre(nombre);
		setHabilitada(habiiltada);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}

	public void deshabilitar() {
		this.habilitada=false;		
	}
	
	public void habilitar() {
		this.habilitada=true;		
	}	
	
	
}
