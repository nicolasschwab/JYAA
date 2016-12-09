package jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BuscarBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{actividadBean}")
	private ActividadBean actividad;
	@ManagedProperty(value="#{rutaBean}")
	private RutaBean ruta;
	
	
	public ActividadBean getActividad() {
		return actividad;
	}
	public void setActividad(ActividadBean actividad) {
		this.actividad = actividad;
	}
	public RutaBean getRuta() {
		return ruta;
	}
	public void setRuta(RutaBean ruta) {
		this.ruta = ruta;
	}
	
	
	
	

}
