package resource;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import model.Punto;
import service.PuntoService;

@Path("/puntos")
public class PuntosResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	private PuntoService puntoService;

	public PuntosResource() {
		this.puntoService = new PuntoService();
	}

	@Path("{punto}")
	public PuntoResource getPunto(@PathParam("punto") Long id) {
		return new PuntoResource(uriInfo, request, id);
	}

	

}
