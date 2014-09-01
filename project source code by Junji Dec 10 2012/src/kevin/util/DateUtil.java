package kevin.util;

import java.util.Calendar;


//Date utilities class
public class DateUtil {
	public static String getCalStr(Calendar calendar) {
		// TODO Auto-generated method stub
		int year       = calendar.get(Calendar.YEAR);
		int month      = calendar.get(Calendar.MONTH); 
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // Jan = 0, not 1
		int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
//		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
//		int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);
		
		String str = "";
		str += year;
		str += '-';
		str += (month+1);
		str += '-';
		str += dayOfMonth;
		str += ", ";
		str += getDateOfWeekStr(dayOfWeek);
		//str += ' ';
		return str;
	}
	private static String getDateOfWeekStr(int dayOfWeek) {
		// TODO Auto-generated method stub
		String dStr = null;
		
		switch(dayOfWeek)
		{
		case 1:
			dStr = "Sunday";
			break;
		case 2:
			dStr = "Monday";
			break;
		case 3:
			dStr = "Tuesday";
			break;
		case 4:
			dStr = "Wednesday";
			break;
		case 5:
			dStr = "Thursday";
			break;
		case 6:
			dStr = "Friday";
			break;
		case 7:
			dStr = "Saturday";
			break;
		}
		
		
		return dStr;
	}
	
	public static long daysBetween(Calendar startDate, Calendar endDate) {
		  Calendar date = (Calendar) startDate.clone();
		  long daysBetween = 0;
		  while (date.before(endDate)) {
		    date.add(Calendar.DAY_OF_MONTH, 1);
		    daysBetween++;
		  }
		  return daysBetween;
		}
	
	public static void print(float s){
		System.out.println(s);
	}
	
	//sort an array of length of three
	private static float[] sort(float[] fs) {
		// TODO Auto-generated method stub
		float[] ret = new float[3];
		
		ret[0] = fs[0]>fs[1] && fs[0]>fs[2]? fs[0]: (fs[1]>fs[2]?fs[1]:fs[2]);
		ret[2] = fs[0]<fs[1] && fs[0]<fs[2]? fs[0]: (fs[1]<fs[2]?fs[1]:fs[2]);
		ret[1] = fs[0] != ret[0] && fs[0]!= ret[2]? fs[0]: (fs[1] != ret[0] && fs[1]!= ret[2]? fs[1]:fs[2]);
		
		return ret;
	}
	
	public static void main(String[] args) {
		float[] fs = {3.0f, 20000.0f, 344.0f};
		float [] ret = sort(fs);
		print(ret[0]);print(ret[1]);print(ret[2]);
	}
}
