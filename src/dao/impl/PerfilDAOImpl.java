package dao.impl;

import model.Perfil;
import dao.PerfilDAO;

public class PerfilDAOImpl extends GenericDAOImpl<Perfil> implements PerfilDAO {
	public PerfilDAOImpl() {
		super(Perfil.class);
	}
}
