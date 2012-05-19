
public class Ogrenci extends Kisi {
	private int ogrNo;
	private String bolum;
	
	public Ogrenci() {
		// �st s�n�f�n arg�man almayan yap�land�r�c�s�n� �a��rd�k.
		super();
		
		this.ogrNo = -1;
		this.bolum = "";
	}
	
	public Ogrenci(Kisi k, int ogrNo, String bolum) {
		// �st s�n�f�n Kisi tipinde parametre alan yap�land�r�c�s�n� �a��rd�k.
		super(k);
		
		this.setOgrNo(ogrNo);
		this.setBolum(bolum);
	}
	
	public Ogrenci(String adSoyad, String dogumTarihi, char cinsiyet,
			int ogrNo, String bolum) {
		// �st s�n�f�n 3 arg�man alan Constructure metodunu �a��rd�k.
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
