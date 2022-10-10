package MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapsObjetTool  extends ClasesBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetTool(WebDriver driver)
	{
		super(driver);
	}
	
	//LOS ELEMENTOS DE LA PAGINA DE LOS BOTONES DE TOOL
		protected By btn1Alert= By.id("alertButton");
		protected By btn2Alert= By.id("timerAlertButton");
		protected By btn3Alert= By.id("confirmButton");
		protected By btn4Alert= By.id("promtButton");
	
}