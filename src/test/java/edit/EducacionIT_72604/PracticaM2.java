package edit.EducacionIT_72604;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class PracticaM2 {
	String url = "http://www.automationpractice.pl";
	
	@Test
	public void registrarUsario() {
		// (1) Definir qué navegador queremos utilizar
		WebDriver driver = new FirefoxDriver();
		
		// (2) Abrir la página de prueba
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		// (3) Hacer clic en el hipervínculo 'Sign in'
		WebElement lnkSign = driver.findElement(By.partialLinkText("Sign"));
		lnkSign.click();
		
		// Otra forma
		//driver.findElement(By.partialLinkText("Sign")).click();
		
		// Opcion 1: Generamos un correo con un numero aleatorio
		//String email = "correo" + Math.random() + "@mailinator.com";
				
		// Opcion 2: Utilizamos una librería de generación de datos aleatorios
		Faker faker = new Faker();
		String email = faker.internet().emailAddress();
				
		// (4) Escribir el correo electrónico
		WebElement txtEmail = driver.findElement(By.cssSelector("#email_create"));
		txtEmail.sendKeys(email);
		
		// (5) Hacer clic en el botón 'Create an Account'
		WebElement btnCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		btnCreate.click();
		
		// Sumar una espera porque hay una demora en la carga del formulario
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
		
		// (6) Completar el formulario
		WebElement radTitle = driver.findElement(By.id("id_gender2"));
		radTitle.click();
		
		WebElement txtFirstName = driver.findElement(By.name("customer_firstname"));
		txtFirstName.sendKeys("Arturo");
		
		WebElement txtLastName = driver.findElement(By.cssSelector("#customer_lastname"));
		txtLastName.sendKeys("Lopez");
		
		WebElement txtEmail2 = driver.findElement(By.xpath("//input[@id='email']"));
		txtEmail2.clear(); // Limpiar el valor anterior del campo
		txtEmail2.sendKeys(email);
		
		WebElement txtPassword = driver.findElement(By.id("passwd"));
		txtPassword.sendKeys("1q2w3e4r5t");
		
		Select dias = new Select(driver.findElement(By.id("days")));
		dias.selectByValue("18");
		
		Select meses = new Select(driver.findElement(By.name("months")));
		meses.selectByVisibleText("June ");
		
		Select anios = new Select(driver.findElement(By.cssSelector("#years")));
		anios.selectByIndex(30);
		
		WebElement chkNews = driver.findElement(By.name("newsletter"));
		chkNews.click();
		
		// (7) Hacer clic en el botón 'Register'
		WebElement btnRegister = driver.findElement(By.xpath("//button[@id='submitAccount']"));
		btnRegister.click();
		
		// (8) Cerrar el navegador
	}
}
