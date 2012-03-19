import javax.swing.*;

public class MatematikTestDrive {
	public static void main(String[] args) {
		Matematik Mat = new Matematik();
		
		String menu = "- Toplama (+)\n- Çıkartma (-)\n" +
				"- Çarpma (*)\n- Bölme (/)\n- Üst Alma (u)\n- Çıkış (q)";
		String cikis = "Çıkmak istediğinize emin misiniz?";
		String uyari = "Yanlış işlem girdiniz!\nProgram sadece (+), (-), (*), (/), (u), (q) işlemlerini"
				+ " desteklemektedir...";
		String menuTitle = "Ana Mena";
		String islem = JOptionPane.showInputDialog(null, menu, menuTitle, 1);
		
		while (!islem.equals("q")) {
			if (islem.equals("+") || islem.equals("-") || islem.equals("*") || islem.equals("/") || islem.equals("u")) {
				String a = JOptionPane.showInputDialog(null, "Birinci Sayı:\n(Çıkış için -> (q)", "Sayı Girişi", 1);
				if (!a.equals("q")) {
					String b = JOptionPane.showInputDialog(null, "İkinci Sayı:\n(Çıkış -> (q))", "Sayı Girişi", 1);
					if (!b.equals("q")) {
						double dbl_a = Double.parseDouble(a);
						double dbl_b = Double.parseDouble(b);
						double sonuc = 0.0;
						
						switch (islem) {
							case "+":
								sonuc = Mat.TopLa(dbl_a, dbl_b);
								break;
							case "-":
								sonuc = Mat.Cikart(dbl_a, dbl_b);
								break;
							case "*":
								sonuc = Mat.Carp(dbl_a, dbl_b);
								break;
							case "/":
								sonuc = Mat.BoL(dbl_a, dbl_b);
								break;
							case "u":
								int int_a = (int) dbl_a;
								int int_b = (int) dbl_b;
								sonuc = Mat.UstAL(int_a, int_b);
								break;
							default:
								JOptionPane.showMessageDialog(null, "HATA! Buraya hiç gelmemeliydin!\n" +
									"(Not: İşlem kısmına +, -, *, /, u, q dışında bir parametre giremezsiniz!)");
						}
						
						JOptionPane.showMessageDialog(null, dbl_a + " " + islem + " " + dbl_b +
								" = ?\nSonuç = " + sonuc , "Sonuç", 1);
						islem = JOptionPane.showInputDialog(null, menu, menuTitle, 1);
						
						if (islem.equals("q")) {
							int exit1 = JOptionPane.showConfirmDialog(null, cikis, "Çıkış Ekranı", 1);
							if (exit1 != 0)
								islem = JOptionPane.showInputDialog(null, menu, menuTitle, 1);
						}					
				} else {
					int exit2 = JOptionPane.showConfirmDialog(null, cikis, "Çıkış Ekranı", 1);
					if (exit2 != 0)
						islem = JOptionPane.showInputDialog(null, menu, menuTitle, 1);
					else
						break;
				}
			} else {
				int exit3 = JOptionPane.showConfirmDialog(null, cikis, "Çıkış Ekranı", 1);
				if (exit3 != 0)
					islem = JOptionPane.showInputDialog(null, menu, menuTitle, 1);
				else
					break;
			}
		} else {
			JOptionPane.showMessageDialog(null, uyari, "Uyarı", 0);
			islem = JOptionPane.showInputDialog(menu);
		}
		}
		JOptionPane.showMessageDialog(null, "Hoşçakalın...", "Kapat", 1);
		System.exit(0);
	}
}
