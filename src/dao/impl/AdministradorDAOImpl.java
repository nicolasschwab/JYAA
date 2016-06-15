package dao.impl;

import model.Administrador;
import dao.AdministradorDAO;

public class AdministradorDAOImpl extends GenericDAOImpl<Administrador> implements AdministradorDAO {
	public AdministradorDAOImpl() {
		super(Administrador.class);
	}
}
