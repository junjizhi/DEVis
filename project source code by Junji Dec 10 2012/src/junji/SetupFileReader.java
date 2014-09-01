package junji;

import java.io.*;
import java.util.*;


public class SetupFileReader {

	private Color ChangedWordColor=null;
	private Color AddedWordColor=null;
	private Color DeletedWordColor=null; 
	private Color SpiralLineColor=null;
	private String DocXclsFilePath =null;
	
	public Color getChangedWordColor() {
		return ChangedWordColor;
	}

	public void setChangedWordColor(Color changedWordColor) {
		ChangedWordColor = changedWordColor;
	}

	public Color getAddedWordColor() {
		return AddedWordColor;
	}

	public void setAddedWordColor(Color addedWordColor) {
		AddedWordColor = addedWordColor;
	}

	public Color getDeletedWordColor() {
		return DeletedWordColor;
	}

	public void setDeletedWordColor(Color deletedWordColor) {
		DeletedWordColor = deletedWordColor;
	}

	public Color getSpiralLineColor() {
		return SpiralLineColor;
	}

	public void setSpiralLineColor(Color spiralLineColor) {
		SpiralLineColor = spiralLineColor;
	}

	public String getDocXclsFilePath() {
		return DocXclsFilePath;
	}

	public void setDocXclsFilePath(String docXclsFilePath) {
		DocXclsFilePath = docXclsFilePath;
	}

	public float getThetaspeed() {
		return Thetaspeed;
	}

	public void setThetaspeed(float thetaspeed) {
		Thetaspeed = thetaspeed;
	}

	public float getRspeed() {
		return Rspeed;
	}

	public void setRspeed(float rspeed) {
		Rspeed = rspeed;
	}

	public String getSetupFileName() {
		return SetupFileName;
	}

	public void setSetupFileName(String setupFileName) {
		SetupFileName = setupFileName;
	}

	private float Thetaspeed, Rspeed ;
	
	
	private int logNumToRead;
	public int getLogNumToRead() {
		return logNumToRead;
	}

	public void setLogNumToRead(int logNumToRead) {
		this.logNumToRead = logNumToRead;
	}

	private String SetupFileName;	
	
	private float textLeading ;
	
	public float getTextLeading() {
		return textLeading;
	}

	public void setTextLeading(float textLeading) {
		this.textLeading = textLeading;
	}

	public static SetupFileReader getSetupFileReader(String fileName)
	{
		return new SetupFileReader(fileName);
	}
	
	public static SetupFileReader getSetupFileReader()
	{
		return new SetupFileReader();
	}
	
	private SetupFileReader(){
		this("setup.txt");	//by default the setup file is setup.txt
	}
	
	private SetupFileReader(String fileName){
		SetupFileName = fileName;
		File file = new File(SetupFileName);
		try {
			Scanner scanner = new Scanner(file, "UTF-8");
			
			String line = scanner.nextLine();//skip a word
			String[] spilts = line.split(" ");
			DocXclsFilePath = spilts[1];
			
			scanner.next();	//skip a word
			logNumToRead = scanner.nextInt();
			
			scanner.next();	//skip a word
			this.textLeading = scanner.nextFloat();
			
			scanner.next();	//skip a word
			this.SpiralLineColor = new Color(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
			
			scanner.next();	//skip a word
			this.ChangedWordColor = new Color(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
			
			scanner.next();	//skip a word
			this.AddedWordColor = new Color(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
			
			scanner.next();	//skip a word
			this.DeletedWordColor = new Color(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
			
			scanner.next();	//skip a word
			this.Thetaspeed  = scanner.nextFloat();
			
			scanner.next();	//skip a word
			this.Rspeed  = scanner.nextFloat();
			
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Setup File Not found");
		}
	}
	
	public static void main(String args[]){
		SetupFileReader sfr= getSetupFileReader();
		System.out.println(sfr.getDocXclsFilePath());
		System.out.println(sfr.getTextLeading());
		
	}
}
