package dao;

import java.util.List;

import model.Ruta;

public interface RutaDAO extends GenericDAO<Ruta> {

	List<Ruta> getRutasConActividad(String nombre);

}
