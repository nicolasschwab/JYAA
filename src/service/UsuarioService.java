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
}
