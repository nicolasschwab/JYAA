package jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PuntoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String lon;
	private String lat;
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public PuntoBean(String lon, String lat) {
		super();
		this.lon = lon;
		this.lat = lat;
	}

}
