import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public class ModifyTable extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private String[] sutunAdlari = {"Kitap", "Yazar", "Yayınevi", "Ücret"};
	
	private String[][] data = {
			{"ORHAN VELİ BÜTÜN ŞİİRLERİ", "ORHAN VELİ", "YKY", "9,75 TL"},
			{"MIRMIR BALIĞI", "SEMA MARAŞLI", "ÇİLEK", "6,23 TL"},
			{"AŞIKLAR KORUSU", "MAEVE BİNCHY", "DOĞAN KİTAP", "12,00 TL"},
			{"BAŞARI ÜNİVERSİTESİ", "MÜMİN SEKMAN", "ALFA", "3,50 TL"},
			{"MAVİ SÜRGÜN", "HALİKARNAS BALIKÇISI", "BİLGİ YAYINEVİ", "9,00 TL"}
	};
	
	// tableModel oluştur.
	DefaultTableModel tableModel = new DefaultTableModel(data, sutunAdlari);
	
	// table oluştur.
	JTable table = new JTable(tableModel);
	
	// butonlar
	private JButton addRow = new JButton("yeni satır ekle");
	private JButton addColumn = new JButton("yeni sütun ekle");
	private JButton deleteRow = new JButton("seçili satırı sil");
	private JButton deleteColumn = new JButton("seçili sütunu sil");
	private JButton save = new JButton("Kaydet");
	private JButton clear = new JButton("Temizle");
	private JButton restore = new JButton("Sıfırla");
	
	// seçim modu
	private JComboBox<String> selectionMode = new JComboBox<String>(
			new String[] {
					"SINGLE_SELECTION", "SINGLE_INTERVAL_SELECTION",
					"MULTIPLE_INTERVAL_SELECTION"
	});
	
	private JCheckBox rowSelectionAllowed = new JCheckBox(
			"RowSelectionAllowed", true
	);
	private JCheckBox columnSelectionAllowed = new JCheckBox(
			"ColumnSelectionAllowed", false
	);

	public ModifyTable() {
		
		JFrame frame = new JFrame("Örnek JTable");
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 2));
		panel1.add(addRow);
		panel1.add(addColumn);
		panel1.add(deleteRow);
		panel1.add(deleteColumn);
		
		JPanel panel2 = new JPanel();
		panel2.add(save);
		panel2.add(clear);
		panel2.add(restore);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout(5, 0));
		panel3.add(new JLabel("Selection Mode"), BorderLayout.WEST);
		panel3.add(selectionMode); // otomatik olarak center' e ekleniyor.
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		panel4.add(rowSelectionAllowed);
		panel4.add(columnSelectionAllowed);
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(2, 1));
		panel5.add(panel3);
		panel5.add(panel4);
		
		JPanel panel6 = new JPanel();
		panel6.setLayout(new GridLayout(2, 1));
		panel6.add(panel2);
		panel6.add(panel1);
		
		frame.add(panel5, BorderLayout.NORTH);
		frame.add(new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
		));
		
		
		frame.add(panel6, BorderLayout.SOUTH);
		
		// initialize table
		table.setRowHeight(25);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		addRow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					tableModel.insertRow(table.getSelectedRow(), new java.util.Vector<Object>());
				} else {
					tableModel.addRow(new java.util.Vector<Object>());
				}
			}
		});
		
		addColumn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String columnName = JOptionPane.showInputDialog(
						null,
						"Yeni sütun Adı",
						"new column",
						1
				);
				if (!columnName.equals(""))
					tableModel.addColumn(columnName, new java.util.Vector<Object>());
			}
		});
		
		deleteRow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0)
					tableModel.removeRow(table.getSelectedRow());
			}
		});
		
		deleteColumn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedColumn() >= 0) {
					TableColumnModel columnModel = table.getColumnModel();
					TableColumn tableColumn = columnModel.getColumn(table.getSelectedColumn());
					columnModel.removeColumn(tableColumn);
				}
			}
		});
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ObjectOutputStream out = new ObjectOutputStream(
							new FileOutputStream("text/tablemodel.dat"));
					out.writeObject(tableModel.getDataVector());
					out.writeObject(getColumnNames());
					out.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//tableModel.setRowCount();
			}
		});
		
		restore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ObjectInputStream in = new ObjectInputStream(
							new FileInputStream("text/tablemodel.dat"));
					Vector rowData = (Vector) in.readObject();
					Vector columnNames = (Vector) in.readObject();
					tableModel.setDataVector(rowData, columnNames);
					in.close();
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		rowSelectionAllowed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setRowSelectionAllowed(rowSelectionAllowed.isSelected());
			}
		});
		
		columnSelectionAllowed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setColumnSelectionAllowed(columnSelectionAllowed.isSelected());
			}
		});
		
		selectionMode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) selectionMode.getSelectedItem();
				if (selectedItem.equals("SINGLE_SELECTION"))
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				else if (selectedItem.equals("SINGLE_INTERVAL_SELECTION"))
					table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				else if (selectedItem.equals("MULTIPLE_INTERVAL_SELECTION"))
					table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 500);
		frame.setVisible(true);
	}
	
	
	
	private Vector getColumnNames() {
		Vector<String> columnNames = new Vector<String>();
		
		for (int i = 0; i < table.getColumnCount(); i++) {
			columnNames.add(table.getColumnName(i));
		}
		
		return columnNames;
	}
	
	public static void main(String[] args) {
		new ModifyTable();
	}
}
