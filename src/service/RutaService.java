package service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import model.Actividad;
import model.Foto;
import model.Punto;
import model.Ruta;
import model.Usuario;
import util.FactoryDAO;
import util.FactoryService;
import util.SessionUtil;
import util.Validator;
import dao.RutaDAO;
import jsf.ActividadBean;

public class RutaService {

	private RutaDAO rutaDAO;
	private UsuarioService usuarioService;

	public RutaService(){
		this.rutaDAO = FactoryDAO.getRutaDAO();
		usuarioService = new UsuarioService();
	}
	
	public void create(Ruta ruta){
		this.rutaDAO.save(ruta);
	}
	
	public void editRuta(Ruta ruta) throws Exception{
		checkPermission(ruta);
		this.rutaDAO.edit(ruta);
	}
	
	public void editRutaAjena(Ruta ruta) throws Exception{
		this.rutaDAO.edit(ruta);
	}
	
	public Ruta getRuta(Long id){
		return rutaDAO.get(id);
	}
	
	public List<Ruta> getRutas(){
		return rutaDAO.getAll();
	}

	public List<Ruta> getRutasConActividad(String nombre) {
		return rutaDAO.getRutasConActividad(nombre);
		
	}
	
	public List<Ruta> buscar(Ruta ruta, ActividadBean actividad, String ordenar, Usuario usr) throws ParseException{
		return rutaDAO.buscar(ruta, actividad, ordenar, usr);
	}
	
	public void eliminar(Ruta ruta) throws Exception{
		checkPermission(ruta);
		Long id = SessionUtil.getUserId();
		Usuario usuario = usuarioService.encontrar(id);
		usuario.eliminarRuta(ruta);
		usuarioService.modificar(usuario);
		rutaDAO.delete(ruta.getId());
	}
	
	private void checkPermission(Ruta ruta) throws Exception{
		Long id = SessionUtil.getUserId();
		Usuario usuario = usuarioService.encontrar(id);
		if(!usuario.esMiRuta(ruta.getId())){
			throw new Exception();
		}
	}
}
