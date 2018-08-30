package com.medicine.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.medicine.dao.CustomerDao;
import com.medicine.dao.impl.CustomerDaoImpl;
import com.medicine.pojo.Customer;

public class AddCustomerForm extends JInternalFrame {
	private JTextField customerName_tf;
	private JTextField age_tf;
	private JTextField tel_tf;
	private JTextField address_tf;
	private JTextField cardId_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomerForm frame = new AddCustomerForm();
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
	public AddCustomerForm() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u60A3\u8005\u767B\u8BB0");
		setBounds(100, 100, 571, 404);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3   \u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(49, 35, 72, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u5E74   \u9F84\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(49, 86, 72, 19);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u7535   \u8BDD\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(49, 136, 72, 19);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u5BB6\u5EAD\u5730\u5740\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(49, 183, 96, 19);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(49, 232, 96, 19);
		getContentPane().add(label_3);
		
		customerName_tf = new JTextField();
		customerName_tf.setBounds(131, 35, 140, 21);
		getContentPane().add(customerName_tf);
		customerName_tf.setColumns(10);
		
		age_tf = new JTextField();
		age_tf.setColumns(10);
		age_tf.setBounds(131, 86, 140, 21);
		getContentPane().add(age_tf);
		
		tel_tf = new JTextField();
		tel_tf.setColumns(10);
		tel_tf.setBounds(131, 136, 263, 21);
		getContentPane().add(tel_tf);
		
		address_tf = new JTextField();
		address_tf.setColumns(10);
		address_tf.setBounds(131, 183, 312, 21);
		getContentPane().add(address_tf);
		
		cardId_tf = new JTextField();
		cardId_tf.setColumns(10);
		cardId_tf.setBounds(131, 232, 312, 21);
		getContentPane().add(cardId_tf);
		
		JButton confirm_btn = new JButton("\u786E\u8BA4\u767B\u8BB0");
		confirm_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer c = new Customer();
				int customerId = (int)(Math.random()*1000); 
				String cId = String.valueOf(customerId);
				JOptionPane.showMessageDialog(null, cId);
					c.setCustomerId(cId);
				//c.setCustomerId(c.getCustomerId());
				c.setCustomerName(customerName_tf.getText());
				c.setAge(Integer.parseInt(age_tf.getText()));
				c.setPhone(tel_tf.getText());
				c.setAddress(address_tf.getText());
				c.setCardId(cardId_tf.getText());
				CustomerDao cus = new CustomerDaoImpl();
				int row=cus.addCustomer(c);
				if(row ==1){
					JOptionPane.showMessageDialog(null, "添加成功!!!");
				}else{
					JOptionPane.showMessageDialog(null, "添加失败！！！");
				}
				
			}
		});
		confirm_btn.setBounds(49, 285, 93, 23);
		getContentPane().add(confirm_btn);
		
		JButton reset_btn = new JButton("\u91CD\u7F6E");
		reset_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerName_tf.setText(null);
				age_tf.setText(null);
				tel_tf.setText(null);
				address_tf.setText(null);
				cardId_tf.setText(null);
			}
		});
		reset_btn.setBounds(201, 285, 93, 23);
		getContentPane().add(reset_btn);

	}
}
