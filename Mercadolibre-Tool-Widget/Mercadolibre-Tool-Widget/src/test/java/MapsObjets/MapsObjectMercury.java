package MapsObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapsObjectMercury  extends ClasesBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapsObjectMercury(WebDriver driver)
	{
		super(driver);
	}
	
	//ELEMENTOS DEL FORMULARIO 
		protected By linkIngresar=By.xpath("//*[text()='REGISTER']");
		protected By txtNombre=By.name("firstName");
		protected By txtApellido=By.name("lastName");
		protected By txtTelefono=By.name("phone");
		protected By txtCorreo=By.id("userName");
		protected By txtDireccion=By.name("address1");
		protected By txtCiudad=By.name("city");
		protected By txtDpto=By.name("state");
		protected By txtCodigo=By.name("postalCode");
		protected By linkPais=By.name("country");
		protected By txtName=By.id("email");
		protected By txtPass=By.name("password");
		protected By txtConfirmar=By.name("confirmPassword");
		protected By btnEnviar=By.xpath("//input[@name='submit']");
			
}