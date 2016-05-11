package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ruta {

	private Long id;
	private String nombre;
	private String descripcion;
	private String privacidad;
	private String formato;
	private Double distancia;
	private String dificultad;
	private String tiempoEstimado;
	private Date fechaRealizacion;
	private Actividad actividad;
	private List<Foto> fotos;
	private Map<Usuario, Integer> hacedores;
	private List<Punto> puntos;
	
	public Ruta() {
		super();
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
		actividad.addRuta(this);
		setActividad(actividad);
		setFotos(new ArrayList<Foto>());
		setHacedores(new HashMap<Usuario, Integer>());
		setPuntos(new ArrayList<Punto>());
	}
	
	
	public Integer cantidadHacedores() {
		return getHacedores().size();
	}
	
	public Double puntajePromedio() {
		Double sumaTotal = 0.0;
		Integer cantidadPuntuadores = 0;
		for ( Integer i : getHacedores().values() ){
			cantidadPuntuadores += ( i < 0 ) ? 0 : 1;
			sumaTotal += ( i < 0 ) ? 0 : i;
		}
		return sumaTotal / cantidadPuntuadores;
	}
	
	public void hiceEstaRuta(Usuario usuario){
		getHacedores().put(usuario, -1);
	}
	
	public void valorar(Integer puntaje, Usuario usuario){
		getHacedores().put(usuario, puntaje);
	}	
	
	public void addFoto(Foto foto){
		getFotos().add(foto);
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
	public HashMap<Usuario, Integer> getHacedores() {
		return (HashMap<Usuario, Integer>) hacedores;
	}
	public void setHacedores(HashMap<Usuario, Integer> hacedores) {
		this.hacedores = hacedores;
	}
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	public List<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public List<Punto> getPuntos() {
		return puntos;
	}

	public void setPuntos(List<Punto> puntos) {
		this.puntos = puntos;
	}

	public void setHacedores(Map<Usuario, Integer> hacedores) {
		this.hacedores = hacedores;
	}
	
	
}
