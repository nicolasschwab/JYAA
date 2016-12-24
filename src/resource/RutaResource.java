package resource;

import java.io.IOException;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import model.Punto;
import model.Ruta;
import service.RutaService;

public class RutaResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	private Long id;

	private RutaService rutaService;
	
	private PuntoResource puntoResource;

	public RutaResource(UriInfo uriInfo, Request request, Long id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		this.rutaService = new RutaService();
		this.puntoResource = new PuntoResource();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Collection<Punto> getRuta() {
		return rutaService.getRuta(id).getPuntos();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putRuta(JAXBElement<Ruta> rutaElement) throws Exception {
		Ruta ruta = rutaElement.getValue();
		Response response;
		response = Response.created(uriInfo.getAbsolutePath()).build();
		rutaService.editRuta(ruta);
		return response;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public void createPunto(@FormParam("lat") double latitud, @FormParam("lon") double longitud  ) throws Exception {
		Punto punto= new Punto(latitud,longitud);
		Ruta ruta=rutaService.getRuta(id);
		ruta.agregarPunto(punto);
		this.rutaService.editRuta(ruta);
	}

	@DELETE
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public void borrarPunto(@FormParam("id") int idPunto) throws Exception{
		Ruta ruta=rutaService.getRuta(id);
		if(idPunto==0){
			//Significa que apretaron el boton de borrar todos los puntos
			Collection<Punto> puntos=ruta.borrarTodosPuntos();
			this.rutaService.editRuta(ruta);
			for(Punto punto:puntos){
				this.puntoResource.borrar(punto.getId());
			}			
		}else{			
			ruta.borrarPunto(this.puntoResource.get(idPunto));
			this.rutaService.editRuta(ruta);
			this.puntoResource.borrar(idPunto);
		}
		
	}
	
}
