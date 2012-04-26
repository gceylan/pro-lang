
public class Game2 extends Game {
	
	public Game2() {
		super();
	}
	
	/*//@overload
	public boolean sayiyiKarsilastir(int tahminEdilen) {
		boolean b;
		
		int fark = rastgeleSayi - tahminEdilen;
		
		if (fark == 0)
			b = true;
		else
			b = false;
		
		return b;
	}*/
	
	//@override
	public int sayiyiKarsilastir(int tahminEdilen) {
		int fark = rastgeleSayi - tahminEdilen;
		return fark;
	}
}
