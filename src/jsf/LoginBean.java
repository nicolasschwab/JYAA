package jsf;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public String login(){
		if (getUsername().equals("administrador") && getPassword().equals("administrador")){
			return "listarActividades?faces-redirect=true";
		}
		if (getUsername().equals("usuario") && getPassword().equals("usuario")){
			return "listarRutasUsuario?faces-redirect=true";
		}
		return "index.xhtml?faces-redirect=true";
	}
	
	public void logout() throws IOException{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
	    ec.redirect(ec.getRequestContextPath() + "/");
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

}
