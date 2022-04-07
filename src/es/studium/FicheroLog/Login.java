package es.studium.FicheroLog;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
public class Login
{
	//creamos la ventana para el login
	Frame ventana = new Frame();
	Dialog dlgFeedback = new Dialog (ventana, "Mensaje", true);
	Label lblFeedback = new Label ("XXXXXXXXXXXXXXXXXXXXXXX");

	//objetos para indicar usuario y clave del login
	Label lblUsuario = new Label("Usuario");
	Label lblClave = new Label("Clave");
	TextField txtUsuario = new TextField(10);	
	TextField txtClave = new TextField(10);	
	Button btnAceptar = new Button("Aceptar");
	Button btnCancelar = new Button("Cancelar");

	Panel pnlPanel = new Panel();
	//BaseDatos bd = new BaseDatos();

	public Login()
	{
		//Configuración ventana
				ventana.setTitle("Login");// Título
				ventana.setSize(210, 150); // Tamaño: Ancho x Alto
				ventana.setResizable(false); // No permitir redimensión
				ventana.setLayout(new FlowLayout()); // Distribución - Diseño
				pnlPanel.setLayout(new FlowLayout());
				pnlPanel.setSize(250,200);
			
				ventana.add(lblUsuario);
				ventana.add(txtUsuario);
				ventana.add(lblClave);
				txtClave.setEchoChar('*');
				ventana.add(txtClave);

				ventana.add(pnlPanel);		
				ventana.add(btnAceptar);
				ventana.add(btnCancelar);

				ventana.setLocationRelativeTo(null); // Centrar
				ventana.setVisible(true); // Mostrarla
	}
}
