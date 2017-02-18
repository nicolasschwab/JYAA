package dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import jsf.ActividadBean;
import model.Actividad;
import model.Ruta;
import model.Usuario;

public interface RutaDAO extends GenericDAO<Ruta> {

	List<Ruta> getRutasConActividad(String nombre);

	List<Ruta> buscar(Ruta ruta, ActividadBean actividad, String ordenar, Usuario usr) throws ParseException;

}
