package PagsObjets;

import java.io.File;


import org.openqa.selenium.WebDriver;

import MapsObjets.MapsObjetHome;




	
public class PagsObjetHome extends MapsObjetHome
{
	String busquedas = null;
	//CREAR EL CONSTRUCTOR DE LA CLASE
	public PagsObjetHome(WebDriver driver)
	{
		super (driver);
	}
	
	//METODO DE BUSQUEDA
		public void busqueda(String busqueda) {
		busquedas=busqueda;
		
	}
		//METODO INICIAL
 		public void urlAcceso(String url)
 		{
 			driver.get(url);
 		
 		}
		
	
	//METODO DE LA PRUEBA PAGINA PRINCIPAL TOOLQA
	
	public void PaginaToolQA(String producto, File rutaCarpeta, String generarEvidencia) throws Exception
	{
		
			//ENVIO DE LOS VALORES DE BUSQUEDA EN EL NAVEGADOR 
	
			scroll(200);
	    	tiempoEspera(2000);
	    	//CLIC EN ALERTS
			click(linkAlert,rutaCarpeta, generarEvidencia);
			//TIEMPO DE ESPERA
			tiempoEspera(3000);
		
			scroll(200);
			click(linkAlerts,rutaCarpeta, generarEvidencia);
	
			
			
		
		
	}

	public void PaginaWidgets(String producto, File rutaCarpeta, String generarEvidencia) throws Exception 
	{
		

		scroll(300);
    	tiempoEspera(1000);
		//INGRESA A Widgets
		click(linkWidget,rutaCarpeta, generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(3000);
		//SE SELECCIONA ALERTS
		//js.executeScript("window.scrollBy(0,200)");
		scroll(300);
		click(linkPicker,rutaCarpeta, generarEvidencia);
		//TIEMPO DE ESPERA
		
		
	}

	

}
