package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;

public class PracticaM4b {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@BeforeTest
	@Parameters("navegador")
	public void abrirNavegador(String navegador) {
		if (navegador.equalsIgnoreCase("Chrome")) {
			// Acciones para abrir el navegador Chrome
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			
			driver = new ChromeDriver(options);
		} else if (navegador.equalsIgnoreCase("Edge")) {
			// Acciones para abrir el navegador Edge
			driver = new EdgeDriver();
		} else if (navegador.equalsIgnoreCase("Firefox")) {
			// Acciones para abrir el navegador Firefox
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("dress");
		inicio.hacerClicEnBuscar();
	}
}
