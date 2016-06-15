package dao.impl;

import dao.PuntajeDAO;
import model.Puntaje;

public class PuntajeDAOImpl extends GenericDAOImpl<Puntaje> implements PuntajeDAO{
	
	public PuntajeDAOImpl(){
		super(Puntaje.class);
	}

}
