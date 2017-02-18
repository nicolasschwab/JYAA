package jsf;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

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
public class RutaBean {

	private RutaService rutaService = FactoryService.getRutaService();
	private UsuarioService usuarioService = FactoryService.getUsuarioService();
	private FotoService fotoService = FactoryService.getFotoService();
	private ActividadService actividadService = FactoryService.getActividadService();
	private Ruta ruta;
	private List<Ruta> rutasBusqueda;
	@ManagedProperty(value="#{actividadBean}")
	private ActividadBean actividad;
	@ManagedProperty(value="#{usuarioBean}")
	private UsuarioBean usuarioBean;

	private List<Actividad> actividades;
	private String latLong;
	private boolean modificar;
	private String ordenar;
	private int calificacion;
	
	public String calificar() throws Exception{
		if(SessionUtil.hasSession()){
			ruta.valorar(calificacion, usuarioService.encontrar(SessionUtil.getUserId()));
			rutaService.editRutaAjena(ruta);
		}
		return "";
	}
	
	public boolean yaCalifico(){
		if(SessionUtil.hasSession()){
			return ruta.yaCalifico(usuarioService.encontrar(SessionUtil.getUserId()));
		}
		return false;
	}
	
	public String crear() throws IOException{
		if(SessionUtil.hasSession()){
			if(Validator.validateCreateRuta(ruta.getNombre(), ruta.getDescripcion(), ruta.getFormato(), ruta.getDificultad(), (List<Punto>) ruta.getPuntos() )){
				Actividad act = actividadService.getActividad(actividad.getNombre());
				ruta.setActividad(act);
				Usuario usr= usuarioService.encontrar(SessionUtil.getUserId());
				ruta.setOwner(usr);
				//rutaService.create(ruta);
				usuarioService.nuevaRuta(ruta);
				return usuarioBean.redireccionarListadoRutas();
			}
		}
		return "";
	}
	
	public String doModificar() throws IOException{
		if(SessionUtil.hasSession()){			
			if(Validator.validateCreateRuta(ruta.getNombre(), ruta.getDescripcion(), ruta.getFormato(), ruta.getDificultad(), (List<Punto>) ruta.getPuntos() )){
				Actividad act = actividadService.getActividad(actividad.getNombre());
				ruta.setActividad(act);
				try{
					//usuarioService.modificar(usuarioService.encontrar(SessionUtil.getUserId()));
					rutaService.editRuta(ruta);
				}
				catch(Exception e){
					this.crearMensaje("No podes modificar esta ruta");
					return "";
				}
				this.crearMensaje("La ruta se modifico con exito!");
				return usuarioBean.redireccionarListadoRutas();			
			}
		}
		return "";
	}
	
	public String eliminar(Ruta ruta){
		if(SessionUtil.hasSession()){
			try{
				rutaService.eliminar(ruta);
			}
			catch(Exception e){
				this.crearMensaje("No podes eliminar esta ruta");
				return "";
			}
		}
		return usuarioBean.redireccionarListadoRutas();
	}
		
	public boolean hayRutasConActividad(String nombre){
		if(SessionUtil.hasSession()){
			List<Ruta> rutas=rutaService.getRutasConActividad(nombre);
			if ( rutas.isEmpty() || rutas == null){
				return false;
			}
		}
		return true;
	}
	
	public void setLatLong(String latLong) {
		this.latLong = latLong;
		this.addPunto();
	}
	
	public String showModificar(Ruta ruta){
		if(SessionUtil.hasSession()){
			this.ruta = ruta;
			this.setModificar(true);
			return "altaRuta?faces-redirect=true";
		}
		return "";
	}
	
	public String showDetalle(Ruta ruta){
		if(SessionUtil.hasSession()){
			this.ruta = ruta;
			return "detalleRuta?faces-redirect=true";
		}
		return "";
	}
	
	public String redireccionarRutaNueva(){
		if(SessionUtil.hasSession()){
			this.ruta = new Ruta(usuarioService.encontrar(SessionUtil.getUserId()));
			this.setModificar(false);
			return "altaRuta?faces-redirect=true";
		}
		return "";
	}
	
	private void addPunto(){
		String[] arrayLatLong = this.latLong.split("\\_");
		if(arrayLatLong.length == 2){
			Double lon = Double.parseDouble(arrayLatLong[1]);
			Double lat = Double.parseDouble(arrayLatLong[0]);
			Punto punto = new Punto(lat, lon);
			this.ruta.getPuntos().add(punto);
		}		
	}
	
	private void crearMensaje(String mensaje){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						mensaje,
						mensaje));
	}
	
	public String redireccionarBusquedaRuta(){
		if(SessionUtil.hasSession()){
			this.ruta = new Ruta();
			return "busquedaRuta?faces-redirect=true";
		}
		return "";
	}
	
	public String buscar() throws ParseException{
		if(SessionUtil.hasSession()){
			this.setRutasBusqueda( rutaService.buscar(ruta, actividad, ordenar, usuarioService.encontrar(SessionUtil.getUserId())) );
		}
		return "";
	}

	public ActividadBean getActividad() {
		return actividad;
	}

	public void setActividad(ActividadBean actividad) {
		this.actividad = actividad;
	}

	public List<Actividad> getActividades() {
		actividades = actividad.getHabilitadas();
		return actividades;
	}
	
	public Part getFoto1(){
		return null;
	}
	
	public Part getFoto2(){
		return null;
	}
	
	public Part getFoto3(){
		return null;
	}

	public void setFoto1(Part foto1) throws IOException {
		if(foto1 != null){
			Foto foto = fotoService.crear(foto1);
			this.ruta.setFoto1(foto);
		}		
	}

	public void setFoto2(Part foto2) throws IOException {
		if(foto2 != null){
			Foto foto = fotoService.crear(foto2);
			this.ruta.setFoto2(foto);
		}
	}

	public void setFoto3(Part foto3) throws IOException {
		if(foto3 != null){
			Foto foto = fotoService.crear(foto3);
			this.ruta.setFoto3(foto);
		}
	}

	public String getLatLong() {
		return latLong;
	}

	public boolean isModificar() {
		return modificar;
	}

	public void setModificar(boolean modificar) {
		this.modificar = modificar;
	}

	public String getPuntos() {
		String puntosString = "";
		for(Punto punto: ruta.getPuntos()){
			puntosString+=punto.getLatitud()+"_"+punto.getLongitud()+",";
		}
		return puntosString;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public String getOrdenar() {
		return ordenar;
	}

	public void setOrdenar(String ordenar) {
		this.ordenar = ordenar;
	}

	public List<Ruta> getRutasBusqueda() {
		return rutasBusqueda;
	}

	public void setRutasBusqueda(List<Ruta> rutasBusqueda) {
		this.rutasBusqueda = rutasBusqueda;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	
	
	
	
	
	
	
}
