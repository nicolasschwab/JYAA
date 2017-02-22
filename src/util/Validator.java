package util;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import model.Punto;

public class Validator {

	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	enum valoresDificultad {
			Facil("Facil"), Moderado("Moderado"), Dificil("Dificil"), MuyDificil("Muy Dificil"), SoloExpertos("Solo Expertos");
		
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
			crearMensaje("El campo "+stringName+" no puede estar vacio");
			return false;
		}
	}
	
	public static boolean stringNoVacio(String string){
		if(string != null && string != "" && string.trim().length() > 0){
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
	
	public static boolean validarNuevoUsuario(String nombreUsuario, String dni,String domicilio,String email, String nombreCompleto,String sexo ){
		boolean paso = true;	
		paso &= stringNoVacio(nombreUsuario, "Nombre de Usuario");
		paso &= validarInt(dni, "dni");
		paso &= stringNoVacio(domicilio, "Domicilio");
		paso &= validateEmail(email, "Correo electronico");
		paso &= stringNoVacio(nombreCompleto, "Nombre completo");
		paso &= stringNoVacio(sexo, "Sexo");
		return paso;
	}
	
	private static boolean validarInt(String unInt, String nombreCampo){
		try{
			Integer.valueOf(unInt);
			return true;
		}catch(Exception e){
			crearMensaje("El campo "+nombreCampo+ " debe ser un numero");
			return false;
		}
	}
	
	public static void fechaAnterior(Date fecha, String nombreCampo) throws Exception{
		boolean anterior = fecha.before(new Date());
    	if(!anterior){
    		crearMensaje("La fecha del campo "+ nombreCampo+ " no puede superior a la actual");
    		throw new Exception();
    	}
	}
	
	private static void crearMensaje(String mensaje){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						mensaje,
						mensaje));
	}
	
	public static boolean validateActividad(String nombre){
		return stringNoVacio(nombre);
	}
	
	private static boolean validateEmail(String email, String nombreCampo) {
		 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
        	return true;
        }else{
        	crearMensaje("El campo "+nombreCampo+ " debe ser un email");
        	return false;
        }
 
    }
}
