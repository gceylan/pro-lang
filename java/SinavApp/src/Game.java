
public class Game {
	int rastgeleSayi;
	
	public Game() {
		rastgeleSayi = (int)(Math.random() * 100);
	}
	
	public int sayiyiKarsilastir(int tahminEdilen) {
		return rastgeleSayi - tahminEdilen;
	}
}
