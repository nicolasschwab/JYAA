package util;

import service.ActividadService;
import service.AdministradorService;
import service.FotoService;
import service.RutaService;
import service.UsuarioService;

public class FactoryService {

	private static UsuarioService usuarioService;
	private static AdministradorService adminService;
	private static ActividadService actividadService;
	private static RutaService rutaService;
	private static FotoService fotoService;
	
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
	
	public static FotoService getFotoService(){
		if(fotoService==null){
			fotoService=new FotoService();
		}
		return fotoService;
	}
	
}
