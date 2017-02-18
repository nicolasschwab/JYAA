package model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.Part;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import util.Validator;

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
	@Temporal(TemporalType.DATE)
	private Date fechaRealizacion;
	@ManyToOne(fetch = FetchType.EAGER)
	private Actividad actividad;
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DELETE})
	private Foto foto1;
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DELETE})
	private Foto foto2;
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DELETE})
	private Foto foto3;
	@OneToMany(fetch = FetchType.LAZY)
	@Cascade({CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DELETE})
	private Collection<Punto> puntos;
	private int puntajeTotal;
	@ManyToMany  
	private Collection<Usuario> hacedores;
	@ManyToOne
	private Usuario owner;
	
	public Ruta (){
		
	}
	
	public Ruta(Usuario usr) {
		super();
		setPuntos(new ArrayList<Punto>());
		setHacedores(new ArrayList<Usuario>());
		this.getHacedores().add(usr);
		setFoto1(new Foto());
		setFoto2(new Foto());
		setFoto3(new Foto());
		setPuntajeTotal(0);
	}
	
	public Ruta(String nombre, String descripcion, boolean privacidad,
			String formato, Double distancia, String dificultad,
			String tiempoEstimado, Date fechaRealizacion,
			Actividad actividad, Usuario usr) {
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
		setPuntajeTotal(0);
		setOwner(usr);
		setHacedores(new ArrayList<Usuario>());
		this.getHacedores().add(usr);
	}
	
	public StreamedContent getShowFoto1() throws IOException{		
		if(this.foto1 != null && this.foto1.getContenido() != null){
			Foto foto = (Foto) this.foto1;
			return genericGetFoto(foto);
		}
		return null;
	}
	
	public StreamedContent getShowFoto2() throws IOException{		
		if(this.foto2 != null  && this.foto2.getContenido() != null){
			Foto foto = (Foto) this.foto2;
			return genericGetFoto(foto);
		}
		return null;
	}
	
	public StreamedContent getShowFoto3() throws IOException{		
		if(this.foto3 != null && this.foto3.getContenido() != null){
			Foto foto = (Foto) this.foto3;
			return genericGetFoto(foto);
		}
		return null;
	}
	
	public StreamedContent getShowFoto() throws IOException{
		StreamedContent foto = this.getShowFoto1();
		if(foto != null ){
			return foto;
		}else{
			foto = this.getShowFoto2();
			if(foto != null){
				return foto;
			}else{
				foto = this.getShowFoto3();
				if(foto != null){
					return foto;
				}
			}
		}
		return new DefaultStreamedContent();
	} 
	
	private StreamedContent genericGetFoto(Foto foto) throws IOException{
		if(foto != null){
			InputStream inputStream = new ByteArrayInputStream(foto.getContenido());
			return new DefaultStreamedContent(inputStream);	
		}
		return null;
	}
	
	public void valorar(Integer puntaje, Usuario usuario){
		if(!this.getHacedores().contains(usuario)){
			this.getHacedores().add( usuario );
			this.setPuntajeTotal( puntajeTotal+puntaje );
		}		
	}
	
	public Double getCalificacion(){
		if(this.getHacedores().size() == 1){
			return 0.0;
		}
		return (double) (this.getPuntajeTotal() / (this.getHacedores().size() - 1));
	}
	
	public boolean yaCalifico(Usuario usr){
		return this.getHacedores().contains(usr);
	}
	
	public int getCantHacedores(){
		return this.getHacedores().size();
	}
	
	public void addPunto(Punto punto){
		getPuntos().add(punto);
	}
	
	public String getBuscarNombre(){
		return Validator.stringNoVacio(this.getNombre()) ? this.getNombre() : "%";
	}
	
	public String getBuscarDificultad(){
		return Validator.stringNoVacio(this.getDificultad()) ? this.getDificultad() : "%";
	}
	
	public String getBuscarFormato(){
		return Validator.stringNoVacio(this.getFormato()) ? this.getFormato() : "%";
	}
	
	public Double getBuscarDistancia(){
		return this.getDistancia() != null ? this.getDistancia() : null;
	}
	
	public String getBuscarTiempoEstimado(){
		return Validator.stringNoVacio(this.getTiempoEstimado()) ? this.getTiempoEstimado() : "%";
	}
	
	public Date getBuscarFecha() throws ParseException{
		if (this.getFechaRealizacion() != null){ 
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(fechaRealizacion.getTime());
			cal.add(Calendar.DATE, 1);
			return new Date(cal.getTimeInMillis());
		}else{
			return null;
		}
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

	public int getPuntajeTotal() {
		return puntajeTotal;
	}

	public void setPuntajeTotal(int puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}

	public Collection<Usuario> getHacedores() {
		return hacedores;
	}

	public void setHacedores(Collection<Usuario> hacedores) {
		this.hacedores = hacedores;
	}

	public Usuario getOwner() {
		return owner;
	}

	public void setOwner(Usuario owner) {
		this.owner = owner;
	}
	
	
	
}
