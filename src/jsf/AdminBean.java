package jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import util.FactoryService;
import model.Usuario;

@ManagedBean
@SessionScoped
public class AdminBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Usuario> listadoDeUsuariosHabilitados;
	private List<Usuario> listadoDeUsuariosDeshabilitados;
	
	public AdminBean(){
		listadoDeUsuariosHabilitados = FactoryService.getUsuarioService().getAllByActivo(true);
		listadoDeUsuariosDeshabilitados = FactoryService.getUsuarioService().getAllByActivo(false);
	}
	
	public String deshabilitar(Long id){
		FactoryService.getUsuarioService().deshabilitarUsuario(id);
		return "listarUsuarios?faces-redirect=true";
	}
	
	public String habilitar(Long id){
		FactoryService.getUsuarioService().habilitarUsuario(id);
		return "listarUsuarios?faces-redirect=true";
	}

	public String listarUsuarios(){
		return "listarUsuarios?faces-redirect";
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


	
}
