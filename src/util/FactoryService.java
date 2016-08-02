package util;

import service.UsuarioService;

public class FactoryService {

	private static UsuarioService usuarioService;
	
	public static UsuarioService getUsuarioService(){
		if(usuarioService==null){
			usuarioService=new UsuarioService();
		}
		return usuarioService;
	}
	
}
