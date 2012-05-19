
public class Ogrenci extends Kisi {
	private int ogrNo;
	private String bolum;
	
	public Ogrenci() {
		// üst sýnýfýn argüman almayan yapýlandýrýcýsýný çaðýrdýk.
		super();
		
		this.ogrNo = -1;
		this.bolum = "";
	}
	
	public Ogrenci(Kisi k, int ogrNo, String bolum) {
		// üst sýnýfýn Kisi tipinde parametre alan yapýlandýrýcýsýný çaðýrdýk.
		super(k);
		
		this.setOgrNo(ogrNo);
		this.setBolum(bolum);
	}
	
	public Ogrenci(String adSoyad, String dogumTarihi, char cinsiyet,
			int ogrNo, String bolum) {
		// üst sýnýfýn 3 argüman alan Constructure metodunu çaðýrdýk.
		super(adSoyad, dogumTarihi, cinsiyet);
		
		this.setOgrNo(ogrNo);
		this.setBolum(bolum);
	}
	
	public Ogrenci(Ogrenci o) {
		super(o.getAdSoyad(), o.getDogumTarihi(), o.getCinsiyet());
		
		this.setOgrNo(o.getOgrNo());
		this.setBolum(o.getBolum());
	}
	
	public int getOgrNo() {
		return ogrNo;
	}
	
	public void setOgrNo(int ogrNo) {
		this.ogrNo = ogrNo;
	}
	
	public String getBolum() {
		return bolum;
	}
	
	public void setBolum(String bolum) {
		this.bolum = bolum;
	}
	
}
