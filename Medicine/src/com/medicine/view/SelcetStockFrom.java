package com.medicine.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import com.medicine.dao.StorckDao;
import com.medicine.dao.impl.StorckDaoImpl;
import com.medicine.pojo.Stock;

import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelcetStockFrom extends JInternalFrame {
	private JTextField tfMedicineName;
	private JTable table;
	private JTextField tfMedicineId;
	private JTextField tfStockAmount;
	private JTable table_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelcetStockFrom frame = new SelcetStockFrom();
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
	public SelcetStockFrom() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("\u5E93\u5B58\u67E5\u8BE2");
		setBounds(100, 100, 764, 501);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setBounds(0, 0, 748, 472);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(28, 10, 80, 42);
		panel.add(label);
		
		tfMedicineName = new JTextField();
		tfMedicineName.setBounds(118, 12, 241, 42);
		panel.add(tfMedicineName);
		tfMedicineName.setColumns(10);
		
		JButton btnSelcetMedicineStock = new JButton("\u67E5\u8BE2");
		btnSelcetMedicineStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				String mname = tfMedicineName.getText();
				StorckDao dao = new StorckDaoImpl();
				Vector v = new Vector<>();
				v.add("药品编号");
				v.add("药品名称");
				v.add("药品规格");
				v.add("库存量");
				if(mname != null && !("".equals(mname))){
					model.setDataVector(dao.getByStockName(mname), v);
				}else{
					model.setDataVector(dao.getMedicineAmount(), v);
				}	
			}
		});
		btnSelcetMedicineStock.setBounds(383, 14, 72, 37);
		panel.add(btnSelcetMedicineStock);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 94, 649, 268);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//得到选中的行数
				int row = table.getSelectedRow();
				String medicineId = table.getValueAt(row, 0).toString();
				String stockAmount = table.getValueAt(row, 3).toString();
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
		v.add("库存量");
		model.setDataVector(storckdao.getMedicineAmount(), v);
		table.setModel(model);
		table.setBounds(49, 132, 673, 297);
		scrollPane.setViewportView(table);
		
		JLabel label_2 = new JLabel("\u836F\u54C1\u7F16\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(56, 386, 88, 42);
		panel.add(label_2);
		
		tfMedicineId = new JTextField();
		tfMedicineId.setEnabled(false);
		tfMedicineId.setColumns(10);
		tfMedicineId.setBounds(154, 390, 142, 37);
		panel.add(tfMedicineId);
		
		JLabel label_3 = new JLabel("\u5E93\u5B58\u91CF\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(320, 386, 64, 42);
		panel.add(label_3);
		
		tfStockAmount = new JTextField();
		tfStockAmount.setColumns(10);
		tfStockAmount.setBounds(394, 390, 133, 37);
		panel.add(tfStockAmount);
		
		JButton btnUpdateStockAmount = new JButton("\u4FEE\u6539");
		btnUpdateStockAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock stock = new Stock();
				stock.setMedicineId(tfMedicineId.getText());
				JOptionPane.showMessageDialog(null, tfMedicineId.getText());
				stock.setAmount(Integer.parseInt(tfStockAmount.getText()));
				JOptionPane.showMessageDialog(null,tfStockAmount.getText());
				StorckDao dao = new StorckDaoImpl();
				int row = dao.updateStorck(stock);
				if(row ==1){
					JOptionPane.showMessageDialog(null, "修改成功!!!");
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					StorckDao storckdao = new StorckDaoImpl();
					Vector v = new Vector<>();
					v.add("药品编号");
					v.add("药品名称");
					v.add("药品规格");
					v.add("库存量");
					model.setDataVector(storckdao.getMedicineAmount(), v);
				}else{
					JOptionPane.showMessageDialog(null, "修改失败！！！");
				}
			}
		});
		btnUpdateStockAmount.setBounds(561, 390, 72, 37);
		panel.add(btnUpdateStockAmount);
		
		JButton btnDeleteMedicineStockAmount = new JButton("\u5220\u9664");
		btnDeleteMedicineStockAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "确认删除么？");
				if(option != 0){
					return ;
				}
				StorckDao dao = new StorckDaoImpl();
				int rows = dao.deleStorck(Integer.parseInt(tfMedicineId.getText()));
				if(rows !=0){
					JOptionPane.showMessageDialog(null, "删除成功！！！");
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					StorckDao storckdao = new StorckDaoImpl();
					Vector v = new Vector<>();
					v.add("药品编号");
					v.add("药品名称");
					v.add("药品规格");
					v.add("库存量");
					model.setDataVector(storckdao.getMedicineAmount(), v);
				}else{
					JOptionPane.showMessageDialog(null, "删除失败！！！");
				}
			}
		});
		btnDeleteMedicineStockAmount.setBounds(643, 390, 72, 37);
		panel.add(btnDeleteMedicineStockAmount);
		
	}
}
