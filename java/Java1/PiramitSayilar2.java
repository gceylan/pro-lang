import java.util.Scanner;


public class PiramitSayilar2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Piramit için bir deðer girin: ");
		int n = input.nextInt();
		
		if (0 < n && n > 20) {
			System.out.println("( 0 - 10 ) aralýðýnda bir deðer giriniz.");
			System.exit(0);
		}
		
		int orta = n * 2 - 1 / 2;
		
		for(int x = 0; x <= n; x++) {
			for (int i = x; i < orta; i++) {
				System.out.print("   ");
			}
			
			String output = "";
			
			// sol piramit
			for (int j = x; 0 < j; j--) {
				output += j >= 10 ? " " + j : "  " + j;
			}
			
			for (int k = 2; k <= x; k++) {
				output += k >= 10 ? " " + k : "  " + k;
			}
			
			
			
			System.out.println(output);
		}
		
	}
}
