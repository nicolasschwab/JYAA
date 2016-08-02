package service;

import dao.AdministradorDAO;
import model.Administrador;
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
	
	
}
