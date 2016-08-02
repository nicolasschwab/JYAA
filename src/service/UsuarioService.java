package service;

import dao.UsuarioDAO;
import model.Usuario;
import util.FactoryDAO;

public class UsuarioService {

	
	UsuarioDAO usuarioDAO;
	
	public UsuarioService(){
		usuarioDAO=FactoryDAO.getUsuarioDAO();
	}
	
	public void persistirUsuario(Usuario usuario){
		usuarioDAO.save(usuario);
	}

	public Usuario encontrar(String username, String password) {
		return this.usuarioDAO.getByUsernamePassword(username,password);
	}
	
	public Usuario encontrar(Long id){
		return this.usuarioDAO.get(id);
	}

	public void modificar(Usuario usr) {
		this.usuarioDAO.edit(usr);		
	}
}
