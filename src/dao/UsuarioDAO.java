package dao;

import model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{

	Usuario getByUsernamePassword(String username, String password);

}
