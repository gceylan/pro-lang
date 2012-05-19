import java.util.Scanner;


public class PramitSayýlar {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Piramit için bir deðer girin: ");
		int n = input.nextInt();
		
		int orta = n * 2 - 1 / 2;
		
		for(int x = 0; x <= n; x++) {
			for (int i = x; i < orta; i++) {
				System.out.print(" ");
			}
			
			String output = "";
			
			
			// piramitin sag tarafi
			for (int j = 1; j <= x; j++) {
				output += " " + j; 
			}
			
			
			System.out.println(output);
		}
		
	}
}
