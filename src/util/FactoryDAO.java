package util;

import dao.ActividadDAO;
import dao.AdministradorDAO;
import dao.FotoDAO;
import dao.PuntajeDAO;
import dao.PuntoDAO;
import dao.RutaDAO;
import dao.UsuarioDAO;
import dao.impl.ActividadDAOImpl;
import dao.impl.AdministradorDAOImpl;
import dao.impl.FotoDAOImpl;
import dao.impl.PuntajeDAOImpl;
import dao.impl.PuntoDAOImpl;
import dao.impl.RutaDAOImpl;
import dao.impl.UsuarioDAOImpl;

public class FactoryDAO {
	
	static ActividadDAO actividad=new ActividadDAOImpl();
	static AdministradorDAO administrador=new AdministradorDAOImpl();
	static FotoDAO foto=new FotoDAOImpl();
	static PuntoDAO punto=new PuntoDAOImpl();
	static RutaDAO ruta=new RutaDAOImpl();
	static UsuarioDAO usuario=new UsuarioDAOImpl();

	public static ActividadDAO getActividadDAO(){
		return actividad;
	}
	public static AdministradorDAO getAdministradorDAO(){
		return administrador;
	}
	public static FotoDAO getFotoDAO(){
		return foto;
	}
	public static PuntoDAO getPuntoDAO(){
		return punto;
	}
	public static RutaDAO getRutaDAO(){
		return ruta;
	}
	public static UsuarioDAO getUsuarioDAO(){
		return usuario;
	}
	public static PuntajeDAO getPuntajeDAO(){
		return new PuntajeDAOImpl();
	}
	
}
