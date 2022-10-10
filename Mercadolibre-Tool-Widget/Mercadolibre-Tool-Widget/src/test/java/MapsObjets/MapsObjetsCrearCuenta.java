package MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapsObjetsCrearCuenta extends ClasesBase
{
	// CREAR EL CONSTRUCTOR
	public MapsObjetsCrearCuenta(WebDriver driver)
	{
		super(driver);
		
	}
	//ELEMENTOS CREAR CUENTA
	protected By Check= By.id("terms-and-conds");
	protected By btnContinuar= By.xpath("//span[@class='andes-button__content']");
	protected By linkEmail= By.xpath("//span[@class='andes-button__text']");
	protected By ingresarCorreo= By.xpath("//input[@type='email']");

}
