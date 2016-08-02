package jsf;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import model.Usuario;
import service.UsuarioService;
import util.FactoryService;
import util.Validator;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String contrase�a="cambiala123";

	private String username;	
	private String dni;
	private String nombreCompleto;
	private String domicilio;
	private String nacimiento;
	private String sexo;
	private String email;
	
	public String registrar(){
		if(this.validarVariables()){			
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    Date nacimientoDate = null;
		    try
		    {
		    	nacimientoDate = formatter.parse(getNacimiento());           
		    } 
		    catch (java.text.ParseException e)
		    {
		         e.printStackTrace();
		    }
			Usuario usuarioNuevo =  new Usuario(getUsername(), getDni(), getNombreCompleto(), getDomicilio(), nacimientoDate, getSexo(), getEmail());
			//se crea una contrasenia por defecto
			usuarioNuevo.setContrasenia(contrase�a);
			FactoryService.getUsuarioService().persistirUsuario(usuarioNuevo);
			FacesContext context=FacesContext.getCurrentInstance();
			context.addMessage("loginForm:message", new FacesMessage("Felicidades tu nueva contrasenia es: "+contrase�a));
			
			System.out.println("Se creó un nuevo usuario!");			
		}
		return "index.xhtml?faces-redirect=true";
	}

	private boolean validarVariables(){
		if(Validator.stringNoVacio(this.getUsername())){
			if(Validator.stringNoVacio(this.getDni())){
				if(Validator.stringNoVacio(this.getDomicilio())){
					if(Validator.stringNoVacio(this.getEmail())){
						if(Validator.stringNoVacio(this.getNacimiento())){
							if(Validator.stringNoVacio(this.getNombreCompleto())){
								if(Validator.stringNoVacio(this.getSexo())){
									return true;
								}
							}
						}						
					}
				}
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
