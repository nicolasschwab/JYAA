package util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

	public static HttpSession getSession() {
		return (HttpSession) getExternalContext().getSession(false);
	}
	
	public static String getUserName() {
		HttpSession session = getSession();
		return session.getAttribute("name").toString();
	}

	public static Long getUserId() {
		HttpSession session = getSession();
		if (session != null)
			return  (Long) session.getAttribute("id");
		else
			return null;
	}
	
	public static boolean hasSession(){
		HttpSession session = getSession();
		Long id = (Long) session.getAttribute("id");
		if(id != null && id > 0){
			return true;
		}
		return false;
	}
	
	public static ExternalContext terminateSession(){
		ExternalContext ec = getExternalContext();
	    ec.invalidateSession();
	    return ec;
	}
	
	private static ExternalContext getExternalContext(){
		return FacesContext.getCurrentInstance().getExternalContext();
	}
}
