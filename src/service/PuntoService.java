package service;

import model.Punto;
import util.FactoryDAO;
import dao.PuntoDAO;

public class PuntoService {
	
	private PuntoDAO puntoDAO;

	public PuntoService(){
		this.puntoDAO = FactoryDAO.getPuntoDAO();
	}
	
	public Punto createPunto(Punto punto){
		return this.puntoDAO.save(punto);
	}
	
	public Punto getPunto(Long id){
		return this.puntoDAO.get(id);
	}
	
	public void deletePunto(Long id){
		this.puntoDAO.delete(id);
	}
}
