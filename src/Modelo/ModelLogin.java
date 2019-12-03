package Modelo;

public class ModelLogin {
	private String usuario;
	private String password;
	
	public ModelLogin() {
		
	}
	public ModelLogin(String usuario,String password){
		this.usuario = usuario;
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ModelLogin [usuario=" + usuario + ", password=" + password + "]";
	}
	
	
	
	
}
