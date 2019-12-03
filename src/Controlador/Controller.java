package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JOptionPane;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import AES.AES;
import AES.conexion;
import Modelo.ModelLogin;
import Vista.LoginVista;

public class Controller implements ActionListener {
	private LoginVista view;
	private static   ModelLogin model;
	private ActionListener actionListener;
	
	public Controller(LoginVista view, ModelLogin model) {
		this.view = view;
		this.model = model;
		this.view.btnEntrar.addActionListener(this);
		this.view.btnNuevoUsuario.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object boton= e.getSource();
		if(boton==view.btnEntrar) {
			Entrar();
		}else if(boton==view.btnNuevoUsuario) {
			NuevoUsuario();
		}
		
		
	}
	
	public void Entrar() {
		String usuario = view.txtUsuario.getText().toString();
		String password = view.txtPassword.getText().toString();
		
		if(usuario== null) {
			System.out.println("dsdsds");
		}
		
		AES.setKey("12345");
    	AES.encrypt(password);
    	
    	System.out.println("String to Encrypt: " + password); 
        System.out.println("Encrypted: " + AES.getEncryptedString());
    
        final String strToDecrypt =  AES.getEncryptedString();
        AES.decrypt(strToDecrypt.trim());
       
        System.out.println("String To Decrypt : " + strToDecrypt);
        System.out.println("Decrypted : " + AES.getDecryptedString());
        
        
	}
	
	public void NuevoUsuario() {
		String usuario = view.txtUsuario.getText().toString();
		String password = view.txtPassword.getText().toString();
		
		AES.setKey("12345");
    	AES.encrypt(password);
    	
    	System.out.println("String to Encrypt: " + password); 
        System.out.println("Encrypted: " + AES.getEncryptedString());
    
        final String strToDecrypt =  AES.getEncryptedString();
        AES.decrypt(strToDecrypt.trim());
       
        System.out.println("String To Decrypt : " + strToDecrypt);
        System.out.println("Decrypted : " + AES.getDecryptedString());
		
		
		conexion con =new conexion();
        MongoClient mongo = con.crearConexion();
		if(mongo != null) {
        	DB db =mongo.getDB("prueba");
        	insertarUsuario(db,"usuarios",usuario,AES.getEncryptedString());
        }
	}
	
	 private static void insertarUsuario(DB db, String tabla, String usuario, String password) {
		 	model = new ModelLogin(usuario,password);	    	
		 	DBCollection table = db.getCollection(tabla);
	    	BasicDBObject document = new BasicDBObject();
	    	document.put("usuario",model.getUsuario().toString());
	    	document.put("password",model.getPassword().toString());
	    	//insertar datos a Mongodb
	    	table.insert(document);
	    }
	
	

}
