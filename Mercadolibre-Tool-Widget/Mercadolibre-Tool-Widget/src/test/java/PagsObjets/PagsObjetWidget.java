package PagsObjets;

import java.io.File;
//import java.time.Month;
import java.time.LocalDate;
import java.time.Month;

import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;



import MapsObjets.MapsObjetWidget;
//import java.time.LocalDate;
import java.util.List;



	
public class PagsObjetWidget extends MapsObjetWidget {
	
	// SE GENERA EL CONSTRUCTOR
	public PagsObjetWidget(WebDriver driver) {
		super(driver);
		
	}
	

	public void PaWidgets(String producto, File rutaCarpeta, String generarEvidencia) throws Exception  {
		
		click(txtFecha, rutaCarpeta, generarEvidencia);
		String fecha = fechaSistema();
		String[] fechaVector= fecha.split("-");
		
		int dia =  Integer.parseInt(fechaVector[0]);
		int mes =  Integer.parseInt(fechaVector[1]);
		int year =  Integer.parseInt(fechaVector[2]);
		int hora = Integer.parseInt(fechaVector[3]);
	    int min = Integer.parseInt(fechaVector[4]);
	    int seg = Integer.parseInt(fechaVector[5]);
		
	    		
	    dia=dia-1;
		mes=mes-1;
		year=year-1;
		hora = hora -1;
		
		String fechamenor = dia+"/"+mes+"/"+year;
		String fechaMenorHora = mes+"/"+dia+"/"+year+" "+hora+":"+min+":"+seg;
		
		//BORRO LA CELDA
		
		borrartxt(txtFecha,rutaCarpeta,generarEvidencia);
		tiempoEspera(3000);
		
		//AGREGA EL VALOR EN LA CELDA
		sendKey(fechamenor,txtFecha , rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		
		click(fecha2, rutaCarpeta, generarEvidencia);
		//BORRO LA CELDA
		borrartxt(fecha2,rutaCarpeta, generarEvidencia);
		//AGREGA EL VALOR EN LA CELDA
		sendKey(fechaMenorHora, fecha2,rutaCarpeta, generarEvidencia);
		tiempoEspera(2000);
		click(clic, rutaCarpeta, generarEvidencia);
	
		
	

	}
}