package listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bean.Usuario;

/**
 * Application Lifecycle Listener implementation class ListenerDeContexto
 *
 */
@WebListener
public class ListenerDeContexto implements ServletContextListener {

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
    /**
     * Default constructor. 
     */
    public ListenerDeContexto() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         usuarios.add(new Usuario("administrador", "administrador", 1));
         usuarios.add(new Usuario("usuario", "usuario", 2));
         ServletContext context = event.getServletContext();
         context.setAttribute("usuarios", usuarios);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
