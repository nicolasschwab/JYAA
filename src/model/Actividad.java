package model;

import java.util.ArrayList;
import java.util.List;

public class Actividad {

	private String nombre;
	private List<Ruta> rutas;
	
	public Actividad(){
		super();
	}
	
	public Actividad(String nombre){
		setNombre(nombre);
		setRutas(new ArrayList<Ruta>());
	}
	
	public void addRuta(Ruta ruta){
		getRutas().add(ruta);	
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Ruta> getRutas() {
		return rutas;
	}
	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}
	
}
