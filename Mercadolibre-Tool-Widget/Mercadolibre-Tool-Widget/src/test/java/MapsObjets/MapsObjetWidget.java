package MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapsObjetWidget  extends ClasesBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetWidget(WebDriver driver)
	{
		super(driver);
	}
	
	protected By txtFecha= By.id("datePickerMonthYearInput");
	//input[@id='datePickerMonthYearInput']
	protected By fecha2= By.id("dateAndTimePickerInput");
	protected By hora = By.xpath("//div[@class='react-datepicker__time']");
	protected By btnHora=By.xpath("//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[3]/div[2]/div/ul/li");
	protected By clic = By.xpath("//div[@class='left-pannel']");
	
	
}