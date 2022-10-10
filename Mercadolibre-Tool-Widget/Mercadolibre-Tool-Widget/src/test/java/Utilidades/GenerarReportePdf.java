package Utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.itextpdf.text.Document;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ClaseBase.ClasesBase;

public class GenerarReportePdf {

	
	static String nombre="prueba";
	static String fecha;
	static Document documento;
	static FileOutputStream archivo;
	static Paragraph titulo;
	String rutaImagen;
	String hora;
	String horaIni, horaFin;
	
	public void setRutaImagen(String rutaImagen)
	{
		this.rutaImagen= rutaImagen;
	}
	
	public void crearPlantilla (String nomTest, File rutaCarpeta)
	{
		//INSTANCIAR DOCUMENTO
		documento= new Document();
		
		//TOMAR LA HORA DEL SISTEMA
		hora = ClasesBase.fechaHora();
		horaIni = ClasesBase.fechaHoraDos();
		
		try 
		{
			//CREAR RUTA Y NOMBRE DEL PDF
			archivo = new FileOutputStream(rutaCarpeta+"\\"+"Reporte-"+nomTest +"-"+ hora + ".pdf");
			PdfWriter.getInstance(documento, archivo);
			
			//*****CREAR ENCABEZADO 
			//UBICACION DE LA IMAGEN
			Image header = Image.getInstance(rutaImagen);
			//TAMAÑO DE LA IMAGEN AJUSTAR A MI TELEFONO
			header.scaleToFit(200,200);
			//header.setAlignment(Chunk.ALING_CENTER);
			header.setWidthPercentage(100);
			
			//CREAR TITULO DEL PDF
			titulo = new Paragraph(nomTest + "\n\n" + "Fecha inicio:   " + horaIni );
			titulo.setAlignment(1);
			
			//CREAR TABLA DE ENCABEZADO
			PdfPTable table= new PdfPTable(2);
			table.setWidthPercentage(100);
			
			PdfPCell pos1 = new PdfPCell(header);
			pos1.setHorizontalAlignment(1);
			pos1.setVerticalAlignment(2);
			
			PdfPCell pos2 = new PdfPCell(titulo);
			pos2.setHorizontalAlignment(1);
			pos2.setVerticalAlignment(2);
			
			table.addCell(pos2);
			table.addCell(pos1);
			
			//GENERAR MARGEN
			documento.setMargins(30, 30, 30, 30);
			//ABRIR DOCUMENTO
			documento.open();
			
			//INSERTAR LA IMAGEN
			documento.add(table);
			
			documento.add(Chunk.NEWLINE);
		}
		catch(FileNotFoundException e)
		{
			System.err.println(e.getMessage());
		}
		catch(DocumentException e)
		{
			System.err.println(e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("Error al logo de DemoQa: "+e.getMessage());
		}
	}
	
	public void crearBody(By locator, String rutaImagen) throws DocumentException, MalformedURLException, IOException
	{
		
		//OBTENER NOMBRE DEL LOCALIZADOR
		String locator1=locator.toString();
		//DAR FORMATO A LA FUENTE 
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_LEFT);
		parrafo.setFont(FontFactory.getFont("Arial",10,Font.NORMAL));
		parrafo.add("Se realiza accion sobre el elemento: "+locator1);
		
		//ADICIONAR MENSAJE AL PDF
	//	documento.add(parrafo);
		
		//INSERTAR UNA IMAGEN
		//UBICACION DE LA IMAGEN
		Image imagen = Image.getInstance(rutaImagen);
		imagen.setBorderColor(BaseColor.BLACK);
		
		//TAMAÑO DE LA IMAGEN
		imagen.scaleToFit(500,1600);
		
		imagen.setAlignment(Chunk.ALIGN_CENTER);
		//documento.add(imagen);
		
		// INSERTAMOS SALTO DE LINEA
		//Paragraph saltoDeLinea = new Paragraph("                                                                                                                                                                                                                                                                                                                                                                                   ");
		//documento.add(saltoDeLinea);
		
		// INSERTAMOS SALDO DE LINEA
		Paragraph saltoDeLinea = new Paragraph("                                                                                                                                                                                                                                                                                                                                                                                   ");
		//CREAMOS UNA TABLA
		PdfPTable tb = new PdfPTable(1);
		//CREAMOS UNA CELDA
		PdfPCell c1= new PdfPCell();
		c1.setBorder(0);
		c1.setIndent(1);
		//AGREGAMOS EL TEXTO Y LA IMAGEN A LA CELDA
		c1.addElement(parrafo);
		c1.addElement(saltoDeLinea);
		c1.addElement(imagen);
		//ANEXAMOS LA CELDA A LA TABLA
		tb.addCell(c1);
		
		//ANEXAMOS LA TABLA AL DOCUMENTO
		documento.add(tb);
		documento.add(saltoDeLinea);
	}
	
	public void crearbodyError(By locator, String rutaImagen, String msnError) throws DocumentException, MalformedURLException, IOException
	{
		//OBTENER EL NOMBRE DEL LOCALIZADOR 
		String locator1= locator.toString();
		//DAR FORMATO A LA FUENTE
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_LEFT);
		parrafo.setFont(FontFactory.getFont("Arial",10,Font.NORMAL));
		parrafo.add("Se realiza accion sobre el elemento: "+locator1);
		//ADICIONAR MENSAJE AL PDF
		documento.add(parrafo);
		
		//INSET IMAGEN 
		//UBICACION DE LA IMAGEN 
		Image imagen = Image.getInstance(rutaImagen);
		//TAMAÑO DE LA IMAGEN 
		imagen.scaleToFit(1000,1000);
		imagen.setAlignment(Chunk.ALIGN_LEFT);
		documento.add(imagen);
		
		// MENSAJE ERROR
		//DAR FORMATO A LA FUENTE
		Paragraph parrafoError = new Paragraph();
		parrafoError.setAlignment(Chunk.ALIGN_LEFT);
		parrafoError.setFont(FontFactory.getFont("Arial",8,Font.NORMAL,BaseColor.BLACK));
		parrafoError.add("EL MENSAJE DE ERROR:  "+"\n"+msnError);
		documento.add(parrafoError);		
	}
	
	public void cerrarPlantilla() throws DocumentException
	{
		documento.add(Chunk.NEWLINE);
		//DAR FORMATO A LA FUENTE
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_RIGHT);
		parrafo.setFont(FontFactory.getFont("Arial",10,Font.BOLD));
		parrafo.add("Fecha inicio:   "+horaIni+"\n");
		
		//ADICIONAR MENSAJE AL PDF
		//documento.add(parrafo);
		horaFin = ClasesBase.fechaHoraDos();
		parrafo.add("Fecha fFin:  "+horaFin);
		
		//ADICIONAR MENSAJE AL PDF
		documento.add(parrafo);
		documento.close();
	}
		
}
