package pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaAlerta;

public class PracticaM5 {
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		double zoom = 0.67;
		options.addArguments("--force-device-scale-factor=" + zoom);
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void usarAlerta1() {
		// (1) Hacer clic en el botón de la página
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicEnNotificacion();
		
		// (2) Obtener la alerta (esperamos que haya aparecido)
		Alert alerta = pagina.obtenerAlerta();
		
		// Mostrar en la consola el texto de la alerta
		System.out.println(pagina.obtenerTextoAlerta(alerta));
		
		// (3) Simular el 'Aceptar' en la alerta
		pagina.hacerClicEnAceptar(alerta);
	}
	
	@Test
	public void usarAlerta2() 
	{
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicEnEspera();
		
		Alert alerta = pagina.obtenerAlerta();
		pagina.hacerClicEnAceptar(alerta);
	}
	
	@Test
	public void usarAlerta3() {
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicenCancelar();
		
		Alert alerta = pagina.obtenerAlerta();
		pagina.hacerClicEnCancelar(alerta);
	}
	
	@Test
	public void usarAlerta4() {
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicEnPrompt();
		
		Alert alerta = pagina.obtenerAlerta();
		pagina.escribirEnAlerta(alerta, "Clase de Automatizacion");
		pagina.hacerClicEnAceptar(alerta);
	}
}
