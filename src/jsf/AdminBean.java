package jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import util.FactoryService;
import util.Mensaje;
import util.SessionUtil;
import util.Validator;
import model.Actividad;
import model.Usuario;

@ManagedBean
@SessionScoped
public class AdminBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{actividadBean}")
	private ActividadBean actividad;
	private List<Usuario> listadoDeUsuariosHabilitados;
	private List<Usuario> listadoDeUsuariosDeshabilitados;
	private List<Actividad> listadoDeActividadesHabilitadas;
	private List<Actividad> listadoDeActividadesDeshabilitadas;
	
	public AdminBean(){
		this.asignarListadosUsuario();
	}
	
	public String deshabilitar(Long id){
		FactoryService.getUsuarioService().deshabilitarUsuario(id);
		this.asignarListadosUsuario();
		return null;
	}
	
	public String habilitar(Long id){
		FactoryService.getUsuarioService().habilitarUsuario(id);
		this.asignarListadosUsuario();
		return null;
	}
	
	public String altaActividad(){
		if(SessionUtil.hasSession()){		
			if(Validator.stringNoVacio(getActividad().getNombre())){
				this.getActividad().alta();
			}else{
				Mensaje.crearMensaje("Debes darle un nombre a la actividad");
			}
		}
		return this.listarActividades();
	}
	
	public String deshabilitarActividad(){
		if(SessionUtil.hasSession()){
			
		}
		return null;
	}

	public String listarUsuarios(){
		if(SessionUtil.hasSession()){		
			return "listarUsuarios?faces-redirect";
		}
		return null;
	}

	public String listarActividades(){
		if(SessionUtil.hasSession()){			
			this.asignarListadoActividadesHabilitadas();
			this.asignarListadoActividadesDeshabilitadas();
			return "listarActividades?faces-redirect=true";
		}
		return null;
	}
	
	private void asignarListadosUsuario(){
		listadoDeUsuariosHabilitados = FactoryService.getUsuarioService().getAllByActivo(true);
		listadoDeUsuariosDeshabilitados = FactoryService.getUsuarioService().getAllByActivo(false);
	}
	
	private void asignarListadoActividadesHabilitadas(){
		listadoDeActividadesHabilitadas=actividad.listarTodasHabilitadas();
	}
	
	private void asignarListadoActividadesDeshabilitadas(){
		listadoDeActividadesDeshabilitadas=actividad.listarTodasDeshabilitadas();
	}

	public List<Usuario> getListadoDeUsuariosHabilitados() {
		return listadoDeUsuariosHabilitados;
	}

	public void setListadoDeUsuariosHabilitados(
			List<Usuario> listadoDeUsuariosHabilitados) {
		this.listadoDeUsuariosHabilitados = listadoDeUsuariosHabilitados;
	}

	public List<Usuario> getListadoDeUsuariosDeshabilitados() {
		return listadoDeUsuariosDeshabilitados;
	}

	public void setListadoDeUsuariosDeshabilitados(
			List<Usuario> listadoDeUsuariosDeshabilitados) {
		this.listadoDeUsuariosDeshabilitados = listadoDeUsuariosDeshabilitados;
	}
	
	public ActividadBean getActividad() {
		return actividad;
	}

	public void setActividad(ActividadBean actividad) {
		this.actividad = actividad;
	}

	public List<Actividad> getListadoDeActividadesHabilitadas() {
		return listadoDeActividadesHabilitadas;
	}

	public void setListadoDeActividadesHabilitadas(List<Actividad> listadoDeActividadesHabilitadas) {
		this.listadoDeActividadesHabilitadas = listadoDeActividadesHabilitadas;
	}

	public List<Actividad> getListadoDeActividadesDeshabilitadas() {
		return listadoDeActividadesDeshabilitadas;
	}

	public void setListadoDeActividadesDeshabilitadas(List<Actividad> listadoDeActividadesDeshabilitadas) {
		this.listadoDeActividadesDeshabilitadas = listadoDeActividadesDeshabilitadas;
	}
	
	
	
	
	
	
}
