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
import model.Administrador;
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
		if(SessionUtil.hasSession()){
			if(isAdmin()){
				FactoryService.getUsuarioService().deshabilitarUsuario(id);
				this.asignarListadosUsuario();
			}
		}
		return null;
	}
	
	public String habilitar(Long id){
		if(SessionUtil.hasSession()){
			if(isAdmin()){
				FactoryService.getUsuarioService().habilitarUsuario(id);
				this.asignarListadosUsuario();
			}
		}
		return null;
	}
	
	public String altaActividad(){
		if(SessionUtil.hasSession()){
			if(isAdmin()){
				if(Validator.validateActividad(this.getActividad().getNombre())){
					this.getActividad().alta();
				}else{
					Mensaje.crearMensaje("Debes darle un nombre a la actividad");
				}
			}
		}
		return this.listarActividades();
	}
	
	public String deshabilitarActividad(Actividad actividad){
		if(SessionUtil.hasSession()){
			if(isAdmin()){
				if(this.actividad.deshabilitar(actividad)){
					Mensaje.crearMensaje("Se deshabilitó la actividad");
				}else{
					Mensaje.crearMensaje("La actividad no existe");
				}
				this.listarActividades();
			}
		}
		return null;
	}
	
	public String eliminarActividad(Actividad actividad){
		if(SessionUtil.hasSession()){
			if(isAdmin()){
				if(this.actividad.eliminar(actividad)){
					Mensaje.crearMensaje("Se eliminó la actividad");
				}else{
					Mensaje.crearMensaje("Hay rutas con esta actividad asignada");
				}
				this.listarActividades();
			}
		}
		return null;
	}
	
	public String modificarActividad(Actividad actividad){
		if(SessionUtil.hasSession()){
			if(isAdmin()){
				if(Validator.validateActividad(actividad.getNombre())){
					if(this.actividad.modificar(actividad)){
						Mensaje.crearMensaje("Se modificó la actividad");
					}else{
						Mensaje.crearMensaje("La actividad no existe");
					}
				}else{
					Mensaje.crearMensaje("La actividad debe tener un nombre");
				}
				this.listarActividades();
			}
		}
		return null;
	}
	
	public String habilitarActividad(Actividad actividad){
		if(SessionUtil.hasSession()){
			if(isAdmin()){
				if(this.actividad.habilitar(actividad)){
					Mensaje.crearMensaje("Se habilitó la activdad");
				}
				else{
					Mensaje.crearMensaje("La actividad no existe!");
				}
				this.listarActividades();
			}
		}
		return null;
	}

	public String listarUsuarios(){
		if(SessionUtil.hasSession()){
			if(isAdmin()){
				return "listarUsuarios?faces-redirect";
			}
		}
		return null;
	}

	public String listarActividades(){
		if(SessionUtil.hasSession()){
			if(isAdmin()){
				this.asignarListadoActividadesHabilitadas();
				this.asignarListadoActividadesDeshabilitadas();
				return "listarActividades?faces-redirect=true";
			}
		}
		return null;
	}
	
	private boolean isAdmin(){
		Administrador admin = FactoryService.getAdministradorService().encontrar(SessionUtil.getUserId());
		if(admin != null){
			if(admin.getId() == SessionUtil.getUserId()){
				return true;
			}
		}
		return false;
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
