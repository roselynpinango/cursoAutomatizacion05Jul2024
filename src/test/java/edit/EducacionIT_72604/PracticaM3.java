package edit.EducacionIT_72604;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilidades.CapturaEvidencia;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticaM3 {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	File screen; 
	String dirEvidencias = "..\\EducacionIT-72604\\Evidencias\\";
	String nombreImagen = "img.jpg";
	String nombreDocumento = "Documento de Evidencias.docx";
	
	@BeforeSuite
	public void abrirNavegador() {
		// Linea extra para resolver posibles conflictos al ejecutar con Chrome
		WebDriverManager.chromedriver().setup();
				
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Buscar Palabra", priority=200)
	public void buscarPalabraChrome() throws IOException {
		// Captura de Pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "1_pantallaPrincipal.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Captura de pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "2_palabraABuscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Captura de Pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "3_resultadosBusqueda.jpg"));
		
		// Modulo 3: Assertions (incorporar validaciones despues de ejecutar acciones)
		String tituloEsperado = "Search - My Shop";
		String tituloActual = driver.getTitle(); // Devuelve el titulo actual de la pagina
		
		Assert.assertEquals(tituloActual, tituloEsperado);
		
		/* Otras validaciones
		Assert.assertNotEquals("A", "B");
		Assert.assertTrue(1 == 1);
		Assert.assertFalse(1 == 2);
		Assert.assertNull(null);
		Assert.assertNotNull(tituloActual);
		*/
		
		// SoftAssert: validación "suave" 
		/*SoftAssert soft = new SoftAssert();
		soft.assertEquals(tituloActual, "X", "Fake SoftAssert");
		System.out.println("ABC");
		soft.assertAll();*/
		
	}
	
	@Test(description="CP02 - Ir a Contactanos", priority=100)
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		// nombreDocumento = "CP02 - Ir a contactanos.docx";
		
		// Capturar evidencia
		CapturaEvidencia.escribirTituloEnDocumento(
							dirEvidencias + nombreDocumento,
							"Documento de Evidencias - AutomationPractice",
							20);
		CapturaEvidencia.capturarPantallaEnDocumento(
							driver,
							dirEvidencias + nombreImagen,
							dirEvidencias + nombreDocumento,
							"Paso 1 - Pantalla Inicial");
		
		// 1. Hacer clic en Contact Us
		WebElement lnkContact = driver.findElement(By.linkText("Contact us"));
		lnkContact.click();
		
		// Capturar evidencia
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + nombreImagen,
				dirEvidencias + nombreDocumento,
				"Paso 2 - Después de hacer clic en Contact Us");
		
		// 2. Completar el formulario
		Select selSubject = new Select(driver.findElement(By.id("id_contact")));
		selSubject.selectByVisibleText("Webmaster");
		
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email']"));
		txtEmail.sendKeys("correo@gmail.com");
		
		WebElement txtOrder = driver.findElement(By.name("id_order"));
		txtOrder.sendKeys("ABC-123");
		
		WebElement filAttached = driver.findElement(By.cssSelector("#fileUpload"));
		filAttached.sendKeys("C:\\addIntegerData.txt"); // Windows 
		//filAttached.sendKeys("/carpeta/addIntegerData.txt"); // Linux/Mac
		
		WebElement txtMessage = driver.findElement(By.tagName("textarea"));
		txtMessage.sendKeys("Mensaje de Contacto del Cliente");
		
		// Capturar evidencia
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + nombreImagen,
				dirEvidencias + nombreDocumento,
				"Paso 3 - Después de completar el formulario");
		
		// 3. Hacer clic en el boton Send
		WebElement btnSend = driver.findElement(By.id("submitMessage"));
		btnSend.click();
		
		// Capturar evidencia
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + nombreImagen,
				dirEvidencias + nombreDocumento,
				"Paso 4 - Luego de enviar el formulario de contacto");
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		//driver.close();
	}
}
