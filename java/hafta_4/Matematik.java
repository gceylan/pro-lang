
public class Matematik {
	public double TopLa(double x, double y) {
		return x + y;
	}
	public double Cikart(double x, double y) {
		return x - y;
	}
	public double Carp(double x, double y) {
		return x * y;
	}
	public double BoL(double x, double y) {
		return x / y;
	}
	public int UstAL(int sayi, int us) {
		if (us == 0)
			return 1;
		else
			return sayi * UstAL(sayi, us - 1);
	}
}