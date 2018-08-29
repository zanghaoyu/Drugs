package com.medicine.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.medicine.dao.MedicineDao;
import com.medicine.dao.StorckDao;
import com.medicine.dao.impl.MedicineDaoImpl;
import com.medicine.dao.impl.StorckDaoImpl;
import com.medicine.pojo.Stock;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStockFrom extends JInternalFrame {
	private JTextField tfMedicineName;
	private JTable table;
	private JTextField tfMedicineId;
	private JTextField tfStockAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStockFrom frame = new AddStockFrom();
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
	public AddStockFrom() {
		setTitle("\u5E93\u5B58\u767B\u8BB0");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 756, 496);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 30, 720, 447);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u540D\u79F0:");
		lblNewLabel.setBounds(10, 10, 88, 43);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		tfMedicineName = new JTextField();
		tfMedicineName.setBounds(101, 10, 248, 43);
		panel.add(tfMedicineName);
		tfMedicineName.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mName = tfMedicineName.getText();
				//JOptionPane.showMessageDialog(null, mName);
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				StorckDao storckdao = new StorckDaoImpl();
				Vector v = new Vector<>();
				v.add("药品编号");
				v.add("药品名称");
				v.add("药品规格");
				v.add("药品产地");
				v.add("供应商名称");
				v.add("进价");
				v.add("零售价");
				v.add("库存");
				if(mName ==null && "".equals(mName)){
					//JOptionPane.showMessageDialog(null, "文本框为空");
					model.setDataVector(storckdao.getMedicineSupplierAmount(),v);
				}else{
					//JOptionPane.showMessageDialog(null, "文本框不为空");
					model.setDataVector(storckdao.getMedicineSupplierAmountByName(mName),v);
				}
			}
		});
		button.setBounds(366, 10, 74, 43);
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 62, 710, 284);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String medicineId = table.getValueAt(row, 0).toString();
				String stockAmount = table.getValueAt(row, 7).toString();
				tfMedicineId.setText(medicineId);
				tfStockAmount.setText(stockAmount);
			}
		});
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		StorckDao storckdao = new StorckDaoImpl();
		Vector v = new Vector<>();
		v.add("药品编号");
		v.add("药品名称");
		v.add("药品规格");
		v.add("药品产地");
		v.add("供应商名称");
		v.add("进价");
		v.add("零售价");
		v.add("库存");
		model.setDataVector(storckdao.getMedicineSupplierAmount(),v);
		table.setModel(model);
		table.setBounds(0, 62, 708, 260);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u836F\u54C1\u7F16\u53F7:");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(10, 356, 88, 43);
		panel.add(label);
		
		tfMedicineId = new JTextField();
		tfMedicineId.setEnabled(false);
		tfMedicineId.setColumns(10);
		tfMedicineId.setBounds(89, 363, 111, 31);
		panel.add(tfMedicineId);
		
		JLabel label_1 = new JLabel("\u5E93\u5B58\u91CF:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(211, 356, 88, 43);
		panel.add(label_1);
		
		tfStockAmount = new JTextField();
		tfStockAmount.setColumns(10);
		tfStockAmount.setBounds(287, 363, 106, 31);
		panel.add(tfStockAmount);
		
		JButton btnAddStock = new JButton("\u786E\u5B9A");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stock stock = new Stock();
				stock.setMedicineId(tfMedicineId.getText());
				stock.setAmount(Integer.parseInt(tfStockAmount.getText()));
				StorckDao dao = new StorckDaoImpl();
				int rows = dao.updateStorck(stock);
				if(rows==1){
					JOptionPane.showMessageDialog(null, "添加成功！！！");
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					StorckDao storckdao = new StorckDaoImpl();
					Vector v = new Vector<>();
					v.add("药品编号");
					v.add("药品名称");
					v.add("药品规格");
					v.add("药品产地");
					v.add("供应商名称");
					v.add("进价");
					v.add("零售价");
					v.add("库存");
					model.setDataVector(storckdao.getMedicineSupplierAmount(),v);
				}else{
					JOptionPane.showMessageDialog(null, "添加失败！！！");
				}
			}
		});
		btnAddStock.setFont(new Font("宋体", Font.PLAIN, 16));
		btnAddStock.setBounds(435, 356, 111, 36);
		panel.add(btnAddStock);

	}
}
