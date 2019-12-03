package Vista;



import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.placeholder.PlaceHolder;

public class LoginVista extends JFrame {
	JFrame frame = new JFrame();
	public JButton btnEntrar,btnNuevoUsuario;
	public JTextField txtUsuario;
	public JLabel lblImg,lblTitle;
	public  JPasswordField txtPassword;
	private PlaceHolder holder;

	public LoginVista() {
		super("Login");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		
		Font font = new Font("TimesRoman", Font.BOLD, 20);
		lblTitle = new JLabel();
		lblTitle.setBounds(20,10,100,45);
		lblTitle.setText("Login");
		lblTitle.setFont(font);
		lblTitle.setVisible(true);
		frame.add(lblTitle);
		
		lblImg = new JLabel();
	    lblImg.setIcon(new ImageIcon("./img/login.png"));
	    lblImg.setBounds(253, 40, 1500, 100);
	    frame.add(lblImg);
	    lblImg.setVisible(true);
		
		btnEntrar = new JButton();
		btnEntrar.setBounds(225, 300, 150, 35);
		btnEntrar.setText("Entrar");
		frame.add(btnEntrar);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(200, 150, 200, 35);
		frame.setVisible(true);
		frame.add(txtUsuario);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(200, 210, 200, 35);
		txtPassword.setVisible(true);
		frame.add(txtPassword);
		
		btnNuevoUsuario = new JButton();
		btnNuevoUsuario.setBounds(400, 300, 150, 35);
		btnNuevoUsuario.setText("Nuevo");
		frame.add(btnNuevoUsuario);
		
        holder= new PlaceHolder(txtUsuario,"Usuario");
        holder = new PlaceHolder(txtPassword,"Password");
       
		frame.setVisible(true);
	}

}
