package dao.impl;

import model.Actividad;
import dao.ActividadDAO;

public class ActividadDAOImpl extends GenericDAOImpl<Actividad> implements
		ActividadDAO {
	public ActividadDAOImpl() {
		super(Actividad.class);
	}
}
