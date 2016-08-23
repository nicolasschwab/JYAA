package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensaje {

	
	public static void crearMensaje(String mensaje){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						mensaje,
						mensaje));
	}
}
