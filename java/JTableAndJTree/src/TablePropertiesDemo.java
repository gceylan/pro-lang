import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class TablePropertiesDemo extends JApplet {
	
	private static final long serialVersionUID = 1L;
	
	private String[] sutunAdlari = {"Kitap", "Yazar", "Yayınevi", "Ücret"};
	
	private String[][] data = {
			{"ORHAN VELİ BÜTÜN ŞİİRLERİ", "ORHAN VELİ", "YKY", "9,75 TL"},
			{"MIRMIR BALIĞI", "SEMA MARAŞLI", "ÇİLEK", "6,23 TL"},
			{"AŞIKLAR KORUSU", "MAEVE BİNCHY", "DOĞAN KİTAP", "12,00 TL"},
			{"BAŞARI ÜNİVERSİTESİ", "MÜMİN SEKMAN", "ALFA", "3,50 TL"},
			{"MAVİ SÜRGÜN", "HALİKARNAS BALIKÇISI", "BİLGİ YAYINEVİ", "9,00 TL"}
	};
	
	private JTable table = new JTable(data, sutunAdlari);
	
	private JSpinner rowHeight = new JSpinner(
			new SpinnerNumberModel(16, 1, 50, 1));
	
	private JSpinner rowMargin = new JSpinner(
			new SpinnerNumberModel(1, 1, 50, 1));
	
	private JCheckBox showGrid = new JCheckBox("çizgileri göster");
	
	private JComboBox<String> autoResizeMode = new JComboBox<String>(
			new String[] {
					"AUTO_RESIZE_OFF",
					"AUTO_RESIZE_LAST_COLUMN",
					"AUTO_RESIZE_SUBSEQUENT_COLUMNS",
					"AUTO_RESIZE_NEXT_COLUMN",
					"AUTO_RESIZE_ALL_COLUMNS"
			});
	
	public TablePropertiesDemo() {
		JPanel panel1 = new JPanel();
		
		panel1.add(new JLabel("satır genişliği"));
		panel1.add(rowHeight);
		
		panel1.add(new JLabel("satır marjı"));
		panel1.add(rowMargin);
		panel1.add(showGrid);
		
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("auto resize mode"));
		panel2.add(autoResizeMode);
		
		add(panel1, BorderLayout.SOUTH);
		add(panel2, BorderLayout.NORTH);
		add(new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER
		);
		
		// tablo' nun default ayarı
		table.setShowGrid(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		table.setGridColor(Color.BLUE);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(Color.RED);
		table.setSelectionForeground(Color.WHITE);
		
		// dinamik olarak satır genişliğini değiştiriyoruz...
		rowHeight.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				table.setRowHeight(((Integer) rowHeight.getValue()).intValue());
			}
		});
		
		rowMargin.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				table.setRowMargin(((Integer) rowMargin.getValue()).intValue());
			}
		});
		
		// grid çizgilerini aç/kapat
		showGrid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setShowGrid(showGrid.isSelected());
			}
		});
		
		// table' ın özelliklerini değiştiriyoruz...
		autoResizeMode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) autoResizeMode.getSelectedItem();
				
				if (selectedItem.equals("AUTO_RESIZE_OFF"))
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				else if (selectedItem.equals("AUTO_RESIZE_LAST_COLUMN"))
					table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				else if (selectedItem.equals("AUTO_RESIZE_SUBSEQUENT_COLUMNS"))
					table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
				else if (selectedItem.equals("AUTO_RESIZE_NEXT_COLUMN"))
					table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				else if (selectedItem.equals("AUTO_RESIZE_ALL_COLUMNS"))
					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			}
		});
	}
}
