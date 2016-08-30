package util;

import service.ActividadService;
import service.AdministradorService;
import service.RutaService;
import service.UsuarioService;

public class FactoryService {

	private static UsuarioService usuarioService;
	private static AdministradorService adminService;
	private static ActividadService actividadService;
	private static RutaService rutaService;
	
	public static UsuarioService getUsuarioService(){
		if(usuarioService==null){
			usuarioService=new UsuarioService();
		}
		return usuarioService;
	}
	
	public static AdministradorService getAdministradorService(){
		if(adminService==null){
			adminService=new AdministradorService();
		}
		return adminService;
	}
	
	public static ActividadService getActividadService(){
		if(actividadService==null){
			actividadService=new ActividadService();
		}
		return actividadService;
	}

	public static RutaService getRutaService() {
		if(rutaService==null){
			rutaService=new RutaService();
		}
		return rutaService;
	}
	
}
