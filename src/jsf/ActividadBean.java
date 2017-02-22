package jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Actividad;
import util.FactoryService;
import util.SessionUtil;
import util.Validator;

@ManagedBean
@SessionScoped
public class ActividadBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private boolean habilitada;
	
	private RutaBean rutaBean;
	
	public List<Actividad> getHabilitadas(){
		if(SessionUtil.hasSession()){
			return FactoryService.getActividadService().listHabilitadas();
		}
		return null;
	}
	
	public void alta(){
		if(SessionUtil.hasSession()){
			FactoryService.getActividadService().createActividad(this.getNombre(),this.isHabilitada());			
		}
	}
	
	public void nombreCualquiera() {
		if(this.nombre == "" || this.nombre == null){
			this.nombre = "%";
		}		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isHabilitada() {
		return habilitada;
	}
	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<Actividad> listarTodas() {
		if(SessionUtil.hasSession()){
			return FactoryService.getActividadService().listAll();
		}
		return null;
	}

	public List<Actividad> listarTodasHabilitadas() {
		if(SessionUtil.hasSession()){
			return FactoryService.getActividadService().listHabilitadas();
		}
		return null;
	}

	public List<Actividad> listarTodasDeshabilitadas() {
		if(SessionUtil.hasSession()){
			return FactoryService.getActividadService().listDeshabilitadas();
		}
		return null;
	}

	public boolean deshabilitar(Actividad actividad) {
		if(SessionUtil.hasSession()){
			actividad.setHabilitada(false);
			return FactoryService.getActividadService().modificar(actividad);
		}
		return false;
	}
	
	public boolean habilitar(Actividad actividad) {
		if(SessionUtil.hasSession()){
			actividad.setHabilitada(true);
			return FactoryService.getActividadService().modificar(actividad);
		}
		return false;
	}

	public boolean eliminar(Actividad actividad) {
		if(SessionUtil.hasSession()){
			if(rutaBean.hayRutasConActividad(actividad.getNombre())){
				return FactoryService.getActividadService().eliminar(actividad);
			}
			return false;
		}
		return false;
	}
	
	public boolean modificar(Actividad actividad) {
		if(SessionUtil.hasSession()){
			return FactoryService.getActividadService().modificar(actividad);
		}
		return false;
	}

	public String getBuscarNombre() {
		if(SessionUtil.hasSession()){
			return Validator.stringNoVacio(this.getNombre()) ? this.getNombre() : "%" ;
		}
		return null;
	}
	
	
	
}
