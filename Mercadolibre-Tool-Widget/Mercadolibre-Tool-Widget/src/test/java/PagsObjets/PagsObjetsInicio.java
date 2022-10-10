package PagsObjets;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import MapsObjets.MapsObjetsInicio;



	
public class PagsObjetsInicio extends MapsObjetsInicio
 	{
 		//CREAR CONSTRUCTOR DE LA CLASE 
 		public PagsObjetsInicio(WebDriver driver)
 		{
 			super(driver);
 		}
 		
 		//METODO INICIAL CON EXCEL
 		
 		
 		public void urlAcceso(String url) throws IOException 
 		{
 			driver.get(url);
 	
 		}
 		
 		
 		//METODO PRIMERA PRUEBA
 		public void busquedaInicial( String producto, File rutaCarpeta, String generarEvidencia) throws IOException
 	
 		{
 			
 			try {
 				//ENVIAMOS LOS VALORES DE BUSQUEDA EN EL NAVEGADOR
 				//LIMPIAR EL TEXTO DE BUSQUEDA
 	 			borrar(txtBusqueda,rutaCarpeta,generarEvidencia);
 	 			//ENVIAR LO QUE VA A BUSCAR
 	 			sendKey(producto,txtBusqueda,rutaCarpeta, generarEvidencia);
 	 			
 	 			//SE ACEPTA LA BUSQUEDA
 	 			submit(txtBusqueda,rutaCarpeta, generarEvidencia);
 	 			//TIEMPO DE ESPERA
 	 			tiempoEspera(2000);
 	 			//ACERPTAR COOKIES
 	 			validacion(linkCookies,rutaCarpeta, generarEvidencia);
 	 			//CERRAR VENTANA UBICACION
 	 			//tiempoEspera(2000);
 	 			validacion(linkUbicacion,rutaCarpeta, generarEvidencia);			
 	 			//SELECIONAR EL OBJETO
 	 			click(btnSeleccionar,rutaCarpeta, generarEvidencia);
 	 			//SELECCIONAR EL CARRITO
 	 			//tiempoEspera(2000);
 	 			click(btnCarrito,rutaCarpeta, generarEvidencia);
 	 			//tiempoEspera(2000);
 	 			click(btnCuenta,rutaCarpeta,generarEvidencia);
 	 			
			} catch (Exception e) {
				System.out.println(e);
			}
 			
 			
 			
 		}

		

		public void Cuenta(File rutaCarpeta, String generarEvidencia) throws Exception {
			//INGRESAR A CREAR CUENTA
			click(linkCuenta,rutaCarpeta, generarEvidencia);
			// ACEPTAR LAS COOKIES
			validacion(linkCookies,rutaCarpeta, generarEvidencia); 
			
		}

		 
		

		
			
		

		 
 	}