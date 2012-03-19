
public class EnumKullanimi {
	public enum Gunler {
		Pazartesi, Salı, Çarşamba, Perşembe, Cuma, Cumartesi, Pazar
	};
	public static void main(String[] args) {
		int n = 1;
		for (Gunler gun: Gunler.values()) {
			System.out.println(n + ". gün -> " + gun);
			n++;
		}
	}
}
