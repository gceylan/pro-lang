import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class Zaman {
	public static String Now() 	{
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
	    String strTime = sdf.format(now);
	    return strTime;
	}

	public Date convertToDate(String s) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date utilDate = dateFormat.parse(s, pos);
		return utilDate;
	}
	
	public void kacSaatKacDkVar(String date) { 
		Zaman z = new Zaman();
		
		long l1 = z.convertToDate(Zaman.Now()).getTime();
		long l2 = z.convertToDate(date).getTime();
		
		long gun  = ((l2-l1) / (1000*60*60*24));
		long saat = ((l2-l1) / (1000 * 60 * 60));
		long dk = ((l2-l1) / (1000 * 60));
		long sn = (l2-l1) / 1000;
		
		System.out.println(
				((gun == 0) ? "" : gun + " gün ") +
				(((saat % 60) == 0) ? "" : (saat % 60) % 24 + " saat ") +
				(((dk % 60) == 0) ? "" : dk % 60 + " dakika ") +
				sn % 60 + " sn var.");
	}
	
	public static void main(String[] args) {
		Zaman z = new Zaman();
		
		z.kacSaatKacDkVar("04-06-2012 20:20:20");
		
		/*long l1 = z.convertToDate("04-06-2012 12:20:00").getTime();
		long l2 = z.convertToDate("04-07-2012 12:30:00").getTime();

		System.out.println("Kaç gün var?    : " + ((l2-l1) / (1000*60*60*24)));
		System.out.println("Kaç saat var?   : " + ((l2-l1) / (1000 * 60 * 60)));
		System.out.println("Kaç dakika var? : " + ((l2-l1) / (1000 * 60)));
		System.out.println("Kaç saniye var? : " + ((l2-l1) / (1000)));
		
		l1 = z.convertToDate("04-06-2012 10:00:00").getTime();
		l2 = z.convertToDate("04-06-2012 15:30:00").getTime();

		System.out.println("Kaç gün var?    : " + ((l2-l1) / (1000*60*60*24)));
		System.out.println("Kaç saat var?   : " + ((l2-l1) / (1000 * 60 * 60)));
		System.out.println("Kaç dakika var? : " + ((l2-l1) / (1000 * 60)));
		System.out.println("Kaç saniye var? : " + ((l2-l1) / (1000)));*/
	}
}