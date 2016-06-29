package resource;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
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
	public Ruta getRuta() {
		return rutaService.getRuta(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putRuta(JAXBElement<Ruta> rutaElement) {
		Ruta ruta = rutaElement.getValue();
		Response response;
		response = Response.created(uriInfo.getAbsolutePath()).build();
		rutaService.editRuta(ruta);
		return response;
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createPunto(@FormParam("id") String id,
			@FormParam("latitud") Long latitud,
			@FormParam("longitud") Long longitud) throws IOException {
		Punto punto = new Punto(latitud, longitud);
		puntoResource.crearPunto(punto);
	}

}
