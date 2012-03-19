import javax.swing.*;

public class DizideAra {
	public static void main(String[] args) {
		final int size = 10;
		int i = 0;
		int[] myArray = new int[size];
		String strArray = "";
		
		for (i=0; i < size; i++) {
			int randSayi = (int) (Math.random() * 100);
			myArray[i] = randSayi;
			if (i != size - 1)
				strArray += randSayi + " - ";
			else
				strArray += randSayi;
		}
		
		int aranan = Integer.parseInt(JOptionPane.showInputDialog(null, "Aranacak sayı:", "Sayı Girişi", 1));
		
		for (i=0; i < size; i++) {
			if (myArray[i] == aranan) {
				JOptionPane.showMessageDialog(null, "Seçilen dizi: " + strArray
						+ "\nAranan Sayı: " + aranan + "\nSonuç: Sayı bulundu!", "Sonuç", 1);
				return;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Seçilen dizi: " + strArray
				+ "\nAranan Sayı: " + aranan + "\nSonuç: Sayı bulunamadı!", "Sonuç", 1);
		System.exit(0);
	}
}
