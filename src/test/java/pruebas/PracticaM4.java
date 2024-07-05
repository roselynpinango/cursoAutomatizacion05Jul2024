package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class PracticaM4 {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		// 1) Hacer clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		// 2) Completar el correo y contraseña
		PaginaLogin login = new PaginaLogin(driver);
		//login.ingresarCredenciales("correo@gmail.com", "1q2w3e4r5t");
		
		login.escribirCorreo("correo@gmail.com");
		login.escribirPassword("1q2w3e4r5t");
		
		// 3) Hacer clic en el botón Login
		login.hacerClicEnLogin();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("dress");
		inicio.hacerClicEnBuscar();
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		//driver.close();
	}
}
