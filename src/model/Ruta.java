package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Ruta {

	//@Id @GeneratedValue(strategy=GenerationType.TABLE)
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String descripcion;
	private String privacidad;
	private String formato;
	private Double distancia;
	private String dificultad;
	private String tiempoEstimado;
	private Date fechaRealizacion;
	@OneToOne(fetch = FetchType.EAGER)
	private Actividad actividad;
	@OneToMany(fetch = FetchType.LAZY)
	private Collection<Foto> fotos;
	@OneToMany(fetch = FetchType.LAZY)
	private Collection<Punto> puntos;
	
	public Ruta() {
		super();
		setFotos(new ArrayList<Foto>());
		setPuntos(new ArrayList<Punto>());
	}
	
	public Ruta(String nombre, String descripcion, String privacidad,
			String formato, Double distancia, String dificultad,
			String tiempoEstimado, Date fechaRealizacion,
			Actividad actividad) {
		super();
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrivacidad(privacidad);
		setFormato(formato);
		setDistancia(distancia);
		setDificultad(dificultad);
		setTiempoEstimado(tiempoEstimado);
		setFechaRealizacion(fechaRealizacion);
		setActividad(actividad);
		setFotos(new ArrayList<Foto>());
		setPuntos(new ArrayList<Punto>());
	}
	
	
	public void hiceEstaRuta(Usuario usuario){
		//getHacedores().put(usuario, -1);
	}
	
	public void valorar(Integer puntaje, Usuario usuario){
		//getHacedores().put(usuario, puntaje);
	}	
	
	public void addFoto(Foto foto){
		getFotos().add(foto);
	}
	public void addPunto(Punto punto){
		getPuntos().add(punto);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrivacidad() {
		return privacidad;
	}
	public void setPrivacidad(String privacidad) {
		this.privacidad = privacidad;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	public String getTiempoEstimado() {
		return tiempoEstimado;
	}
	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}
	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	public Collection<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(Collection<Foto> fotos) {
		this.fotos = fotos;
	}
	public Collection<Punto> getPuntos() {
		return puntos;
	}
	public void setPuntos(Collection<Punto> puntos) {
		this.puntos = puntos;
	}
	
}
