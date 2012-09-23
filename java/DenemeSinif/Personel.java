
public class Personel extends Kisi {
	private String sicilNo;
	private String birim;
	private String unvan;
	private String dahiliTelNo;

	public Personel() {
		super();

		this.sicilNo = "";
		this.birim = "";
		this.unvan = "";
		this.dahiliTelNo = "";
	}

	public Personel(Kisi k, String sicilNo,
			String birim, String unvan, String dahiliTelNo) {
		super(k);

		this.setSicilNo(sicilNo);
		this.setBirim(birim);
		this.setUnvan(unvan);
		this.setDahiliTelNo(dahiliTelNo);
	}

	public Personel(Personel p) {
		super(p.getAdSoyad(), p.getDogumTarihi(), p.getCinsiyet());

		this.sicilNo = p.getSicilNo();
		this.birim = p.getBirim();
		this.unvan = p.getUnvan();
		this.dahiliTelNo = p.getDahiliTelNo();
	}

	public Personel(String adSoyad, String dogumTarihi, char cinsiyet,
			String sicilNo, String birim, String unvan, String dahiliTelNo) {
		super(adSoyad, dogumTarihi, cinsiyet);

		this.setSicilNo(sicilNo);
		this.setBirim(birim);
		this.setUnvan(unvan);
		this.setDahiliTelNo(dahiliTelNo);
	}

	public String getBirim() {
		return birim;
	}

	public void setBirim(String birim) {
		this.birim = birim;
	}

	public String getUnvan() {
		return unvan;
	}

	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}

	public String getSicilNo() {
		return sicilNo;
	}

	public void setSicilNo(String sicilNo) {
		this.sicilNo = sicilNo;
	}

	public String getDahiliTelNo() {
		return dahiliTelNo;
	}

	public void setDahiliTelNo(String dahiliTelNo) {
		this.dahiliTelNo = dahiliTelNo;
	}
}
