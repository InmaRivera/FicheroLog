package es.studium.FicheroLog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener
{
	Login login;
	Modelo modelo;
	public Controlador (Login l, Modelo m)
	{
		login  = l;
		modelo = m;
		login.ventana.addWindowListener(this);
		login.btnCancelar.addActionListener(this);
		login.btnAceptar.addActionListener(this);
		login.dlgFeedback.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource().equals(login.btnCancelar))
		{
			login.txtUsuario.setText("");
			login.txtClave.setText("");
			login.txtUsuario.requestFocus();
		}
		else if (evento.getSource().equals(login.btnAceptar))
		{
			//Conectar
			modelo.conectar();
			//Consultar
			String usuario = login.txtUsuario.getText();
			String clave = login.txtClave.getText();
			String sentencia = "SELECT * FROM usuarios WHERE " 
					+ "nombreUsuario = '"
					+ usuario 
					+ "' AND claveUsuario = SHA2('" + clave +  "', 256);";
			int resultado = modelo.consultar(sentencia);
			//si credenciales incorrectas ---> mensaje de error 
			if(resultado == -1)
			{
				login.dlgFeedback.setSize(200,100);
				login.dlgFeedback.setLayout(new FlowLayout());
				login.dlgFeedback.setResizable(false);
				login.lblFeedback.setText("Credenciales incorrectas");
				login.dlgFeedback.add(login.lblFeedback);
				login.dlgFeedback.setLocationRelativeTo(null);
				login.dlgFeedback.setVisible(true);
			}
			//Si credenciales correctas ---> mostrar menu principal
			else
			{
				modelo.guardarLog(usuario, "Login");
				new MenuPrincipal(resultado);
				login.ventana.setVisible(false);//para que no aparezca la ventana de login cuando aparece Menu Principal
			}
			//Desconectar
			modelo.desconectar();
			//Actuar: Menú/Error
		}

	}
	@Override
	public void windowClosing(WindowEvent e)
	{
		if (login.dlgFeedback.isActive())
		{
			login.dlgFeedback.setVisible(false);
		}
		else
		{
		System.exit(0);
		}

	}
	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}
}
