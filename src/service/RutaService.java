package service;

import java.util.Date;
import java.util.List;

import model.Actividad;
import model.Foto;
import model.Punto;
import model.Ruta;
import util.FactoryDAO;
import util.FactoryService;
import util.Validator;
import dao.RutaDAO;
import jsf.ActividadBean;

public class RutaService {

	private RutaDAO rutaDAO;

	public RutaService(){
		this.rutaDAO = FactoryDAO.getRutaDAO();
	}
	
	public void createPunto(Ruta ruta){
		this.rutaDAO.save(ruta);
	}
	
	public void editRuta(Ruta ruta){
		this.rutaDAO.edit(ruta);
	}
	
	public Ruta getRuta(Long id){
		return rutaDAO.get(id);
	}
	
	public List<Ruta> getRutas(){
		return rutaDAO.getAll();
	}

	public List<Ruta> getRutasConActividad(String nombre) {
		return rutaDAO.getRutasConActividad(nombre);
		
	}
	
	public List<Ruta> buscar(String nombre, ActividadBean actividad, Date fecha){
		if(!Validator.stringNoVacio(nombre)){
			nombre = "%";
		}
		actividad.nombreCualquiera();
		return rutaDAO.buscar(nombre ,actividad, fecha);
	}
}
