package util;

import service.ActividadService;
import service.AdministradorService;
import service.UsuarioService;

public class FactoryService {

	private static UsuarioService usuarioService;
	private static AdministradorService adminService;
	private static ActividadService actividadService;
	
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
	
}
