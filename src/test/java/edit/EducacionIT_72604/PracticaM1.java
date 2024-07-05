package edit.EducacionIT_72604;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//Informacion sobre las librerías necesarias para estas pruebas
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticaM1 {
	// Definicion de variables de uso comun
	String url = "http://www.automationpractice.pl";
	
	// Métodos de Prueba
	@Test
	public void buscarPalabraEnEdge() {
		// 1) Definir que navegador utilizamos
		WebDriver navegador = new EdgeDriver();
		
		// 2) Abrir la página de prueba
		navegador.get(url);   // Otra forma: navegador.navigate().to(url);
		navegador.manage().window().maximize(); // Maximizar la ventana
		navegador.manage().deleteAllCookies(); // borra las cookies
		
		// 3) Escribir una palabra a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.clear(); // Limpiar el valor que tenia un campo de texto
		txtBuscador.sendKeys("dress");
		
		// Alternativa: Simular que presionamos la tecla ENTER
		txtBuscador.sendKeys(Keys.ENTER);
		
		// 4) Hacer clic en "la lupita" (botón de búsqueda)
		//WebElement btnBuscar = navegador.findElement(By.name("submit_search"));
		//btnBuscar.click();
		
		navegador.close(); // Cerrar la ventana actual de prueba
		//navegador.quit(); // Cerrar todas las ventanas que se hayan abierto durante la prueba
	}
	
	@Test
	public void buscarPalabraEnFirefox() {
		// 1) Definir que navegador utilizamos
		WebDriver navegador = new FirefoxDriver();
		
		// 2) Abrir la página de prueba
		navegador.get(url);   // Otra forma: navegador.navigate().to(url);
		
		// 3) Escribir una palabra a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// 4) Hacer clic en "la lupita" (botón de búsqueda)
		WebElement btnBuscar = navegador.findElement(By.name("submit_search"));
		btnBuscar.click();
	}
}
