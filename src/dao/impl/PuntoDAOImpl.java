package dao.impl;

import model.Punto;
import dao.PuntoDAO;

public class PuntoDAOImpl extends GenericDAOImpl<Punto> implements PuntoDAO {
	public PuntoDAOImpl() {
		super(Punto.class);
	}
}
