package bean;

public class Usuario {

	private String username;
	private String password;
	private Integer type;
	
	public Usuario(String username, String password, Integer type){
		setUsername(username);
		setPassword(password);
		setType(type);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
