import javax.swing.JOptionPane;


public class GameTest2 {
	
	public static void main(String[] args) {
		Game2 g2 = new Game2();
		int fark;
		
		do {
			int tahmin = Integer.valueOf(JOptionPane.showInputDialog("sayiyi giriniz"));
			fark = g2.sayiyiKarsilastir(tahmin);
			if (fark == 0) {
				System.out.println("Tebrikler! Doðru tahmin...");
				break;
			}
			else if (fark > 0)
				System.out.println("Sayýyý büyültün");
			else
				System.out.println("sayýyý küçültün");
			
		} while (fark != 0);
	}

}
