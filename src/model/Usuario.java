package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario extends Perfil {
	
	private String nombreUsuario;
	private String dni;
	private String apellido;
	private String nombre;
	private String domicilio;
	private Date fechaNacimiento;
	private String sexo;
	private String email;
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
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
