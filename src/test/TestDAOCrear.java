package test;

import java.util.Date;

import junit.framework.TestCase;
import model.Actividad;
import model.Administrador;
import model.Foto;
import model.Perfil;
import model.Puntaje;
import model.Punto;
import model.Ruta;
import model.Usuario;
import util.FactoryDAO;

public class TestDAOCrear extends TestCase{
		
	private Actividad actividad;
	private Actividad actividad2;
	private Administrador administrador;
	private Foto foto;
	private Puntaje puntaje;
	private Punto puntoInicial;
	private Punto puntoFinal;
	private Ruta ruta;
	private Usuario usuario;
	
	protected void setUp() throws Exception {
		super.setUp();
		actividad = new Actividad("Mountain Bike", true);
		actividad2 = new Actividad("Kajac", true);
		administrador = new Administrador();
		administrador.setNombreUsuario("admin");
		administrador.setContrasenia("1234");
		administrador.setNombreCompleto("juan perez");
		puntoInicial = new Punto();
		puntoInicial.setDescripcion("Punto de inicio de la ruta");
		puntoFinal = new Punto();
		puntoFinal.setDescripcion("Punto de finalización de la ruta");
		usuario = new Usuario("Pepe","3333","Jose Luis","Calle 1 y 50", new Date(),"Masculino","pepe@luis.com");
		ruta = new Ruta("Ruta1", "Una ruta de prueba", true, "Ida", 33.3, "Normal", "24hrs", new Date(), actividad, usuario);
		ruta.addPunto(puntoFinal);
		ruta.addPunto(puntoInicial);
		//usuario.addRuta(ruta);
	}
	
	public void testPersistir() {
		FactoryDAO.getActividadDAO().save(actividad);
		FactoryDAO.getActividadDAO().save(actividad2);
		FactoryDAO.getAdministradorDAO().save(administrador);
		FactoryDAO.getUsuarioDAO().save(usuario);
		usuario.addRuta(ruta);
		FactoryDAO.getUsuarioDAO().edit(usuario);
		ruta = usuario.getMisRutas().get(0);
		//FactoryDAO.getRutaDAO().save(ruta);
		
		assertNotNull(FactoryDAO.getActividadDAO().get(actividad.getId()));
		assertNotNull(FactoryDAO.getAdministradorDAO().get(administrador.getId()));
		//assertNotNull(FactoryDAO.getFotoDAO().get(foto.getId()));
//		for(Punto punto: ruta.getPuntos()){
//			assertNotNull(FactoryDAO.getPuntoDAO().get(punto.getId()));
//		}
//		assertNotNull(FactoryDAO.getRutaDAO().get(ruta.getId()));
		assertNotNull(FactoryDAO.getUsuarioDAO().get(usuario.getId()));
	}

}
