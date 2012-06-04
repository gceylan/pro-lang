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
	
	public String kacSaatKacDkVar(String date) { 
		Zaman z = new Zaman();
		
		long l1 = z.convertToDate(Zaman.Now()).getTime();
		long l2 = z.convertToDate(date).getTime();
		
		long gun  = ((l2-l1) / (1000*60*60*24));
		long saat = ((l2-l1) / (1000 * 60 * 60));
		long dk = ((l2-l1) / (1000 * 60));
		long sn = (l2-l1) / 1000;
		
		String neKadar = "" + 
				((gun == 0) ? "" : gun + " gün ") +
				(((saat % 60) == 0) ? "" : (saat % 60) % 24 + " sa ") +
				(((dk % 60) == 0) ? "" : dk % 60 + " dk ") + sn % 60 + " sn";
		
		return neKadar;
	}
	
	public double kacSaatVar(String date) {
		Zaman z = new Zaman();
		
		long l1 = z.convertToDate(Zaman.Now()).getTime();
		long l2 = z.convertToDate(date).getTime();
		
		long saat = ((l2-l1) / (1000 * 60 * 60));
		long dk = ((l2-l1) / (1000 * 60)) % 60;

		return saat + dk / 100.0;
	}
	
	public static void main(String[] args) {
		Zaman z = new Zaman();
		
		System.out.println(z.kacSaatKacDkVar("04-06-2012 23:30:59"));
		System.out.println(z.kacSaatVar("04-06-2012 23:30:59"));
	}
}