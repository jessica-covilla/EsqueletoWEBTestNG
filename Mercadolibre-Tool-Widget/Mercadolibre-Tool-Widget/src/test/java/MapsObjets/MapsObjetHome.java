package MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapsObjetHome  extends ClasesBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetHome(WebDriver driver)
	{
		super(driver);
	}
	
	//ELEMENTOS DE PAGINA PRINCIPAL 
	
		protected By linkWidget= By.xpath("//*[text()='Widgets']");
		protected By linkPicker= By.xpath("//span[text()='Date Picker']");
		
		protected By linkAlert= By.xpath("//*[text()='Alerts, Frame & Windows']");
		protected By linkAlerts= By.xpath("//span[text()='Alerts']");
		
	
}