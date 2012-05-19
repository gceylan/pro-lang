
public class Program {
	public static void main(String[] args) {
		Ucgen u1 = new Ucgen(1, 2, 3);
		System.out.println("adı -> u1 : \nçevre: " + u1.cevre());
		
		System.out.println("------------------------------------");
		
		Eskenar u2 = new Eskenar(5, 5, 5);
		System.out.println("adı -> u2 : \nçevre :" + u2.cevre() + 
				"\nalan  : " + u2.alan());
		
		System.out.println("------------------------------------");
		
		Ikizkenar u4 = new Ikizkenar(3, 3, 5);
		System.out.println("adı -> u4 : \nçevre :" + u4.cevre() + 
				"\nalan  : " + u4.alan());
		
		System.out.println("------------------------------------");
		
		Ikizkenar u5 = new Ikizkenar(4, 5, 6);
		
		Eskenar u3 = new Eskenar(5,	4, 3);
	}
}
