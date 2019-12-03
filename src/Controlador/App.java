package Controlador;

import Modelo.ModelLogin;
import Vista.LoginVista;

public class App {
	public static void main(String[] args) {
		ModelLogin modelo=new ModelLogin();
		LoginVista loginvista= new LoginVista();
		Controller loginController=new Controller(loginvista,modelo);
	}
}
