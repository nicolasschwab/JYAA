package service;

import java.util.List;

import model.Ruta;
import model.Usuario;
import util.FactoryDAO;
import util.SessionUtil;
import dao.UsuarioDAO;

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
	
	public void deshabilitarUsuario(Long id){
		usuarioDAO.edit(usuarioDAO.get(id).deshabilitar());
	}
	
	public void habilitarUsuario(Long id){
		usuarioDAO.edit(usuarioDAO.get(id).habilitar());
	}
	
	public List<Usuario> getAll(){
		return usuarioDAO.getAll();
	}
	
	public List<Usuario> getAllByActivo(Boolean activo){
		return usuarioDAO.getAllByActivo(activo);
	}

	public void nuevaRuta(Ruta ruta) {
		Long id = SessionUtil.getUserId();
		Usuario user = usuarioDAO.get(id);
		user.addRuta(ruta);
		usuarioDAO.edit(user);		
	}
}
