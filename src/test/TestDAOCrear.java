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
	private Punto punto;
	private Ruta ruta;
	private Usuario usuario;
	
	protected void setUp() throws Exception {
		super.setUp();
		actividad = new Actividad("Mountain Bike");
		actividad2 = new Actividad("Kajac");
		administrador = new Administrador();
		administrador.setNombreUsuario("admin");
		administrador.setContrasenia("1234");
		administrador.setNombre("juan");
		administrador.setApellido("perez");
		foto = new Foto();
		foto.setNombre("Una foto para una ruta");
		puntaje = new Puntaje();
		punto = new Punto();
		punto.setDescripcion("Un punto en la ruta");	
		ruta = new Ruta();
		ruta.setActividad(actividad);
		ruta.setDescripcion("Una ruta de prueba");
		ruta.setDificultad("Normal");
		ruta.setDistancia(33.3);
		ruta.setFechaRealizacion(new Date());
		ruta.setFormato("Ida");
		ruta.setNombre("Ruta1");
		ruta.setPrivacidad("privada");
		ruta.setTiempoEstimado("24hrs");
		ruta.addFoto(foto);
		usuario = new Usuario("Pepe","3333","Luis","Pepe","Calle 1 y 50", new Date(),"Masculino","pepe@luis.com");
		puntaje.setCalificacion(4);
		puntaje.setCalificador(usuario);
		puntaje.setRuta(ruta);
	}
	
	public void testPersistir() {		
		FactoryDAO.getActividadDAO().save(actividad);
		FactoryDAO.getActividadDAO().save(actividad2);
		FactoryDAO.getAdministradorDAO().save(administrador);
		FactoryDAO.getUsuarioDAO().save(usuario);
		FactoryDAO.getFotoDAO().save(foto);
		FactoryDAO.getPuntoDAO().save(punto);
		FactoryDAO.getRutaDAO().save(ruta);
		FactoryDAO.getPuntajeDAO().save(puntaje);
		
		assertNotNull(FactoryDAO.getActividadDAO().get(actividad.getId()));
		assertNotNull(FactoryDAO.getAdministradorDAO().get(administrador.getId()));
		assertNotNull(FactoryDAO.getFotoDAO().get(foto.getId()));
		assertNotNull(FactoryDAO.getPuntoDAO().get(punto.getId()));
		assertNotNull(FactoryDAO.getRutaDAO().get(ruta.getId()));
		assertNotNull(FactoryDAO.getUsuarioDAO().get(usuario.getId()));
		assertNotNull(FactoryDAO.getPuntajeDAO().get(puntaje.getId()));
	}

}
