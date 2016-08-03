package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{


	Usuario getByUsernamePassword(String username, String password);
	public List<Usuario> getAllByActivo(Boolean activo);

}
