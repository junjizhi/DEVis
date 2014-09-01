package junji;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import kevin.util.DateUtil;



public class ExcelDataReader 
{
	final private String fileName;
//	final private int Total_Cell_Num_in_Row = 6;
	
	protected int curRowNum = 2;
	protected boolean readFileSuccess = false;
	
	protected Sheet sheet = null;
	
	protected int rowNumToRead ;
	protected int rowThatHasBeenRead = 0;
	
	protected int curDate;
	
	public ExcelDataReader(String fileName,int lntr)
	{
		this.fileName = fileName;
		rowNumToRead = lntr;
		init();
	}
	
	protected void init()
	{
		try
		{
		InputStream inp = new FileInputStream(fileName);

	    Workbook wb = WorkbookFactory.create(inp);
	    sheet = wb.getSheetAt(0);
	  
		}
		catch(Exception e){
			System.out.println("Exception catched.");
			e.printStackTrace();
			readFileSuccess = false;
		}
	   
		readFileSuccess = true;
	}
	
	private int getIntFromCell(Cell cell)
	{
		
		  return (int)(cell.getNumericCellValue());
	}
	
	public Log nextLog()
	{
		Log log = null;
		
		
		if(readFileSuccess && rowThatHasBeenRead < rowNumToRead)
		{
			  Row row = sheet.getRow(curRowNum);
			  
			  long dayDuration = getDayDuration(curRowNum);
			  
			  Cell cell = row.getCell(1); 
			  
			  Date date = getDateFromCell(cell);
			  
			  cell = row.getCell(2);  
			  int changedWordNum = getIntFromCell(cell);
			  
			  cell = row.getCell(3);
			  int addeddWordNum = getIntFromCell(cell);
			 
			  cell = row.getCell(4);
			  int deleteddWordNum = getIntFromCell(cell);
			 
			  cell = row.getCell(5);
			  int visitNum = getIntFromCell(cell);
			  
			  log = new Log(changedWordNum,addeddWordNum,deleteddWordNum,visitNum);
			  log.setDaysToLast(dayDuration);
			  log.setDate(date);
			  curRowNum++;
			  rowThatHasBeenRead++;
		}
		
		return log;
	}
	
	private Date getDateFromCell(Cell cell) {
		// TODO Auto-generated method stub
//		if(cell.getCellType() != cell.)
		
		return cell.getDateCellValue();
//		return null;
	}

	private long getDayDuration(int curRowNum){
		  Row row = sheet.getRow(curRowNum);
		  
		  Cell cell = row.getCell(1); 
		  
		  Date prevDate = getDateFromCell(cell);
		  
		  Row nextRow = sheet.getRow(curRowNum+1);
		  
		  cell = nextRow.getCell(1); 
		  
		  Date laterDate = getDateFromCell(cell);
		  
		  Calendar startDate = new GregorianCalendar();
		  startDate.setTime(prevDate);
		  
		  Calendar endDate = new GregorianCalendar();
		  endDate.setTime(laterDate);
		  
//		  print("prevDate: "+DateUtil.getCalStr(startDate));
//		  print("laterDate: "+DateUtil.getCalStr(endDate));
		  
		  return DateUtil.daysBetween(startDate,endDate);
	}
	
	/** Using Calendar - THE CORRECT WAY**/
	//assert: startDate must be before endDate
	
	
	public static void print(String str)
	{
		System.out.println(str);
	}
	
//	private static void testDaysBetweenMethod()
//	{
//		print("Testing daysBetween function");
//	}
	
	public static void main(String args[])
	{
		
		
		
//		ExcelDataReader rd = new ExcelDataReader(10);
//		Log l = rd.nextLog();		
//		System.out.println(l.toString());
//		
//		l = rd.nextLog();		
//		System.out.println(l.toString());
//		
//		l = rd.nextLog();		
//		System.out.println(l.toString());
	}
	
}
