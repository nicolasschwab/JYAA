package service;

import java.util.List;

import model.Ruta;
import util.FactoryDAO;
import dao.RutaDAO;

public class RutaService {

	private RutaDAO rutaDAO;

	public RutaService(){
		this.rutaDAO = FactoryDAO.getRutaDAO();
	}
	
	public void createPunto(Ruta ruta){
		this.rutaDAO.save(ruta);
	}
	
	public void editRuta(Ruta ruta){
		this.rutaDAO.edit(ruta);
	}
	
	public Ruta getRuta(Long id){
		return rutaDAO.get(id);
	}
	
	public List<Ruta> getRutas(){
		return rutaDAO.getAll();
	}
}
