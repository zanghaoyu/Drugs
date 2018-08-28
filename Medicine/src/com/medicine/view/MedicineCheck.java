package com.medicine.view;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.medicine.dao.MedicineDao;
import com.medicine.dao.impl.MedicineDaoImpl;

public class MedicineCheck extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	//private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicineCheck frame = new MedicineCheck();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MedicineCheck() {
		setClosable(true);
		setTitle("\u836F\u54C1\u67E5\u8BE2");
		setBounds(100, 100, 739, 423);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 723, 394);
		getContentPane().add(panel);
		panel.setLayout(null);
		
	
		
		
		JLabel label = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0");
		label.setBounds(31, 31, 79, 27);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(105, 27, 91, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setBounds(527, 24, 93, 40);
		panel.add(button);
		
		JLabel label_1 = new JLabel("\u836F\u54C1\u7F16\u53F7");
		label_1.setBounds(56, 234, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u8FDB  \u4EF7  ");
		label_2.setBounds(56, 273, 54, 15);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 270, 106, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(105, 231, 106, 21);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("\u5143");
		label_3.setBounds(221, 273, 20, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u96F6\u552E\u4EF7  ");
		label_4.setBounds(269, 273, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u836F\u54C1\u540D\u79F0");
		label_5.setBounds(269, 234, 54, 15);
		panel.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(321, 231, 106, 21);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(321, 270, 106, 21);
		panel.add(textField_4);
		
		JLabel label_6 = new JLabel("\u836F\u54C1\u89C4\u683C");
		label_6.setBounds(475, 234, 54, 15);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0");
		label_7.setBounds(475, 273, 70, 15);
		panel.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(555, 231, 106, 21);
		panel.add(textField_5);
		
		JLabel label_8 = new JLabel("\u5143");
		label_8.setBounds(432, 273, 20, 15);
		panel.add(label_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(555, 270, 106, 21);
		panel.add(comboBox);
		
		JLabel label_9 = new JLabel("\u836F\u54C1\u4EA7\u5730");
		label_9.setBounds(56, 324, 54, 15);
		panel.add(label_9);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(134, 321, 440, 21);
		panel.add(textField_6);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.setBounds(91, 361, 93, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.setBounds(500, 361, 93, 23);
		panel.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 68, 634, 149);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		MedicineDao bookTypeDao = new MedicineDaoImpl();
		
		Vector v = new Vector();
		v.add("药品编号");
		v.add("药品名称");
		v.add("药品规格");
		v.add("药品产地");
		v.add("供货商名称");
		v.add("进价");
		v.add("零售价");
		model.setDataVector(bookTypeDao.getAllDrug(), v);
	}
}
