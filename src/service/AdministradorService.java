package service;

import dao.AdministradorDAO;
import model.Administrador;
import model.Usuario;
import util.FactoryDAO;

public class AdministradorService {

	private static AdministradorDAO adminDAO;

	public AdministradorDAO getAdminDAO() {
		if(adminDAO==null){
			adminDAO=FactoryDAO.getAdministradorDAO();
		}
		return adminDAO;
	}
	
	public Administrador encontrar(String username, String password) {
		return getAdminDAO().getByUsernamePassword(username,password);
	}
	
	public Administrador encontrar(Long id){
		return this.getAdminDAO().get(id);
	}
	
	
}
