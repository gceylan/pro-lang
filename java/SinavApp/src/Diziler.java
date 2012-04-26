import javax.swing.JOptionPane;


public class Diziler {
	
	public float[] sirala(float[] dizi) {
		
		for (int i = 0; i < dizi.length; i++) {
			for (int j = 1; j < dizi.length - 1; j++) {
				if (dizi[i] < dizi[j]) {
					float temp = dizi[i];
					dizi[i] = dizi[j];
					dizi[j] = temp;
				}
			}
		}
		
		return dizi;
	}
	
	public void ekranaYaz(float[] dizi) {
		for(int i = 0; i < dizi.length; i++) {
			System.out.println(dizi[i] + ", ");
		}
	}
	
	public static void main(String[] args) {
		Diziler d = new Diziler();
		
		float [] dizim = new float[10];
		
		for (int i = 0; i < dizim.length; i++) {
			dizim[i] = Float.parseFloat(JOptionPane.showInputDialog("bir sayi girin: "));
		}
		
		dizim = d.sirala(dizim);
		d.ekranaYaz(dizim);
	}

}
