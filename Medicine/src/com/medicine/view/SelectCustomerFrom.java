package com.medicine.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Panel;
import java.util.Vector;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.medicine.dao.CustomerDao;
import com.medicine.dao.MedicineDao;
import com.medicine.dao.impl.CustomerDaoImpl;
import com.medicine.dao.impl.MedicineDaoImpl;
import com.medicine.pojo.Customer;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectCustomerFrom extends JInternalFrame {
	private JTextField cuName_tf;
	private JTextField cusId_tf;
	private JTextField age_tf;
	private JTextField cusName_tf;
	private JTextField address_tf;
	private JTextField tel_tf;
	private JTextField cardId_tf;
	private JTable table;
	JScrollPane scrollPane = new JScrollPane();
	CustomerDao customerDao = new CustomerDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectCustomerFrom frame = new SelectCustomerFrom();
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
	public SelectCustomerFrom() {
		setTitle("\u60A3\u8005\u67E5\u8BE2");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 768, 547);
		
		Panel panel = new Panel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D:");
		lblNewLabel.setBounds(50, 44, 54, 15);
		panel.add(lblNewLabel);
		
		cuName_tf = new JTextField();
		cuName_tf.setBounds(114, 41, 182, 21);
		panel.add(cuName_tf);
		cuName_tf.setColumns(10);
		
		JButton search_btn = new JButton("\u641C\u7D22");
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector vData = new Vector<>();
				String name = cuName_tf.getText();
				if(name != null && !("".equals(name))){
					vData=customerDao.getCustomerByName(name);
				}else{
					vData=customerDao.getAllCustomer();
				}	
				setCustomerTable(vData);
			}
		});
		search_btn.setBounds(353, 40, 93, 23);
		panel.add(search_btn);
		
		
		scrollPane.setBounds(50, 84, 668, 211);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String customerId = table.getValueAt(row, 0).toString();
				String customerName = table.getValueAt(row, 1).toString();
				String age = table.getValueAt(row, 2).toString();
				String tel = table.getValueAt(row, 3).toString();
				String address = table.getValueAt(row, 4).toString();
				String cardId = table.getValueAt(row, 5).toString();
				
				cusId_tf.setText(customerId);
				cusName_tf.setText(customerName);
				age_tf.setText(age);
				tel_tf.setText(tel);
				address_tf.setText(address);
				cardId_tf.setText(cardId);
				
			}
		});
		scrollPane.setViewportView(table);
		
		setCustomerTable(customerDao.getAllCustomer());
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16  \u53F7:");
		lblNewLabel_1.setBounds(50, 344, 54, 15);
		panel.add(lblNewLabel_1);
		
		cusId_tf = new JTextField();
		cusId_tf.setEnabled(false);
		cusId_tf.setBounds(98, 341, 102, 21);
		panel.add(cusId_tf);
		cusId_tf.setColumns(10);
		
		JLabel label = new JLabel("\u7535  \u8BDD:");
		label.setBounds(494, 344, 54, 15);
		panel.add(label);
		
		age_tf = new JTextField();
		age_tf.setColumns(10);
		age_tf.setBounds(98, 396, 102, 21);
		panel.add(age_tf);
		
		JLabel label_1 = new JLabel("\u59D3  \u540D:");
		label_1.setBounds(271, 344, 54, 15);
		panel.add(label_1);
		
		cusName_tf = new JTextField();
		cusName_tf.setColumns(10);
		cusName_tf.setBounds(335, 341, 102, 21);
		panel.add(cusName_tf);
		
		JLabel label_2 = new JLabel("\u5BB6\u5EAD\u5730\u5740:");
		label_2.setBounds(271, 402, 54, 15);
		panel.add(label_2);
		
		address_tf = new JTextField();
		address_tf.setColumns(10);
		address_tf.setBounds(335, 396, 149, 21);
		panel.add(address_tf);
		
		JLabel label_3 = new JLabel("\u5E74  \u9F84:");
		label_3.setBounds(50, 399, 54, 15);
		panel.add(label_3);
		
		tel_tf = new JTextField();
		tel_tf.setColumns(10);
		tel_tf.setBounds(558, 341, 149, 21);
		panel.add(tel_tf);
		
		JLabel label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7:");
		label_4.setBounds(494, 402, 54, 15);
		panel.add(label_4);
		
		cardId_tf = new JTextField();
		cardId_tf.setColumns(10);
		cardId_tf.setBounds(556, 396, 151, 21);
		panel.add(cardId_tf);
		
		JButton modify_btn = new JButton("\u4FEE\u6539");
		modify_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				customer.setCustomerId(cusId_tf.getText());
				customer.setCustomerName(cusName_tf.getText());
				customer.setAge(Integer.parseInt(age_tf.getText()));
				customer.setPhone(tel_tf.getText());
				customer.setAddress(address_tf.getText());
				customer.setCardId(cardId_tf.getText());
				int row = customerDao.updateCustomer(customer);
				if(row == 1){
					setCustomerTable(customerDao.getAllCustomer());
				}else{
					JOptionPane.showMessageDialog(null, "修改失败！！！");
				}
			}
		});
		modify_btn.setBounds(50, 464, 93, 23);
		panel.add(modify_btn);
		
		JButton del_btn = new JButton("\u5220\u9664");
		del_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "确认删除么？");
				if(option != 0){
					return ;
				}
				int rows = customerDao.delCustomer(Integer.parseInt(cusId_tf.getText()));
				if(rows != 0){
					setCustomerTable(customerDao.getAllCustomer());
					cusId_tf.setText("");
					cusName_tf.setText("");
					age_tf.setText("");
					tel_tf.setText("");
					address_tf.setText("");
					cardId_tf.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "删除失败！！！");
				}
			}
		});
		del_btn.setBounds(187, 464, 93, 23);
		panel.add(del_btn);
		
		
		
	}
	public void setCustomerTable(Vector vStockData){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Vector v = new Vector();
		v.add("编号");
		v.add("顾客姓名");
		v.add("年龄");
		v.add("电话");
		v.add("家庭地址");
		v.add("身份证号");
		model.setDataVector(vStockData, v);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}
