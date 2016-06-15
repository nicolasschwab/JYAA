package util;

import dao.ActividadDAO;
import dao.AdministradorDAO;
import dao.FotoDAO;
import dao.PerfilDAO;
import dao.PuntoDAO;
import dao.RutaDAO;
import dao.UsuarioDAO;
import dao.impl.ActividadDAOImpl;
import dao.impl.AdministradorDAOImpl;
import dao.impl.FotoDAOImpl;
import dao.impl.PerfilDAOImpl;
import dao.impl.PuntoDAOImpl;
import dao.impl.RutaDAOImpl;
import dao.impl.UsuarioDAOImpl;

public class FactoryDAO {

	public static ActividadDAO getActividadDAO(){
		return new ActividadDAOImpl();
	}
	public static AdministradorDAO getAdministradorDAO(){
		return new AdministradorDAOImpl();
	}
	public static FotoDAO getFotoDAO(){
		return new FotoDAOImpl();
	}
	public static PerfilDAO getPerfilDAO(){
		return new PerfilDAOImpl();
	}
	public static PuntoDAO getPuntoDAO(){
		return new PuntoDAOImpl();
	}
	public static RutaDAO getRutaDAO(){
		return new RutaDAOImpl();
	}
	public static UsuarioDAO getUsuarioDAO(){
		return new UsuarioDAOImpl();
	}
	
}
