package bean;

import java.util.Date;

import javax.persistence.Entity;


public class Usuario{

	private Integer type;
	private String nombreUsuario;
	private String contrasenia;
	
	public Usuario(String username, String password, Integer type){
		setNombreUsuario(username);
		setContrasenia(password);
		setType(type);
	}
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
}
