package dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import jsf.ActividadBean;
import model.Actividad;
import model.Ruta;

public interface RutaDAO extends GenericDAO<Ruta> {

	List<Ruta> getRutasConActividad(String nombre);

	List<Ruta> buscar(Ruta ruta, ActividadBean actividad, String ordenar) throws ParseException;

}
