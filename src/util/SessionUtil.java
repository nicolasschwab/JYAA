package util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUtil {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}
	
	public static String getUserName() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute("name").toString();
	}

	public static Long getUserId() {
		HttpSession session = getSession();
		if (session != null)
			return  (Long) session.getAttribute("id");
		else
			return null;
	}
	
}
