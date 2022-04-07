package es.studium.FicheroLog;

public class Principal
{
	public static void main(String[] args)
	{
		Login login = new Login();//ventana de login
		Modelo modelo = new Modelo();//funcionalidad base de datos
		new Controlador(login, modelo);
	}
}
