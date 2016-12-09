package jsf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import model.Actividad;
import model.Foto;
import model.Punto;
import model.Ruta;
import model.Usuario;
import service.ActividadService;
import service.FotoService;
import service.RutaService;
import service.UsuarioService;
import util.FactoryService;
import util.SessionUtil;
import util.Validator;

@ManagedBean
@SessionScoped
public class RutaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private RutaService rutaService = FactoryService.getRutaService();
	private UsuarioService usuarioService = FactoryService.getUsuarioService();
	private FotoService fotoService = FactoryService.getFotoService();
	private ActividadService actividadService = FactoryService.getActividadService();
	private String nombre;
	@ManagedProperty(value="#{actividadBean}")
	private ActividadBean actividad;
	private Date fecha;
	private List<Actividad> actividades;
	private String dificultad;
	private String formato;
	private Double distancia;
	private String tiempoEstimado;
	private boolean privada;
	private String comentario;
	private Part foto1;
	private Part foto2;
	private Part foto3;
	private StreamedContent showFoto1;
	private StreamedContent showFoto2;
	private StreamedContent showFoto3;
	private String latLong;
	private List<Punto> puntos = new ArrayList<Punto>();
	private boolean modificar = false;
	private Long id;
	
	public String crear() throws IOException{
		List<Foto> fotos  = this.crearFotos();
		String redirect = "";
		if(Validator.validateCreateRuta(nombre, comentario, formato, dificultad, puntos )){
			rutaService.crear(nombre, comentario, privada, formato, distancia, dificultad, tiempoEstimado, fecha, actividadService.getActividad(actividad.getNombre()), fotos, puntos);
			redirect = "lisarRutasUsuario?faces-redirect=true";
		}		
		return redirect;
	}
	
	public String doModificar() throws IOException{
		List<Foto> fotos  = this.crearFotos();
		String redirect = "";
		if(Validator.validateCreateRuta(nombre, comentario, formato, dificultad, puntos )){
			Usuario user = usuarioService.encontrar(SessionUtil.getUserId());
			if(user.esMiRuta(this.getId())){
				Ruta ruta = rutaService.getRuta(this.getId());
				ruta.modificar(nombre, comentario, privada, formato, distancia, dificultad, tiempoEstimado, fecha, actividadService.getActividad(actividad.getNombre()), fotos, puntos);
				rutaService.editRuta(ruta);
				redirect = "lisarRutasUsuario?faces-redirect=true";
				this.crearMensaje("La ruta se modifico con exito!");
			}			
		}		
		return redirect;
	}
		
	public boolean hayRutasConActividad(String nombre){
		List<Ruta> rutas=rutaService.getRutasConActividad(nombre);
		if ( rutas.isEmpty() || rutas == null){
			return false;
		}
		return true;
	}
	
	public void setLatLong(String latLong) {
		System.out.println(latLong);
		this.latLong = latLong;
		this.addPunto();
	}
	
	public String showModificar(Ruta ruta){
		actividad.setNombre(ruta.getActividad().getNombre());
		this.setComentario(ruta.getDescripcion());
		this.setDificultad(ruta.getDificultad());
		this.setDistancia(ruta.getDistancia());
		this.setFecha(ruta.getFechaRealizacion());
		this.setTiempoEstimado(ruta.getTiempoEstimado());
		this.setFormato(ruta.getFormato());
		this.setNombre(ruta.getNombre());
		this.createFotos(ruta.getFotos());
		this.setModificar(true);
		this.setPrivada(ruta.getPrivacidad()=="privada"?true:false);
		this.setPuntos((List<Punto>) ruta.getPuntos());
		this.setId(ruta.getId());
		return "altaRuta?faces-redirect=true";
	}
	
	private void addPunto(){
		String[] arrayLatLong = this.latLong.split("\\_");
		if(arrayLatLong.length == 2){
			Double lon = Double.parseDouble(arrayLatLong[1]);
			Double lat = Double.parseDouble(arrayLatLong[0]);
			Punto punto = new Punto(lat, lon);
			this.puntos.add(punto);
		}		
	}
	
	private void crearMensaje(String mensaje){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						mensaje,
						mensaje));
	}
	
	private void createFotos(Collection<Foto> fotos){
		Foto [] fotosArray = fotos.toArray(new Foto[fotos.size()]);
		for(int i=0; i <fotosArray.length; i ++){
			if(i == 0){
				this.showFoto1 = createOneFoto(fotosArray[i]);
			}
			if(i == 1){
				this.showFoto2 = createOneFoto(fotosArray[i]);
			}
			if(i == 2){
				this.showFoto3 = createOneFoto(fotosArray[i]);
			}
		}
	}
	
	private StreamedContent createOneFoto(Foto foto){
		InputStream inputStream = new ByteArrayInputStream(foto.getContenido());
		return new DefaultStreamedContent(inputStream);		
	}
	
	public String redireccionarBusquedaRuta(){
		return "busquedaRuta?faces-redirect=true";
	}
	
	public String buscar(){
		rutaService.buscar(nombre, actividad, fecha);
		return this.redireccionarBusquedaRuta();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ActividadBean getActividad() {
		return actividad;
	}

	public void setActividad(ActividadBean actividad) {
		this.actividad = actividad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Actividad> getActividades() {
		actividades = actividad.getHabilitadas();
		return actividades;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
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

	public String getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	
	public Part getFoto1() {
		return foto1;
	}

	public void setFoto1(Part foto1) {
		this.foto1 = foto1;
	}

	public Part getFoto2() {
		return foto2;
	}

	public void setFoto2(Part foto2) {
		this.foto2 = foto2;
	}

	public Part getFoto3() {
		return foto3;
	}

	public void setFoto3(Part foto3) {
		this.foto3 = foto3;
	}

	public String uploadFoto(){
		System.out.println("prueba");
		return "";
	}
	
	public StreamedContent getShowFoto1() throws IOException{
		if(showFoto1 == null){
			showFoto1 = this.genericGetFoto(foto1);
		}
		return showFoto1;
	}
	
	public void setShowFoto1(StreamedContent st){
		this.showFoto1 = st;
	}

	public StreamedContent getShowFoto2() throws IOException {
		if(showFoto2 == null){
			showFoto2 = this.genericGetFoto(foto2);
		}		
		return showFoto2;
	}

	public void setShowFoto2(StreamedContent showFoto2) {
		this.showFoto2 = showFoto2;
	}

	public StreamedContent getShowFoto3() throws IOException {
		if(showFoto3 == null){
			showFoto3 = this.genericGetFoto(foto3);
		}
		return showFoto3;
	}

	public void setShowFoto3(StreamedContent showFoto3) {
		this.showFoto3 = showFoto3;
	}
	
	private StreamedContent genericGetFoto(Part foto) throws IOException{
		if(foto != null){
			InputStream inputStream = foto.getInputStream();
			return new DefaultStreamedContent(inputStream);
		}
		return null;
	}

	public String getLatLong() {
		return latLong;
	}

	public boolean isPrivada() {
		return privada;
	}

	public void setPrivada(boolean privada) {
		this.privada = privada;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	private List<Foto> crearFotos() throws IOException{
		List<Foto> fotos = new ArrayList<Foto>();
		if(foto1 != null){
			fotos.add(fotoService.crear(foto1));
		}
		if(foto2 != null){
			fotos.add(fotoService.crear(foto2));
		}
		if(foto3 != null){
			fotos.add(fotoService.crear(foto3));
		}
		return fotos;
	}

	public boolean isModificar() {
		return modificar;
	}

	public void setModificar(boolean modificar) {
		this.modificar = modificar;
	}

	public String getPuntos() {
		String puntosString = "";
		for(Punto punto: puntos){
			puntosString+=punto.getLatitud()+"_"+punto.getLongitud()+",";
		}
		return puntosString;
	}

	public void setPuntos(List<Punto> puntos) {
		this.puntos = puntos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
}
