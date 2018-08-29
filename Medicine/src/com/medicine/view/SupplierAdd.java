package com.medicine.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.medicine.dao.SupplierDao;
import com.medicine.dao.impl.SupplierDaoImpl;
import com.medicine.pojo.Supplier;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupplierAdd extends JInternalFrame {
	private JTextField textSuppId;
	private JTextField textSuppName;
	private JTextField textSuppAddress;
	private JTextField textSuppPhopne;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierAdd frame = new SupplierAdd();
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
	public SupplierAdd() {
		setClosable(true);
		setTitle("\u4F9B\u5E94\u5546\u767B\u8BB0");
		setBounds(100, 100, 739, 423);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u4F9B\u5E94\u5546\u7F16\u53F7");
		label.setBounds(139, 26, 68, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0");
		label_1.setBounds(139, 73, 68, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u4F9B\u5E94\u5546\u5730\u5740");
		label_2.setBounds(139, 118, 68, 15);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u4F9B\u5E94\u5546\u7535\u8BDD");
		label_3.setBounds(139, 163, 68, 15);
		getContentPane().add(label_3);
		
		textSuppId = new JTextField();
		textSuppId.setBounds(212, 23, 101, 21);
		getContentPane().add(textSuppId);
		textSuppId.setColumns(10);
		
		textSuppName = new JTextField();
		textSuppName.setColumns(10);
		textSuppName.setBounds(212, 73, 242, 21);
		getContentPane().add(textSuppName);
		
		textSuppAddress = new JTextField();
		textSuppAddress.setColumns(10);
		textSuppAddress.setBounds(212, 115, 242, 21);
		getContentPane().add(textSuppAddress);
		
		textSuppPhopne = new JTextField();
		textSuppPhopne.setColumns(10);
		textSuppPhopne.setBounds(212, 160, 242, 21);
		getContentPane().add(textSuppPhopne);
		
		
		//添加供应商
		JButton add = new JButton("\u786E\u8BA4\u767B\u8BB0");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//创建一个新的供应商对象，获取信息
				Supplier supp=new Supplier();
				supp.setSupplierid(textSuppId.getText());
				supp.setSuppliername(textSuppName.getText());
				supp.setAddress(textSuppAddress.getText());
				supp.setPhone(textSuppPhopne.getText());
				
				//实现添加
				SupplierDao sd=new SupplierDaoImpl();
				sd.addSupplier(supp);
				
			}
		});
		add.setBounds(139, 236, 93, 23);
		getContentPane().add(add);
		
		JButton rest = new JButton("\u91CD\u7F6E");
		rest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSuppId.setText("");
				textSuppName.setText("");
				textSuppAddress.setText("");
				textSuppPhopne.setText("");
				
			}
		});
		rest.setBounds(384, 236, 93, 23);
		getContentPane().add(rest);

	}

}
