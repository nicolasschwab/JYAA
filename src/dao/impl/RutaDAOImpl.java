package dao.impl;

import model.Ruta;
import dao.RutaDAO;

public class RutaDAOImpl extends GenericDAOImpl<Ruta> implements RutaDAO {
	public RutaDAOImpl() {
		super(Ruta.class);
	}
}
