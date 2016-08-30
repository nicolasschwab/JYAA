package service;

import model.Actividad;
import util.FactoryDAO;

import java.util.List;

import dao.ActividadDAO;

public class ActividadService {

	private ActividadDAO actividadDAO;

	public ActividadService(){
		actividadDAO = FactoryDAO.getActividadDAO();
	}
	
	public void createActividad(String nombre, boolean habilitada){
		Actividad actividad = new Actividad(nombre,habilitada);
		actividadDAO.save(actividad);
	}
	
	public Actividad getActividad(Long id){
		return actividadDAO.get(id);
	}

	public List<Actividad> listAll() {
		return actividadDAO.getAll();		
	}

	public List<Actividad> listHabilitadas() {
		return actividadDAO.getAllByHabilitada(true);
	}

	public List<Actividad> listDeshabilitadas() {
		return actividadDAO.getAllByHabilitada(false);
	}

	public boolean eliminar(Actividad actividad) {
		if(actividad!=null){
			actividadDAO.delete(actividad.getId());
			return true;
		}
		return false;
	}
	
	public boolean modificar(Actividad actividad) {
		if(actividad!=null){
			actividadDAO.edit(actividad);
			return true;
		}
		return false;
	}
	
}
