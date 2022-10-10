package PagsObjets;

import java.io.File;


import org.openqa.selenium.WebDriver;


import MapsObjets.MapsObjetTool;




	
public class PagsObjetTool extends 	MapsObjetTool
{
	// SE GENERA EL CONSTRUCTOR
	public PagsObjetTool(WebDriver driver) {
		super(driver);
		 
	}
	 
	//METODO DE LA PRUEBA PAGINA PRINCIPAL TOOLQA
	public void BotonesTool(String name, File rutaCarpeta, String generarEvidencia) throws Exception
	{
		
	
		
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
	
		scroll(100);
		//SELECCIONA 1ER BOTTON
		click(btn1Alert,rutaCarpeta, generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		driver.switchTo().alert().accept();
		//TIEMPO DE ESPERA
		
		
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		//SELECCIONA 2do BOTTON
		click(btn2Alert,rutaCarpeta, generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(6000);
		driver.switchTo().alert().accept();
		//TIEMPO DE ESPERA

		
		//SELECCIONAR EL ACEPTAR
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		//SELECCIONA 3er BOTTON
		click(btn3Alert,rutaCarpeta, generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);

		//SELECCIONAR EL CANCELAR
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		//SELECCIONA 3er BOTTON
		click(btn3Alert,rutaCarpeta, generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		driver.switchTo().alert().dismiss();
		tiempoEspera(2000);
	
		
		
	
		
		//SELECCIONA 4er BOTTON
		click(btn4Alert,rutaCarpeta, generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		//AGREGA EL NOMBRE
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
	
	}

	

}