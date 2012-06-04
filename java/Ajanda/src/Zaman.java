import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class Zaman {
	public static String Now() 	{
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
	    String strTime = sdf.format(now);
	    //System.out.println("Time: " + strTime);
	    return strTime;
	}

	public Date convertToDate(String s) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date utilDate = dateFormat.parse(s, pos);
		return utilDate;
	}
	
	public static boolean kacSaatKacDkVar(String date) {
		Zaman z = new Zaman();
		long l1 = z.convertToDate(Zaman.Now()).getTime();
		long l2 = z.convertToDate(date).getTime();
		
		System.out.println(Zaman.Now());
		
		int gun = 0, saat = 0, dk = 0;
		
		gun = (int)(l2-l1)/(1000*60*60*24);
		
		saat = (int)(l2 - l1) / ( 1000 * 60);
		
		while ( saat > 60 ) {
			dk += saat % 60;
			saat /= 60;
		}
		
		System.out.println(((gun == 0) ? "" : gun + " gün, ")
				+ ((saat == 0) ? "" : saat + " saat ")
				+ ((dk == 0) ? "" : dk + " dk")
				+ " var");
		
		return saat == 1 && dk == 0;
	}
	
	public static void main(String[] args) {
		Zaman z = new Zaman();
		
		long l1 = z.convertToDate("31-05-2012 12:20:00").getTime();
		long l2 = z.convertToDate("31-06-2012 15:30:00").getTime();

		System.out.println("Kaç gün var  ?  : " + ((l2-l1)/(1000*60*60*24)));
		//System.out.println("Kaç saat var ?  : " + ((l2 - l1) / ( 1000 * 60)));
		//kacSaatKacDkVar("03-06-2012 03:46:45");
	}
}