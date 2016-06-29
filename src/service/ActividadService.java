package service;

import model.Actividad;
import util.FactoryDAO;
import dao.ActividadDAO;

public class ActividadService {

	private ActividadDAO actividadDAO;
	
	public ActividadService(){
		actividadDAO = FactoryDAO.getActividadDAO();
	}
	
	public void createActividad(Actividad actividad){
		actividadDAO.save(actividad);
	}
	
	public Actividad getActividad(Long id){
		return actividadDAO.get(id);
	}
	
}
