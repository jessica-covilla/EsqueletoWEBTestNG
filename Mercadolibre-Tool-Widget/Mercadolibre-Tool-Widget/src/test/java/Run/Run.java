package Run;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ClaseBase.ClasesBase;
import PagsObjets.PagsObjetHome;
import PagsObjets.PagsObjetMercury;
import PagsObjets.PagsObjetTool;
import PagsObjets.PagsObjetWidget;
import PagsObjets.PagsObjetsCrearCuenta;
import PagsObjets.PagsObjetsInicio;
import Utilidades.ExcelUtilidades;
import Utilidades.GenerarReportePdf;
import Utilidades.MyScreenRecorder;



public class Run 
{	
	 WebDriver driver;
	 PagsObjetsCrearCuenta crearCuenta;
	 PagsObjetsInicio paginas;
	 ClasesBase clasesBase;
	 GenerarReportePdf generarReportePdf;
	 String rutaImagen;
	 PagsObjetHome home;
	 PagsObjetTool tool;
	 PagsObjetWidget widget;
	 PagsObjetMercury mercury;
	 String rutaImgDemo;
	 String rutaImgMercu;
	 
	 @BeforeClass
		
		@Parameters({"url","rutaImagenReporte","rutaImagenReportedemo","rutaImagenReporteMercury", "Output"})
		  public void beforeClass(@Optional("default") String url,
				  					@Optional("default") String rutaImagenReporte, 
				  					@Optional("default") String rutaImagenReportedemo,
				  					@Optional("default") String rutaImagenReporteMercury,
		  							@Optional("default") String Output) throws IOException
		 
		{  
		{	
			// INSTANCIAR TODAS LAS CLASE 
			driver = ClasesBase.chomeDriverConnetion();
			clasesBase = new ClasesBase(driver);
			paginas = new PagsObjetsInicio(driver);
			crearCuenta = new PagsObjetsCrearCuenta(driver);
			home = new PagsObjetHome(driver);
			tool = new PagsObjetTool(driver);
			widget = new PagsObjetWidget(driver);
			mercury = new PagsObjetMercury(driver);
			generarReportePdf =new GenerarReportePdf();
			rutaImagen = rutaImagenReporte;
			rutaImgDemo = rutaImagenReportedemo;
			rutaImgMercu =rutaImagenReporteMercury;
			
			
		}	
		}

		@DataProvider(name = "datosMercadolibre")
		public Object[][] datosMercadolibre() throws Exception {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/prueba.xlsx","Mercadolibre");
			return arreglo;
		}

		@Test(dataProvider = "datosMercadolibre", priority = 5)
		
		
		public void test(String url, String ejecutar, String generarEvidencia, String producto, String correo) throws Exception 
		{
			if (ejecutar.equals("Si")) 
			{
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
				File rutaCarpeta = clasesBase.crearCarpeta(nomTest);
				// SE GENERA LA EVIDENCIA
				if (generarEvidencia.equals("Si"))
				{
					generarReportePdf.setRutaImagen(rutaImagen);
					// COMIENZA LAGRABACION EN VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					// COMIENZA EL REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
					// ACCEDER A LA URL
					paginas.urlAcceso(url);
					// INGRESA A MERCADO LIBRE
					paginas.busquedaInicial(producto, rutaCarpeta, generarEvidencia);
					//INGRESA A CREAR CUENTA
					crearCuenta.crearCuenta(correo, rutaCarpeta, generarEvidencia);
					// FINALIZAR GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					// TERMINA EL REPORTE PDF
					generarReportePdf.cerrarPlantilla();
				}else 
				{
					// ACCEDER A LA URL
					paginas.urlAcceso(url);
					// INGRESA A MERCADO LIBRE
					paginas.busquedaInicial(producto, rutaCarpeta, generarEvidencia);
					//INGRESA A CREAR CUENTA
					crearCuenta.crearCuenta(correo, rutaCarpeta, generarEvidencia);
				}
				
			} else 
			{
				System.out.println("No se ejecutara la automatización");
			}
		}
		
		@DataProvider(name = "datosCrearCuenta")
		public Object[][] datosCrearCuenta() throws Exception {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/prueba.xlsx","CrearCuenta");
			return arreglo;
		}
		
		
		@Test(dataProvider = "datosCrearCuenta",priority = 4)
		
		
		public void crearCuenta(String url, String ejecutar, String generarEvidencia, String correo) throws Exception 
		{
			if (ejecutar.equals("Si")) 
			{
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
				File rutaCarpeta = clasesBase.crearCarpeta(nomTest);
				//SE GENERA LA EVIDENCIA
				if (generarEvidencia.equals("Si"))
				{
					generarReportePdf.setRutaImagen(rutaImagen);
					// COMIENZA LAGRABACION EN VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					// COMIENZA EL REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
					// ACCEDER A LA URL
					paginas.urlAcceso(url);
					// INGRESA AL LINK CREAR CUENTA
					paginas.Cuenta(rutaCarpeta, generarEvidencia);
					//INGRESA A CREAR CUENTA
					crearCuenta.crearCuenta(correo, rutaCarpeta, generarEvidencia);
					// FINALIZAR GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					// FINALILZAR CREACION DEL REPORTE PDF
					generarReportePdf.cerrarPlantilla();
				}else 
				{
					// ACCEDER A LA URL
					paginas.urlAcceso(url);
					// INGRESA AL LINK CREAR CUENTA
					paginas.Cuenta(rutaCarpeta, generarEvidencia);
					//INGRESA A CREAR CUENTA
					crearCuenta.crearCuenta(correo, rutaCarpeta, generarEvidencia);
				}
				
			} else 
			{
				System.out.println("No se ejecutara la automatización");
			}
		}
		
		
		@DataProvider(name = "datosTool")
		public Object[][] datosTool() throws Exception {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/prueba.xlsx","Tool");
			return arreglo;
		}
		
		
		@Test(dataProvider = "datosTool",priority = 2)
		
		
		public void Tool(String url, String ejecutar, String generarEvidencia, String name) throws Exception 
		{
			if (ejecutar.equals("Si")) 
			{
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
				File rutaCarpeta = clasesBase.crearCarpeta(nomTest);
				//SE GENERA LA EVIDENCIA
				if (generarEvidencia.equals("Si"))
				{
					generarReportePdf.setRutaImagen(rutaImgDemo);
					// COMIENZA LAGRABACION EN VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					// COMIENZA EL REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
					// ACCEDER A LA URL
					home.urlAcceso(url);
					// INGRESA AL LINK CREAR CUENTA
					home.PaginaToolQA(nomTest, rutaCarpeta, generarEvidencia);
					//INGRESA A CREAR CUENTA
					tool.BotonesTool(name, rutaCarpeta, generarEvidencia);
					// FINALIZAR GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					// FINALILZAR CREACION DEL REPORTE PDF
					generarReportePdf.cerrarPlantilla();
				}else 
				{
					// ACCEDER A LA URL
					home.urlAcceso(url);
					// INGRESA AL LINK CREAR CUENTA
					home.PaginaToolQA(nomTest, rutaCarpeta, generarEvidencia);
					//INGRESA A CREAR CUENTA
					tool.BotonesTool(name, rutaCarpeta, generarEvidencia);
				}
				
			} else 
			{
				System.out.println("No se ejecutara la automatización");
			}
		}
		
		@DataProvider(name = "datoswidget")
		public Object[][] datoswidget() throws Exception {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/prueba.xlsx","Widget");
			return arreglo;
		}
		
		
		@Test(dataProvider = "datoswidget",priority = 3)
		
		
		public void Widget(String url, String ejecutar, String generarEvidencia) throws Exception 
		{
			if (ejecutar.equals("Si")) 
			{
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
				File rutaCarpeta = clasesBase.crearCarpeta(nomTest);
				//SE GENERA LA EVIDENCIA
				if (generarEvidencia.equals("Si"))
				{
					generarReportePdf.setRutaImagen(rutaImgDemo);
					// COMIENZA LAGRABACION EN VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					// COMIENZA EL REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
					// ACCEDER A LA URL
					home.urlAcceso(url);
					// INGRESA AL LINK CREAR CUENTA
					home.PaginaWidgets(nomTest, rutaCarpeta, generarEvidencia);
					//INGRESA A CREAR CUENTA
					widget.PaWidgets(nomTest, rutaCarpeta, generarEvidencia);
					// FINALIZAR GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					// FINALILZAR CREACION DEL REPORTE PDF
					generarReportePdf.cerrarPlantilla();
				}else 
				{
					// ACCEDER A LA URL
					home.urlAcceso(url);
					// INGRESA AL LINK CREAR CUENTA
					home.PaginaWidgets(nomTest, rutaCarpeta, generarEvidencia);
					//INGRESA A CREAR CUENTA
					widget.PaWidgets(nomTest, rutaCarpeta, generarEvidencia);
					// FINALIZAR GRABACION DE VIDEO
				}
				
			} else 
			{
				System.out.println("No se ejecutara la automatización");
			}
		}
		
				@DataProvider(name = "datosMercury")
				public Object[][] datosMercury() throws Exception {
					Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/prueba.xlsx","Mercury");
					return arreglo;
		}
		
				@Test(dataProvider = "datosMercury", priority = 1)
		
		
				public void registroMercuryTours(String url, String ejecutar, String generarEvidencia,  String firstName, String lastName, 
				String phone, String email, String address, String city, String stateProvince, 
				String postalCode, String country, String userName, String password, String confirmPassword) throws Exception 
				{
				if (ejecutar.equals("Si")) 
					{
					// OBTENER EL NOMBRE DEL METODO A EJECUTAR
					String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
					// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
					File rutaCarpeta = clasesBase.crearCarpeta(nomTest);
					//VALIDAR SI SE GENERA EVIDENCIA
					if (generarEvidencia.equals("Si"))
				{
					generarReportePdf.setRutaImagen(rutaImgMercu);
					// INICIAR GRABACION EN VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					// INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
					// ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
					mercury.urlAcceso(url);
					// ACCEDER AL METODO DE PRUEBA INICIAL
					mercury.formularioMercury(nomTest,rutaCarpeta, generarEvidencia, firstName, lastName, phone, email, address, city, stateProvince,
							postalCode, country, userName, password, confirmPassword);
					
					// FINALIZAR GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					// FINALILZAR CREACION DEL REPORTE PDF
					generarReportePdf.cerrarPlantilla();
				}else 
				{
					// ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
					mercury.urlAcceso(url);
					// ACCEDER AL METODO DE PRUEBA INICIAL
					
					mercury.formularioMercury(nomTest,rutaCarpeta, generarEvidencia, firstName, lastName, phone, email, address, city, stateProvince,
							postalCode, country, userName, password, confirmPassword);
				}
				
			} else 
			{
				System.out.println("La automatización no se ejecura");
			}
		}
		
		
		

		@AfterTest
		public void cerrarNavegador()
		{
			driver.quit();
		}
		@AfterClass
		public void afterClass() 
		{
			driver.close();
			driver.quit();
		}
	}