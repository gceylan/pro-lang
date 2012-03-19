
public class EnumAylar {
	public enum Aylar {
		Ocak, Şubat, Mart, Nisan, Mayıs, Haziran, Temmuz, Ağustos, Eylül, Ekim, Kasım, Aralık
	};
	public static void main(String[] args) {
		int sira = 0;
		for (Aylar ay: Aylar.values()) {
			sira = ay.ordinal() + 1; 	//enum indexini verir
			System.out.println(sira + ". ay ----> " + ay);
		}
	}

}
