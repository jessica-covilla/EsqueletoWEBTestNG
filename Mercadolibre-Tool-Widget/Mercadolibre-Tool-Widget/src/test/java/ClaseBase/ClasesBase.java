package ClaseBase;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import Utilidades.GenerarReportePdf;


public class ClasesBase 
{
	
	protected static WebDriver driver;
	
	//CONSTRUCTOR DE CLASE
	public ClasesBase (WebDriver driver)
	{
		super();
	}
  
	//REALIZA EL METODO DE NAVEGADOR
		public static WebDriver chomeDriverConnetion()
		{
			//SETEAR LAS OPCIONES DEL NAVEGADOR 
			//DEFINIR ESTRATEGIA DE CARGA DE LA PAG
			ChromeOptions chromeOptions= new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
			//SETEAR PROPIEDADES DEL NAVEGADOR
			System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			//MAXIMIZAR VENTANA DEL NAVEGADOR
			driver.manage().window().maximize();
			
		return driver;
		}
		
		//METODO CLICK 
		public void click(By locator, File rutaCarpeta, String generarEvidencia) throws Exception
		{
			captureScreen(rutaCarpeta, locator, generarEvidencia);
			driver.findElement(locator).click();
			tiempoEspera(1000);
		}
				
		//METODO BORRAR
		public void borrar (By locator, File rutaCarpeta, String generarEvidencia) throws Exception
				{
					driver.findElement(locator).clear();
					captureScreen(rutaCarpeta, locator, generarEvidencia);
				}
				
				
		//METODO ENVIAR TEXTO
		public void sendKey(String string, By locator, File rutaCarpeta, String generarEvidencia) throws Exception
				{
					driver.findElement(locator).sendKeys(string);
					captureScreen(rutaCarpeta, locator, generarEvidencia);
				}
				
			
				
		//METODO ENTER SUBMIT
		public void submit(By locator,  File rutaCarpeta, String generarEvidencia) throws Exception
				{
					driver.findElement(locator).submit();
					tiempoEspera(500);
					captureScreen(rutaCarpeta, locator, generarEvidencia);
				}
				
		//METODO TIEMPO DE ESPERA
		public void tiempoEspera(long tiempo) throws InterruptedException
				{
					Thread.sleep(tiempo);
				}
				
		// SCROLL DOWN  200 PIXEL VERTICAL
		public void scrollDown(int y, int numMovimiento) throws InterruptedException
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
					for (int i=0; i<= numMovimiento; i++) {
					js.executeScript("window.scrollBy(0,"+y+")");
					}
				}
				
		//METODO TIEMPO DE ESPERA
		public void imprimirConsola(Exception mensaje) throws InterruptedException
				{
					System.out.println("e");
				}
				
				// TOMA DE EVIDENCIAS CON SCREENSHOT
				
		
				
		public void captureScreen(File rutaCarpeta, By locator, String generarEvidencia) throws Exception
				{
					if(generarEvidencia.equals("Si"))
					{
					String hora = HoraSistema();
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
					String rutaImagen = new File(rutaCarpeta+"\\"+hora+".png").toString();
					
					//INSTANCIAR CLASE GENERAR PDF
					GenerarReportePdf informePdf = new GenerarReportePdf();
					//SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
					informePdf.crearBody(locator, rutaImagen);
					
					//ELIMINAR IMAGEN CREADA
					eliminarArchivo(rutaImagen);
					}
				}
				
		public File crearCarpeta(String nomTest)
				{
					//ALMECENAMOS LA FECHA DEL SISTEMA 
					String fecha = fechaHora();
					//CREAMOS EL NOMBRE DE LA CARPETA
					String nomCarpeta = nomTest+"-"+fecha;
					//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR 
					File directorio = new File("./output/"+nomCarpeta);
					//C:\Users\HP\eclipse-workspace\SemilleroToolsQa\output
					//CREAMOS LA CARPETA ./Properties/output
					directorio.mkdir();
					return directorio;
				}
				
				
		public static String  fechaHora() 
				{
					//TOMAR LA FECHA DEL SISTEMA 
					LocalDateTime fechaSistema = LocalDateTime.now();
					//DEFINIR FORMATO FECHA
					DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
					//DAR FORMATO A LA FECHA DEL SISTEMA 
					String formatFecha = fecha.format(fechaSistema);
					return formatFecha;
					
				}
				
		public static String  fechaHoraDos() 
				{
					//TOMAR LA FECHA DEL SISTEMA 
					LocalDateTime fechaSistema = LocalDateTime.now();
					//DEFINIR FORMATO FECHA
					DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					//DAR FORMATO A LA FECHA DEL SISTEMA 
					String formatFecha = fecha.format(fechaSistema);
					return formatFecha;
					
				}
				
		public void eliminarArchivo(String rutaImagen)
				{
					File fichero = new File(rutaImagen);
					fichero.delete();
				}
				
				
				
		public String HoraSistema ()
				{
					//TOMAR LA HORA DEL SISTEMA
					LocalTime horaSistema = LocalTime.now();
					//DEFINIR FORMATO HORA
					DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
					//DAR FORMATO A LA HORA DEL SISTEMA
					String hora = fecha.format(horaSistema);
					return hora;
				}
		/*
		public String fechaWidget()
		{
			String fecha = fechaSistema();
			String[] fechaVector= fecha.split("-");
			
			int dia =  Integer.parseInt(fechaVector[0]);
			int mes =  Integer.parseInt(fechaVector[1]);
			int year =  Integer.parseInt(fechaVector[2]);
			
			dia=dia-1;
			mes=mes-1;
			year=year-1;
			
			String fechaMenor = dia+"/"+mes+"/"+year;
			return fechaMenor;
			
		}*/
		
		public String fechaSistema()
		{
			//TOMAMOS LA FECHA DEL SISTEMA
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH-mm-ss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}
		
		public String fechaWidget2()
		{
			String fecha2 = fechaSistema();
			String[] fechaVector= fecha2.split("-");
			
	
			int dia =  Integer.parseInt(fechaVector[0]);
			         
			//=  Integer.parseInt(fechaVector[1]);
			int year =  Integer.parseInt(fechaVector[2]);
			
			dia=dia-1;
		//	mes=mes-1;
			year=year-1;
			
			Month mes1=LocalDate.now().minusMonths(1).getMonth();
			fecha2 = mes1+"/"+dia+"/"+year;
			return fecha2;
			
			
		}
		
		public void scroll(int y)
		{
			//ENVIO DE LOS VALORES DE BUSQUEDA EN EL NAVEGADOR 
			JavascriptExecutor js = (JavascriptExecutor) driver;
	    	// This  will scroll down the page by  1000 pixel vertical        
			js.executeScript("window.scrollBy(0,"+y+")");
		}
		
		public void captureScreen(File rutaCarpeta) throws Exception
		{
			//
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
			
		}
		public List<WebElement> listaElementos(By locator) throws Exception
        {
          
            List<WebElement> elemento=driver.findElements(locator);
            return elemento;
            
        }
		public void validacion(By localizador, File rutaCarpeta, String generarEvidencia) {
		    try {
		        driver.findElement(localizador).isEnabled();
		        click(localizador,rutaCarpeta,generarEvidencia);
		    }catch (Exception e){
		        System.out.println(e);
		    }
		}
		
		//METODO BORRAR
        public void borrartxt (By locator, File rutaCarpeta, String evidencia) throws Exception
            {
                driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
                captureScreen(rutaCarpeta, locator, evidencia);
            }
		
      //METODO PARA UN SELECT 
    	public void select(By locator, String pais, File rutaCarpeta) throws Exception
    	{
    		Select paisList = new Select(driver.findElement(locator));
    		paisList.selectByValue(pais);
    		
    	}
		
		
}
