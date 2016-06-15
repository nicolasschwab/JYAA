package dao.impl;

import model.Administrador;
import dao.AdminDAO;

public class AdminDAOImpl extends GenericDAOImpl<Administrador> implements AdminDAO {
	public AdminDAOImpl() {
		super(Administrador.class);
	}
}
