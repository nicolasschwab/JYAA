package bean;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Usuario extends Perfil {

	private Integer type;
	String dni;
	String domicilio;
	Date fechaNacimiento;
	String sexo;
	String email;
	
	public Usuario(){
		
	}
	
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
