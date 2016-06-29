package resource;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import model.Actividad;
import service.ActividadService;

@Path("/actividad")
public class ActividadResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	ActividadService actividadService;
	
	public ActividadResource(){
		this.actividadService = new ActividadService();
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createAnimal(@FormParam("nombre") String nombre,
			@Context HttpServletResponse servletResponse) throws IOException {
		Actividad actividad = new Actividad(nombre);
		actividadService.createActividad(actividad);
		servletResponse.sendRedirect("./listarActividades/");
	}
}
