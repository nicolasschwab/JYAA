package test;

import java.util.List;

import junit.framework.TestCase;
import model.Actividad;
import util.FactoryDAO;

public class TestDAOModificar extends TestCase{

	public void testModificar(){
		List<Actividad> actividades = FactoryDAO.getActividadDAO().get("Kajac");		
		Actividad actividad = actividades.get(0);
		actividad.setNombre("Alpinismo");
		FactoryDAO.getActividadDAO().edit(actividad);
		assertNotNull(FactoryDAO.getActividadDAO().get("Alpinismo"));
	}
}
