import java.util.Scanner;


public class SwitchCase {

	public static void main(String[] args) {
		int gun;
		
		System.out.print("Gün deðerini sayý olarak" + 
					" (1 - 7) giriniz : ");
		
		Scanner scan = new Scanner(System.in);
		gun = scan.nextInt();
		
		switch(gun) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("Hafta içi bir gün!");
			break;
		case 6:
		case 7:
			System.out.println("Hafta sonu bir gün!");
			break;
		default:
			System.out.println("Geçersiz bir deðer girdiniz!");
			break;
		}
	}
}
