import java.util.Scanner;


public class SwitchCase {

	public static void main(String[] args) {
		int gun;
		
		System.out.print("G�n de�erini say� olarak" + 
					" (1 - 7) giriniz : ");
		
		Scanner scan = new Scanner(System.in);
		gun = scan.nextInt();
		
		switch(gun) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("Hafta i�i bir g�n!");
			break;
		case 6:
		case 7:
			System.out.println("Hafta sonu bir g�n!");
			break;
		default:
			System.out.println("Ge�ersiz bir de�er girdiniz!");
			break;
		}
	}
}
