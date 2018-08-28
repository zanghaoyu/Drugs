package com.medicine.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.medicine.pojo.UserType;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UserLogonForm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_realname;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogonForm frame = new UserLogonForm();
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
	public UserLogonForm() {
		setTitle("\u7BA1\u7406\u5458\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		UserType ut = new UserType();
		
		JLabel label_username = new JLabel("\u7528\u6237\u540D");
		label_username.setBounds(110, 30, 54, 15);
		contentPane.add(label_username);
		
		JLabel label_realname = new JLabel("\u771F\u5B9E\u59D3\u540D");
		label_realname.setBounds(110, 70, 54, 15);
		contentPane.add(label_realname);
		
		JLabel label_gender = new JLabel("\u6027\u522B");
		label_gender.setBounds(110, 109, 54, 15);
		contentPane.add(label_gender);
		
		JLabel label_pwd = new JLabel("\u5BC6\u7801");
		label_pwd.setBounds(110, 150, 54, 15);
		contentPane.add(label_pwd);
		
		textField_username = new JTextField();
		textField_username.setBounds(228, 27, 102, 21);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		textField_realname = new JTextField();
		textField_realname.setBounds(228, 67, 102, 21);
		contentPane.add(textField_realname);
		textField_realname.setColumns(10);
		
		JRadioButton radioButton_male = new JRadioButton("\u7537");
		radioButton_male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioButton_male.isSelected()) {
					ut.setGender(radioButton_male.getText());
				}
			}
		});
		radioButton_male.setBounds(228, 105, 45, 23);
		contentPane.add(radioButton_male);
		
		JRadioButton radioButton_female = new JRadioButton("\u5973");
		radioButton_female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_female.isSelected()) {
					ut.setGender(radioButton_female.getText());
				}
			}
		});
		radioButton_female.setBounds(290, 105, 40, 23);
		contentPane.add(radioButton_female);
		
		ButtonGroup gbg = new ButtonGroup();
		gbg.add(radioButton_male);
		gbg.add(radioButton_female);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.setBounds(95, 204, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_username.setText(null);
				textField_realname.setText(null);
				passwordField.setText(null);
			}
		});
		button_1.setBounds(237, 204, 93, 23);
		contentPane.add(button_1);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(228, 147, 83, 21);
		contentPane.add(passwordField);
		
		JButton button_enablepwd = new JButton("New button");
		button_enablepwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passwordField.setEchoChar((char)0);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				passwordField.setEchoChar('*');
			}
		});
		button_enablepwd.setBounds(309, 146, 21, 23);
		contentPane.add(button_enablepwd);
	}
}

