package PagsObjets;

import java.io.File;


import org.openqa.selenium.WebDriver;

import com.itextpdf.io.exceptions.IOException;

import MapsObjets.MapsObjectMercury;
import MapsObjets.MapsObjetTool;




	
public class PagsObjetMercury extends 	MapsObjectMercury
{
	// SE GENERA EL CONSTRUCTOR
	public PagsObjetMercury(WebDriver driver) {
		super(driver);
		 
	}
	
	//METODO INICIAL
		public void urlAcceso(String url)
		{
			driver.get(url);
		
		}
	 
	//METODO DE LA PRUEBA PAGINA PRINCIPAL TOOLQA


	public void formularioMercury(String producto,File rutaCarpeta, String generarEvidencia, String firstName, String lastName,
			String phone, String email, String address, String city, String stateProvince, String postalCode,
			String country, String userName, String password, String confirmPassword) throws Exception {
		
		//CLIC EN LINK INGRESAR	
				click(linkIngresar,rutaCarpeta, generarEvidencia);
				// ENVIA EL VALOR NOMBRE
				sendKey(firstName,txtNombre,rutaCarpeta, generarEvidencia);
				//ENVIA EL VALOR APELLIDO
				sendKey(lastName,txtApellido,rutaCarpeta, generarEvidencia);
				//ENVIA EL VALOR TELEFONO
				sendKey(phone,txtTelefono,rutaCarpeta, generarEvidencia);
				//ENVIA EL VALOR CORREO
				sendKey(email,txtCorreo,rutaCarpeta, generarEvidencia);
				//ENVIA EL VALOR DIRECCION
				sendKey(address,txtDireccion,rutaCarpeta, generarEvidencia);
				//ENVIA EL VALOR CIUDAD
				sendKey(city,txtCiudad,rutaCarpeta, generarEvidencia);
				//ENVIA EL VALOR DPTO
				sendKey(stateProvince,txtDpto,rutaCarpeta, generarEvidencia);
				//ENVIA EL VALOR CODIGO
				sendKey(postalCode,txtCodigo,rutaCarpeta, generarEvidencia);
				//SELECCIONA EL VALOR CORRESPONDIENTE
				click(txtCodigo,rutaCarpeta, generarEvidencia);
				sendKey(country,linkPais,rutaCarpeta, generarEvidencia);
				//ENVIA EL VALOR NAME
				sendKey(userName,txtName,rutaCarpeta, generarEvidencia);
				//ENVIA EL VALOR PASSWORD
				sendKey(password,txtPass,rutaCarpeta, generarEvidencia);
				//ENVIA EL VALOR CONFIRMAR DEL PASSWORD
				sendKey(confirmPassword,txtConfirmar,rutaCarpeta, generarEvidencia);
				// CLIC EN EL BOTON ENVIAR 
				//tiempoEspera(2000);
				click(btnEnviar,rutaCarpeta,generarEvidencia);
				tiempoEspera(3000);
				
	}

	

	

}