package jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Actividad;
import util.FactoryService;

@ManagedBean
@SessionScoped
public class ActividadBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private boolean habilitada;
	
	
	public void alta(){
		FactoryService.getActividadService().createActividad(this.getNombre(),this.isHabilitada());
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
		return FactoryService.getActividadService().listAll();		
	}

	public List<Actividad> listarTodasHabilitadas() {
		return FactoryService.getActividadService().listHabilitadas();
	}

	public List<Actividad> listarTodasDeshabilitadas() {
		return FactoryService.getActividadService().listDeshabilitadas();
	}
	
	
	
}
