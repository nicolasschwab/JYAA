package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Puntaje {

	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private int calificacion;
	@OneToOne
	private Usuario calificador;
	@OneToOne
	private Ruta ruta;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public Usuario getCalificador() {
		return calificador;
	}
	public void setCalificador(Usuario calificador) {
		this.calificador = calificador;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	
}
