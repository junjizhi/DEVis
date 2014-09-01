package junji;

import java.util.Date;
//import java.util.Calendar;
//import java.util.GregorianCalendar;

//a javaBean-like class that holds the data for each log of document data
//one log corresponds to one row of data in the excel sheet
public class Log 
{
	protected Date date = null;
	
	  public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getDaysToLast() {
		return daysToLast;
	}

	public void setDaysToLast(long daysToLast) {
		this.daysToLast = daysToLast;
	}

	protected int changeWordCnt;
	  protected int deleteWordCnt;
	  protected int numOfVisit;
	  protected int addWordCnt;
	  protected long daysToLast;
	  
	  public Log(int c, int a,int d, int v)
	  {
	    changeWordCnt = c;
	    deleteWordCnt = d;
	    numOfVisit = v;
	    addWordCnt = a;
	  }
	  
	  //index: c: 1, a: 2, d: 3, v: 4 
	  public int getMaxIndex()
	  {
	    int m = max(changeWordCnt,deleteWordCnt,addWordCnt);
	    if ( m == changeWordCnt)
	      return 1;
	    if ( m == addWordCnt)
	      return 2;
	    if ( m == deleteWordCnt)
	      return 3;
	    //by default, doc is changed. 
	    return 1;
	  }
	  
	  private int max(int a, int b, int c)
	  {
		  return (a>b && a>c)?a:(b>c?b:c);
	  }
	  
	  public String toString()
	  {
		  String str = "changeWordCnt: " + changeWordCnt+"\n";
		  str += "addWordCnt: " + addWordCnt+"\n";
		  str += "deleteWordCnt: " + deleteWordCnt+"\n";
		  str += "numOfVisit: " + numOfVisit+"\n";
		  str += "dayDuration: " + daysToLast+"\n";
		  str += "ChangeWordPercentage: " + getChangeWordPercentage()+"\n";
		  str += "AddWordPercentage: " + getAddWordPercentage()+"\n";
		  str += "DeleteWordPercentage: " + getDeleteWordPercentage()+"\n";
		  return str;
	  }
	  
	  public float getChangeWordPercentage()
	  {
		  float pctg = (float)changeWordCnt / (float)(changeWordCnt+addWordCnt+deleteWordCnt);
	      return pctg;
	  }
	  
	  public float getAddWordPercentage()
	  {
		  float pctg = (float)addWordCnt / (float)(changeWordCnt+addWordCnt+deleteWordCnt);
	      return pctg;
	  }
	  
	  public float getDeleteWordPercentage()
	  {
		  float pctg = (float)deleteWordCnt / (float)(changeWordCnt+addWordCnt+deleteWordCnt);
	      return pctg;
	  }

	public int getChangeWordCnt() {
		return changeWordCnt;
	}

	public void setChangeWordCnt(int changeWordCnt) {
		this.changeWordCnt = changeWordCnt;
	}

	public int getDeleteWordCnt() {
		return deleteWordCnt;
	}

	public void setDeleteWordCnt(int deleteWordCnt) {
		this.deleteWordCnt = deleteWordCnt;
	}

	public int getNumOfVisit() {
		return numOfVisit;
	}

	public void setNumOfVisit(int numOfVisit) {
		this.numOfVisit = numOfVisit;
	}

	public int getAddWordCnt() {
		return addWordCnt;
	}

	public void setAddWordCnt(int addWordCnt) {
		this.addWordCnt = addWordCnt;
	}
}
