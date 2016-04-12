package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(urlPatterns = { "/listarUsuarios", "/listarActividades" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher;
			
		String[] uri = request.getRequestURI().split("/");
		switch (uri[uri.length-1]) {
		case "listarUsuarios":
			dispatcher = getServletContext().getRequestDispatcher("/views/listarUsuarios.jsp");
			break;
		case "listarActividades":
			dispatcher = getServletContext().getRequestDispatcher("/views/listarActividades.jsp");
			break;
		default:
			dispatcher = getServletContext().getRequestDispatcher("/views/indexAdministrador.jsp");
			break;
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
