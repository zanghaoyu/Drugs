package com.medicine.view;

import java.awt.EventQueue;
import java.util.List;
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
import com.medicine.dao.SupplierDao;
import com.medicine.dao.impl.MedicineDaoImpl;
import com.medicine.dao.impl.SupplierDaoImpl;
import com.medicine.pojo.Medicine;
import com.medicine.pojo.Supplier;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MedicineCheck extends JInternalFrame {
	private JTextField textSuppName;
	private JTextField textPprice;
	private JTextField textMid;
	private JTextField textMname;
	private JTextField textMRetprice;
	private JTextField textMunit;
	private JTextField textMregion;
	private JTable table;
	// private JTable table;

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
		
		textSuppName = new JTextField();
		textSuppName.setBounds(105, 27, 91, 35);
		panel.add(textSuppName);
		textSuppName.setColumns(10);
		
		//查询
		JButton buttCheck = new JButton("\u67E5\u8BE2");
		buttCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				
				MedicineDao md=new MedicineDaoImpl();
				
				String sSuppName=textSuppName.getText();
				
				Vector v=new Vector<>();
				v.add("药品编号");
				v.add("药品名称");
				v.add("药品规格");
				v.add("药品产地");
				v.add("供货商名称");
				v.add("进价");
				v.add("零售价");
				
				if(sSuppName!=null && !("".equals(sSuppName))){
					model.setDataVector(md.checkDurg(sSuppName),v);
				}else{
					model.setDataVector(md.getAllDrug(), v);
				}
			}
		});
		
		buttCheck.setBounds(527, 24, 93, 40);
		panel.add(buttCheck);
		
		JLabel label_1 = new JLabel("\u836F\u54C1\u7F16\u53F7");
		label_1.setBounds(56, 234, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u8FDB  \u4EF7  ");
		label_2.setBounds(56, 273, 54, 15);
		panel.add(label_2);
		
		textPprice = new JTextField();
		textPprice.setBounds(105, 270, 106, 21);
		panel.add(textPprice);
		textPprice.setColumns(10);
		
		textMid = new JTextField();
		textMid.setEnabled(false);
		textMid.setColumns(10);
		textMid.setBounds(105, 231, 106, 21);
		panel.add(textMid);
		
		JLabel label_3 = new JLabel("\u5143");
		label_3.setBounds(221, 273, 20, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u96F6\u552E\u4EF7  ");
		label_4.setBounds(269, 273, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u836F\u54C1\u540D\u79F0");
		label_5.setBounds(269, 234, 54, 15);
		panel.add(label_5);
		
		textMname = new JTextField();
		textMname.setColumns(10);
		textMname.setBounds(321, 231, 106, 21);
		panel.add(textMname);
		
		textMRetprice = new JTextField();
		textMRetprice.setEnabled(false);
		textMRetprice.setColumns(10);
		textMRetprice.setBounds(321, 270, 106, 21);
		panel.add(textMRetprice);
		
		JLabel label_6 = new JLabel("\u836F\u54C1\u89C4\u683C");
		label_6.setBounds(475, 234, 54, 15);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0");
		label_7.setBounds(475, 273, 70, 15);
		panel.add(label_7);
		
		textMunit = new JTextField();
		textMunit.setEnabled(false);
		textMunit.setColumns(10);
		textMunit.setBounds(555, 231, 106, 21);
		panel.add(textMunit);
		
		JLabel label_8 = new JLabel("\u5143");
		label_8.setBounds(432, 273, 20, 15);
		panel.add(label_8);
		
		//供应商名称
		SupplierDao sd = new SupplierDaoImpl();
		
		JComboBox comboBox = new JComboBox();
		List<Supplier> vec=sd.checkSupplier();
		for (Object o: vec) {
			comboBox.addItem(o);
		}
		comboBox.setBounds(555, 270, 106, 21);
		panel.add(comboBox);
		
		JLabel label_9 = new JLabel("\u836F\u54C1\u4EA7\u5730");
		label_9.setBounds(56, 324, 54, 15);
		panel.add(label_9);
		
		textMregion = new JTextField();
		textMregion.setColumns(10);
		textMregion.setBounds(134, 321, 440, 21);
		panel.add(textMregion);
		
		//修改
		JButton buttCharge = new JButton("\u4FEE\u6539");
		buttCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str=textMid.getText();
				//JOptionPane.showMessageDialog(null, str);
				int i=JOptionPane.showConfirmDialog(null, "是否修改");
				if(i!=0){
					return;
				}
				
				MedicineDao mdao=new MedicineDaoImpl();
				Vector connectv=mdao.connect(str);
				int a=connectv.size();
				if(a!=0){
					Medicine med=new Medicine();
					med.setEmdicineName(textMname.getText());
					med.setUnit(textMunit.getText());
					med.setRegion(textMregion.getText());
					med.setRetailPrice(Float.parseFloat(textMRetprice.getText()));
					med.setMedicineId(str);
					
					int rows=mdao.chargeDrug(med);
					if(rows!=0){
						JOptionPane.showMessageDialog(null, "修改成功");
						DefaultTableModel model=(DefaultTableModel) table.getModel();
						
						Vector v = new Vector();
						v.add("药品编号");
						v.add("药品名称");
						v.add("药品规格");
						v.add("药品产地");
						v.add("供货商名称");
						v.add("进价");
						v.add("零售价");
						model.setDataVector(mdao.getAllDrug(), v);
					}
				}
			}
		});
		buttCharge.setBounds(91, 361, 93, 23);
		panel.add(buttCharge);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.setBounds(500, 361, 93, 23);
		panel.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 68, 634, 149);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			
			@Override//获取表中的数据
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				String sMid=table.getValueAt(row, 0).toString();
				String sMname=table.getValueAt(row, 1).toString();
				String sMunit=table.getValueAt(row, 2).toString();
				String sMpprice=table.getValueAt(row, 5).toString();
				String sMrprice=table.getValueAt(row, 6).toString();
				String sMreg=table.getValueAt(row, 3).toString();
				String sSupp=table.getValueAt(row, 4).toString();
				
				textMid.setText(sMid);
				textMname.setText(sMname);
				textMunit.setText(sMunit);
				textMRetprice.setText(sMrprice);
				textMregion.setText(sMreg);
				textPprice.setText(sMpprice);
			
				
			}
		});
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
