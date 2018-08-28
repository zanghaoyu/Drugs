package com.medicine.view;

import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.medicine.dao.MedicineDao;
import com.medicine.dao.SupplierDao;
import com.medicine.dao.impl.MedicineDaoImpl;
import com.medicine.dao.impl.SupplierDaoImpl;
import com.medicine.pojo.Medicine;
import com.medicine.pojo.Purchase;
import com.medicine.pojo.Supplier;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MedicineAdd extends JInternalFrame {
	private JTextField textmedicineId;
	private JTextField textpurchaseprice;
	private JTextField textmedicinename;
	private JTextField textretailprice;
	private JTextField textunit;
	private JTextField textregion;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicineAdd frame = new MedicineAdd();
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
	public MedicineAdd() {
		setTitle("\u836F\u54C1\u6DFB\u52A0");
		setClosable(true);
		setBounds(100, 100, 739, 423);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 723, 394);
		getContentPane().add(panel);
		panel.setLayout(null);
		//药品编号
		textmedicineId = new JTextField();
		textmedicineId.setColumns(10);
		textmedicineId.setBounds(98, 42, 106, 21);
		panel.add(textmedicineId);
		
		JLabel label = new JLabel("\u836F\u54C1\u7F16\u53F7");
		label.setBounds(49, 34, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8FDB  \u4EF7  ");
		label_1.setBounds(49, 73, 54, 15);
		panel.add(label_1);
		
		//进  价  
		textpurchaseprice = new JTextField();
		textpurchaseprice.setColumns(10);
		textpurchaseprice.setBounds(98, 70, 106, 21);
		panel.add(textpurchaseprice);
		
		JLabel label_2 = new JLabel("\u5143");
		label_2.setBounds(214, 73, 20, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u836F\u54C1\u540D\u79F0");
		label_3.setBounds(262, 34, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u96F6\u552E\u4EF7  ");
		label_4.setBounds(262, 73, 54, 15);
		panel.add(label_4);
		
		//药品名称
		textmedicinename = new JTextField();
		textmedicinename.setColumns(10);
		textmedicinename.setBounds(314, 31, 106, 21);
		panel.add(textmedicinename);
		
		//零售价  
		textretailprice = new JTextField();
		textretailprice.setColumns(10);
		textretailprice.setBounds(314, 70, 106, 21);
		panel.add(textretailprice);
		
		JLabel label_5 = new JLabel("\u5143");
		label_5.setBounds(425, 73, 20, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("\u836F\u54C1\u89C4\u683C");
		label_6.setBounds(468, 34, 54, 15);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0");
		label_7.setBounds(468, 73, 70, 15);
		panel.add(label_7);
		
		//供应商名称
		SupplierDao sd = new SupplierDaoImpl();
		
		JComboBox comboBox = new JComboBox();
		List<String> vec=sd.checkSupplier();
		for (Object o: vec) {
			comboBox.addItem(o);
		}
		comboBox.setBounds(548, 70, 106, 21);
		
		panel.add(comboBox);
		
		//药品规格
		textunit = new JTextField();
		textunit.setColumns(10);
		textunit.setBounds(548, 31, 106, 21);
		panel.add(textunit);
		
		//药品产地
		textregion = new JTextField();
		textregion.setColumns(10);
		textregion.setBounds(160, 101, 440, 21);
		panel.add(textregion);
		
		JLabel label_8 = new JLabel("\u836F\u54C1\u4EA7\u5730");
		label_8.setBounds(82, 104, 54, 15);
		panel.add(label_8);
		
		//添加
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medicine medi = new Medicine();
				Purchase pur=new Purchase();
				Supplier supp=new Supplier();
				
				//获取信息
				medi.setMedicineId(textmedicineId.getText());
				medi.setEmdicineName(textmedicinename.getText());
				pur.setPurchaseprice(Float.parseFloat(textpurchaseprice.getText()));
				medi.setUnit(textunit.getText());
				medi.setRegion(textregion.getText());
				medi.setRetailPrice(Float.parseFloat(textretailprice.getText()));
				
				//获取供应商名称
				String name = comboBox.getName();
				//新建一个供应商dao，根据name查找供应商id
				SupplierDao sd=new SupplierDaoImpl();
				
			}
		});
		btnNewButton.setBounds(558, 134, 77, 31);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 185, 648, 199);
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
