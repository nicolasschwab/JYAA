package resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import service.RutaService;

@Path("/rutas")
public class RutasResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	private RutaService rutaService;
	
	public RutasResource(){
		this.rutaService = new RutaService();
	}
	
	@Path("{ruta}")
	public RutaResource getRuta(@PathParam("ruta") Long id){
		return new RutaResource(uriInfo, request, id);
	}
	
	/*@POST
	@Path("{ruta}")
	public RutaResource getRuta(@PathParam("ruta") Long id){
		return new RutaResource(uriInfo, request, id);
	}*/
	
	@Path("/puntos")
	public PuntosResource getPunto(){
		return new PuntosResource();
	}
}
