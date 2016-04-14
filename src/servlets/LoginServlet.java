package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login", "/logout" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/index.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		@SuppressWarnings("unchecked")
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>)this.getServletContext().getAttribute("usuarios");
		
		for (Usuario usuario : usuarios) {
			if ( usuario.getUsername().equals(username) && usuario.getPassword().equals(password) ){
				RequestDispatcher dispatcher;
				switch (usuario.getType()) {
				case 1:
					response.sendRedirect("listarActividades");
					break;
				case 2:
					response.sendRedirect("listarRutasUsuario");
					break;
				}
				return;				
			}
		}		
		doGet(request, response);

	}

}
