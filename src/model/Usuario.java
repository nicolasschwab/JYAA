package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@XmlRootElement
@Entity
public class Usuario extends Perfil {
	
	private String dni;
	private String domicilio;
	private Date fechaNacimiento;
	private String sexo;
	private String email;
	private Boolean activo;
	@OneToMany
	@Cascade({CascadeType.DELETE, CascadeType.REMOVE, CascadeType.SAVE_UPDATE, CascadeType.MERGE})
	private List<Ruta> misRutas;
	
	public Usuario(){
		super();
	}
	
	public boolean esMiRuta(Long id){
		for(Ruta ruta : misRutas){
			if(ruta.getId()==id){
				return true;
			}
		}
		return false;
	}
	
	public Usuario(String nombreUsuario, String dni, 
			String nombreCompleto, String domicilio,
			Date fechaNacimiento, String sexo, String email){
		super();
		setNombreUsuario(nombreUsuario);
		setDni(dni);
		setNombreCompleto(nombreCompleto);
		setDomicilio(domicilio);
		setFechaNacimiento(fechaNacimiento);
		setSexo(sexo);
		setEmail(email);
		setMisRutas(new ArrayList<Ruta>());
		setActivo(true);
	}
	
	public Usuario deshabilitar(){
		setActivo(false);
		return this;
	}
	
	public Usuario habilitar(){
		setActivo(true);
		return this;
	}
	
	public void addRuta(Ruta ruta){
		getMisRutas().add(ruta);
	}
	
	public void eliminarRuta(Ruta ruta){
		Ruta rutaToRemove = null;
		for(Ruta miRuta: misRutas){
			if(miRuta.getId() == ruta.getId()){
				rutaToRemove = miRuta;
			}
		}
		if(rutaToRemove != null){
			misRutas.remove(rutaToRemove);
		}
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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
