package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(urlPatterns = { "/listarRutasUsuario", "/altaRuta", "/buscarRuta", "/detalleRuta", "/editarUsuario" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		
		String[] uri = request.getRequestURI().split("/");
		switch (uri[uri.length-1]) {
		case "listarRutasUsuario":
			dispatcher = getServletContext().getRequestDispatcher("/views/listarRutasUsuario.xhtml");
			break;
		case "altaRuta":
			dispatcher = getServletContext().getRequestDispatcher("/views/altaRuta.html");
			break;
		case "buscarRuta":
			dispatcher = getServletContext().getRequestDispatcher("/views/busquedaRuta.html");
			break;
		case "detalleRuta":
			dispatcher = getServletContext().getRequestDispatcher("/views/detalleRuta.html");
			break;
		case "editarUsuario":
			dispatcher = getServletContext().getRequestDispatcher("/views/editarUsuario.xhtml");
			break;
		default:
			dispatcher = getServletContext().getRequestDispatcher("/views/listarRutasUsuario.jsp");
			break;
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
