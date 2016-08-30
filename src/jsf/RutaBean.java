package jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Ruta;
import util.FactoryService;

@ManagedBean
@SessionScoped
public class RutaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public boolean hayRutasConActividad(String nombre){
		List<Ruta> rutas=FactoryService.getRutaService().getRutasConActividad(nombre);
		if ( rutas.isEmpty() || rutas == null){
			return false;
		}
		return true;
		
	}
}
