package model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.servlet.http.Part;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@XmlRootElement
@Entity
public class Ruta {

	//@Id @GeneratedValue(strategy=GenerationType.TABLE)
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String descripcion;
	private boolean privacidad;
	private String formato;
	private Double distancia;
	private String dificultad;
	private String tiempoEstimado;
	private Date fechaRealizacion;
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.MERGE, CascadeType.DELETE})
	private Actividad actividad;
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.MERGE, CascadeType.DELETE})
	private Foto foto1;
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.MERGE, CascadeType.DELETE})
	private Foto foto2;
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.MERGE, CascadeType.DELETE})
	private Foto foto3;
	@OneToMany(fetch = FetchType.LAZY)
	@Cascade({CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DELETE})
	private Collection<Punto> puntos;
	
	public Ruta() {
		super();
		setPuntos(new ArrayList<Punto>());
		setFoto1(new Foto());
		setFoto2(new Foto());
		setFoto3(new Foto());
	}
	
	public Ruta(String nombre, String descripcion, boolean privacidad,
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
		setFoto1(new Foto());
		setFoto2(new Foto());
		setFoto3(new Foto());
		setPuntos(new ArrayList<Punto>());
	}
	
	public StreamedContent getShowFoto1() throws IOException{		
		if(this.foto1 != null && this.foto1.getContenido() != null && this.foto1.getContenido().length == 0){
			Foto foto = (Foto) this.foto1;
			return genericGetFoto(foto);
		}
		return null;
	}
	
	public StreamedContent getShowFoto2() throws IOException{		
		if(this.foto2 != null  && this.foto2.getContenido() != null && this.foto2.getContenido().length == 0){
			Foto foto = (Foto) this.foto2;
			return genericGetFoto(foto);
		}
		return null;
	}
	
	public StreamedContent getShowFoto3() throws IOException{		
		if(this.foto3 != null && this.foto3.getContenido() != null && this.foto3.getContenido().length == 0){
			Foto foto = (Foto) this.foto3;
			return genericGetFoto(foto);
		}
		return null;
	}
	
	private StreamedContent genericGetFoto(Foto foto) throws IOException{
		if(foto != null){
			InputStream inputStream = new ByteArrayInputStream(foto.getContenido());
			return new DefaultStreamedContent(inputStream);	
		}
		return null;
	}
	
	
	public void hiceEstaRuta(Usuario usuario){
		//getHacedores().put(usuario, -1);
	}
	
	public void valorar(Integer puntaje, Usuario usuario){
		//getHacedores().put(usuario, puntaje);
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
	public boolean getPrivacidad() {
		return privacidad;
	}
	public void setPrivacidad(boolean privacidad) {
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
	public Foto getFoto1() {
		return foto1;
	}
	public void setFoto1(Foto foto1) {
		this.foto1 = foto1;
	}
	public Foto getFoto2() {
		return foto2;
	}
	public void setFoto2(Foto foto2) {
		this.foto2 = foto2;
	}
	public Foto getFoto3() {
		return foto3;
	}
	public void setFoto3(Foto foto3) {
		this.foto3 = foto3;
	}
	public Collection<Punto> getPuntos() {
		return puntos;
	}
	public void setPuntos(Collection<Punto> puntos) {
		this.puntos = puntos;
	}

	public void agregarPunto(Punto punto) {
		this.getPuntos().add(punto);
	}

	public void borrarPunto(Punto punto) {
		for(Punto unPunto:this.getPuntos()){
			if(unPunto.getId()==punto.getId()){
				this.getPuntos().remove(unPunto);
				break;
			}
		}
	}

	public Collection<Punto> borrarTodosPuntos() {
		Collection<Punto> puntos=this.getPuntos();
		this.setPuntos(new ArrayList<Punto>());
		return puntos;
	}
	
}
