package dao;

import model.Administrador;
import model.Usuario;

public interface AdministradorDAO extends GenericDAO<Administrador>{

	Administrador getByUsernamePassword(String username, String password);

}
