
public class Ogrenci extends Kisi implements KisiTaslak {
	
	int ogrNo;
	String bolum;
	
	public Ogrenci() {
		// üst sınıfın parametre almayan yapılandırıcı metodu çağrılıyor.
		super();
		
		this.ogrNo = 0;
		this.bolum = "";
	}

	@Override
	// bu metod KisiTaslak interface sini implements ettiğimizde yazmak zorunda
	// olduğumuz metod.
	public void kisiselBilgiGoster() {
		System.out.println("Kişi Bilgisi:");
		System.out.println("Öğrenci No: " + this.ogrNo);
		System.out.println("Ad: " + this.getAdSoyad());
		System.out.println("Bölüm: " + this.bolum);
		System.out.println("Cinsiyet: " + this.getCinsiyet());
	}
	
}
