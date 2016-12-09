package dao;

import java.util.Date;
import java.util.List;

import jsf.ActividadBean;
import model.Actividad;
import model.Ruta;

public interface RutaDAO extends GenericDAO<Ruta> {

	List<Ruta> getRutasConActividad(String nombre);

	List<Ruta> buscar(String nombre, ActividadBean actividad, Date fecha);

}
