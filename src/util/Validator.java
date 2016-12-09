package util;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import model.Punto;

public class Validator {

	enum valoresDificultad {
			Facil("Facil"), Moderado("Moderado"), Dificil("Dificil"), Muy_Dificil("Muy Dificil"), Solo_Expertos("Solo Expertos");
		
			private String name;
			valoresDificultad(String name){
				this.name = name;
			}
			public String getName(){
				return this.name;
			}
			@Override
			public String toString(){
				return this.name;
			}
		}
	
	public static boolean stringNoVacio(String string, String stringName){
		if(stringNoVacio(string)){
			return true;
		}else{
			crearMensaje("el campo"+stringName+" no puede estar vacio");
			return false;
		}
	}
	
	public static boolean stringNoVacio(String string){
		if(string != null && string != ""){
			return true;
		}
		return false;
	}
	
	public static boolean validateCreateRuta(String nombre, String comentario, String formato, String dificultad, List<Punto> puntos){
		boolean success = true;
		success &= stringNoVacio(nombre, "nombre");
		success &= stringNoVacio(comentario, "comentario");
		success &= stringNoVacio(formato, "formato");
		success &= stringNoVacio(dificultad, "dificultad");
		
		try{
			valoresDificultad.valueOf(dificultad);
		}
		catch(Exception e){
			success = false;
		}
		if(puntos.isEmpty()){
			crearMensaje("Selecciona al menos un punto!");
			success = false;
		}
		
		return success;
	}
	
	private static void crearMensaje(String mensaje){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						mensaje,
						mensaje));
	}
}
