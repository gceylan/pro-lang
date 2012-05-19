
public class Ikizkenar extends Ucgen {

	public Ikizkenar(int x, int y, int z) {
		super(x, y, z);
		
		if (x != y && x != z) {
			System.out.println("Bu bir İkizkenar Uçgen değil!");
			System.exit(0);
		}
		System.out.println("Bu bir İkizkenar Üçgen!");
	}
	
	public double alan() {
		double A = 0;
		
		if (x == y) {
			A = Math.pow(Math.pow(x, 2) + Math.pow(z/2.0, 2), 0.5) * z / 2.0;
		}
		else if (y == z ) {
			A = Math.pow(Math.pow(y, 2) + Math.pow(x/2.0, 2), 0.5) * x / 2.0;
		}
		else {
			A = Math.pow(Math.pow(x, 2) + Math.pow(y/2.0, 2), 0.5) * y / 2.0;
		}
		
		return A;
	}	
}