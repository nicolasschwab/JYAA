package test;

import java.util.List;

import junit.framework.TestCase;
import model.Actividad;
import util.FactoryDAO;

public class TestDAOEliminar extends TestCase{

	public void testEliminar(){
		List<Actividad> actividades = FactoryDAO.getActividadDAO().get("Alpinismo");		
		Actividad actividad = actividades.get(0);		
		FactoryDAO.getActividadDAO().delete(actividad.getId());
		assertTrue( FactoryDAO.getActividadDAO().get("Alpinismo").isEmpty() );
	}
}
