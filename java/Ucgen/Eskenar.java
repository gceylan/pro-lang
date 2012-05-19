
public class Eskenar extends Ucgen {
	public Eskenar(int x, int y, int z) {
		super(x, y, z);
		
		if (x != y) {
			System.out.println("Bu bir Eşkenar Üçgen değil!");
			System.exit(0);
		}
		System.out.println("Bu bir Eşkenar Üçgen!");
	}
	
	public double alan() {
		return Math.pow(x, 2) * Math.pow(3, 0.5) / 4;
	}
	
}
