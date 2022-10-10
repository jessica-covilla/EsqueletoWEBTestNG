package MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapsObjetsInicio  extends ClasesBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetsInicio(WebDriver driver)
	{
		super(driver);
	}
	
	//ELEMENTOS PAGINA INICIAL
	protected By txtBusqueda= By.name("as_word");
	protected By linkCookies= By.xpath("//button[@class='cookie-consent-banner-opt-out__action cookie-consent-banner-opt-out__action--primary cookie-consent-banner-opt-out__action--key-accept']");
	protected By linkUbicacion= By.xpath("//button[@class='andes-tooltip-button-close']");
	protected By btnSeleccionar= By.xpath("(//img[@class='ui-search-result-image__element shops__image-element'])[1]");
	protected By btnCarrito= By.xpath("//button[@class='andes-button andes-spinner__icon-base andes-button--quiet']//span[@class='andes-button__content'][text()='Agregar al carrito']");
	protected By btnCuenta= By.xpath("//a[@id='registration-link']/span[@class='andes-button__content']");
	
	protected By linkCuenta= By.xpath("//a[@data-link-id='registration']");
	
	
}