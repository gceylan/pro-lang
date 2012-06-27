import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class TestTableModel extends JApplet {

	private static final long serialVersionUID = 1L;

	private String[] sutunAdlari = {"Ülke", "Başkent", "Nüfus(Milyon)", "Demokrasi"};
	
	private Object[][] data = {
			{"Türkiye", "Ankara", 80, true},
			{"USA", "Washington DC", 280, true},
			{"Germany", "Berlin", 83, true}
	};
	
	private DefaultTableModel tableModel = new DefaultTableModel(data, sutunAdlari);
	
	private JTable table = new JTable(tableModel);

	public TestTableModel() {
		add(new JScrollPane(table));
		tableModel.insertRow(0, new Object[]
				{"Türkiye", "Ankara", 75, true}
		);
	}

}
