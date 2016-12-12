package jsf;

import java.io.IOException;
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
	@ManagedProperty(value="#{actividadBean}")
	private ActividadBean actividad;
	@ManagedProperty(value="#{usuarioBean}")
	private UsuarioBean usuarioBean;

	private List<Actividad> actividades;
	private String latLong;
	private boolean modificar;
	
	public String crear() throws IOException{
		if(SessionUtil.hasSession()){
			if(Validator.validateCreateRuta(ruta.getNombre(), ruta.getDescripcion(), ruta.getFormato(), ruta.getDificultad(), (List<Punto>) ruta.getPuntos() )){
				Actividad act = actividadService.getActividad(actividad.getNombre());
				ruta.setActividad(act);
				rutaService.createPunto(ruta);
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
				rutaService.editRuta(ruta);
				this.crearMensaje("La ruta se modifico con exito!");
				return usuarioBean.redireccionarListadoRutas();			
			}
		}
		return "";
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
	
	public String redireccionarRutaNueva(){
		if(SessionUtil.hasSession()){
			this.ruta = new Ruta();
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
			return "busquedaRuta?faces-redirect=true";
		}
		return "";
	}
	
	public String buscar(){
		//rutaService.buscar(nombre, actividad, fecha);
		return this.redireccionarBusquedaRuta();
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
	
	
	
	
	
	
	
}
