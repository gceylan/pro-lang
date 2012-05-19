
public class Ucgen {
	int x, y, z;
	
	public Ucgen(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		System.out.println("Bir Üçgen Oluşturuldu.(x: " + x + ", y: " + y + ", z: " + z + ")");
	}
	
	public int cevre() {
		return x + y + z;
	}
}
