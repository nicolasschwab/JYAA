package dao.impl;

import model.Usuario;
import dao.UsuarioDAO;


public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO{
	public UsuarioDAOImpl() {
		super(Usuario.class);
	}
}
