package PagsObjets;



import java.io.File;


import org.openqa.selenium.WebDriver;

import MapsObjets.MapsObjetsCrearCuenta;



public class PagsObjetsCrearCuenta extends MapsObjetsCrearCuenta
{
		
	
	
	public PagsObjetsCrearCuenta(WebDriver driver) {
		super(driver);
		
	}

	public void crearCuenta(String correo, File rutaCarpeta, String generarEvidencia) throws Exception 
	{		
				
				//ACTIVAR CHECK
				click(Check,rutaCarpeta, generarEvidencia);
				//SELECCIONAR CONTINUAR
				click(btnContinuar,rutaCarpeta, generarEvidencia);
				//SELECCIONAR VALIDAR CORREO
				click(linkEmail,rutaCarpeta, generarEvidencia);
				tiempoEspera(2000);
				sendKey(correo,ingresarCorreo,rutaCarpeta, generarEvidencia);
	}
	
}
