import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SimpleDotComTestDrive2 {
	public static void main(String[] args) {
		SimpleDotCom2 dot = new SimpleDotCom2();
		ArrayList<Integer> locations = dot.myArr;
		
		dot.setNumOfHits(0);	//numOfHits' i set metoduyla 0' a set ettik.
		String userGuess = "-2";
		String result;
		int total = 0;
		boolean durum = false;
		double basari = 0;
		
		//Cevaplarý bilerek çözmek için aþaðýdaki satýrýn commentini kaldýrýn :)
		//System.out.println(dot.stringNumberOfArray);

		while (!userGuess.equals("-1") && (total < 5)) {
			userGuess = JOptionPane.showInputDialog(null, "Tahmininiz?(0 - 10)");
			result = dot.checkYourSelf(userGuess);
			total++;
			if (dot.getNumOfHits() == 3) {
				durum = true;
				basari = 300 / total;
				JOptionPane.showMessageDialog(null, "Tebrikler! 3 hit(1 kill) yaptýnýz!\nBaþarý: %" + basari, "bilgi", 1);
				break;
			}
		}
		
		if (total == 5 && durum == false) {
			basari = 20 * dot.getNumOfHits();
			JOptionPane.showMessageDialog(null, "Hakkýnýz doldu!\nSeçilen Sayýlar: " + dot.stringNumberOfArray + "\nBaþarý: %" + basari);
		}
	}
}
