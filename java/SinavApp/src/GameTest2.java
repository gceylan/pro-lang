import javax.swing.JOptionPane;


public class GameTest2 {
	
	public static void main(String[] args) {
		Game2 g2 = new Game2();
		int fark;
		
		do {
			int tahmin = Integer.valueOf(JOptionPane.showInputDialog("sayiyi giriniz"));
			fark = g2.sayiyiKarsilastir(tahmin);
			if (fark == 0) {
				System.out.println("Tebrikler! Do�ru tahmin...");
				break;
			}
			else if (fark > 0)
				System.out.println("Say�y� b�y�lt�n");
			else
				System.out.println("say�y� k���lt�n");
			
		} while (fark != 0);
	}

}
