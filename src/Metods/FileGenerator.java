package Metods;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import WindowBuilder.GeneralProperties;


public class FileGenerator {
	
	private File fileIn;
	private File fileOut;
	private String fileLocalisation;
	private String skipError;
	private PartXmlGenerator[] PXG;
	private String startRecord;
	private GeneralProperties properties;
	

	
	public FileGenerator(File fileIn, String fileLocalisation, boolean b, PartXmlGenerator[] PXG, GeneralProperties properties) throws FileNotFoundException {
		super();
		this.fileIn = fileIn;
		this.fileLocalisation = fileLocalisation;
		this.skipError = b;
		this.PXG=PXG;
		this.properties = properties;
			
		String  fileOutName = "generateBy_UfXmlGen.xml";

		throw new FileNotFoundException("B£¥D PRZY OTWIERANIU PLIKU!");		
	}
	
	public void PutToFile(String PartOfxml, PrintStream printStream) {
		Scanner scanner = new Scanner(System.in);
		try {
			while(scanner.hasNext() && !(PartOfxml = scanner.next()).equals("stop")) {
			    printStream.println(PartOfxml);
			   }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void CallGenerate() {
		
		try {
			  
			   FileReader fileReader = new FileReader(fileIn);
			   PrintStream printStream = new PrintStream(fileOut);
			   BufferedReader bufferReader = new BufferedReader(fileReader);
			   String applicatinNumber;
			   
			   //zapis do pliku podstawowych parametrów
			   PutToFile(properties.GenerateRecord(), printStream);
			   
			   //zapis do pliku poszczególnych rekordów	
			   while((applicatinNumber = bufferReader.readLine()) != null) {
				   for(int i=0; PXG.length<i; i++) {
					   PutToFile(PXG[i].GeneratePart(),printStream);
					}
			   }
			   PutToFile("</WorkflowTest>", printStream);
			   
			   fileReader.close();
			   printStream.close();
			  }
			  catch (FileNotFoundException e) {
			   e.printStackTrace();
			  } 
			  catch (IOException e) {
			   e.printStackTrace();
			  }
			 
	}
	
	
}
