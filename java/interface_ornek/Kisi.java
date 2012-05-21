
public class Kisi {
	private String adSoyad;
	private String dogumTarihi;
	private char cinsiyet;
	
	public Kisi() {
		// argümansız yapılandırıcı metod
		this.adSoyad = "";
		this.dogumTarihi = "";
		this.cinsiyet = ' ';
	}
	
	public Kisi(String adSoyad, String dogumTarihi, char cinsiyet) {
		// argümanlı yapılandırıcı metod
		this.setAdSoyad(adSoyad);
		this.setDogumTarihi(dogumTarihi);
		this.setCinsiyet(cinsiyet);
	}
	
	public Kisi(Kisi k) {
		// this.setAdSoyad = k.adSoyad, this.adSoyad = k.adSoyad, adSoyad = k.adSoyad
		this.setAdSoyad(k.getAdSoyad());
		this.setDogumTarihi(k.getDogumTarihi());
		this.setCinsiyet(k.getCinsiyet());
	}
	
	public char getCinsiyet() {
		return cinsiyet;
	}
	
	public void setCinsiyet(char cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	
	public String getDogumTarihi() {
		return dogumTarihi;
	}
	
	public void setDogumTarihi(String dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	
	public String getAdSoyad() {
		return adSoyad;
	}
	
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
}
