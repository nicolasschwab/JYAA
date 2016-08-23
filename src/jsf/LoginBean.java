package jsf;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.Administrador;
import model.Usuario;
import util.FactoryService;
import util.Mensaje;
import util.SessionUtil;
import util.Validator;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	@ManagedProperty(value="#{adminBean}")
	private AdminBean admin;
	
	public String login(){
		if(this.validarVariables()){
			Usuario usr=FactoryService.getUsuarioService().encontrar(this.getUsername(),this.getPassword());
			if(usr!=null){
				SessionUtil.getSession().setAttribute("name", usr.getNombreUsuario());
				SessionUtil.getSession().setAttribute("id", usr.getId());
				return "listarRutasUsuario?faces-redirect=true";
			}else{//puede ser admin
				Administrador admin=FactoryService.getAdministradorService().encontrar(this.getUsername(),this.getPassword());
				if(admin!=null){
					SessionUtil.getSession().setAttribute("name", admin.getNombreUsuario());
					SessionUtil.getSession().setAttribute("id", admin.getId());
					return this.admin.listarActividades();
				}
			}
		}else{
			Mensaje.crearMensaje("Completa todos los campos");
		}
		Mensaje.crearMensaje("Los datos son incorrectos");
		return null;
	}
	
	public void logout() throws IOException{
		ExternalContext ec= SessionUtil.terminateSession();
		ec.redirect(ec.getRequestContextPath() + "/");
	}
	
	private boolean validarVariables(){
		if(Validator.stringNoVacio(this.getPassword())){
			if(Validator.stringNoVacio(this.getUsername())){
				return true;
			}
		}
		return false;
	}
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public AdminBean getAdmin() {
		return admin;
	}

	public void setAdmin(AdminBean admin) {
		this.admin = admin;
	}
	

}
