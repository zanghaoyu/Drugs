package com.medicine.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SupplierAdd extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		textField = new JTextField();
		textField.setBounds(212, 23, 101, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(212, 73, 242, 21);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(212, 115, 242, 21);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(212, 160, 242, 21);
		getContentPane().add(textField_3);
		
		JButton button = new JButton("\u786E\u8BA4\u767B\u8BB0");
		button.setBounds(139, 236, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(384, 236, 93, 23);
		getContentPane().add(button_1);

	}

}
