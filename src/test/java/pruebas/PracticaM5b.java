package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class PracticaM5b {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirCorreo(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
		
		// Volver a la posicion inicial de la prueba
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2];
		
		// Completar los datos a utilizar
		datos[0][0] = "abc@gmail.com"; // Correo
		datos[0][1] = "4twet5w45te"; // Contraseña
		
		datos[1][0] = "def@gmail.com"; // Correo
		datos[1][1] = "76u7tii7tr"; // Contraseña
		
		datos[2][0] = "ghi@gmail.com"; // Correo
		datos[2][1] = "e6yewt4wtw"; // Contraseña
		
		return datos;
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		// Leer un archivo excel y devolver los datos como Object[][]
		String nombreExcel = "..\\EducacionIT-72604\\Datos\\datos_login03Jul2024.xlsx";
		String nombreHoja = "Hoja1";
		
		return DatosExcel.leerExcel(nombreExcel, nombreHoja);
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
	
}
