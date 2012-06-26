import javax.swing.*;


public class TestTable extends JApplet {

	private static final long serialVersionUID = 1L;
	
	private String[] sutunAdlari = {"Ülke", "Başkent", "Nüfus(Milyon)", "Demokrasi"};
	
	private Object[][] data = {
			{"Türkiye", "Ankara", 80, true},
			{"USA", "Washington DC", 280, true},
			{"Germany", "Berlin", 83, true}
	};
	
	private JTable table = new JTable(data, sutunAdlari);

	public TestTable() {
		add(new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED)
		);
	}
}
