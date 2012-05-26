import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class Zaman {
	public static String Now() 	{
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
	    String strTime = sdf.format(now);
	    //System.out.println("Time: " + strTime);
	    return strTime;
	}

	public Date convertToDate(String s) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		ParsePosition pos = new ParsePosition(0);
		Date utilDate = dateFormat.parse(s, pos);
		return utilDate;
	}
	
	public static void main(String[] args) {
		Zaman z = new Zaman();
		
		long l1 = z.convertToDate("30-05-2004").getTime();
		long l2 = z.convertToDate("31-05-2006").getTime();

		System.out.println("Kaç gün var ? : " + ((l2-l1)/(1000*60*60*24)));
	}
}