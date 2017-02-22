package jsf;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import model.Ruta;
import model.Usuario;
import service.UsuarioService;
import util.FactoryService;
import util.SessionUtil;
import util.Validator;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String contrasena="cambiala123";
	private Usuario usr;

	private String username;	
	private String dni;
	private String nombreCompleto;
	private String domicilio;
	private String nacimiento;
	private String sexo;
	private String email;
	private List<Ruta> misRutas;
	
	private String contrasenaVieja;
	private String nuevaContrasena;
	private String nuevaAgain;
	
	public String registrar(){
		if(!SessionUtil.hasSession()){
			if(Validator.validarNuevoUsuario(username, dni, domicilio, email, nombreCompleto, sexo)){			
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			    Date nacimientoDate = null;
			    try
			    {
			    	nacimientoDate = formatter.parse(getNacimiento());
			    	Validator.fechaAnterior(nacimientoDate, "fecha nacimiento");
			    	
			    } 
			    catch (Exception e)
			    {
			         return "";
			    }
				Usuario usuarioNuevo =  new Usuario(getUsername(), getDni(), getNombreCompleto(), getDomicilio(), nacimientoDate, getSexo(), getEmail());
				//se crea una contrasenia por defecto
				usuarioNuevo.setContrasenia(contrasena);
				FactoryService.getUsuarioService().persistirUsuario(usuarioNuevo);
				this.crearMensaje("El usuario se creo correctamente!");
				this.crearMensaje("La contrasena es '"+contrasena+"'");
				System.out.println("Se creó un nuevo usuario!");			
			}else{
				this.crearMensaje("debes completar todos los campos");
			}
		}
		return null;
	}
	
	public String redireccionModificar(){
		if(SessionUtil.hasSession()){
			this.setUsr(FactoryService.getUsuarioService().encontrar(SessionUtil.getUserId()));
			return "editarUsuario.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public String modificar(){
		if(SessionUtil.hasSession()){
			if(Validator.validarNuevoUsuario(this.getUsr().getNombreUsuario(), this.getUsr().getDni(), this.getUsr().getDomicilio(), this.getUsr().getEmail(), this.getUsr().getNombreCompleto(), this.getUsr().getSexo())){
				FactoryService.getUsuarioService().modificar(usr);
				this.crearMensaje("Se modificaron los datos!");
			}else{
				this.crearMensaje("Completa todos los campos");
			}
		}
		return null;
	}
	
	public String redireccionarListadoRutas(){
		if(SessionUtil.hasSession()){
			Usuario user = FactoryService.getUsuarioService().encontrar(SessionUtil.getUserId());
			misRutas = user.getMisRutas();
			return "listarRutasUsuario.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public String redireccionarDetalleRuta(){
		if(SessionUtil.hasSession()){
			return "detalleRuta.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public String modificarContrasena(){
		if(SessionUtil.hasSession()){
			if(this.validarVariablesContrasena()){
				if(this.getContrasenaVieja().equals(this.getUsr().getContrasenia())){
					if(this.getNuevaContrasena().equals(this.getNuevaAgain())){
						if(!this.getContrasenaVieja().equals(this.getNuevaAgain())){
							this.getUsr().setContrasenia(this.getNuevaAgain());
							FactoryService.getUsuarioService().modificar(usr);
							this.crearMensaje("Se cambio la contrasenia con exito!");
						}else{
							this.crearMensaje("Las contrasenias nuevas y viejas no pueden coincidir");
						}
					}else{
						this.crearMensaje("Las nuevas contrasenas no coinciden");
					}
				}else{
					this.crearMensaje("La contrasena actual no es la correcta");
				}
			}else{
				
			}
		}
		return null;
	}
	
	private void crearMensaje(String mensaje){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						mensaje,
						mensaje));
	}

	private boolean validarVariablesContrasena(){
		if(Validator.stringNoVacio(this.getContrasenaVieja())){
			if(Validator.stringNoVacio(this.getNuevaContrasena())){
				if(Validator.stringNoVacio(this.getNuevaAgain())){
					return true;
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

	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	public String getContrasenaVieja() {
		return contrasenaVieja;
	}

	public void setContrasenaVieja(String contrasenaVieja) {
		this.contrasenaVieja = contrasenaVieja;
	}

	public String getNuevaContrasena() {
		return nuevaContrasena;
	}

	public void setNuevaContrasena(String nuevaContrasena) {
		this.nuevaContrasena = nuevaContrasena;
	}

	public String getNuevaAgain() {
		return nuevaAgain;
	}

	public void setNuevaAgain(String nuevaAgain) {
		this.nuevaAgain = nuevaAgain;
	}

	public List<Ruta> getMisRutas() {
		return misRutas;
	}

	public void setMisRutas(List<Ruta> misRutas) {
		this.misRutas = misRutas;
	}
	
	
	
	
	
}
