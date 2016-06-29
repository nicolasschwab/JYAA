package resource;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import model.Punto;
import service.PuntoService;

public class PuntoResource {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	private Long id;
	
	private PuntoService puntoService;
	
	public PuntoResource(){
		this.puntoService = new PuntoService();
	}
	
	public PuntoResource(UriInfo uriInfo, Request request, Long id){
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		this.puntoService = new PuntoService();
	}
	
	public void deletePunto(){
		this.puntoService.deletePunto(id);
	}
	
	public void crearPunto(Punto punto){
		this.puntoService.createPunto(punto);
	}

	public void borrar(long idPunto) {
		this.puntoService.deletePunto((long) idPunto);		
	}
	public Punto get(int idPunto){
		return this.puntoService.getPunto((long) idPunto);
	}
	
}
