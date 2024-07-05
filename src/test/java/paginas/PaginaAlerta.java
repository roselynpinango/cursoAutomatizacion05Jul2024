package paginas;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaAlerta {
	// Elementos web 
	@FindBy(css="#alertButton")
	WebElement btnNotificacion;
	
	@FindBy(id="timerAlertButton")
	WebElement btnEspera;
	
	@FindBy(xpath="//button[@id='confirmButton']")
	WebElement btnCancelar;
	
	@FindBy(css="#promtButton")
	WebElement btnPrompt;
	
	WebDriver driver;
	
	// Constructor
	public PaginaAlerta(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	// Acciones sobre elementos web
	public void hacerClicEnNotificacion() {
		btnNotificacion.click();
	}
	
	public void hacerClicEnEspera() {
		btnEspera.click();
	}
	
	public void hacerClicenCancelar() {
		btnCancelar.click();
	}
	
	public void hacerClicEnPrompt() {
		btnPrompt.click();
	}
	
	public Alert obtenerAlerta() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
		return driver.switchTo().alert();
	}
	
	public void hacerClicEnAceptar(Alert alerta) {
		alerta.accept();
	}
	
	public void hacerClicEnCancelar(Alert alerta) {
		alerta.dismiss();
	}
	
	public void escribirEnAlerta(Alert alerta, String palabra) {
		alerta.sendKeys(palabra);
	}
	
	public String obtenerTextoAlerta(Alert alerta) {
		return alerta.getText();
	}
}
