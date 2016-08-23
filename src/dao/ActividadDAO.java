package dao;

import java.util.List;

import model.Actividad;

public interface ActividadDAO extends GenericDAO<Actividad>{

	List<Actividad> getAllByHabilitada(boolean estado);	

}
