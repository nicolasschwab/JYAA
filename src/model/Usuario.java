package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario extends Perfil {
	
	private String dni;
	private String domicilio;
	private Date fechaNacimiento;
	private String sexo;
	private String email;
	@OneToMany
	private List<Ruta> misRutas;
	
	public Usuario(){
		super();
	}
	
	public Usuario(String nombreUsuario, String dni, 
			String apellido, String nombre, String domicilio,
			Date fechaNacimiento, String sexo, String email){
		super();
		setNombreUsuario(nombreUsuario);
		setDni(dni);
		setApellido(apellido);
		setNombre(nombre);
		setDomicilio(domicilio);
		setFechaNacimiento(fechaNacimiento);
		setSexo(sexo);
		setEmail(email);
		setMisRutas(new ArrayList<Ruta>());
	}
	
	
	public void addRuta(Ruta ruta){
		getMisRutas().add(ruta);
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
	public List<Ruta> getMisRutas() {
		return misRutas;
	}
	public void setMisRutas(List<Ruta> misRutas) {
		this.misRutas = misRutas;
	}
}
